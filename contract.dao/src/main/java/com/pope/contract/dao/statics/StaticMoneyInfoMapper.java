package com.pope.contract.dao.statics;

import com.pope.contract.entity.statics.StaticMoneyInfo;

public interface StaticMoneyInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(StaticMoneyInfo record);

    int insertSelective(StaticMoneyInfo record);

    StaticMoneyInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(StaticMoneyInfo record);

    int updateByPrimaryKey(StaticMoneyInfo record);
}