package com.pope.contract.service.custom;

import java.util.List;

import com.pope.contract.entity.custom.CustomUpdateLog;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年10月28日 下午5:01:19
* 类说明
*/
public interface CustomUpdateLogService {
	 int deleteByPrimaryKey(String wid) throws Exception;

	    int insert(CustomUpdateLog record) throws Exception;

	    int insertSelective(CustomUpdateLog record) throws Exception;

	    CustomUpdateLog selectByPrimaryKey(String wid) throws Exception;

	    int updateByPrimaryKeySelective(CustomUpdateLog record) throws Exception;

	    int updateByPrimaryKey(CustomUpdateLog record) throws Exception;
	    

		List<CustomUpdateLog> selectByCondition(CustomUpdateLog customUpdateLog) throws Exception;
		
		CustomUpdateLog selectSingleByCondition(CustomUpdateLog customUpdateLog) throws Exception;
}
