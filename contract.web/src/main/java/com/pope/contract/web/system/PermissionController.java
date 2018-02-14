package com.pope.contract.web.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pope.contract.code.Result;
import com.pope.contract.entity.system.Permission;
import com.pope.contract.entity.system.Role;
import com.pope.contract.service.system.PermissionService;
import com.pope.contract.service.system.RolePermissionService;
import com.pope.contract.service.system.RoleService;
import com.pope.contract.util.CommonUtil;
import com.pope.contract.web.BaseController;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年5月29日 下午4:35:48
* 类说明
*/
@Controller
@RequestMapping("permissions")
public class PermissionController extends BaseController{

	@Autowired
	private PermissionService permissionService;
	@Autowired
	private RolePermissionService rolePermissionService;
	@RequestMapping("index")
	public String index(){
		return "system/permission";
	}
	
	
	
	@RequestMapping("permission")
	@ResponseBody
	public Result permission(@RequestParam String roleId){
		List<Permission> perms=permissionService.selectPermissionByRoleId(roleId);
		boolean findFirst=false;
		if(CommonUtil.isNotEmptyList(perms)){
			for(Permission perm:perms){
				if(perm.getWid().equals("1")){
					findFirst=true;
				}
			}
		}
		if(!findFirst){
			Permission perm=permissionService.selectByPrimaryKey("1");
			if(perm!=null){
				if(perms==null){
					perms=new ArrayList<Permission>();
				}
				perms.add(perm);
			}
		}
		return Result.success(perms);
	}
	@RequestMapping("updateRolePerms")
	@ResponseBody
	public Result updateRolePerms(@RequestParam String roleId,@RequestParam String perms){
		rolePermissionService.updatePermissionsByRoleId(roleId, perms);
		return Result.success();
	}
	
}
