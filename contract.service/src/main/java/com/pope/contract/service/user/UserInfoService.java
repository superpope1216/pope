package com.pope.contract.service.user;

import java.util.List;

import com.pope.contract.condition.UserInfoCondition;
import com.pope.contract.dto.LoginInfo;
import com.pope.contract.entity.user.UserInfo;

public interface UserInfoService {
	int insert(UserInfo record,String userId,String userInfoRoles) throws Exception;

	int insertSelective(UserInfo record,String userId) throws Exception;

	UserInfo selectByPrimaryKey(String wid);

	UserInfo selectByGh(String gh);

	LoginInfo login(UserInfo userInfo);

	int updateByPrimaryKeySelective(UserInfo record,String userId) throws Exception;

	int updateByPrimaryKey(UserInfo record,String userId) throws Exception;
	
	 List<UserInfo> selectListByCondition(UserInfoCondition condition);

}