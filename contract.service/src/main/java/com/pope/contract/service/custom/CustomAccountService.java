package com.pope.contract.service.custom;

import java.util.List;

import com.pope.contract.entity.custom.CustomAccount;
import com.pope.contract.entity.custom.extend.CustomAccountExtend;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年8月26日 上午7:42:38 类说明
 */
public interface CustomAccountService {

	int deleteByPrimaryKey(String wid,String userId) throws Exception;

	int insert(CustomAccount record,String userId) throws Exception;

	CustomAccount selectByPrimaryKey(String wid) throws Exception;

	int updateByPrimaryKeySelective(CustomAccount record,String userId) throws Exception;

	CustomAccount selectSingleByCondition(CustomAccountExtend customAccountExtend) throws Exception;

	List<CustomAccount> selectByCondition(CustomAccountExtend customAccountExtend) throws Exception;

	CustomAccountExtend selectSingleDisplayByCondition(CustomAccountExtend customAccountExtend) throws Exception;

	List<CustomAccountExtend> selectByDisplayCondition(CustomAccountExtend customAccountExtend) throws Exception;

	Integer selectMax() throws Exception;

	void checkAddCustomAccount(String customId) throws Exception;
}
