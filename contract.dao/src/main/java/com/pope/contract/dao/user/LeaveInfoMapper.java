package com.pope.contract.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.user.LeaveInfo;

public interface LeaveInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(LeaveInfo record);

    int insertSelective(LeaveInfo record);

    LeaveInfo selectByPrimaryKey(String wid);
    
    List<LeaveInfo> selectByYhid(@Param(value="yhid") String yhid);

    int updateByPrimaryKeySelective(LeaveInfo record);

    int updateByPrimaryKey(LeaveInfo record);
}