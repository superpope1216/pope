package com.pope.contract.service.task.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pope.contract.code.BatchStateEnum;
import com.pope.contract.code.DataStatus;
import com.pope.contract.code.FlowSetCode;
import com.pope.contract.code.FlowStateCode;
import com.pope.contract.code.TaskSonStatusEnum;
import com.pope.contract.code.TaskStatusEnum;
import com.pope.contract.dao.project.BatchInfoMapper;
import com.pope.contract.dao.project.extend.BatchInfoDetailExtendMapper;
import com.pope.contract.dao.system.FxxmInfoMapper;
import com.pope.contract.dao.system.extend.FxxmInfoExtendMapper;
import com.pope.contract.dao.task.TaskInfoDetailMapper;
import com.pope.contract.dao.task.TaskInfoMapper;
import com.pope.contract.dao.task.extend.TaskInfoDetailExtendMapper;
import com.pope.contract.dao.task.extend.TaskInfoExtendMapper;
import com.pope.contract.entity.project.BatchInfo;
import com.pope.contract.entity.project.BatchInfoDetail;
import com.pope.contract.entity.system.FlowSet;
import com.pope.contract.entity.system.FlowSetData;
import com.pope.contract.entity.system.FxxmInfo;
import com.pope.contract.entity.system.extend.FxxmExtendInfo;
import com.pope.contract.entity.task.TaskInfo;
import com.pope.contract.entity.task.TaskInfoDetail;
import com.pope.contract.entity.task.extend.TaskInfoExtend;
import com.pope.contract.entity.user.LeaveInfo;
import com.pope.contract.service.BaseService;
import com.pope.contract.service.system.FlowSetDataService;
import com.pope.contract.service.system.FlowSetService;
import com.pope.contract.service.task.TaskInfoService;
import com.pope.contract.util.CommonUtil;
import com.pope.contract.util.ConstantUtil;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月14日 上午9:24:38
* 类说明
*/
@Service("taskInfoService")
public class TaskInfoServiceImpl extends BaseService implements TaskInfoService{

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
	private BatchInfoMapper batchInfoMapper;
	@Autowired
	private FlowSetDataService flowSetDataService;
	@Autowired
	private FlowSetService flowSetService;
	
	@Autowired
	private FxxmInfoMapper fxxmInfoMapper;
	
