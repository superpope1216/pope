package com.pope.contract.service.pxgl.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pope.contract.code.FlowSetCode;
import com.pope.contract.code.FlowStateCode;
import com.pope.contract.dao.pxgl.PxglInfoMapper;
import com.pope.contract.dao.pxgl.extend.PxglInfoExtendMapper;
import com.pope.contract.entity.pxgl.PxglInfo;
import com.pope.contract.entity.pxgl.extend.PxglInfoExtend;
import com.pope.contract.entity.supply.ShbInfo;
import com.pope.contract.entity.supply.SupplyTotalInfo;
import com.pope.contract.entity.system.FlowSet;
import com.pope.contract.exception.ServiceException;
import com.pope.contract.service.BaseService;
import com.pope.contract.service.pxgl.PxglInfoService;
import com.pope.contract.service.system.FlowSetService;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年9月10日 下午2:54:26
* 类说明
*/
@Service("pxglInfoService")
public class PxglInfoServiceImpl extends BaseService implements PxglInfoService{
	@Autowired
	private FlowSetService flowSetService;
	@Autowired
	private PxglInfoMapper pxglInfoMapper;
	
	@Autowired
	private PxglInfoExtendMapper pxglInfoExtendMapper;
	@Override
	public int deleteByPrimaryKey(String wid) {
		if(StringUtils.isEmpty(wid)){
			throw new ServiceException("WI不能为空");
		}
		PxglInfo info=this.selectByPrimaryKey(wid);
		if(!FlowStateCode.CG.getCode().equals(StringUtil.toStr(info.getRwzt()))){
			throw new ServiceException("该任务状态下的任务不能删除！");
		}
		return pxglInfoMapper.deleteByPrimaryKey(wid);
	}

	@Override
	@Transactional
	public int insertSelective(PxglInfo record,String flag)  throws Exception{
		String wid=StringUtil.getUuId();
		record.setWid(wid);
		record.setBy2(DateUtil.getCurrentDateTimeStr());
		if(flag.equals("1")){//保存草稿
			record.setRwzt(StringUtil.toInt(FlowStateCode.CG.getCode()));
		}else{//提交审核
			
			FlowSet flowSet = flowSetService.selectNextStep(FlowSetCode.PXGL.getCode(), 0);
			String currentStep="0",taskStatus=FlowStateCode.YJS.getCode();
			if(flowSet!=null){
				currentStep=flowSet.getPx().toString();
				taskStatus=FlowStateCode.DSH.getCode();
			}
			record.setCurrentstep(StringUtil.toInt(currentStep));
			record.setRwzt(StringUtil.toInt(taskStatus));
			if(flowSet!=null){
				saveFlowSetData(flowSet.getPx(), wid, FlowStateCode.DSH, FlowSetCode.PXGL, record.getBy1(),FlowStateCode.DSH.getMsg());
			}
		}
		return pxglInfoMapper.insertSelective(record);
	}

	@Override
	public PxglInfo selectByPrimaryKey(String wid) {
		return pxglInfoMapper.selectByPrimaryKey(wid);
	}

	@Override
	@Transactional
	public int updateByPrimaryKeySelective(PxglInfo record,String flag)  throws Exception{
		record.setBy2(DateUtil.getCurrentDateTimeStr());
		if(flag.equals("1")){//保存草稿
			
		}else{
			if(FlowStateCode.CG.getCode().equals(StringUtil.toStr(record.getRwzt()))){
				throw new ServiceException("任务状态错误，请重新确认！");
			}
			FlowSet flowSet = flowSetService.selectNextStep(FlowSetCode.PXGL.getCode(), 0);
			String currentStep="0",taskStatus=FlowStateCode.YJS.getCode();
			if(flowSet!=null){
				currentStep=flowSet.getPx().toString();
				taskStatus=FlowStateCode.DSH.getCode();
			}
			record.setCurrentstep(StringUtil.toInt(currentStep));
			record.setRwzt(StringUtil.toInt(taskStatus));
			if(flowSet!=null){
				saveFlowSetData(flowSet.getPx(), record.getWid(), FlowStateCode.DSH, FlowSetCode.PXGL, record.getBy1(),FlowStateCode.DSH.getMsg());
			}
		}
		return pxglInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public PxglInfo selectSingleByCondition(PxglInfoExtend pxglInfoExtend) {
		return pxglInfoExtendMapper.selectSingleByCondition(pxglInfoExtend);
	}

	@Override
	public List<PxglInfo> selectByCondition(PxglInfoExtend pxglInfoExtend) {
		return pxglInfoExtendMapper.selectByCondition(pxglInfoExtend);
	}

	@Override
	public PxglInfoExtend selectSingleDisplayByCondition(PxglInfoExtend pxglInfoExtend) {
		return pxglInfoExtendMapper.selectSingleDisplayByCondition(pxglInfoExtend);
	}

	@Override
	public List<PxglInfoExtend> selectDisplayByCondition(PxglInfoExtend pxglInfoExtend) {
		return pxglInfoExtendMapper.selectDisplayByCondition(pxglInfoExtend);
	}

	
	@Override
	@Transactional
	public void examinePass(String wid, String userid) throws Exception {
		// TODO Auto-generated method stub
		PxglInfo taskInfo=this.selectByPrimaryKey(wid);
		
		FlowSet flowSet=flowSetService.selectNextStep(FlowSetCode.PXGL.getCode(), taskInfo.getCurrentstep());
		
		Integer currentStep=-1;
		if(flowSet==null || flowSet.getPx()==null){
			
			taskInfo.setRwzt(StringUtil.toInt(FlowStateCode.YJS.getCode()));
			saveFlowSetData(currentStep, wid, FlowStateCode.YJS, FlowSetCode.PXGL, userid,FlowStateCode.YJS.getMsg());
		}else{
			currentStep=flowSet.getPx();
			taskInfo.setRwzt(StringUtil.toInt(FlowStateCode.JXZ.getCode()));
			saveFlowSetData(currentStep, wid, FlowStateCode.JXZ, FlowSetCode.PXGL, userid,FlowStateCode.JXZ.getMsg());
		}
		taskInfo.setCurrentstep(currentStep);
		this.pxglInfoMapper.updateByPrimaryKeySelective(taskInfo);
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
		PxglInfo taskInfo=this.selectByPrimaryKey(wid);
		Integer currentStep=taskInfo.getCurrentstep();
		taskInfo.setCurrentstep(-1);
		taskInfo.setRwzt(StringUtil.toInt(FlowStateCode.BTG.getCode()));
		saveFlowSetData(currentStep, wid, FlowStateCode.BTG, FlowSetCode.PXGL, userid,FlowStateCode.BTG.getMsg());
		this.pxglInfoMapper.updateByPrimaryKeySelective(taskInfo);
	}
}
