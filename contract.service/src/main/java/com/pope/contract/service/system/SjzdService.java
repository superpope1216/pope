package com.pope.contract.service.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.system.Sjzd;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年6月3日 下午6:32:12
* 类说明
*/
public interface SjzdService {
		int deleteByPrimaryKey(String tableName,String wid ) throws Exception;
	
	
	 	int insert(Sjzd record ) throws Exception;

	    int insertSelective(Sjzd record ) throws Exception;

	    Sjzd selectByPrimaryKey(String tableName,String wid) ;
	    
	    List<Sjzd> selectAll(String tableName,String lbdms);

	    int updateByPrimaryKeySelective(Sjzd record ) throws Exception;

	    int updateByPrimaryKey(Sjzd record ) throws Exception;
}
