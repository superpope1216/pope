package com.pope.contract.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.contract.dao.system.AlarmInfoMapper;
import com.pope.contract.dao.system.extend.AlarmInfoExtendMapper;
import com.pope.contract.entity.system.AlarmInfo;
import com.pope.contract.service.system.AlarmInfoService;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年11月1日 上午11:22:52
* 类说明
*/
@Service("alarmInfoService")
public class AlarmInfoServiceImpl implements AlarmInfoService{

	@Autowired
	private AlarmInfoMapper alarmInfoMapper;
	@Autowired
	private AlarmInfoExtendMapper alarmInfoExtendMapper;
	@Override
	public int deleteByPrimaryKey(String wid) {
		return alarmInfoMapper.deleteByPrimaryKey(wid);
	}

	@Override
	public int insert(AlarmInfo record) {
		return alarmInfoMapper.insert(record);
	}

	@Override
	public int insertSelective(AlarmInfo record) {
	return  alarmInfoMapper.insertSelective(record);
	}

	@Override
	public AlarmInfo selectByPrimaryKey(String wid) {
		return  alarmInfoMapper.selectByPrimaryKey(wid);
	}

	@Override
	public int updateByPrimaryKeySelective(AlarmInfo record) {
		return alarmInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(AlarmInfo record) {
		return alarmInfoMapper.updateByPrimaryKey(record);
	}

	@Override
	public AlarmInfo selectSingleByCondition(AlarmInfo alarmInfo) {
		return alarmInfoExtendMapper.selectSingleByCondition(alarmInfo);
	}

	@Override
	public List<AlarmInfo> selectByCondition(AlarmInfo alarmInfo) {
		return alarmInfoExtendMapper.selectByCondition(alarmInfo);
	}
	@Override
	public List<AlarmInfo> selectByRoles(List<String> roles){
		return alarmInfoExtendMapper.selectByRoles(roles);
	}
}
