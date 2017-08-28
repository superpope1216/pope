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
import com.pope.contract.dao.supply.GmbInfoMapper;
import com.pope.contract.dao.supply.SupplyInfoMapper;
import com.pope.contract.dao.supply.SupplyTotalInfoMapper;
import com.pope.contract.dao.supply.extend.GmbInfoExtendMapper;
import com.pope.contract.dao.supply.extend.LqbInfoExtendMapper;
import com.pope.contract.entity.supply.GmbInfo;
import com.pope.contract.entity.supply.LqbInfo;
import com.pope.contract.entity.supply.ShbInfo;
import com.pope.contract.entity.supply.SupplyInfo;
import com.pope.contract.entity.supply.SupplyTotalInfo;
import com.pope.contract.entity.supply.extend.GmbInfoExtend;
import com.pope.contract.entity.supply.extend.LqbInfoExtend;
import com.pope.contract.entity.system.FlowSet;
import com.pope.contract.entity.system.FlowSetData;
import com.pope.contract.exception.ServiceException;
import com.pope.contract.service.BaseService;
import com.pope.contract.service.supply.GmbInfoService;
import com.pope.contract.service.system.FlowSetDataService;
import com.pope.contract.service.system.FlowSetService;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月18日 下午10:01:37
* 类说明
*/
@Service("gmbInfoService")
public class GmbInfoServiceImpl extends BaseService implements GmbInfoService {

	@Autowired
	private GmbInfoMapper gmbInfoMapper;
	@Autowired
	private SupplyInfoMapper supplyInfoMapper;
	@Autowired
	private SupplyTotalInfoMapper supplyTotalInfoMapper;
	@Autowired
	private GmbInfoExtendMapper gmbInfoExtendMapper;
	
	@Autowired
	private FlowSetDataService flowSetDataService;
	@Autowired
	private FlowSetService flowSetService;
	@Override
	public int deleteByPrimaryKey(String wid) throws Exception {
		return gmbInfoMapper.deleteByPrimaryKey(wid);
	}

	@Override
	@Transactional
	public int insert(GmbInfo record,String userId) throws Exception {
		String wid = StringUtil.getUuId();
		record.setUserid(userId);
		record.setWid(wid);
		FlowSet flowSet = flowSetService.selectNextStep(FlowSetCode.SUPPLY.getCode(), 0);
		record.setSqsj(DateUtil.getCurrentDateStr());
		record.setRwzt(StringUtil.toStr(FlowStateCode.DSH.getCode()));
		record.setCurentstep(flowSet.getPx());
		saveFlowSetData(flowSet.getPx(), wid, FlowStateCode.DSH, FlowSetCode.SUPPLY, userId,FlowStateCode.DSH.getMsg());
		return gmbInfoMapper.insert(record);
	}

	@Override
	public GmbInfo selectByPrimaryKey(String wid) throws Exception {
		return gmbInfoMapper.selectByPrimaryKey(wid);
	}

	@Override
	public int updateByPrimaryKeySelective(GmbInfo record) throws Exception {
		return gmbInfoMapper.updateByPrimaryKeySelective(record);
	}
	
	@Override
	@Transactional
	public void examinePass(String wid, String userid) throws Exception {
		// TODO Auto-generated method stub
		GmbInfo taskInfo=this.gmbInfoMapper.selectByPrimaryKey(wid);
		SupplyTotalInfo supplyInfo=supplyTotalInfoMapper.selectByPrimaryKey(taskInfo.getHcid());
		int kc=supplyInfo.getKc()==null?0:supplyInfo.getKc();
		int gml=taskInfo.getLysl()==null?0:taskInfo.getLysl();
		
		FlowSet flowSet=flowSetService.selectNextStep(FlowSetCode.SUPPLY.getCode(), taskInfo.getCurentstep());
		
		Integer currentStep=-1;
		if(flowSet==null || flowSet.getPx()==null){
			supplyInfo.setKc(kc+gml);
			taskInfo.setRwzt(StringUtil.toStr(FlowStateCode.YJS.getCode()));
			saveFlowSetData(currentStep, wid, FlowStateCode.YJS, FlowSetCode.SUPPLY, userid,FlowStateCode.YJS.getMsg());
		}else{
			currentStep=flowSet.getPx();
			taskInfo.setRwzt(StringUtil.toStr(FlowStateCode.JXZ.getCode()));
			saveFlowSetData(currentStep, wid, FlowStateCode.JXZ, FlowSetCode.SUPPLY, userid,FlowStateCode.JXZ.getMsg());
		}
		taskInfo.setCurentstep(currentStep);
		gmbInfoMapper.updateByPrimaryKeySelective(taskInfo);
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
		GmbInfo taskInfo=this.gmbInfoMapper.selectByPrimaryKey(wid); 
		Integer currentStep=taskInfo.getCurentstep();
		taskInfo.setCurentstep(-1);
		taskInfo.setRwzt(StringUtil.toStr(FlowStateCode.BTG.getCode()));
		saveFlowSetData(currentStep, wid, FlowStateCode.BTG, FlowSetCode.SUPPLY, userid,FlowStateCode.BTG.getMsg());
		gmbInfoMapper.updateByPrimaryKeySelective(taskInfo);
	}
	
	@Override
	/**
	 * 获取待审核的任务信息
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public List<GmbInfoExtend> selectWaitTaskInfoByStep(String roleId) throws Exception {
		FlowSet flowSet=flowSetService.selectByRoleAndType(roleId, FlowSetCode.CONTRACT.getCode());
		List<Integer> taskStatus=new ArrayList<Integer>();
		taskStatus.add(Integer.valueOf(FlowStateCode.DSH.getCode()));
		taskStatus.add(Integer.valueOf(FlowStateCode.JXZ.getCode()));
		return  gmbInfoExtendMapper.selectDispalyInfoByStep(flowSet.getPx(), taskStatus);
	}

	@Override
	public List<GmbInfoExtend> selectDispalyTaskInfoByCondition(GmbInfo lqbInfo) throws Exception {
		return gmbInfoExtendMapper.selectDispalyTaskInfoByCondition(lqbInfo);
	}

}
