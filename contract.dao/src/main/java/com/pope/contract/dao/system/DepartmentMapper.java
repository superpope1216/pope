package com.pope.contract.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.system.Department;
import com.pope.contract.entity.system.Sjzd;

public interface DepartmentMapper {
    int insert(Department record);

    int insertSelective(Department record);
    
    int updateByPrimaryKeySelective(Department record);
    
    int updateByPrimaryKey(Department record);
    
    Department selectByBm(@Param(value="bm") String bm);
    
    List<Department> selectAll();
    
    List<Department> selectDepartment();
    
    List<Sjzd> selectTeamByDepartment(@Param(value="bm") String bm);
    
    int deleteByWid(String wid);
    
    int deleteByPid(@Param(value="pid") String pid);
}