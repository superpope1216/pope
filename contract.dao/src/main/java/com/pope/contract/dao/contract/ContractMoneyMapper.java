package com.pope.contract.dao.contract;

import com.pope.contract.entity.contract.ContractMoney;

public interface ContractMoneyMapper {
    int deleteByPrimaryKey(String wid);

    int insert(ContractMoney record);

    int insertSelective(ContractMoney record);

    ContractMoney selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(ContractMoney record);

    int updateByPrimaryKey(ContractMoney record);
}