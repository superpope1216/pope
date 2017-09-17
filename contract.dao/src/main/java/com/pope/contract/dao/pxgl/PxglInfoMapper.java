package com.pope.contract.dao.pxgl;

import com.pope.contract.entity.pxgl.PxglInfo;

public interface PxglInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(PxglInfo record);

    int insertSelective(PxglInfo record);

    PxglInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(PxglInfo record);

    int updateByPrimaryKey(PxglInfo record);
}