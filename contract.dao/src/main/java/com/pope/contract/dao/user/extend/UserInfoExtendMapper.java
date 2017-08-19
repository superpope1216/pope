package com.pope.contract.dao.user.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.condition.UserInfoCondition;
import com.pope.contract.dao.user.UserInfoMapper;
import com.pope.contract.entity.user.UserInfo;
import com.pope.contract.entity.user.extend.UserInfoExtend;

public interface UserInfoExtendMapper extends UserInfoMapper {

	UserInfo selectByGh(@Param(value = "gh") String gh);

	List<UserInfoExtend> selectDisplayByCondition(UserInfo user) throws Exception;

	List<UserInfo> selectByRoleName(@Param("name") String name);
}