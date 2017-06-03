package com.pope.contract.web.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.contract.code.Result;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.system.Zdbs;
import com.pope.contract.entity.user.UserInfo;
import com.pope.contract.service.system.ZdbsService;
import com.pope.contract.web.BaseController;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年6月3日 下午3:01:05
* 类说明
*/
@Controller
@RequestMapping("zdbs")
public class ZdbsController extends BaseController{

	@Autowired
	private ZdbsService zdbsService;
	@RequestMapping(value="index",method=RequestMethod.GET)
	public String index() {
		return "system/zdbs";
	}
	@RequestMapping(value="list",method=RequestMethod.GET)
	@ResponseBody
	public Result list(Integer startPage){
		if(startPage==null ||startPage<0){
			startPage=0;
		}
		
		PageParam<Zdbs> pageParam = new PageParam<Zdbs>();
		pageParam.setPage(startPage);
		Page<Zdbs> page = PageHelper.startPage(pageParam.getPage(), pageParam.getPageSize());
		List<Zdbs> users=zdbsService.selectAll();
		pageParam.setTotal(page.getTotal());
		pageParam.setTotalPage(pageParam.getTotalPage());
		pageParam.setData(users);
		return Result.success(pageParam);
	}
	
	@RequestMapping(value="insert",method=RequestMethod.POST)
	@ResponseBody
	public Result insert(Zdbs record) throws Exception{
		zdbsService.insert(record, this.getUserId());
		return Result.success();
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseBody
	public Result update(Zdbs record) throws Exception{
		zdbsService.updateByPrimaryKeySelective(record, this.getUserId());
		return Result.success();
	}
	

	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public Result delete(String wid) throws Exception{
		zdbsService.deleteByPrimaryKey(wid, this.getUserId());
		return Result.success();
	}
	
	@RequestMapping(value="select",method=RequestMethod.GET)
	@ResponseBody
	public Result select(String wid) throws Exception{
		Zdbs zdbs=zdbsService.selectByPrimaryKey(wid);
		return Result.success(zdbs);
	}
}
