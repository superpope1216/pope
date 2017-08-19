package com.pope.contract.service.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.condition.UserInfoCondition;
import com.pope.contract.dto.LoginInfo;
import com.pope.contract.entity.user.UserInfo;
import com.pope.contract.entity.user.extend.UserInfoExtend;

public interface UserInfoService {
	int insert(UserInfo record,String userId,String userInfoRoles) throws Exception;

	int insertSelective(UserInfo record,String userId) throws Exception;

	UserInfo selectByPrimaryKey(String wid);

	UserInfo selectByGh(String gh);

	LoginInfo login(UserInfo userInfo);
	
	int deleteByPrimaryKey(String wid) throws Exception;

	int updateByPrimaryKeySelective(UserInfo record,String userId,String userInfoRoles) throws Exception;

	int updateByPrimaryKey(UserInfo record,String userId) throws Exception;
	
	 
	 List<UserInfoExtend> selectDisplayByCondition(UserInfo userInfo) throws Exception;
	 
	 List<UserInfo> selectByRoleName(String name);

}