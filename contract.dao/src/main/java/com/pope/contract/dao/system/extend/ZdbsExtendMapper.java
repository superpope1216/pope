package com.pope.contract.dao.system.extend;

import java.util.List;

import com.pope.contract.entity.system.Zdbs;

public interface ZdbsExtendMapper {

    List<Zdbs> selectAll();
    
    List<Zdbs> selectByCondition(Zdbs zdbs);
}