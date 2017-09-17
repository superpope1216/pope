package com.pope.contract.dao.system;

import com.pope.contract.entity.system.MessageUserRel;

public interface MessageUserRelMapper {
    int deleteByPrimaryKey(String wid);

    int insert(MessageUserRel record);

    int insertSelective(MessageUserRel record);

    MessageUserRel selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(MessageUserRel record);

    int updateByPrimaryKey(MessageUserRel record);
}