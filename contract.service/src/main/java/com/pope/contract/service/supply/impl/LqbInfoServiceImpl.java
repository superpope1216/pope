package com.pope.contract.service.supply.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.pope.contract.code.FlowSetCode;
import com.pope.contract.code.FlowStateCode;
import com.pope.contract.code.TaskStatusEnum;
import com.pope.contract.dao.supply.LqbInfoMapper;
import com.pope.contract.dao.supply.SupplyInfoMapper;
import com.pope.contract.dao.supply.SupplyTotalInfoMapper;
import com.pope.contract.dao.supply.extend.LqbInfoExtendMapper;
import com.pope.contract.entity.supply.LqbInfo;
import com.pope.contract.entity.supply.SupplyInfo;
import com.pope.contract.entity.supply.SupplyTotalInfo;
import com.pope.contract.entity.supply.extend.LqbInfoExtend;
import com.pope.contract.entity.system.FlowSet;
import com.pope.contract.entity.system.FlowSetData;
import com.pope.contract.entity.task.TaskInfo;
import com.pope.contract.exception.ServiceException;
import com.pope.contract.service.BaseService;
import com.pope.contract.service.supply.LqbInfoService;
import com.pope.contract.service.system.FlowSetDataService;
import com.pope.contract.service.system.FlowSetService;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年8月18日 下午9:55:41 类说明
 */
@Service("lqbInfoService")
public class LqbInfoServiceImpl extends BaseService implements LqbInfoService {

	@Autowired
	private LqbInfoMapper lqbInfoMapper;
	
	@Autowired
	private SupplyInfoMapper supplyInfoMapper;
	
	@Autowired
	private SupplyTotalInfoMapper supplyTotalInfoMapper;
	
	@Autowired
	private LqbInfoExtendMapper lqbInfoExtendMapper;
	@Autowired
	private FlowSetDataService flowSetDataService;
	@Autowired
	private FlowSetService flowSetService;

	@Override
	public int deleteByPrimaryKey(String wid) throws Exception {
		return lqbInfoMapper.deleteByPrimaryKey(wid);
	}

	@Override
	@Transactional
	public int insert(LqbInfo record,String userId) throws Exception {
		SupplyTotalInfo supplyInfo=supplyTotalInfoMapper.selectByPrimaryKey(record.getHcid());
		int kc=supplyInfo.getKc()==null?0:supplyInfo.getKc();
		int ghsl=record.getGhsl()==null?0:record.getGhsl();
		int lysl=record.getLysl()==null?0:record.getLysl();
		if((kc+ghsl)<lysl){
			throw new ServiceException("当前可用数量小于领用数量，请重新确认！");
		}
		String wid = StringUtil.getUuId();
		record.setUserid(userId);
		record.setWid(wid);
		FlowSet flowSet = flowSetService.selectNextStep(FlowSetCode.SUPPLY.getCode(), 0);
		record.setSqsj(DateUtil.getCurrentDateStr());
		record.setRwzt(StringUtil.toStr(TaskStatusEnum.SH.getCode()));
		record.setCurentstep(flowSet.getPx());
		saveFlowSetData(flowSet.getPx(), wid, FlowStateCode.DSH, FlowSetCode.SUPPLY, userId,FlowStateCode.DSH.getMsg());
		return lqbInfoMapper.insert(record);
	}

	@Override
	public LqbInfo selectByPrimaryKey(String wid) throws Exception {
		return lqbInfoMapper.selectByPrimaryKey(wid);
	}

	@Override
	public int updateByPrimaryKeySelective(LqbInfo record) throws Exception {
		return lqbInfoMapper.updateByPrimaryKeySelective(record);
	}
	
	@Override
	@Transactional
	public void examinePass(String wid, String userid) throws Exception {
		// TODO Auto-generated method stub
		LqbInfo taskInfo=this.lqbInfoMapper.selectByPrimaryKey(wid);
		SupplyTotalInfo supplyInfo=supplyTotalInfoMapper.selectByPrimaryKey(taskInfo.getHcid());
		int kc=supplyInfo.getKc()==null?0:supplyInfo.getKc();
		int ghsl=taskInfo.getGhsl()==null?0:taskInfo.getGhsl();
		int lysl=taskInfo.getLysl()==null?0:taskInfo.getLysl();
		if((kc+ghsl)<lysl){
			throw new ServiceException("当前可用数量小于领用数量，请重新确认！");
		}
		
		FlowSet flowSet=flowSetService.selectNextStep(FlowSetCode.SUPPLY.getCode(), taskInfo.getCurentstep());
		
		Integer currentStep=-1;
		if(flowSet==null || flowSet.getPx()==null){
			supplyInfo.setKc(kc+ghsl-lysl);
			taskInfo.setRwzt(StringUtil.toStr(TaskStatusEnum.SHTG.getCode()));
			saveFlowSetData(currentStep, wid, FlowStateCode.YJS, FlowSetCode.SUPPLY, userid,FlowStateCode.YJS.getMsg());
		}else{
			currentStep=flowSet.getPx();
			taskInfo.setRwzt(StringUtil.toStr(TaskStatusEnum.SHJXZ.getCode()));
			saveFlowSetData(currentStep, wid, FlowStateCode.JXZ, FlowSetCode.SUPPLY, userid,FlowStateCode.JXZ.getMsg());
		}
		taskInfo.setCurentstep(currentStep);
		lqbInfoMapper.updateByPrimaryKeySelective(taskInfo);
		supplyTotalInfoMapper.updateByPrimaryKeySelective(supplyInfo);
	}

	@Override
	@Transactional
	/**
	 * 审核不通过
	 * @param wid
	 * @param userid
	 * @throws Exception
	 */
	public void examineNotPass(String wid, String userid) throws Exception {
		LqbInfo taskInfo=this.lqbInfoMapper.selectByPrimaryKey(wid); 
		Integer currentStep=taskInfo.getCurentstep();
		taskInfo.setCurentstep(-1);
		taskInfo.setRwzt(StringUtil.toStr(TaskStatusEnum.SHBTG.getCode()));
		saveFlowSetData(currentStep, wid, FlowStateCode.BTG, FlowSetCode.SUPPLY, userid,FlowStateCode.BTG.getMsg());
		lqbInfoMapper.updateByPrimaryKeySelective(taskInfo);
	}
	
	@Override
	/**
	 * 获取待审核的任务信息
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public List<LqbInfoExtend> selectWaitTaskInfoByStep(String roleId) throws Exception {
		FlowSet flowSet=flowSetService.selectByRoleAndType(roleId, FlowSetCode.SUPPLY.getCode());
		List<Integer> taskStatus=new ArrayList<Integer>();
		taskStatus.add(TaskStatusEnum.SH.getCode());
		taskStatus.add(TaskStatusEnum.SHJXZ.getCode());
		return  lqbInfoExtendMapper.selectDispalyInfoByStep(flowSet.getPx(), taskStatus);
	}

	@Override
	public List<LqbInfoExtend> selectDispalyTaskInfoByCondition(LqbInfo lqbInfo) throws Exception {
		return lqbInfoExtendMapper.selectDispalyTaskInfoByCondition(lqbInfo);
	}

}
