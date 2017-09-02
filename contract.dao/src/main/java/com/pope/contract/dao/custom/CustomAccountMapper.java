package com.pope.contract.dao.custom;

import com.pope.contract.entity.custom.CustomAccount;

public interface CustomAccountMapper {
    int deleteByPrimaryKey(String wid);

    int insert(CustomAccount record);

    int insertSelective(CustomAccount record);

    CustomAccount selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(CustomAccount record);

    int updateByPrimaryKey(CustomAccount record);
}