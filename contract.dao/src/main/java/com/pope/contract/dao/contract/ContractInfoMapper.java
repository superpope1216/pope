package com.pope.contract.dao.contract;

import com.pope.contract.entity.contract.ContractInfo;

public interface ContractInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(ContractInfo record);

    int insertSelective(ContractInfo record);

    ContractInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(ContractInfo record);

    int updateByPrimaryKey(ContractInfo record);
}