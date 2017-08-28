package com.pope.contract.web.supply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pope.contract.code.FlowStateCode;
import com.pope.contract.code.Result;
import com.pope.contract.code.TaskStatusEnum;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.supply.LqbInfo;
import com.pope.contract.entity.supply.ShbInfo;
import com.pope.contract.entity.supply.extend.ShbInfoExtend;
import com.pope.contract.entity.task.TaskInfo;
import com.pope.contract.service.supply.ShbInfoService;
import com.pope.contract.util.StringUtil;
import com.pope.contract.web.BaseController;
import com.pope.contract.web.util.PageUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月18日 下午11:43:23
* 类说明
*/
@Controller
@RequestMapping("shbExamine")
public class ShbInfoExamineController extends BaseController {

	@Autowired
	private ShbInfoService shbInfoService; 
	@RequestMapping("index")
	public String index(){
		return "supply/shbInfoExamine";
	}
	
	@RequestMapping("listDsh")
	@ResponseBody
	public Result listDsh(Integer startPage) throws Exception{
		PageUtil<ShbInfoExtend> pageUtil=new PageUtil<ShbInfoExtend>(startPage);
		List<ShbInfoExtend> datas=shbInfoService.selectWaitTaskInfoByStep(this.getRole().getWid());
		PageParam<ShbInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping("listJxz")
	@ResponseBody
	public Result listJxz(Integer startPage) throws Exception{
		ShbInfo taskInfo=new ShbInfo();
		taskInfo.setRwzt(StringUtil.toStr(FlowStateCode.JXZ.getCode()));
		PageUtil<ShbInfoExtend> pageUtil=new PageUtil<ShbInfoExtend>(startPage);
		List<ShbInfoExtend> datas=shbInfoService.selectDispalyTaskInfoByCondition(taskInfo);
		PageParam<ShbInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping("listShtg")
	@ResponseBody
	public Result listShtg(Integer startPage) throws Exception{
		ShbInfo taskInfo=new ShbInfo();
		taskInfo.setRwzt(StringUtil.toStr(FlowStateCode.YJS.getCode()));
		PageUtil<ShbInfoExtend> pageUtil=new PageUtil<ShbInfoExtend>(startPage);
		List<ShbInfoExtend> datas=shbInfoService.selectDispalyTaskInfoByCondition(taskInfo);
		PageParam<ShbInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping("listShbtg")
	@ResponseBody
	public Result listShbtg(Integer startPage) throws Exception{ 
		ShbInfo taskInfo=new ShbInfo();
		taskInfo.setRwzt(StringUtil.toStr(FlowStateCode.BTG.getCode()));
		PageUtil<ShbInfoExtend> pageUtil=new PageUtil<ShbInfoExtend>(startPage);
		List<ShbInfoExtend> datas=shbInfoService.selectDispalyTaskInfoByCondition(taskInfo);
		PageParam<ShbInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping(value="examinePass",method=RequestMethod.POST)
	@ResponseBody
	public Result examinePassTask(String wid) throws Exception{
		shbInfoService.examinePass(wid, this.getUserId());
		return Result.success();
	}
	
	@RequestMapping(value="examineNotPass",method=RequestMethod.POST)
	@ResponseBody
	public Result examinePassNotTask(String wid) throws Exception{
		shbInfoService.examineNotPass(wid, this.getUserId());
		return Result.success();
	}
}
