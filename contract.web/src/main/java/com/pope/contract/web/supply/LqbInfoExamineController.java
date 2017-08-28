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
import com.pope.contract.entity.supply.extend.LqbInfoExtend;
import com.pope.contract.entity.task.TaskInfo;
import com.pope.contract.service.supply.LqbInfoService;
import com.pope.contract.util.StringUtil;
import com.pope.contract.web.BaseController;
import com.pope.contract.web.util.PageUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月18日 下午11:43:23
* 类说明
*/
@Controller
@RequestMapping("lqbExamine")
public class LqbInfoExamineController extends BaseController {

	@Autowired
	private LqbInfoService lqbInfoService; 
	@RequestMapping("index")
	public String index(){
		return "supply/lqbInfoExamine";
	}
	
	@RequestMapping("listDsh")
	@ResponseBody
	public Result listDsh(Integer startPage) throws Exception{
		PageUtil<LqbInfoExtend> pageUtil=new PageUtil<LqbInfoExtend>(startPage);
		List<LqbInfoExtend> datas=lqbInfoService.selectWaitTaskInfoByStep(this.getRole().getWid());
		PageParam<LqbInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping("listJxz")
	@ResponseBody
	public Result listJxz(Integer startPage) throws Exception{
		LqbInfo taskInfo=new LqbInfo();
		taskInfo.setRwzt(StringUtil.toStr(FlowStateCode.JXZ.getCode()));
		PageUtil<LqbInfoExtend> pageUtil=new PageUtil<LqbInfoExtend>(startPage);
		List<LqbInfoExtend> datas=lqbInfoService.selectDispalyTaskInfoByCondition(taskInfo);
		PageParam<LqbInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping("listShtg")
	@ResponseBody
	public Result listShtg(Integer startPage) throws Exception{
		LqbInfo taskInfo=new LqbInfo();
		taskInfo.setRwzt(StringUtil.toStr(FlowStateCode.YJS.getCode()));
		PageUtil<LqbInfoExtend> pageUtil=new PageUtil<LqbInfoExtend>(startPage);
		List<LqbInfoExtend> datas=lqbInfoService.selectDispalyTaskInfoByCondition(taskInfo);
		PageParam<LqbInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping("listShbtg")
	@ResponseBody
	public Result listShbtg(Integer startPage) throws Exception{ 
		LqbInfo taskInfo=new LqbInfo();
		taskInfo.setRwzt(StringUtil.toStr(FlowStateCode.BTG.getCode()));
		PageUtil<LqbInfoExtend> pageUtil=new PageUtil<LqbInfoExtend>(startPage);
		List<LqbInfoExtend> datas=lqbInfoService.selectDispalyTaskInfoByCondition(taskInfo);
		PageParam<LqbInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping(value="examinePass",method=RequestMethod.POST)
	@ResponseBody
	public Result examinePassTask(String wid) throws Exception{
		lqbInfoService.examinePass(wid, this.getUserId());
		return Result.success();
	}
	
	@RequestMapping(value="examineNotPass",method=RequestMethod.POST)
	@ResponseBody
	public Result examinePassNotTask(String wid) throws Exception{
		lqbInfoService.examineNotPass(wid, this.getUserId());
		return Result.success();
	}
}
