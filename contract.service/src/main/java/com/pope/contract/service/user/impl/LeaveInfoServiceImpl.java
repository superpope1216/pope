package com.pope.contract.service.user.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pope.contract.code.DataStatus;
import com.pope.contract.code.FlowSetCode;
import com.pope.contract.code.FlowStateCode;
import com.pope.contract.dao.user.LeaveInfoMapper;
import com.pope.contract.entity.system.FlowSet;
import com.pope.contract.entity.system.FlowSetData;
import com.pope.contract.entity.user.LeaveInfo;
import com.pope.contract.service.system.FlowSetDataService;
import com.pope.contract.service.system.FlowSetService;
import com.pope.contract.service.user.LeaveInfoService;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年6月4日 下午7:53:39
* 类说明
*/
@Service("leaveInfoService")
public class LeaveInfoServiceImpl implements LeaveInfoService {

	@Autowired
	private LeaveInfoMapper leaveInfoMapper; 
	
	@Autowired
	private FlowSetDataService flowSetDataService;
	@Autowired
	private FlowSetService flowSetService;
	@Override
	public int deleteByPrimaryKey(String wid,String userId) throws Exception{
		LeaveInfo record=new LeaveInfo();
		record.setWid(wid);
		record.setStatus(DataStatus.delete.getCode()); 
		record.setUpdateby(userId);
		record.setUpdatetime(DateUtil.getCurrentDate());
		return leaveInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	@Transactional
	/**
	 * 审核
	 * @param wid
	 * @param useId
	 * @return
	 * @throws Exception
	 */
	public int examinePass(String wid,String userId) throws Exception{
		LeaveInfo leaveInfo=this.leaveInfoMapper.selectByPrimaryKey(wid);
		FlowSet flowSet=flowSetService.selectNextStep(FlowSetCode.LEAVE.getCode(), Integer.valueOf(leaveInfo.getCurrentStep()));
		Integer currentStep=-1;
		
		if(flowSet==null || flowSet.getPx()==null){
			leaveInfo.setTaskstatus(FlowStateCode.YJS.getCode());
		}else{
			currentStep=flowSet.getPx();
			leaveInfo.setTaskstatus(FlowStateCode.JXZ.getCode());
		}
		leaveInfo.setCurrentStep(currentStep.toString());
		FlowSetData flowSetData=new FlowSetData();
		flowSetData.setWid(StringUtil.getUuId());
		flowSetData.setCjsj(DateUtil.getCurrentDateTimeStr());
		flowSetData.setCurrentStep(currentStep);
		flowSetData.setCurrentState(leaveInfo.getTaskstatus());
		flowSetData.setDataId(leaveInfo.getWid());
		flowSetData.setType(FlowSetCode.LEAVE.getCode());
		flowSetData.setShid(userId);
		flowSetData.setContent("审核通过");
		flowSetDataService.insert(flowSetData);
		return leaveInfoMapper.updateByPrimaryKeySelective(leaveInfo);
		
	}
	@Override
	@Transactional
	public int insert(LeaveInfo record,String userId) throws Exception {
		String userLevelId=StringUtil.getUuId();
		FlowSet flowSet=flowSetService.selectNextStep(FlowSetCode.LEAVE.getCode(), 0);
		record.setWid(userLevelId);
		record.setStatus(DataStatus.normal.getCode());
		record.setTaskstatus(FlowStateCode.DSH.getCode());
		record.setCreateby(userId);
		record.setCreatetime(DateUtil.getCurrentDate());
		record.setUpdateby(userId);
		record.setUpdatetime(DateUtil.getCurrentDate());
		record.setCurrentStep(flowSet.getPx().toString());
		record.setTime(caluTime(record.getStarttime(), record.getEndtime()));
		FlowSetData flowSetData=new FlowSetData();
		flowSetData.setWid(StringUtil.getUuId());
		flowSetData.setCjsj(DateUtil.getCurrentDateTimeStr());
		flowSetData.setCurrentStep(flowSet.getPx());
		flowSetData.setCurrentState(FlowStateCode.DSH.getCode());
		flowSetData.setDataId(userLevelId);
		flowSetData.setType(FlowSetCode.LEAVE.getCode());
		flowSetData.setShid(userId);
		flowSetData.setContent("提交审核");
		flowSetDataService.insert(flowSetData);
		return leaveInfoMapper.insert(record);
	}

	@Override
	public int insertSelective(LeaveInfo record,String userId) throws Exception {
		record.setWid(StringUtil.getUuId());
		record.setStatus(DataStatus.normal.getCode());
		record.setCreateby(userId);
		record.setCreatetime(DateUtil.getCurrentDate());
		record.setUpdateby(userId);
		record.setUpdatetime(DateUtil.getCurrentDate());
		record.setTime(caluTime(record.getStarttime(), record.getEndtime()));
		return leaveInfoMapper.insertSelective(record);
	}

	@Override
	public LeaveInfo selectByPrimaryKey(String wid) {
		return leaveInfoMapper.selectByPrimaryKey(wid);
	}
	@Override
	public List<LeaveInfo> selectByYhid(String yhid){
		return leaveInfoMapper.selectByYhid(yhid);
	}
	@Override
	public int updateByPrimaryKeySelective(LeaveInfo record,String userId) throws Exception {
		record.setUpdateby(userId);
		record.setUpdatetime(DateUtil.getCurrentDate());
		record.setTime(caluTime(record.getStarttime(), record.getEndtime()));
		return leaveInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(LeaveInfo record,String userId) throws Exception {
		record.setUpdateby(userId);
		record.setUpdatetime(DateUtil.getCurrentDate());
		record.setTime(caluTime(record.getStarttime(), record.getEndtime()));
		return leaveInfoMapper.updateByPrimaryKey(record);
	}

	private double caluTime(String start,String end) throws Exception{
		long days=DateUtil.getDaysBetween(start, end);
		Date d1=DateUtil.parseDateTime(start+":00");
		Date d2=DateUtil.parseDateTime(end+":00");
		
		int hours=d2.getHours()-d1.getHours();
		int minus=d2.getMinutes()-d1.getMinutes();
		hours=(int)days*8+hours;
		double dMinus=minus/60;
		return (hours+dMinus);
	}
	@Override	
	public List<LeaveInfo> selectByRoleId(String roldId,List<String> taskStatus,String departId,String teamId) throws Exception{
		FlowSet flowSet=flowSetService.selectByRoleAndType(roldId, FlowSetCode.LEAVE.getCode());
		return leaveInfoMapper.selectLeaveInfoByStep(flowSet.getPx().toString(), flowSet.getShType(),teamId , departId,taskStatus);
	}
	
	@Override	
	public List<LeaveInfo> selectByOtherRoleId(String roldId,List<String> taskStatus,String departId,String teamId) throws Exception{
		FlowSet flowSet=flowSetService.selectByRoleAndType(roldId, FlowSetCode.LEAVE.getCode());
		return leaveInfoMapper.selectLeaveInfoByStep(null, flowSet.getShType(),teamId , departId,taskStatus);
	}
	


}
