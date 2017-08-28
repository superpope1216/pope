package com.pope.contract.web.task;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.pope.contract.code.DataStatus;
import com.pope.contract.code.Result;
import com.pope.contract.code.TaskStatusEnum;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.project.BatchInfo;
import com.pope.contract.entity.system.Sjzd;
import com.pope.contract.entity.task.TaskInfo;
import com.pope.contract.entity.task.TaskInfoDetail;
import com.pope.contract.entity.task.extend.TaskInfoExtend;
import com.pope.contract.service.project.BatchInfoService;
import com.pope.contract.service.system.FxxmInfoService;
import com.pope.contract.service.system.SjzdService;
import com.pope.contract.service.task.TaskInfoService;
import com.pope.contract.util.CommonUtil;import com.pope.contract.util.ConstantUtil;
import com.pope.contract.util.StringUtil;
import com.pope.contract.web.BaseController;
import com.pope.contract.web.util.PageUtil;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年8月13日 下午8:26:57 类说明
 */
@Controller
@RequestMapping("task")
public class TaskInfoController extends BaseController {

	@Autowired
	private BatchInfoService batchInfoService;

	@Autowired
	private TaskInfoService taskInfoService;

	@Autowired
	private SjzdService sjzdService;

	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("task/taskInfo");
		mv.addObject("buttons", this.getButtonPermission("/task/index"));
		return mv;
	}

	@RequestMapping("taskadd")
	public ModelAndView taskAdd(String wid) {
		if (StringUtils.isEmpty(wid)) {
			wid = "";
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("pcid", wid);
		mv.setViewName("task/taskEditInfo");
		return mv;
	}

	@RequestMapping("selectFxxm")
	@ResponseBody
	public Result selectFxxm(String pcid) throws Exception {
		List<Sjzd> fxxms = sjzdService.selectAll("T_CONTRACT_SJZD_FXXM", null);
		TaskInfoExtend queryTaskInfo = new TaskInfoExtend();
		queryTaskInfo.setPcwid(pcid);
		queryTaskInfo.setDatastatus(StringUtil.toStr(DataStatus.normal.getCode()));
		List<TaskInfo> listTaskInfo = taskInfoService.selectTaskInfoByCondition(queryTaskInfo);
		if (CommonUtil.isNotEmptyList(fxxms) && CommonUtil.isNotEmptyList(listTaskInfo)) {
			Iterator<Sjzd> sjzds = fxxms.iterator();
			while (sjzds.hasNext()) {
				Sjzd sjzd = sjzds.next();
				for (TaskInfo taskInfo : listTaskInfo) {
					if (sjzd.getLbdm().equals(taskInfo.getFxxm())) {
						sjzds.remove();
					}
				}
			}
		}
		return Result.success(fxxms);
	}

	@RequestMapping("taskaddView")
	@ResponseBody
	public Result taskAddView(String wid) {
		BatchInfo batchInfo = batchInfoService.selectByPrimaryKey(wid);
		return Result.success(batchInfo);
	}

	@RequestMapping("taskDetailsIndex")
	public ModelAndView taskDetailsIndex(String wid, String flag) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("wid", wid);
		mv.addObject("flag", flag);
		mv.setViewName("task/taskInfoDetail");
		return mv;
	}

	@RequestMapping("listTaskInfo")
	@ResponseBody
	public Result listTaskInfo(Integer startPage,TaskInfoExtend taskInfoExtend) throws Exception {
		PageUtil<TaskInfoExtend> pageUtil = new PageUtil<TaskInfoExtend>(startPage);
		List<TaskInfoExtend> users = taskInfoService.selectDispalyTaskInfoByPermission(this.getRole().getName(),
				this.getUserId(),null,taskInfoExtend);
		PageParam<TaskInfoExtend> pageParam = pageUtil.getPageParam(users);
		return Result.success(pageParam);
	}

	@RequestMapping("listTaskDetailInfo")
	@ResponseBody
	public Result listTaskDetailInfo(String pwid, Integer startPage) throws Exception {
		TaskInfoDetail taskInfoDetail = new TaskInfoDetail();
		taskInfoDetail.setDatastatus(com.pope.contract.util.StringUtil.toStr(DataStatus.normal.getCode()));
		taskInfoDetail.setFrwid(pwid);
		PageUtil<TaskInfoDetail> pageUtil = new PageUtil<TaskInfoDetail>(startPage);
		List<TaskInfoDetail> users = taskInfoService.selectDispalyTaskInfoDetailByCondition(taskInfoDetail);
		PageParam<TaskInfoDetail> pageParam = pageUtil.getPageParam(users);
		return Result.success(pageParam);
	}

	@RequestMapping("save")
	@ResponseBody
	public Result saveTaskInfo(TaskInfo taskInfo) throws Exception {
		taskInfoService.insertTaskInfo(taskInfo, this.getUserId());
		return Result.success();
	}

	@RequestMapping("submitTaskInfoDetail")
	@ResponseBody
	public Result submitTaskInfoDetail(String pid, String datas) throws Exception {
		List<Map> list = JSONObject.parseArray(datas, Map.class);
		taskInfoService.submitTaskInfoDetail(pid, list, this.getUserId());
		return Result.success();
	}

	@RequestMapping("submitTaskInfo")
	@ResponseBody
	public Result submitTaskInfo(String datas) throws Exception {
		if (!StringUtils.isEmpty(datas)) {
			List<Map> list = JSONObject.parseArray(datas, Map.class);
			taskInfoService.submitTaskInfo(list, this.getUserId());
		}
		return Result.success();
	}
	
	public Result deleteTask(String wid) throws Exception{
		taskInfoService.deleteTask(wid);
		return Result.success();
	}

}
