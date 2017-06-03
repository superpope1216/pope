package com.pope.contract.service.system;

import java.util.List;

import com.pope.contract.entity.system.Zdbs;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年6月3日 下午3:09:53
* 类说明
*/
public interface ZdbsService {
	int deleteByPrimaryKey(String wid,String userId) throws Exception;

    int insert(Zdbs record,String userId) throws Exception;

    int insertSelective(Zdbs record,String userId) throws Exception;

    Zdbs selectByPrimaryKey(String wid);
    
    List<Zdbs> selectAll();

    int updateByPrimaryKeySelective(Zdbs record,String userId) throws Exception;

    int updateByPrimaryKey(Zdbs record,String userId) throws Exception;
}
