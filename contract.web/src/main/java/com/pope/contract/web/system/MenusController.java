package com.pope.contract.web.system;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pope.contract.code.Result;
import com.pope.contract.entity.system.Permission;
import com.pope.contract.util.CommonUtil;
import com.pope.contract.web.BaseController;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年9月25日 下午1:03:36
* 类说明
*/
@Controller
@RequestMapping("menus")
public class MenusController extends BaseController{

	@RequestMapping("index")
	public String index() throws Exception{
		return "system/menu";
	}
	
	@RequestMapping("selectTree")
	@ResponseBody
	public Result selectTree() throws Exception{
		List<Permission> permissions=permissionService.selectAll();
		List<Permission> lists=new ArrayList<Permission>();
		if(CommonUtil.isNotEmptyList(permissions)){
			for(Permission per:permissions){
				if(per.getLevel()!=4){
					lists.add(per);
				}
			}
		}
		return Result.success(lists);
	}
	@RequestMapping("save")
	@ResponseBody
	public Result save(Permission permission) throws Exception{
		permissionService.updateByPrimaryKeySelective(permission);
		return Result.success();
	}
	@RequestMapping("updateMenuSort")
	@ResponseBody
	public Result updateMenuSort(String data) throws Exception{
		List<String> wids=new ArrayList<String>();
		JSONArray datas=JSON.parseArray(data);
		for(int i=0;i<datas.size();i++){
			JSONObject jo=(JSONObject)datas.get(i);
			String wid=jo.getString("wid");
			String pid=jo.getString("pid");
			wids.add(wid+","+pid);
		}
		permissionService.updateMenuSort(wids);
		return Result.success();
	}
}
