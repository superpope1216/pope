package com.pope.contract.dao.custom;

import com.pope.contract.entity.custom.CustomInfo;

public interface CustomInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(CustomInfo record);

    int insertSelective(CustomInfo record);

    CustomInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(CustomInfo record);

    int updateByPrimaryKey(CustomInfo record);
}