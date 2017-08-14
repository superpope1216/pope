package com.pope.contract.dao.project;

import com.pope.contract.entity.project.BatchInfoFxxm;

public interface BatchInfoFxxmMapper {
    int deleteByPrimaryKey(String wid);

    int insert(BatchInfoFxxm record);

    int insertSelective(BatchInfoFxxm record);

    BatchInfoFxxm selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(BatchInfoFxxm record);

    int updateByPrimaryKey(BatchInfoFxxm record);
}