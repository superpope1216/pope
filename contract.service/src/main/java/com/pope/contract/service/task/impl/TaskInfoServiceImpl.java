package com.pope.contract.service.task.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pope.contract.code.DataStatus;
import com.pope.contract.code.FlowSetCode;
import com.pope.contract.code.FlowStateCode;
import com.pope.contract.code.TaskStatusEnum;
import com.pope.contract.dao.project.extend.BatchInfoDetailExtendMapper;
import com.pope.contract.dao.task.TaskInfoDetailMapper;
import com.pope.contract.dao.task.TaskInfoMapper;
import com.pope.contract.dao.task.extend.TaskInfoDetailExtendMapper;
import com.pope.contract.dao.task.extend.TaskInfoExtendMapper;
import com.pope.contract.entity.project.BatchInfoDetail;
import com.pope.contract.entity.system.FlowSet;
import com.pope.contract.entity.system.FlowSetData;
import com.pope.contract.entity.task.TaskInfo;
import com.pope.contract.entity.task.TaskInfoDetail;
import com.pope.contract.service.system.FlowSetDataService;
import com.pope.contract.service.system.FlowSetService;
import com.pope.contract.service.task.TaskInfoService;
import com.pope.contract.util.CommonUtil;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月14日 上午9:24:38
* 类说明
*/
@Service("taskInfoService")
public class TaskInfoServiceImpl implements TaskInfoService{

	@Autowired
	private TaskInfoMapper taskInfoMapper;
	@Autowired
	private TaskInfoDetailMapper taskInfoDetailMapper;
	@Autowired
	private TaskInfoDetailExtendMapper taskInfoDetailExtendMapper;
	
	@Autowired
	private TaskInfoExtendMapper taskInfoExtendMapper; 
	@Autowired
	private BatchInfoDetailExtendMapper batchInfoDetailExtendMapper;
	@Autowired
	private FlowSetDataService flowSetDataService;
	@Autowired
	private FlowSetService flowSetService;
	
	@Override
	@Transactional
	public void insertTaskInfo(TaskInfo taskInfo,String userId) throws Exception {
		Integer max=taskInfoExtendMapper.selectMaxXh();
		if(max==null)max=0;
		max++;
		String sMax=String.format("%05d",max);
		String wid=StringUtil.getUuId();
		taskInfo.setWid(wid);
		taskInfo.setRwbh(sMax);
		taskInfo.setDatastatus(StringUtil.toStr(DataStatus.normal.getCode()));
		taskInfo.setDqbh(max);
		taskInfo.setRwbh(sMax);
		taskInfo.setRwzt(TaskStatusEnum.JC.getCode());
		FlowSet flowSet=flowSetService.selectNextStep(FlowSetCode.LEAVE.getCode(), 0);
		taskInfo.setCurrentstep(flowSet.getPx());
		BatchInfoDetail batchInfoDetail=new BatchInfoDetail();
		batchInfoDetail.setPcwid(taskInfo.getPcwid());
		List<BatchInfoDetail> listBatchInfoDetail=batchInfoDetailExtendMapper.selectByCondition(batchInfoDetail);
		if(CommonUtil.isNotEmptyList(listBatchInfoDetail)){
			for(BatchInfoDetail detail:listBatchInfoDetail){
				Integer maxDetail=taskInfoDetailExtendMapper.selectMaxXh();
				if(maxDetail==null){
					maxDetail=0;
				}
				maxDetail++;
				String sMaxDetail=String.format("%05d",maxDetail);
				
				TaskInfoDetail taskInfoDetail=new TaskInfoDetail();
				taskInfoDetail.setWid(StringUtil.getUuId());
				taskInfoDetail.setDatastatus(StringUtil.toStr(DataStatus.normal.getCode()));
				
				taskInfoDetail.setDqbh(maxDetail);
				taskInfoDetail.setFrwbh(sMax);
				taskInfoDetail.setFrwid(wid);
				taskInfoDetail.setFxxm(taskInfo.getFxxm());
				taskInfoDetail.setPcwid(taskInfo.getPcwid());
				
				taskInfoDetail.setRwbh(sMaxDetail);
				taskInfoDetail.setRwfpr(taskInfo.getRwfpr());
				taskInfoDetail.setRwlx(taskInfo.getRwlx());
				taskInfoDetail.setRwzt(TaskStatusEnum.JC.getCode());
				taskInfoDetail.setWid(StringUtil.getUuId());
				taskInfoDetail.setYpbh(detail.getYpbh());
				taskInfoDetail.setYpewm(detail.getYpewm());
				taskInfoDetail.setYpph(detail.getYpph());
				taskInfoDetail.setYpxz(detail.getYpxz());
				taskInfoDetail.setYpyybh(detail.getYpyybh());
				taskInfoDetailMapper.insert(taskInfoDetail);
				
			}
		}
		taskInfoMapper.insert(taskInfo);
		FlowSetData flowSetData=new FlowSetData();
		flowSetData.setWid(StringUtil.getUuId());
		flowSetData.setCjsj(DateUtil.getCurrentDateTimeStr());
		flowSetData.setCurrentStep(flowSet.getPx());
		flowSetData.setCurrentState(FlowStateCode.DSH.getCode());
		flowSetData.setDataId(wid);
		flowSetData.setType(FlowSetCode.TASK.getCode());
		flowSetData.setShid(userId);
		flowSetData.setContent("提交检测");
		flowSetDataService.insert(flowSetData);
		
	}

	@Override
	public List<TaskInfo> selectDispalyTaskInfoByCondition(TaskInfo taskInfo) throws Exception {
		return taskInfoExtendMapper.selectDispalyTaskInfoByCondition(taskInfo);
	}

	@Override
	public List<TaskInfoDetail> selectDispalyTaskInfoDetailByCondition(TaskInfoDetail taskInfo) throws Exception {
		return taskInfoDetailExtendMapper.selectDispalyTaskInfoByCondition(taskInfo);
	}

}
