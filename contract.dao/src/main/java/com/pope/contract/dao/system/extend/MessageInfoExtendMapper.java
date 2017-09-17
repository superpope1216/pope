package com.pope.contract.dao.system.extend;

import java.util.List;

import com.pope.contract.entity.system.MessageInfo;
import com.pope.contract.entity.system.extend.MessageInfoExtend;

public interface MessageInfoExtendMapper {
    
	List<MessageInfo> selectByCondition(MessageInfoExtend newsInfoExtend);
	
	MessageInfo selectSingleByCondition(MessageInfoExtend newsInfoExtend);
	
	Integer selectCountByCondition(MessageInfoExtend newsInfoExtend);
}