package com.pope.contract.web.pxgl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pope.contract.code.FlowSetCode;
import com.pope.contract.code.FlowStateCode;
import com.pope.contract.code.Result;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.pxgl.extend.PxglInfoExtend;
import com.pope.contract.entity.supply.ShbInfo;
import com.pope.contract.entity.supply.extend.ShbInfoExtend;
import com.pope.contract.entity.system.FlowSet;
import com.pope.contract.service.pxgl.PxglInfoService;
import com.pope.contract.service.system.FlowSetService;
import com.pope.contract.util.StringUtil;
import com.pope.contract.web.BaseController;
import com.pope.contract.web.util.PageUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年9月10日 下午5:47:53
* 类说明
*/
@RequestMapping("pxglExamineInfo")
@Controller
public class PxglExamineInfoController extends BaseController {

	@Autowired
	private PxglInfoService pxglInfoService;
	@Autowired
	private FlowSetService flowSetService;
	@RequestMapping("index")
	public String index(){
		return "pxgl/pxglInfoExamine";
	}

	@RequestMapping("listDsh")
	@ResponseBody
	public Result listDsh(Integer startPage) throws Exception{
		PageUtil<PxglInfoExtend> pageUtil=new PageUtil<PxglInfoExtend>(startPage);
		FlowSet flowSet=flowSetService.selectByRoleAndType(this.getRole().getWid(), FlowSetCode.PXGL.getCode());
		List<String> taskStatus=new ArrayList<String>();
		taskStatus.add(FlowStateCode.DSH.getCode());
		taskStatus.add(FlowStateCode.JXZ.getCode());
		PxglInfoExtend queryPxglInfoExtend=new PxglInfoExtend();
		queryPxglInfoExtend.setCurrentstep(flowSet.getPx());
		queryPxglInfoExtend.setRwztList(taskStatus);
		List<PxglInfoExtend> datas=this.pxglInfoService.selectDisplayByCondition(queryPxglInfoExtend);
		PageParam<PxglInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping("listJxz")
	@ResponseBody
	public Result listJxz(Integer startPage) throws Exception{
		
		PageUtil<PxglInfoExtend> pageUtil=new PageUtil<PxglInfoExtend>(startPage);
		List<String> taskStatus=new ArrayList<String>();
		taskStatus.add(FlowStateCode.JXZ.getCode());
		PxglInfoExtend queryPxglInfoExtend=new PxglInfoExtend();
		queryPxglInfoExtend.setRwztList(taskStatus);
		List<PxglInfoExtend> datas=this.pxglInfoService.selectDisplayByCondition(queryPxglInfoExtend);
		PageParam<PxglInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping("listShtg")
	@ResponseBody
	public Result listShtg(Integer startPage) throws Exception{
		PageUtil<PxglInfoExtend> pageUtil=new PageUtil<PxglInfoExtend>(startPage);
		List<String> taskStatus=new ArrayList<String>();
		taskStatus.add(FlowStateCode.YJS.getCode());
		PxglInfoExtend queryPxglInfoExtend=new PxglInfoExtend();
		queryPxglInfoExtend.setRwztList(taskStatus);
		List<PxglInfoExtend> datas=this.pxglInfoService.selectDisplayByCondition(queryPxglInfoExtend);
		PageParam<PxglInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping("listShbtg")
	@ResponseBody
	public Result listShbtg(Integer startPage) throws Exception{ 
		PageUtil<PxglInfoExtend> pageUtil=new PageUtil<PxglInfoExtend>(startPage);
		List<String> taskStatus=new ArrayList<String>();
		taskStatus.add(FlowStateCode.BTG.getCode());
		PxglInfoExtend queryPxglInfoExtend=new PxglInfoExtend();
		queryPxglInfoExtend.setRwztList(taskStatus);
		List<PxglInfoExtend> datas=this.pxglInfoService.selectDisplayByCondition(queryPxglInfoExtend);
		PageParam<PxglInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping(value="examinePass",method=RequestMethod.POST)
	@ResponseBody
	public Result examinePassTask(String wid) throws Exception{
		pxglInfoService.examinePass(wid, this.getUserId());
		return Result.success();
	}
	
	@RequestMapping(value="examineNotPass",method=RequestMethod.POST)
	@ResponseBody
	public Result examinePassNotTask(String wid) throws Exception{
		pxglInfoService.examineNotPass(wid, this.getUserId());
		return Result.success();
	}
}
