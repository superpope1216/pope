package com.pope.contract.dao.system;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.system.MessageExtendInfo;
import com.pope.contract.entity.system.extend.MessageInfoExtend;

public interface MessageExtendInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(MessageExtendInfo record);

    int insertSelective(MessageExtendInfo record);

    MessageExtendInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(MessageExtendInfo record);

    int updateByPrimaryKey(MessageExtendInfo record);
    
   
}