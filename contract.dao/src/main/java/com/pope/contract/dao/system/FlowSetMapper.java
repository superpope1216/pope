package com.pope.contract.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.system.FlowSet;

public interface FlowSetMapper {
    int deleteByPrimaryKey(String wid);

    int insert(FlowSet record);

    int insertSelective(FlowSet record);

    FlowSet selectByPrimaryKey(String wid);
    
    FlowSet selectByRoleAndType(@Param("name") String name,@Param("type") String type);
    
    List<FlowSet> list(FlowSet flowSet);
    
    List<FlowSet> selectNextStep(@Param("px") Integer px,@Param("type") String type);

    int updateByPrimaryKeySelective(FlowSet record);

    int updateByPrimaryKey(FlowSet record);
    
    FlowSet selectSingleByCondition(FlowSet flowSet);
}