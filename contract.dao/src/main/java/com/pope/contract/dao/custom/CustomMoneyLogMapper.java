package com.pope.contract.dao.custom;

import com.pope.contract.entity.custom.CustomMoneyLog;

public interface CustomMoneyLogMapper {
    int deleteByPrimaryKey(String wid);

    int insert(CustomMoneyLog record);

    int insertSelective(CustomMoneyLog record);

    CustomMoneyLog selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(CustomMoneyLog record);

    int updateByPrimaryKey(CustomMoneyLog record);
}