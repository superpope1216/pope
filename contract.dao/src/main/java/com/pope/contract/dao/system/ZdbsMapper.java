package com.pope.contract.dao.system;

import java.util.List;

import com.pope.contract.entity.system.Zdbs;

public interface ZdbsMapper {
    int deleteByPrimaryKey(String wid);

    int insert(Zdbs record);

    int insertSelective(Zdbs record);

    Zdbs selectByPrimaryKey(String wid);
    
    List<Zdbs> selectAll();

    int updateByPrimaryKeySelective(Zdbs record);

    int updateByPrimaryKey(Zdbs record);
}