	@Override
	@Transactional
	public void insertTaskInfo(TaskInfo taskInfo,String userId) throws Exception {
		Integer max=taskInfoExtendMapper.selectMaxXh();
		BatchInfo batchInfo=batchInfoMapper.selectByPrimaryKey(taskInfo.getPcwid());
		FxxmInfo queryFxxmInfo=new FxxmInfo();
		queryFxxmInfo.setWid(taskInfo.getFxxm());
		FxxmInfo fxxmInfo=fxxmInfoMapper.selectByPrimaryKey(taskInfo.getFxxm());
		if(max==null)max=0;
		max++;
		String sMax=String.format("%05d",max);
		String wid=StringUtil.getUuId();
		taskInfo.setWid(wid);
		taskInfo.setRwmc(batchInfo.getPcmc()+fxxmInfo.getLbmc());
		taskInfo.setRwfpr(fxxmInfo.getFxry());
		taskInfo.setRwshr(fxxmInfo.getShry());
		taskInfo.setRwbh(sMax);
		taskInfo.setDatastatus(StringUtil.toStr(DataStatus.normal.getCode()));
		taskInfo.setDqbh(max);
		taskInfo.setRwbh(sMax);
		taskInfo.setRwzt(TaskStatusEnum.QCL.getCode());
		//FlowSet flowSet=flowSetService.selectNextStep(FlowSetCode.LEAVE.getCode(), 0);
		//taskInfo.setCurrentstep(flowSet.getPx());
		BatchInfoDetail batchInfoDetail=new BatchInfoDetail();
		batchInfoDetail.setPcwid(taskInfo.getPcwid());
		List<BatchInfoDetail> listBatchInfoDetail=batchInfoDetailExtendMapper.selectByCondition(batchInfoDetail);
		if(CommonUtil.isNotEmptyList(listBatchInfoDetail)){
			for(BatchInfoDetail detail:listBatchInfoDetail){
				if(detail.getFxxm().indexOf(taskInfo.getFxxm())<0){
					continue;
				}
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
				taskInfoDetail.setRwzt(TaskStatusEnum.QCL.getCode());
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
//		FlowSetData flowSetData=new FlowSetData();
//		flowSetData.setWid(StringUtil.getUuId());
//		flowSetData.setCjsj(DateUtil.getCurrentDateTimeStr());
//		flowSetData.setCurrentStep(flowSet.getPx());
//		flowSetData.setCurrentState(FlowStateCode.DSH.getCode());
//		flowSetData.setDataId(wid);
//		flowSetData.setType(FlowSetCode.TASK.getCode());
//		flowSetData.setShid(userId);
//		flowSetData.setContent("提交检测");
//		flowSetDataService.insert(flowSetData);
		
	}

	@Override
	public List<TaskInfoExtend> selectDispalyTaskInfoByCondition(TaskInfo taskInfo) throws Exception {
		return taskInfoExtendMapper.selectDispalyTaskInfoByCondition(taskInfo);
	}

	@Override
	public List<TaskInfoDetail> selectDispalyTaskInfoDetailByCondition(TaskInfoDetail taskInfo) throws Exception {
		return taskInfoDetailExtendMapper.selectDispalyTaskInfoByCondition(taskInfo);
	}

	@Override
	@Transactional
	public void submitTaskInfoDetail(String pid,List<Map> datas,String userId) throws Exception {
		TaskInfo taskInfo=taskInfoMapper.selectByPrimaryKey(pid);
		
		int minValue=Integer.MAX_VALUE;
		List<String> existRecord=new ArrayList<String>(); 
		if(CommonUtil.isNotEmptyList(datas)){
			for(Map map:datas){
				String wid=StringUtil.toStr(map.get("wid"));
				int value=StringUtil.toInt(map.get("value"));
				if(value<taskInfo.getRwzt()){
					throw new Exception("存在任务子项状态小于主任务状态，请重新确认！");
				}
				if(value<minValue){
					minValue=value;
				}
				existRecord.add(wid);
				TaskInfoDetail taskInfDetail=new TaskInfoDetail();
				taskInfDetail.setWid(wid);
				taskInfDetail.setRwzt(value);
				taskInfoDetailMapper.updateByPrimaryKeySelective(taskInfDetail);
			}
		}
		Integer databaseMinValue=taskInfoDetailExtendMapper.selectMinZtByPid(pid,existRecord);
		databaseMinValue=(databaseMinValue==null)?minValue:databaseMinValue;
		if(databaseMinValue<minValue){
			minValue=databaseMinValue;
		}
		taskInfo.setRwzt(minValue);
		taskInfo.setSjkssj(DateUtil.getCurrentDateStr());
		if(minValue==TaskStatusEnum.SJBG.getCode()){
			taskInfo.setSjjssj(DateUtil.getCurrentDateStr());
		}
		if(minValue==TaskStatusEnum.QCL.getCode()){
			taskInfo.setSjkssj(DateUtil.getCurrentDateStr());
		}else if(minValue==TaskStatusEnum.SJBG.getCode()){
			taskInfo.setSjjssj(DateUtil.getCurrentDateStr());
		}
		taskInfoMapper.updateByPrimaryKeySelective(taskInfo); 
		if(minValue==TaskStatusEnum.JC.getCode() ||minValue==TaskStatusEnum.SJCL.getCode() ||minValue==TaskStatusEnum.SJBG.getCode()){
			BatchStateEnum batchStateEnum=BatchStateEnum.JCZ;
			BatchInfo batchInfo=new BatchInfo();
			batchInfo.setWid(taskInfo.getPcwid());
			batchInfo.setPczt(StringUtil.toStr(batchStateEnum.getCode())); 
			batchInfoMapper.updateByPrimaryKeySelective(batchInfo);
		}
	}

	@Override
	@Transactional
	public void submitTaskInfo(List<Map> datas,String userId) throws Exception {
		if(CommonUtil.isNotEmptyList(datas)){
			for(Map map:datas){
				String wid=StringUtil.toStr(map.get("wid"));
				TaskInfo taskInfo=new TaskInfo();
				taskInfo.setWid(wid);
				taskInfo.setRwzt(TaskStatusEnum.SH.getCode());
				//FlowSet flowSet=flowSetService.selectNextStep(FlowSetCode.TASK.getCode(), 0);
				//taskInfo.setCurrentstep(flowSet.getPx()); 
				//saveFlowSetData(flowSet.getPx(), wid, FlowStateCode.DSH, FlowSetCode.TASK, userId,"提交审核"); 
				taskInfoMapper.updateByPrimaryKeySelective(taskInfo);
			}
		}
	}
	
	@Override
	public List<TaskInfo> selectTaskInfoByCondition(TaskInfo taskInfo){
		return taskInfoExtendMapper.selectTaskInfoByCondition(taskInfo);
	}

	@Override
	/**
	 * 获取待审核的任务信息
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public List<TaskInfo> selectWaitTaskInfoByStep(String roleId) throws Exception {
		FlowSet flowSet=flowSetService.selectByRoleAndType(roleId, FlowSetCode.TASK.getCode());
		List<Integer> taskStatus=new ArrayList<Integer>();
		taskStatus.add(TaskStatusEnum.SH.getCode());
		taskStatus.add(TaskStatusEnum.SHJXZ.getCode());
		return taskInfoExtendMapper.selectDispalyTaskInfoByStep(flowSet.getPx(), taskStatus);
	}

	@Override
	public void examinePass(String wid, String userid) throws Exception {
		// TODO Auto-generated method stub
		//TaskInfo taskInfo=this.taskInfoMapper.selectByPrimaryKey(wid);
		TaskInfo taskInfo=new TaskInfo();
		taskInfo.setWid(wid);
		//FlowSet flowSet=flowSetService.selectNextStep(FlowSetCode.TASK.getCode(), taskInfo.getCurrentstep());
		
		Integer currentStep=-1;
//		if(flowSet==null || flowSet.getPx()==null){
//			taskInfo.setRwzt(TaskStatusEnum.SHTG.getCode());
//			
//			saveFlowSetData(currentStep, wid, FlowStateCode.YJS, FlowSetCode.TASK, userid,FlowStateCode.YJS.getMsg());
//		}else{
//			currentStep=flowSet.getPx();
//			taskInfo.setRwzt(TaskStatusEnum.SHJXZ.getCode());
//			
//			saveFlowSetData(currentStep, wid, FlowStateCode.JXZ, FlowSetCode.TASK, userid,FlowStateCode.JXZ.getMsg());
//		}
		taskInfo.setRwshr(userid);
		taskInfo.setCurrentstep(currentStep);
		taskInfo.setRwzt(TaskStatusEnum.SHTG.getCode());
		taskInfo.setShwcsj(DateUtil.getCurrentDateStr());
		taskInfoMapper.updateByPrimaryKeySelective(taskInfo);
	}

	@Override
	/**
	 * 审核不通过
	 * @param wid
	 * @param userid
	 * @throws Exception
	 */
	public void examineNotPass(String wid, String userid) throws Exception {
		//TaskInfo taskInfo=this.taskInfoMapper.selectByPrimaryKey(wid);
		TaskInfo taskInfo=new TaskInfo();
		taskInfo.setWid(wid);
		Integer currentStep=taskInfo.getCurrentstep();
		taskInfo.setRwzt(TaskStatusEnum.SHBTG.getCode());
		taskInfo.setRwshr(userid);
		taskInfo.setCurrentstep(-1);
		taskInfo.setShwcsj(DateUtil.getCurrentDateStr());
		//saveFlowSetData(currentStep, wid, FlowStateCode.BTG, FlowSetCode.TASK, userid,FlowStateCode.BTG.getMsg());
		taskInfoMapper.updateByPrimaryKeySelective(taskInfo);
	}

	@Override
	public List<TaskInfoExtend> selectDispalyTaskInfoByPermission(String roleName, String userId,TaskStatusEnum taskStatus) throws Exception {
		if(ConstantUtil.FXRY_ROLE_NAME.equals(roleName)){
			return taskInfoExtendMapper.selectDispalyTaskInfoByPermission(userId, null,taskStatus.getCode());
		}else if(ConstantUtil.SHRY_ROLE_NAME.equals(roleName)){
			return taskInfoExtendMapper.selectDispalyTaskInfoByPermission(null,userId,taskStatus.getCode());
		}else{
			return taskInfoExtendMapper.selectDispalyTaskInfoByCondition(null);
		}
	}


	

	
}
