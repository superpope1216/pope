package com.pope.contract.service.system;

import java.util.List;

import com.pope.contract.entity.system.AlarmInfo;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年11月1日 上午11:22:02 类说明
 */
public interface AlarmInfoService {
	int deleteByPrimaryKey(String wid);

	int insert(AlarmInfo record);

	int insertSelective(AlarmInfo record);

	AlarmInfo selectByPrimaryKey(String wid);

	int updateByPrimaryKeySelective(AlarmInfo record);

	int updateByPrimaryKey(AlarmInfo record);

	AlarmInfo selectSingleByCondition(AlarmInfo alarmInfo);

	List<AlarmInfo> selectByCondition(AlarmInfo alarmInfo);
	
	List<AlarmInfo> selectByRoles(List<String> roles);
}
