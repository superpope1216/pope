package com.pope.contract.service.task.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.contract.code.DataStatus;
import com.pope.contract.dao.project.extend.BatchInfoExtendMapper;
import com.pope.contract.dao.task.TaskJcInfoMapper;
import com.pope.contract.dao.task.extend.TaskInfoDetailExtendMapper;
import com.pope.contract.dao.task.extend.TaskInfoExtendMapper;
import com.pope.contract.dao.task.extend.TaskJcInfoExtendMapper;
import com.pope.contract.entity.project.extend.BatchInfoExtend;
import com.pope.contract.entity.task.TaskInfoDetail;
import com.pope.contract.entity.task.TaskJcInfo;
import com.pope.contract.entity.task.extend.TaskInfoDetailExtend;
import com.pope.contract.entity.task.extend.TaskInfoExtend;
import com.pope.contract.entity.task.extend.TaskJcInfoExtend;
import com.pope.contract.service.task.TaskJcInfoService;
import com.pope.contract.util.CommonUtil;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年9月23日 下午11:25:04
* 类说明
*/
@Service("taskJcInfoService")
public class TaskJcInfoServiceImpl implements TaskJcInfoService{

	@Autowired
	private TaskInfoDetailExtendMapper taskInfoDetailExtendMapper;
	
	@Autowired
	private TaskInfoExtendMapper taskInfoExtendMapper;
	
	@Autowired
	private BatchInfoExtendMapper batchInfoExtendMapper;
	@Autowired
	private TaskJcInfoMapper taskJcInfoMapper;
	@Autowired
	private TaskJcInfoExtendMapper taskJcInfoExtendMapper;
	@Override
	public int deleteByPrimaryKey(String wid) throws Exception {
		return taskJcInfoMapper.deleteByPrimaryKey(wid);
	}

	@Override
	public int insertSelective(TaskJcInfo record) throws Exception {
		return taskJcInfoMapper.insertSelective(record);
	}

	@Override
	public TaskJcInfo selectByPrimaryKey(String wid) throws Exception {
		return taskJcInfoMapper.selectByPrimaryKey(wid);
	}

	@Override
	public int updateByPrimaryKeySelective(TaskJcInfo record) throws Exception {
		return taskJcInfoMapper.updateByPrimaryKeySelective(record);
	}
	
	public TaskJcInfoExtend showPrint(String taskId) throws Exception{
		TaskJcInfoExtend taskJcInfoExtend=new TaskJcInfoExtend();
		TaskInfoExtend queryTaskInfoExtend=new TaskInfoExtend();
		queryTaskInfoExtend.setWid(taskId);
		List<TaskInfoExtend> taskInfoExtend= taskInfoExtendMapper.selectDispalyTaskInfoByCondition(queryTaskInfoExtend);
		if(CommonUtil.isNotEmptyList(taskInfoExtend)){
			taskJcInfoExtend.setSybh(taskInfoExtend.get(0).getRwbh());
			taskJcInfoExtend.setJcxm(taskInfoExtend.get(0).getFxxm_display());
			taskJcInfoExtend.setJcr(taskInfoExtend.get(0).getRwfpr_display());
			taskJcInfoExtend.setJcsj(taskInfoExtend.get(0).getShwcsj());
			taskJcInfoExtend.setShry(taskInfoExtend.get(0).getRwshr_display());
			taskJcInfoExtend.setShsj(taskInfoExtend.get(0).getShwcsj());
			TaskInfoDetailExtend queryTaskInfoDetailExtend=new TaskInfoDetailExtend();
			queryTaskInfoDetailExtend.setFrwid(taskId);
			queryTaskInfoDetailExtend.setDatastatus(StringUtil.toStr(DataStatus.normal.getCode()));
			List<TaskInfoDetail> taskInfoDetailExtendList=taskInfoDetailExtendMapper.selectDispalyTaskInfoByCondition(queryTaskInfoDetailExtend);
			if(CommonUtil.isNotEmptyList(taskInfoDetailExtendList)){
				taskJcInfoExtend.setYpsl(taskInfoDetailExtendList.size());
			}else{
				taskJcInfoExtend.setYpsl(0);
			}
			BatchInfoExtend queryBatchInfoExtend=new BatchInfoExtend();
			queryBatchInfoExtend.setWid(taskInfoExtend.get(0).getPcwid());
			List<BatchInfoExtend> batchInfoExtendList=batchInfoExtendMapper.selectDisplayByCondition(queryBatchInfoExtend);
			if(CommonUtil.isNotEmptyList(batchInfoExtendList)){
				taskJcInfoExtend.setYplp(batchInfoExtendList.get(0).getPclb_display());
				taskJcInfoExtend.setSyr(batchInfoExtendList.get(0).getSyr());
				taskJcInfoExtend.setSysj(batchInfoExtendList.get(0).getSysj());
			}
			
				TaskJcInfo taskJcInfo=taskJcInfoExtendMapper.selectByTaskId(taskId);
				if(taskJcInfo!=null){
				taskJcInfoExtend.setWid(taskJcInfo.getWid());
				taskJcInfoExtend.setWtbh(taskJcInfo.getWtbh());
				taskJcInfoExtend.setJcyj(taskJcInfo.getJcyj());
				taskJcInfoExtend.setLyr(taskJcInfo.getLyr());
				taskJcInfoExtend.setLysj(taskJcInfo.getLysj());
				taskJcInfoExtend.setBz(taskJcInfo.getBz());
				taskJcInfoExtend.setTaskid(taskJcInfo.getTaskid());
				}
		}
		taskJcInfoExtend.setTaskid(taskId);
		return taskJcInfoExtend;
		
	}

}
