package com.pope.contract.dao.user;

import com.pope.contract.entity.user.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}