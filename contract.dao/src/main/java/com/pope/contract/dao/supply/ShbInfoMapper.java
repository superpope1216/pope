package com.pope.contract.dao.supply;

import com.pope.contract.entity.supply.ShbInfo;

public interface ShbInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(ShbInfo record);

    int insertSelective(ShbInfo record);

    ShbInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(ShbInfo record);

    int updateByPrimaryKey(ShbInfo record);
}