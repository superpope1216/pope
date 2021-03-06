package com.pope.contract.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.system.Sjzd;
import com.pope.contract.entity.system.Zdbs;

public interface SjzdMapper {

    int insert(Sjzd record);

    int insertSelective(Sjzd record);

    Sjzd selectByPrimaryKey(@Param(value="tableName") String tableName,@Param(value="wid") String wid);
    
    List<Sjzd> selectAll(@Param(value="tableName") String tableName,@Param(value="lbdm") List<String> lbdm);
    
    List<Sjzd> selectUsers();

    List<Sjzd> selectRwzt();
    int updateByPrimaryKeySelective(Sjzd record);

    int updateByPrimaryKey(Sjzd record);
}