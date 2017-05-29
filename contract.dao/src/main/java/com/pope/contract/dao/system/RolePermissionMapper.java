package com.pope.contract.dao.system;

import java.util.List;

import com.pope.contract.entity.system.Permission;
import com.pope.contract.entity.system.Role;
import com.pope.contract.entity.system.RolePermission;

public interface RolePermissionMapper {
    int insert(RolePermission record);

    int insertSelective(RolePermission record);
    
   
}