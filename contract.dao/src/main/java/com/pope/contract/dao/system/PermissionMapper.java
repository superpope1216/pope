package com.pope.contract.dao.system;

import com.pope.contract.entity.system.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(String wid);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}