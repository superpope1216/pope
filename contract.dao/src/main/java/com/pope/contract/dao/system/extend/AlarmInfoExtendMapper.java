package com.pope.contract.dao.system.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.system.AlarmInfo;

public interface AlarmInfoExtendMapper {
   
	AlarmInfo selectSingleByCondition(AlarmInfo alarmInfo);
	
	List<AlarmInfo> selectByCondition(AlarmInfo alarmInfo);
	
	List<AlarmInfo> selectByRoles(@Param("roles") List<String> roles);
}