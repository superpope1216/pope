package com.pope.contract.service.system.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pope.contract.code.MessageTypeEnum;
import com.pope.contract.dao.system.DepartmentMapper;
import com.pope.contract.dao.system.MessageInfoMapper;
import com.pope.contract.dao.system.MessageUserRelMapper;
import com.pope.contract.dao.system.extend.DepartmentExtendMapper;
import com.pope.contract.dao.system.extend.MessageExtendInfoExtendMapper;
import com.pope.contract.dao.system.extend.MessageInfoExtendMapper;
import com.pope.contract.dao.system.extend.MessageUserRelExtendMapper;
import com.pope.contract.entity.system.Department;
import com.pope.contract.entity.system.MessageExtendInfo;
import com.pope.contract.entity.system.MessageInfo;
import com.pope.contract.entity.system.MessageUserRel;
import com.pope.contract.entity.system.extend.MessageInfoExtend;
import com.pope.contract.service.system.MessageInfoService;
import com.pope.contract.util.CommonUtil;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年9月17日 下午2:03:25 类说明
 */
@Service("messageInfoService")
@Transactional
public class MessageInfoServiceImpl implements MessageInfoService {

	@Autowired
	private MessageInfoMapper messageInfoMapper;

	@Autowired
	private MessageInfoExtendMapper messageInfoExtendMapper;
	@Autowired
	private MessageUserRelExtendMapper messageUserRelExtendMapper;
	@Autowired
	private MessageUserRelMapper messageUserRelMapper;

	@Autowired
	private MessageExtendInfoExtendMapper messageExtendInfoExtendMapper;

	@Autowired
	private DepartmentExtendMapper departmentExtendMapper;

	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	@Transactional
	public int deleteByPrimaryKey(String wid) throws Exception {
		messageExtendInfoExtendMapper.deleteByPid(wid);
		return messageInfoMapper.deleteByPrimaryKey(wid);
	}

	@Override
	@Transactional
	public int insertSelective(MessageInfo record, String userId) throws Exception {
		record.setCreateTime(DateUtil.getCurrentDateTimeStr());
		record.setCreateMan(userId);
		record.setWid(StringUtil.getUuId());
		update(record);
		return messageInfoMapper.insertSelective(record);
	}

	@Override
	public MessageInfo selectByPrimaryKey(String wid) throws Exception {
		return messageInfoMapper.selectByPrimaryKey(wid);
	}

	@Override
	@Transactional
	public int updateByPrimaryKeySelective(MessageInfo record) throws Exception {
		update(record);
		return messageInfoMapper.updateByPrimaryKeySelective(record);
	}

	private void update(MessageInfo record) {
		messageExtendInfoExtendMapper.deleteByPid(record.getWid());
		if (record.getMessageType().equals(StringUtil.toStr(MessageTypeEnum.DEPART.getCode()))) {
			Department deparment = departmentMapper.selectByBm(record.getMessageReceiveDepart());
			List<Map<String, Object>> lstChilds = departmentExtendMapper.selectChildByPid(deparment.getWid());
			if (CommonUtil.isNotEmptyList(lstChilds)) {
				List<MessageExtendInfo> lstMessageExtendInfo = new ArrayList<MessageExtendInfo>();
				for (Map<String, Object> map : lstChilds) {
					MessageExtendInfo messageExtendInfo = new MessageExtendInfo();
					messageExtendInfo.setWid(StringUtil.getUuId());
					messageExtendInfo.setBm(StringUtil.toStr(map.get("bm")));
					messageExtendInfo.setMe(record.getWid());
					lstMessageExtendInfo.add(messageExtendInfo);
				}
				messageExtendInfoExtendMapper.insertBatch(lstMessageExtendInfo);
			}

		}
	}

	@Override
	@Transactional
	public int updateByPrimaryKeyWithBLOBs(MessageInfo record) throws Exception {
		update(record);
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

	public Integer selectPersonCountByCondition(MessageInfoExtend newsInfoExtend) throws Exception {
		return messageInfoExtendMapper.selectPersonCountByCondition(newsInfoExtend);
	}

	public List<MessageInfo> selectPersonByCondition(MessageInfoExtend newsInfoExtend) throws Exception{
		return messageInfoExtendMapper.selectPersonByCondition(newsInfoExtend);
	}

	@Override
	public MessageInfoExtend selectDisplayByCondition(String wid) throws Exception {
		return messageInfoExtendMapper.selectDisplayByCondition(wid);
	}
	
	public List<MessageInfo>  selectAllPersonByCondition(MessageInfoExtend newsInfoExtend) throws Exception{
		return messageInfoExtendMapper.selectAllPersonByCondition(newsInfoExtend);
	}

	@Override
	public MessageInfo selectAllByPrimaryKey(String wid) throws Exception {
		return messageInfoExtendMapper.selectAllByPrimaryKey(wid);
	}

	@Override
	public Integer selectAllPersonCountByCondition(MessageInfoExtend newsInfoExtend) throws Exception {
		// TODO Auto-generated method stub
		return messageInfoExtendMapper.selectAllPersonCountByCondition(newsInfoExtend);
	}
	@Override
	public MessageInfo readMessages(String yhid,String messageId) throws Exception{
		MessageUserRel queryMessageUserRel=new MessageUserRel();
		queryMessageUserRel.setMessageId(messageId);
		queryMessageUserRel.setUserId(yhid);
		List<MessageUserRel> messageUsers= messageUserRelExtendMapper.selectByCondition(queryMessageUserRel);
		if(CommonUtil.isEmptyList(messageUsers)){
			MessageUserRel saveMessageUserRel=new MessageUserRel();
			saveMessageUserRel.setCreateMan(yhid);
			saveMessageUserRel.setCreateTime(DateUtil.getCurrentDateTimeStr());
			saveMessageUserRel.setMessageId(messageId);
			saveMessageUserRel.setUserId(yhid);
			saveMessageUserRel.setWid(StringUtil.getUuId());
			messageUserRelMapper.insertSelective(saveMessageUserRel);
		}
		return this.selectAllByPrimaryKey(messageId);
	}

}
