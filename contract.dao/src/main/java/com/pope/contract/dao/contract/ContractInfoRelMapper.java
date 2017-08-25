package com.pope.contract.dao.contract;

import com.pope.contract.entity.contract.ContractInfoRel;

public interface ContractInfoRelMapper {
    int deleteByPrimaryKey(String wid);

    int insert(ContractInfoRel record);

    int insertSelective(ContractInfoRel record);

    ContractInfoRel selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(ContractInfoRel record);

    int updateByPrimaryKey(ContractInfoRel record);
}