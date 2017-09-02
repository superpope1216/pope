package com.pope.contract.service.custom.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pope.contract.code.DataOperatorEnum;
import com.pope.contract.code.DataStatus;
import com.pope.contract.dao.custom.CustomAccountMapper;
import com.pope.contract.dao.custom.CustomUpdateLogMapper;
import com.pope.contract.entity.custom.CustomAccount;
import com.pope.contract.entity.custom.CustomUpdateLog;
import com.pope.contract.dao.custom.extend.CustomAccountExtendMapper;
import com.pope.contract.entity.custom.extend.CustomAccountExtend;
import com.pope.contract.exception.ServiceException;
import com.pope.contract.service.custom.CustomAccountService;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月26日 上午7:42:49
* 类说明
*/
@Service("customAccountService")
@Transactional
public class CustomAccountServiceImpl implements CustomAccountService {

	@Autowired
	private CustomAccountMapper customAccountMapper;
	@Autowired
	private CustomAccountExtendMapper customAccountExtendMapper;
	@Autowired
	private CustomUpdateLogMapper customUpdateLogMapper;
	@Override
	public CustomAccount selectSingleByCondition(CustomAccountExtend customAccountExtend) throws Exception {
		return customAccountExtendMapper.selectSingleByCondition(customAccountExtend);
	}

	@Override
	public List<CustomAccount> selectByCondition(CustomAccountExtend customAccountExtend) throws Exception {
		return customAccountExtendMapper.selectByCondition(customAccountExtend);
	}

	@Override
	public  CustomAccountExtend  selectSingleDisplayByCondition(CustomAccountExtend customAccountExtend)
			throws Exception {
		return customAccountExtendMapper.selectSingleDisplayByCondition(customAccountExtend);
	}

	@Override
	public List<CustomAccountExtend> selectByDisplayCondition(CustomAccountExtend customAccountExtend)
			throws Exception {
		return customAccountExtendMapper.selectByDisplayCondition(customAccountExtend);
	}

	@Override
	public Integer selectMax() throws Exception {
		return customAccountExtendMapper.selectMax();
	}

	@Override
	public int deleteByPrimaryKey(String wid,String userId) throws Exception{
		return customAccountMapper.deleteByPrimaryKey(wid);
	}

	@Override
	public int insert(CustomAccount record,String userId) throws Exception{
		checkAddCustomAccount(record.getCustomId());
		CustomAccountExtend queryCustomAccountExtend=new CustomAccountExtend();
		queryCustomAccountExtend.setAccountNumber(record.getAccountNumber());
		queryCustomAccountExtend.setDatastatus(StringUtil.toStr(DataStatus.normal.getCode()));
		CustomAccount customAccount=customAccountExtendMapper.selectSingleByCondition(queryCustomAccountExtend);
		if(customAccount!=null){
			throw new ServiceException("该客户账号编码已存在，请刷新页面重新操作！");
		}
		record.setWid(StringUtil.getUuId());
		record.setCreateMan(userId);
		record.setCreateTime(DateUtil.getCurrentDateTimeStr());
		record.setDatastatus(StringUtil.toStr(DataStatus.normal.getCode()));
		CustomUpdateLog customUpdateLog=new CustomUpdateLog();
		customUpdateLog.setAccountMoney(record.getAccountMoney());
		customUpdateLog.setAccountNumber(record.getAccountNumber());
		customUpdateLog.setBankAccount(record.getBankAccount());
		customUpdateLog.setCreateMan(record.getCreateMan());
		customUpdateLog.setCreateTime(record.getCreateTime());
		customUpdateLog.setCustomId(record.getCustomId());
		customUpdateLog.setUpdateType(DataOperatorEnum.ADD.getCode());
		customUpdateLog.setWid(StringUtil.getUuId());		
		customUpdateLogMapper.insert(customUpdateLog);
		return customAccountMapper.insert(record);
	}

	@Override
	public CustomAccount selectByPrimaryKey(String wid) throws Exception{
		return customAccountMapper.selectByPrimaryKey(wid);
	}

	@Override
	public int updateByPrimaryKeySelective(CustomAccount record,String userId) throws Exception{
		CustomUpdateLog customUpdateLog=new CustomUpdateLog();
		customUpdateLog.setAccountMoney(record.getAccountMoney());
		customUpdateLog.setAccountNumber(record.getAccountNumber());
		customUpdateLog.setBankAccount(record.getBankAccount());
		customUpdateLog.setCreateMan(record.getCreateMan());
		customUpdateLog.setCreateTime(record.getCreateTime());
		customUpdateLog.setCustomId(record.getCustomId());
		customUpdateLog.setUpdateType(DataOperatorEnum.MODIFY.getCode());
		customUpdateLog.setWid(StringUtil.getUuId());		
		customUpdateLogMapper.insert(customUpdateLog);
		return customAccountMapper.updateByPrimaryKeySelective(record);
	}
	
	@Override
	public void checkAddCustomAccount(String customId) throws Exception {
		CustomAccountExtend queryCustomAccountExtend=new CustomAccountExtend();
		queryCustomAccountExtend.setCustomId(customId);
		queryCustomAccountExtend.setDatastatus(StringUtil.toStr(DataStatus.normal.getCode()));
		CustomAccount customAccount=customAccountExtendMapper.selectSingleByCondition(queryCustomAccountExtend);
		if(customAccount!=null){
			throw new ServiceException("该客户已存在账户信息，无法重复创建！");
		}
			
	}

}
