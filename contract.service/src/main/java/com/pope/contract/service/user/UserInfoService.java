package com.pope.contract.service.user;

import java.util.List;

import com.pope.contract.condition.UserInfoCondition;
import com.pope.contract.dto.LoginInfo;
import com.pope.contract.entity.user.UserInfo;

public interface UserInfoService {
	int insert(UserInfo record);

	int insertSelective(UserInfo record);

	UserInfo selectByPrimaryKey(String wid);

	UserInfo selectByGh(String gh);

	LoginInfo login(UserInfo userInfo);

	int updateByPrimaryKeySelective(UserInfo record);

	int updateByPrimaryKey(UserInfo record);
	
	 List<UserInfo> selectListByCondition(UserInfoCondition condition);

}