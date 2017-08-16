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

import com.github.pagehelper.StringUtil;
import com.pope.contract.code.Result;
import com.pope.contract.dao.system.FlowSetMapper;
import com.pope.contract.entity.system.FlowSet;
import com.pope.contract.entity.system.Permission;
import com.pope.contract.entity.system.Role;
import com.pope.contract.service.system.FlowSetService;
import com.pope.contract.web.BaseController;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年6月18日 下午9:31:13
* 类说明
*/
@Controller
@RequestMapping("flowset")
public class FlowSetController extends BaseController{
	
	
	@Autowired
	private FlowSetService flowSetService;
	@RequestMapping(value="index",method=RequestMethod.GET)
	public String index(){
		return "system/flowset";
	}
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	@ResponseBody
	public Result list(String type) throws Exception{
		FlowSet flowSet=new FlowSet();
		if(StringUtil.isNotEmpty(type)){
			flowSet.setType(type);
		}
		List<FlowSet> list=flowSetService.list(flowSet);
		return Result.success(list);
	} 
	
	@RequestMapping(value="view",method=RequestMethod.GET)
	@ResponseBody
	public Result view(String wid) throws Exception{
		FlowSet flowSet=new FlowSet();
		if(StringUtil.isEmpty(wid)){
			return Result.success(flowSet);
		}
		
		flowSet=flowSetService.selectByPrimaryKey(wid);
		return Result.success(flowSet);
	}
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	@ResponseBody
	public Result insert(FlowSet flowSet) throws Exception{
		flowSetService.insert(flowSet);
		return Result.success();
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseBody
	public Result update(FlowSet flowSet) throws Exception{ 
		flowSetService.updateByPrimaryKeySelective(flowSet);
		return Result.success();
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public Result delete(@RequestParam String wid) throws Exception{
		flowSetService.deleteByPrimaryKey(wid);
		return Result.success();
	}
	@RequestMapping(value="select",method=RequestMethod.GET)
	@ResponseBody
	public Result select(@RequestParam String wid) throws Exception{
		FlowSet flowSet=flowSetService.selectByPrimaryKey(wid);
		return Result.success(flowSet);
	}
		
}
