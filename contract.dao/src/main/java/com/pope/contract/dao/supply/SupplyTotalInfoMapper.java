package com.pope.contract.dao.supply;

import com.pope.contract.entity.supply.SupplyTotalInfo;

public interface SupplyTotalInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(SupplyTotalInfo record);

    int insertSelective(SupplyTotalInfo record);

    SupplyTotalInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(SupplyTotalInfo record);

    int updateByPrimaryKey(SupplyTotalInfo record);
}