package com.pope.contract.dao.project;

import com.pope.contract.entity.project.BatchInfoDetail;

public interface BatchInfoDetailMapper {
    int deleteByPrimaryKey(String wid);

    int insert(BatchInfoDetail record);

    int insertSelective(BatchInfoDetail record);

    BatchInfoDetail selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(BatchInfoDetail record);

    int updateByPrimaryKey(BatchInfoDetail record);
}