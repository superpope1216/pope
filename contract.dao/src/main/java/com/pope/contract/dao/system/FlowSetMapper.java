package com.pope.contract.dao.system;

import java.util.List;

import com.pope.contract.entity.system.FlowSet;

public interface FlowSetMapper {
    int deleteByPrimaryKey(String wid);

    int insert(FlowSet record);

    int insertSelective(FlowSet record);

    FlowSet selectByPrimaryKey(String wid);
    
    List<FlowSet> list(FlowSet flowSet);

    int updateByPrimaryKeySelective(FlowSet record);

    int updateByPrimaryKey(FlowSet record);
}