package com.pope.contract.dao.system;

import com.pope.contract.entity.system.MessageInfo;

public interface MessageInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(MessageInfo record);

    int insertSelective(MessageInfo record);

    MessageInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(MessageInfo record);

    int updateByPrimaryKeyWithBLOBs(MessageInfo record);

    int updateByPrimaryKey(MessageInfo record);
}