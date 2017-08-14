package com.pope.contract.web.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.pope.contract.code.DataStatus;
import com.pope.contract.code.Result;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.project.BatchInfo;
import com.pope.contract.entity.project.extend.BatchInfoExtend;
import com.pope.contract.entity.task.TaskInfo;
import com.pope.contract.entity.task.TaskInfoDetail;
import com.pope.contract.service.project.BatchInfoService;
import com.pope.contract.service.task.TaskInfoService;
import com.pope.contract.web.BaseController;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月13日 下午8:26:57
* 类说明
*/
@Controller
@RequestMapping("task")
public class TaskInfoController extends BaseController {

	@Autowired
	private BatchInfoService batchInfoService;
	
	@Autowired
	private TaskInfoService taskInfoService;
	@RequestMapping("index")
	public String index(){
		return "task/taskInfo";
	}
	
	@RequestMapping("taskadd")
	public ModelAndView taskAdd(String wid){
		if(StringUtil.isEmpty(wid)){
			wid="";
		}
		ModelAndView mv=new ModelAndView();
		mv.addObject("pcid",wid);
		mv.setViewName("task/taskEditInfo");
		return mv;
	}
	
	@RequestMapping("taskaddView")
	@ResponseBody
	public Result taskAddView(String wid){
		BatchInfo batchInfo=batchInfoService.selectByPrimaryKey(wid);
		return Result.success(batchInfo);
	}
	
	@RequestMapping("taskDetailsIndex")
	public ModelAndView taskDetailsIndex(String wid) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("wid",wid);
		mv.setViewName("task/taskInfoDetail");
		return mv;
	}
	@RequestMapping("listTaskInfo")
	@ResponseBody
	public Result listTaskInfo(Integer startPage) throws Exception{
		if(startPage==null ||startPage<0){
			startPage=0;
		}
		PageParam<TaskInfo> pageParam = new PageParam<TaskInfo>();
		pageParam.setPage(startPage);
		Page<TaskInfo> page = PageHelper.startPage(pageParam.getPage(), pageParam.getPageSize());
		List<TaskInfo> users=taskInfoService.selectDispalyTaskInfoByCondition(null);
		pageParam.setTotal(page.getTotal());
		pageParam.setTotalPage(pageParam.getTotalPage());
		pageParam.setData(users);
		return Result.success(pageParam);
	}
	
	@RequestMapping("listTaskDetailInfo")
	@ResponseBody
	public Result listTaskDetailInfo(String pwid,Integer startPage) throws Exception{
		if(startPage==null ||startPage<0){
			startPage=0;
		}
		TaskInfoDetail taskInfoDetail=new TaskInfoDetail();
		taskInfoDetail.setDatastatus(com.pope.contract.util.StringUtil.toStr(DataStatus.normal.getCode()));
		taskInfoDetail.setFrwid(pwid);
		PageParam<TaskInfoDetail> pageParam = new PageParam<TaskInfoDetail>();
		pageParam.setPage(startPage);
		Page<TaskInfoDetail> page = PageHelper.startPage(pageParam.getPage(), pageParam.getPageSize());
		List<TaskInfoDetail> users=taskInfoService.selectDispalyTaskInfoDetailByCondition(taskInfoDetail);
		pageParam.setTotal(page.getTotal());
		pageParam.setTotalPage(pageParam.getTotalPage());
		pageParam.setData(users);
		return Result.success(pageParam);
	}
	@RequestMapping("save")
	@ResponseBody
	public Result saveTaskInfo(TaskInfo taskInfo) throws Exception{
		taskInfoService.insertTaskInfo(taskInfo, this.getUserId());
		return Result.success();
	}
	
}
