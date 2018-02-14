package com.pope.contract.dao.system;

import com.pope.contract.entity.system.SysConfigInfo;

public interface SysConfigInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(SysConfigInfo record);

    int insertSelective(SysConfigInfo record);

    SysConfigInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(SysConfigInfo record);

    int updateByPrimaryKey(SysConfigInfo record);
}