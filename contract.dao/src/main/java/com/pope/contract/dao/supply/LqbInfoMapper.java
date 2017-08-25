package com.pope.contract.dao.supply;

import com.pope.contract.entity.supply.LqbInfo;

public interface LqbInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(LqbInfo record);

    int insertSelective(LqbInfo record);

    LqbInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(LqbInfo record);

    int updateByPrimaryKey(LqbInfo record);
}