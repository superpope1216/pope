package com.pope.contract.dao.system.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface DepartmentExtendMapper {
    List<Map<String,Object>> selectChildByPid(@Param(value="pid") String pid);
}