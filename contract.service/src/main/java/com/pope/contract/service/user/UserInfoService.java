package com.pope.contract.service.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.condition.UserInfoCondition;
import com.pope.contract.dto.LoginInfo;
import com.pope.contract.entity.user.UserInfo;
import com.pope.contract.entity.user.UserInfoRole;
import com.pope.contract.entity.user.extend.UserInfoExtend;

public interface UserInfoService {
	int insert(UserInfo record, String userId, String userInfoRoles) throws Exception;

	UserInfo selectByPrimaryKey(String wid);

	LoginInfo login(UserInfo userInfo);

	int deleteByPrimaryKey(String wid) throws Exception;

	int updateByPrimaryKeySelective(UserInfo record, String userId, String userInfoRoles) throws Exception;

	int updateByPrimaryKeySelective(UserInfo record) throws Exception;

	List<UserInfoExtend> selectDisplayByCondition(UserInfoExtend userInfo) throws Exception;

	List<UserInfo> selectByRoleName(String name);

	List<UserInfoRole> selectUserInfoRole(UserInfoRole userInfoRole) throws Exception;

	UserInfoExtend selectSingleDisplayByCondition(UserInfoExtend user) throws Exception;



	List<UserInfo> selectByCondition(UserInfoExtend user) throws Exception;

	UserInfo selectSingleByCondition(UserInfoExtend user) throws Exception;
	void savePassword(String userId,String oldPassword,String newPassword) throws Exception;
}