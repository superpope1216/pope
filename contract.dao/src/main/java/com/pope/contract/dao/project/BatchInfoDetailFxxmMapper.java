package com.pope.contract.dao.project;

import com.pope.contract.entity.project.BatchInfoDetailFxxm;

public interface BatchInfoDetailFxxmMapper {
    int deleteByPrimaryKey(String wid);

    int insert(BatchInfoDetailFxxm record);

    int insertSelective(BatchInfoDetailFxxm record);

    BatchInfoDetailFxxm selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(BatchInfoDetailFxxm record);

    int updateByPrimaryKey(BatchInfoDetailFxxm record);
}