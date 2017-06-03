package com.pope.contract.web.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.contract.code.Result;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.system.Sjzd;
import com.pope.contract.entity.system.Zdbs;
import com.pope.contract.service.system.SjzdService;
import com.pope.contract.service.system.ZdbsService;
import com.pope.contract.web.BaseController;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年6月3日 下午4:47:49
* 类说明
*/
@Controller
@RequestMapping("zdbdetail")
public class ZdbDetailController extends BaseController{
	@Autowired
	private ZdbsService zdbsService;
	
	@Autowired
	private SjzdService sjzdService;
	@RequestMapping(value="index",method=RequestMethod.GET)
	public String index(){
		return "system/zdbdetail";
	}
	
	@RequestMapping(value="listZdb",method=RequestMethod.GET)
	@ResponseBody
	public Result listZdb( ){  
		List<Zdbs> zdbs=zdbsService.selectAll(); 
		return Result.success(zdbs);
	}
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	@ResponseBody
	public Result list(@RequestParam String tableName){
		List<Sjzd> datas=sjzdService.selectAll(tableName);
		return Result.success(datas);
	}
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	@ResponseBody
	public Result insert(Sjzd sjzd) throws Exception{
		sjzdService.insert(sjzd);
		return Result.success();
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseBody
	public Result update(Sjzd sjzd) throws Exception{
		sjzdService.updateByPrimaryKeySelective(sjzd);
		return Result.success();
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public Result delete(String tableName,String wid) throws Exception{
		sjzdService.deleteByPrimaryKey(tableName,wid);
		return Result.success();
	}
	
	@RequestMapping(value="select",method=RequestMethod.GET)
	@ResponseBody
	public Result select(@RequestParam String tableName,@RequestParam String wid) throws Exception{
		Sjzd data=sjzdService.selectByPrimaryKey(tableName, wid);
		return Result.success(data);
		
	}
}
