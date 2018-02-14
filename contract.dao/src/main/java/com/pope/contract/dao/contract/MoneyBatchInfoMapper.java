package com.pope.contract.dao.contract;

import com.pope.contract.entity.contract.MoneyBatchInfo;

public interface MoneyBatchInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(MoneyBatchInfo record);

    int insertSelective(MoneyBatchInfo record);

    MoneyBatchInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(MoneyBatchInfo record);

    int updateByPrimaryKey(MoneyBatchInfo record);
}