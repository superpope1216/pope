package com.pope.contract.dao.supply;

import com.pope.contract.entity.supply.GmbInfo;

public interface GmbInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(GmbInfo record);

    int insertSelective(GmbInfo record);

    GmbInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(GmbInfo record);

    int updateByPrimaryKey(GmbInfo record);
}