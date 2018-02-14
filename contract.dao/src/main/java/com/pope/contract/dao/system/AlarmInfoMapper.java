package com.pope.contract.dao.system;

import com.pope.contract.entity.system.AlarmInfo;

public interface AlarmInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(AlarmInfo record);

    int insertSelective(AlarmInfo record);

    AlarmInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(AlarmInfo record);

    int updateByPrimaryKey(AlarmInfo record);
}