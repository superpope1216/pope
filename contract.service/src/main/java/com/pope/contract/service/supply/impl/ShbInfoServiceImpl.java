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
import com.pope.contract.dao.supply.ShbInfoMapper;
import com.pope.contract.dao.supply.SupplyInfoMapper;
import com.pope.contract.dao.supply.SupplyTotalInfoMapper;
import com.pope.contract.dao.supply.extend.GmbInfoExtendMapper;
import com.pope.contract.dao.supply.extend.ShbInfoExtendMapper;
import com.pope.contract.entity.supply.LqbInfo;
import com.pope.contract.entity.supply.ShbInfo;
import com.pope.contract.entity.supply.SupplyInfo;
import com.pope.contract.entity.supply.SupplyTotalInfo;
import com.pope.contract.entity.supply.extend.LqbInfoExtend;
import com.pope.contract.entity.supply.extend.ShbInfoExtend;
import com.pope.contract.entity.system.FlowSet;
import com.pope.contract.entity.system.FlowSetData;
import com.pope.contract.exception.ServiceException;
import com.pope.contract.service.BaseService;
import com.pope.contract.service.supply.ShbInfoService;
import com.pope.contract.service.system.FlowSetDataService;
import com.pope.contract.service.system.FlowSetService;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月18日 下午9:59:30
* 类说明
*/
@Service("shbInfoService")
public class ShbInfoServiceImpl extends BaseService implements ShbInfoService{
	@Autowired
	private FlowSetDataService flowSetDataService;
	
	@Autowired
	private SupplyInfoMapper supplyInfoMapper;
	@Autowired
	private SupplyTotalInfoMapper supplyTotalInfoMapper;
	@Autowired
	private ShbInfoExtendMapper shbInfoExtendMapper;
	@Autowired
	private FlowSetService flowSetService;
	@Autowired
	private ShbInfoMapper shbInfoMapper;
	@Override
	public int deleteByPrimaryKey(String wid) throws Exception {
		return shbInfoMapper.deleteByPrimaryKey(wid);
	}

	@Override
	@Transactional
	public int insert(ShbInfo record,String userId) throws Exception {
		SupplyTotalInfo supplyInfo=supplyTotalInfoMapper.selectByPrimaryKey(record.getHcid());
		int kc=supplyInfo.getKc()==null?0:supplyInfo.getKc();
		int lysl=record.getLysl()==null?0:record.getLysl();
		if((kc)<lysl){
			throw new ServiceException("当前可用数据小于领用数量，请重新确认！");
		}
		String wid = StringUtil.getUuId();
		record.setUserid(userId);
		record.setWid(wid);
		String taskStatus=FlowStateCode.YJS.getCode(),currentStep="0";
		
		FlowSet flowSet = flowSetService.selectNextStep(FlowSetCode.SUPPLY.getCode(), 0);
		if(flowSet!=null){
			taskStatus=FlowStateCode.DSH.getCode();
			currentStep=StringUtil.toStr(flowSet.getPx());
		}
		record.setSqsj(DateUtil.getCurrentDateStr());
		record.setRwzt(taskStatus);
		record.setCurentstep(StringUtil.toInt(currentStep));
		if(flowSet!=null){
			saveFlowSetData(flowSet.getPx(), wid, FlowStateCode.DSH, FlowSetCode.SUPPLY, userId,FlowStateCode.DSH.getMsg());
		}
		return shbInfoMapper.insert(record);
	}

	@Override
	public ShbInfo selectByPrimaryKey(String wid) throws Exception {
		return shbInfoMapper.selectByPrimaryKey(wid);
	}

	@Override
	public int updateByPrimaryKeySelective(ShbInfo record) throws Exception {
		return shbInfoMapper.updateByPrimaryKeySelective(record);
	}
	
	@Override
	@Transactional
	public void examinePass(String wid, String userid) throws Exception {
		// TODO Auto-generated method stub
		ShbInfo taskInfo=this.shbInfoMapper.selectByPrimaryKey(wid);
		SupplyTotalInfo supplyInfo=supplyTotalInfoMapper.selectByPrimaryKey(taskInfo.getHcid());
		int kc=supplyInfo.getKc()==null?0:supplyInfo.getKc();
		int lysl=taskInfo.getLysl()==null?0:taskInfo.getLysl();
		if((kc)<lysl){
			throw new ServiceException("当前可用数量小于损坏数量，请重新确认！");
		}
		
		FlowSet flowSet=flowSetService.selectNextStep(FlowSetCode.SUPPLY.getCode(), taskInfo.getCurentstep());
		
		Integer currentStep=-1;
		if(flowSet==null || flowSet.getPx()==null){
			supplyInfo.setKc(kc-lysl);
			taskInfo.setRwzt(StringUtil.toStr(FlowStateCode.YJS.getCode()));
			saveFlowSetData(currentStep, wid, FlowStateCode.YJS, FlowSetCode.SUPPLY, userid,FlowStateCode.YJS.getMsg());
		}else{
			currentStep=flowSet.getPx();
			taskInfo.setRwzt(StringUtil.toStr(FlowStateCode.JXZ.getCode()));
			saveFlowSetData(currentStep, wid, FlowStateCode.JXZ, FlowSetCode.SUPPLY, userid,FlowStateCode.JXZ.getMsg());
		}
		taskInfo.setCurentstep(currentStep);
		shbInfoMapper.updateByPrimaryKeySelective(taskInfo);
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
		ShbInfo taskInfo=this.shbInfoMapper.selectByPrimaryKey(wid); 
		Integer currentStep=taskInfo.getCurentstep();
		taskInfo.setCurentstep(-1);
		taskInfo.setRwzt(StringUtil.toStr(FlowStateCode.BTG.getCode()));
		saveFlowSetData(currentStep, wid, FlowStateCode.BTG, FlowSetCode.SUPPLY, userid,FlowStateCode.BTG.getMsg());
		shbInfoMapper.updateByPrimaryKeySelective(taskInfo);
	}
	
	@Override
	/**
	 * 获取待审核的任务信息
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public List<ShbInfoExtend> selectWaitTaskInfoByStep(String roleId) throws Exception {
		FlowSet flowSet=flowSetService.selectByRoleAndType(roleId, FlowSetCode.SUPPLY.getCode());
		List<Integer> taskStatus=new ArrayList<Integer>();
		taskStatus.add(Integer.valueOf(FlowStateCode.DSH.getCode()));
		taskStatus.add(Integer.valueOf(FlowStateCode.JXZ.getCode()));
		return  shbInfoExtendMapper.selectDispalyInfoByStep(flowSet.getPx(), taskStatus);
	}

	@Override
	public List<ShbInfoExtend> selectDispalyTaskInfoByCondition(ShbInfo lqbInfo) throws Exception {
		return shbInfoExtendMapper.selectDispalyTaskInfoByCondition(lqbInfo);
	}

}
