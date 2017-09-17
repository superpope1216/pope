package com.pope.contract.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.contract.dao.system.MessageInfoMapper;
import com.pope.contract.dao.system.extend.MessageInfoExtendMapper;
import com.pope.contract.entity.system.MessageInfo;
import com.pope.contract.entity.system.extend.MessageInfoExtend;
import com.pope.contract.service.system.MessageInfoService;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年9月17日 下午2:03:25
* 类说明
*/
@Service("messageInfoService")
public class MessageInfoServiceImpl implements MessageInfoService{

	@Autowired
	private MessageInfoMapper messageInfoMapper;
	
	@Autowired
	private MessageInfoExtendMapper messageInfoExtendMapper; 
	@Override
	public int deleteByPrimaryKey(String wid) throws Exception {
		return messageInfoMapper.deleteByPrimaryKey(wid);
	}

	@Override
	public int insertSelective(MessageInfo record,String userId) throws Exception {
		record.setCreateTime(DateUtil.getCurrentDateTimeStr());
		record.setCreateMan(userId);
		record.setWid(StringUtil.getUuId());
		return messageInfoMapper.insertSelective(record);
	}

	@Override
	public MessageInfo selectByPrimaryKey(String wid) throws Exception {
		return messageInfoMapper.selectByPrimaryKey(wid);
	}

	@Override
	public int updateByPrimaryKeySelective(MessageInfo record) throws Exception {
		return messageInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(MessageInfo record) throws Exception {
		return messageInfoMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public List<MessageInfo> selectByCondition(MessageInfoExtend newsInfoExtend) throws Exception {
		return messageInfoExtendMapper.selectByCondition(newsInfoExtend);
	}

	@Override
	public MessageInfo selectSingleByCondition(MessageInfoExtend newsInfoExtend) throws Exception {
		return messageInfoExtendMapper.selectSingleByCondition(newsInfoExtend);
	}

	@Override
	public Integer selectCountByCondition(MessageInfoExtend newsInfoExtend) throws Exception {
		return messageInfoExtendMapper.selectCountByCondition(newsInfoExtend);
	}

}
