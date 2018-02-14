package com.pope.contract.service.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.system.MessageInfo;
import com.pope.contract.entity.system.extend.MessageInfoExtend;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年9月17日 下午2:01:09 类说明
 */
public interface MessageInfoService {
	int deleteByPrimaryKey(String wid) throws Exception;


	int insertSelective(MessageInfo record,String userId) throws Exception;

	MessageInfo selectByPrimaryKey(String wid) throws Exception;

	int updateByPrimaryKeySelective(MessageInfo record) throws Exception;

	int updateByPrimaryKeyWithBLOBs(MessageInfo record) throws Exception;


	List<MessageInfo> selectByCondition(MessageInfoExtend newsInfoExtend) throws Exception;

	MessageInfo selectSingleByCondition(MessageInfoExtend newsInfoExtend) throws Exception;

	Integer selectCountByCondition(MessageInfoExtend newsInfoExtend) throws Exception;
	
	Integer selectPersonCountByCondition(MessageInfoExtend newsInfoExtend) throws Exception;
	
	List<MessageInfo>  selectPersonByCondition(MessageInfoExtend newsInfoExtend) throws Exception;
	
	List<MessageInfo>  selectAllPersonByCondition(MessageInfoExtend newsInfoExtend) throws Exception;
	
	MessageInfo  selectAllByPrimaryKey(String wid) throws Exception;
	
	 MessageInfoExtend selectDisplayByCondition(@Param(value="wid") String wid)  throws Exception;
	 
	 Integer selectAllPersonCountByCondition(MessageInfoExtend newsInfoExtend) throws Exception;
	  MessageInfo readMessages(String yhid,String messageId) throws Exception;
	
}
