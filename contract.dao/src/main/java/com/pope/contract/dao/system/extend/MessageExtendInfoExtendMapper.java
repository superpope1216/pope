package com.pope.contract.dao.system.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.system.MessageExtendInfo;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年10月20日 下午10:10:29
* 类说明
*/
public interface MessageExtendInfoExtendMapper {

	int deleteByPid(@Param(value="pid") String pid);
	
	int insertBatch(List<MessageExtendInfo> list);
}
