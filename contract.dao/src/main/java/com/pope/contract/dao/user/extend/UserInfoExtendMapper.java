package com.pope.contract.dao.user.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.condition.UserInfoCondition;
import com.pope.contract.dao.user.UserInfoMapper;
import com.pope.contract.entity.user.UserInfo;
import com.pope.contract.entity.user.extend.UserInfoExtend;

public interface UserInfoExtendMapper extends UserInfoMapper {


	UserInfoExtend selectSingleDisplayByCondition(UserInfoExtend user) throws Exception;

	List<UserInfoExtend> selectDisplayByCondition(UserInfoExtend user) throws Exception;
	
	List<UserInfo> selectByCondition(UserInfoExtend user) throws Exception;
	
	UserInfo selectSingleByCondition(UserInfoExtend user) throws Exception;
	
	List<UserInfo> selectByRoleName(@Param("name") String name);
}