package com.pope.contract.service.contract.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.contract.dao.contract.extend.ContractMoneyExtendMapper;
import com.pope.contract.entity.contract.ContractMoney;
import com.pope.contract.entity.contract.extend.ContractMoneyExtend;
import com.pope.contract.service.contract.ContractMoneyService;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月26日 上午2:37:38
* 类说明
*/
@Service("contractMoneyService")
public class ContractMoneyServiceImpl implements ContractMoneyService {

	@Autowired
	private ContractMoneyExtendMapper contractMoneyExtendMapper;
	@Override
	public List<ContractMoney> selectByCondition(ContractMoney contractMoney) throws Exception {
		return contractMoneyExtendMapper.selectByCondition(contractMoney);
	}

	@Override
	public ContractMoney selectSingleByCondition(ContractMoney contractMoney) throws Exception {
		return contractMoneyExtendMapper.selectSingleByCondition(contractMoney);
	}

	@Override
	public ContractMoneyExtend selectSingleDispalyByCondition(ContractMoney contractMoney) throws Exception {
		return contractMoneyExtendMapper.selectSingleDispalyByCondition(contractMoney);
	}

	@Override
	public List<ContractMoneyExtend> selectDispalyByCondition(ContractMoney contractMoney) throws Exception {
		return contractMoneyExtendMapper.selectDispalyByCondition(contractMoney);
	}

	
}
