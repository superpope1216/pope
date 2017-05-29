package com.pope.contract.dao.user;

import com.pope.contract.entity.user.UserInfoRole;

public interface UserInfoRoleMapper {
    int insert(UserInfoRole record);

    int insertSelective(UserInfoRole record);
    
}