package com.pope.contract.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.system.Permission;
import com.pope.contract.entity.system.Role;

public interface PermissionMapper {
    int insert(Permission record);

    int insertSelective(Permission record);
    
   
}