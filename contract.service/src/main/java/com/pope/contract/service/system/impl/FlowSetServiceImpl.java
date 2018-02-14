package com.pope.contract.service.system.impl;

import java.util.List;

import org.apache.commons.lang3.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.contract.code.FlowSetCode;
import com.pope.contract.dao.system.FlowSetMapper;
import com.pope.contract.entity.system.FlowSet;
import com.pope.contract.exception.ServiceException;
import com.pope.contract.service.system.FlowSetService;
import com.pope.contract.util.CommonUtil;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年6月25日 下午8:56:55
* 类说明
*/
@Service("flowSetService")
public class FlowSetServiceImpl implements FlowSetService{

	@Autowired
	private FlowSetMapper flowSetMapper;
	@Override
	public int deleteByPrimaryKey(String wid) throws Exception {
		
		return flowSetMapper.deleteByPrimaryKey(wid);
	}

	@Override
	public int insert(FlowSet record) throws Exception {
		record.setWid(StringUtil.getUuId());
		FlowSet queryFlowSet=new FlowSet();
		queryFlowSet.setPx(record.getPx());
		queryFlowSet.setType(record.getType());
		FlowSet oldFlowSet=flowSetMapper.selectSingleByCondition(queryFlowSet);
		if(oldFlowSet!=null){
			throw new ServiceException("该步骤已存在，请重新选择！");
		}
		return flowSetMapper.insert(record);
	}

	@Override
	public int insertSelective(FlowSet record) throws Exception {
		FlowSet queryFlowSet=new FlowSet();
		queryFlowSet.setPx(record.getPx());
		queryFlowSet.setType(record.getType());
		FlowSet oldFlowSet=flowSetMapper.selectSingleByCondition(queryFlowSet);
		if(oldFlowSet!=null){
			throw new ServiceException("该步骤已存在，请重新选择！");
		}
		return flowSetMapper.insertSelective(record);
	}

	@Override
	public FlowSet selectByPrimaryKey(String wid) throws Exception {
		return flowSetMapper.selectByPrimaryKey(wid);
	}

	@Override
	public FlowSet selectByRoleAndType(String name,String type) throws Exception{
		return flowSetMapper.selectByRoleAndType(name, type);
	}
	@Override
	public int updateByPrimaryKeySelective(FlowSet record) throws Exception {
		FlowSet queryFlowSet=new FlowSet();
		queryFlowSet.setPx(record.getPx());
		queryFlowSet.setType(record.getType());
		FlowSet oldFlowSet=flowSetMapper.selectSingleByCondition(queryFlowSet);
		if(oldFlowSet!=null &&!oldFlowSet.getWid().equals(record.getWid())){
			throw new ServiceException("该步骤已存在，请重新选择！");
		}
		return flowSetMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(FlowSet record) throws Exception {
		return flowSetMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<FlowSet> list(FlowSet flowSet) throws Exception{
		return flowSetMapper.list(flowSet);
	}

	@Override
	public FlowSet selectNextStep(String type, int currentStep) throws Exception {
		List<FlowSet> list=flowSetMapper.selectNextStep(currentStep,type);
		FlowSet flowSet=null;
		if(CommonUtil.isNotEmptyList(list)){
			flowSet=list.get(0);
		}
		return flowSet;
	}
}
