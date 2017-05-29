package com.pope.contract.web.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pope.contract.code.Result;
import com.pope.contract.entity.system.Permission;
import com.pope.contract.entity.system.Role;
import com.pope.contract.service.system.PermissionService;
import com.pope.contract.service.system.RoleService;
import com.pope.contract.util.DateUtil;
import com.pope.contract.web.BaseController;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年5月29日 下午9:31:29
* 类说明
*/
@Controller
@RequestMapping("roles")
public class RoleController extends BaseController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private PermissionService permissionService;
	@RequestMapping(value="list",method=RequestMethod.GET)
	@ResponseBody
	public Result list(){
		
		List<Role> roles=roleService.selectAll();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("roles", roles);
		List<Permission> permissions=permissionService.selectAll();
		map.put("perms", permissions);
		return Result.success(map);
	} 
	@RequestMapping(value="insert",method=RequestMethod.POST)
	@ResponseBody
	public Result insert(Role role) throws Exception{
		roleService.insert(role,this.getUserId());
		return Result.success();
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseBody
	public Result update(Role role) throws Exception{ 
		roleService.updateByPrimaryKeySelective(role,this.getUserId());
		return Result.success();
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public Result delete(@RequestParam String roleId) throws Exception{
		Role role=new Role();
		role.setWid(roleId);
		roleService.deleteByRoleId(role, this.getUserId());
		return Result.success();
	}
	@RequestMapping(value="select",method=RequestMethod.GET)
	@ResponseBody
	public Result select(@RequestParam String roleId){
		Role role=roleService.selectByPrimaryKey(roleId);
		return Result.success(role);
	}
}
