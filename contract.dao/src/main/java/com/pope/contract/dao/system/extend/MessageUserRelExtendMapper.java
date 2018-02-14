package com.pope.contract.dao.system.extend;

import java.util.List;

import com.pope.contract.entity.system.MessageUserRel;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2018年1月27日 下午3:41:28
* 类说明
*/
public interface MessageUserRelExtendMapper {

		List<MessageUserRel> selectByCondition(MessageUserRel messageUserRel);
}
