package com.pope.contract.dao.system;

import com.pope.contract.entity.system.NewsInfo;

public interface NewsInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(NewsInfo record);

    int insertSelective(NewsInfo record);

    NewsInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(NewsInfo record);

    int updateByPrimaryKeyWithBLOBs(NewsInfo record);

    int updateByPrimaryKey(NewsInfo record);
}