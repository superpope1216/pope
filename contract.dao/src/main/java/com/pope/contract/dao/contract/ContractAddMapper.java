package com.pope.contract.dao.contract;

import com.pope.contract.entity.contract.ContractAdd;

public interface ContractAddMapper {
    int deleteByPrimaryKey(String wid);

    int insert(ContractAdd record);

    int insertSelective(ContractAdd record);

    ContractAdd selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(ContractAdd record);

    int updateByPrimaryKey(ContractAdd record);
}