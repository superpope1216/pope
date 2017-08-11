package com.pope.contract.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.condition.UserInfoCondition;
import com.pope.contract.entity.user.UserInfo;

public interface UserInfoMapper {
    int insert(UserInfo record);

    int deleteByPrimaryKey(String wid);
    int insertSelective(UserInfo record);
    
    UserInfo selectByPrimaryKey(String wid);
    
    UserInfo selectByGh(@Param(value="gh") String gh);
    
    int updateByPrimaryKeySelective(UserInfo record);
    
    int updateByPrimaryKey(UserInfo record);
    
    List<UserInfo> selectListByCondition(UserInfoCondition condition);
}