package com.pope.contract.dao.user.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.user.UserInfoRole;

public interface UserInfoRoleExtendMapper {
	List<UserInfoRole> selectByCondition(UserInfoRole userInfoRole);
    
    
}