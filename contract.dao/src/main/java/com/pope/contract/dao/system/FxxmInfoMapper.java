package com.pope.contract.dao.system;

import com.pope.contract.entity.system.FxxmInfo;

public interface FxxmInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(FxxmInfo record);

    int insertSelective(FxxmInfo record);

    FxxmInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(FxxmInfo record);

    int updateByPrimaryKey(FxxmInfo record);
}