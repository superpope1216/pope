package com.pope.contract.dao.project;

import com.pope.contract.entity.project.BatchInfo;

public interface BatchInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(BatchInfo record);

    int insertSelective(BatchInfo record);

    BatchInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(BatchInfo record);

    int updateByPrimaryKey(BatchInfo record);
}