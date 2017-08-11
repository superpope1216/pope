package com.pope.contract.service.system.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.contract.dao.system.FlowSetDataMapper;
import com.pope.contract.entity.system.FlowSetData;
import com.pope.contract.service.system.FlowSetDataService;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年7月15日 下午12:16:05
* 类说明
*/
@Service("flowSetDataService")
public class FlowSetDataServiceImpl implements FlowSetDataService {

	@Autowired
	private FlowSetDataMapper flowSetDataMapper;
	@Override
	public int deleteByPrimaryKey(String wid) {
		return flowSetDataMapper.deleteByPrimaryKey(wid);
	}

	@Override
	public int insert(FlowSetData record) {
		return flowSetDataMapper.insert(record);
	}

	@Override
	public int insertSelective(FlowSetData record) {
		return flowSetDataMapper.insertSelective(record);
	}

	@Override
	public FlowSetData selectByPrimaryKey(String wid) {
		return flowSetDataMapper.selectByPrimaryKey(wid);
	}

	@Override
	public int updateByPrimaryKeySelective(FlowSetData record) {
		return flowSetDataMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(FlowSetData record) {
		return flowSetDataMapper.updateByPrimaryKey(record);
	}

	@Override
	public FlowSetData selectByDataId(String dataId) {
		return flowSetDataMapper.selectByDataId(dataId);
	}

}
