package com.pope.contract.dao.contract;

import com.pope.contract.entity.contract.ContractFbsqdInfo;

public interface ContractFbsqdInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(ContractFbsqdInfo record);

    int insertSelective(ContractFbsqdInfo record);

    ContractFbsqdInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(ContractFbsqdInfo record);

    int updateByPrimaryKey(ContractFbsqdInfo record);
}