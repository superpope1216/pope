package com.pope.contract.dao.system.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.system.MessageInfo;
import com.pope.contract.entity.system.extend.MessageInfoExtend;

public interface MessageInfoExtendMapper {
    
	List<MessageInfo> selectByCondition(MessageInfoExtend newsInfoExtend);
	
	List<MessageInfo>  selectPersonByCondition(MessageInfoExtend newsInfoExtend);
	
	MessageInfo selectSingleByCondition(MessageInfoExtend newsInfoExtend);
	
	 MessageInfoExtend selectDisplayByCondition(@Param(value="wid") String wid);
	
	MessageInfoExtend selectSingleDisplayByCondition(MessageInfoExtend newsInfoExtend);
	
	Integer selectCountByCondition(MessageInfoExtend newsInfoExtend);
	
	Integer selectPersonCountByCondition(MessageInfoExtend newsInfoExtend);
	
	List<MessageInfo>  selectAllPersonByCondition(MessageInfoExtend newsInfoExtend);
	
	Integer selectAllPersonCountByCondition(MessageInfoExtend newsInfoExtend);
	MessageInfo  selectAllByPrimaryKey(@Param(value="wid") String wid) ;
	
}