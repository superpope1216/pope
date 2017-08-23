package com.pope.contract.web.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.contract.code.Result;
import com.pope.contract.code.TaskStatusEnum;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.task.TaskInfo;
import com.pope.contract.entity.task.extend.TaskInfoExtend;
import com.pope.contract.service.task.TaskInfoService;
import com.pope.contract.util.StringUtil;
import com.pope.contract.web.BaseController;
import com.pope.contract.web.util.PageUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月15日 上午11:14:39
* 类说明
*/
@Controller
@RequestMapping("taskExamine")
public class TaskInfoExamineController extends BaseController{
	@Autowired
	private TaskInfoService taskInfoService;
	@RequestMapping("index")
	public ModelAndView index(){
		ModelAndView mv=new ModelAndView();
		//mv.setViewName("/");
		mv.setViewName("task/taskInfoExamine");
		return mv;
	}
	
	@RequestMapping("listDsh")
	@ResponseBody
	public Result listDsh(Integer startPage) throws Exception{
		PageUtil<TaskInfoExtend> pageUtil=new PageUtil<TaskInfoExtend>(startPage);
		//List<TaskInfo> datas=taskInfoService.selectWaitTaskInfoByStep(this.getRole().getWid());
		List<TaskInfoExtend> datas=taskInfoService.selectDispalyTaskInfoByPermission(this.getRole().getName(), this.getUserId(),TaskStatusEnum.SH);
		PageParam<TaskInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping("listJxz")
	@ResponseBody
	public Result listJxz(Integer startPage) throws Exception{
		TaskInfo taskInfo=new TaskInfo();
		taskInfo.setRwzt(TaskStatusEnum.SHJXZ.getCode());
		PageUtil<TaskInfoExtend> pageUtil=new PageUtil<TaskInfoExtend>(startPage);
		//List<TaskInfoExtend> datas=taskInfoService.selectDispalyTaskInfoByCondition(taskInfo);
		List<TaskInfoExtend> datas=taskInfoService.selectDispalyTaskInfoByPermission(this.getRole().getName(), this.getUserId(),TaskStatusEnum.SHJXZ);
		PageParam<TaskInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping("listShtg")
	@ResponseBody
	public Result listShtg(Integer startPage) throws Exception{
		TaskInfo taskInfo=new TaskInfo();
		taskInfo.setRwzt(TaskStatusEnum.SHTG.getCode());
		PageUtil<TaskInfoExtend> pageUtil=new PageUtil<TaskInfoExtend>(startPage);
		//List<TaskInfoExtend> datas=taskInfoService.selectDispalyTaskInfoByCondition(taskInfo);
		List<TaskInfoExtend> datas=taskInfoService.selectDispalyTaskInfoByPermission(this.getRole().getName(), this.getUserId(),TaskStatusEnum.SHTG);
		PageParam<TaskInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping("listShbtg")
	@ResponseBody
	public Result listShbtg(Integer startPage) throws Exception{ 
		TaskInfo taskInfo=new TaskInfo();
		taskInfo.setRwzt(TaskStatusEnum.SHBTG.getCode());
		PageUtil<TaskInfoExtend> pageUtil=new PageUtil<TaskInfoExtend>(startPage);
		//List<TaskInfoExtend> datas=taskInfoService.selectDispalyTaskInfoByCondition(taskInfo);
		List<TaskInfoExtend> datas=taskInfoService.selectDispalyTaskInfoByPermission(this.getRole().getName(), this.getUserId(),TaskStatusEnum.SHBTG);
		PageParam<TaskInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	@RequestMapping(value="examinePass",method=RequestMethod.POST)
	@ResponseBody
	public Result examinePassTask(String wid) throws Exception{
		taskInfoService.examinePass(wid, this.getUserId());
		return Result.success();
	}
	
	@RequestMapping(value="examineNotPass",method=RequestMethod.POST)
	@ResponseBody
	public Result examinePassNotTask(String wid) throws Exception{
		taskInfoService.examineNotPass(wid, this.getUserId());
		return Result.success();
	}
	
	
}
