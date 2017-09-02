package com.pope.contract.dao.custom;

import com.pope.contract.entity.custom.CustomUpdateLog;

public interface CustomUpdateLogMapper {
    int deleteByPrimaryKey(String wid);

    int insert(CustomUpdateLog record);

    int insertSelective(CustomUpdateLog record);

    CustomUpdateLog selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(CustomUpdateLog record);

    int updateByPrimaryKey(CustomUpdateLog record);
}