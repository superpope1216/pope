package com.pope.contract.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.user.UserInfoRole;

public interface UserInfoRoleMapper {
    int insert(UserInfoRole record);

    int insertSelective(UserInfoRole record);
    
    int deleteByUserId(@Param(value="userId")String userId);
    
    void insertUserRole(List<UserInfoRole> list);
}