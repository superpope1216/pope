package com.pope.contract.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.system.Department;

public interface DepartmentMapper {
    int insert(Department record);

    int insertSelective(Department record);
    
    int updateByPrimaryKeySelective(Department record);
    
    int updateByPrimaryKey(Department record);
    
    Department selectByBm(@Param(value="bm") String bm);
    
    List<Department> selectAll();
    
    int deleteByWid(String wid);
    
    int deleteByPid(@Param(value="pid") String pid);
}