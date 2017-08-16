package com.pope.contract.dao.supply;

import com.pope.contract.entity.supply.SupplyInfo;

public interface SupplyInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(SupplyInfo record);

    int insertSelective(SupplyInfo record);

    SupplyInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(SupplyInfo record);

    int updateByPrimaryKey(SupplyInfo record);
}