package com.pope.contract.service.contract.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.contract.dao.contract.ContractFbsqdInfoMapper;
import com.pope.contract.dao.contract.extend.ContractFbsqdInfoExtendMapper;
import com.pope.contract.entity.contract.ContractFbsqdInfo;
import com.pope.contract.service.contract.ContractFbsqdInfoService;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年9月17日 下午7:41:35
* 类说明
*/
@Service("contractFbsqdInfoService")
public class ContractFbsqdInfoServiceImpl implements ContractFbsqdInfoService {

	@Autowired
	private ContractFbsqdInfoMapper contractFbsqdInfoMapper;
	@Autowired
	private ContractFbsqdInfoExtendMapper contractFbsqdInfoExtendMapper;
	@Override
	public int deleteByPrimaryKey(String wid) throws Exception{
	return contractFbsqdInfoMapper.deleteByPrimaryKey(wid);
	}

	@Override
	public int insertSelective(ContractFbsqdInfo record) throws Exception{
		record.setWid(StringUtil.getUuId());
		return contractFbsqdInfoMapper.insertSelective(record);
	}

	@Override
	public ContractFbsqdInfo selectByPrimaryKey(String wid) throws Exception{
		return contractFbsqdInfoMapper.selectByPrimaryKey(wid);
	}

	@Override
	public int updateByPrimaryKeySelective(ContractFbsqdInfo record)throws Exception {
		return contractFbsqdInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public ContractFbsqdInfo selectSingleByCondition(ContractFbsqdInfo contractFbsqdInfo) throws Exception{
		return contractFbsqdInfoExtendMapper.selectSingleByCondition(contractFbsqdInfo);
	}

}
