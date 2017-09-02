package com.pope.contract.web.contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pope.contract.code.ContractStateEnum;
import com.pope.contract.code.FlowSetCode;
import com.pope.contract.code.FlowStateCode;
import com.pope.contract.code.Result;
import com.pope.contract.code.TaskStatusEnum;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.contract.ContractInfo;
import com.pope.contract.entity.contract.extend.ContractInfoExtend;
import com.pope.contract.entity.supply.GmbInfo;
import com.pope.contract.entity.supply.LqbInfo;
import com.pope.contract.entity.supply.extend.GmbInfoExtend;
import com.pope.contract.entity.supply.extend.LqbInfoExtend;
import com.pope.contract.entity.task.TaskInfo;
import com.pope.contract.service.contract.ContractInfoService;
import com.pope.contract.service.supply.GmbInfoService;
import com.pope.contract.util.StringUtil;
import com.pope.contract.web.BaseController;
import com.pope.contract.web.util.PageUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月18日 下午11:43:23
* 类说明
*/
@Controller
@RequestMapping("contractInfoExamine")
public class ContractInfoExamineController extends BaseController {

	@Autowired
	private GmbInfoService gmbInfoService; 
	@Autowired
	private ContractInfoService contractInfoService; 
	@RequestMapping("index")
	public String index(){
		return "contract/contractInfoExamine";
	}
	
	@RequestMapping("listDsh")
	@ResponseBody
	public Result listDsh(Integer startPage) throws Exception{
		PageUtil<ContractInfoExtend> pageUtil=new PageUtil<ContractInfoExtend>(startPage);
		List<ContractInfoExtend> datas=contractInfoService.selectWaitTaskInfoByStep(this.getRole().getWid());
		PageParam<ContractInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping("listJxz")
	@ResponseBody
	public Result listJxz(Integer startPage) throws Exception{
		ContractInfoExtend taskInfo=new ContractInfoExtend();
		taskInfo.setRwzt(ContractStateEnum.JXZ.getCode());
		PageUtil<ContractInfoExtend> pageUtil=new PageUtil<ContractInfoExtend>(startPage);
		List<ContractInfoExtend> datas=contractInfoService.selectDisplayByCondition(taskInfo);
		PageParam<ContractInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping("listShtg")
	@ResponseBody
	public Result listShtg(Integer startPage) throws Exception{
		ContractInfoExtend taskInfo=new ContractInfoExtend();
		taskInfo.setRwzt(ContractStateEnum.YJS.getCode());
		PageUtil<ContractInfoExtend> pageUtil=new PageUtil<ContractInfoExtend>(startPage);
		List<ContractInfoExtend> datas=contractInfoService.selectDisplayByCondition(taskInfo);
		PageParam<ContractInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping("listShbtg")
	@ResponseBody
	public Result listShbtg(Integer startPage) throws Exception{ 
		ContractInfoExtend taskInfo=new ContractInfoExtend();
		taskInfo.setRwzt(ContractStateEnum.BTG.getCode());
		PageUtil<ContractInfoExtend> pageUtil=new PageUtil<ContractInfoExtend>(startPage);
		List<ContractInfoExtend> datas=contractInfoService.selectDisplayByCondition(taskInfo);
		PageParam<ContractInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping(value="examinePass",method=RequestMethod.POST)
	@ResponseBody
	public Result examinePassTask(String wid) throws Exception{
		contractInfoService.examinePass(wid, this.getUserId());
		return Result.success();
	}
	
	@RequestMapping(value="examineNotPass",method=RequestMethod.POST)
	@ResponseBody
	public Result examinePassNotTask(String wid) throws Exception{
		contractInfoService.examineNotPass(wid, this.getUserId());
		return Result.success();
	}
}
