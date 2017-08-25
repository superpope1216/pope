package com.pope.contract.service.contract.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.contract.dao.contract.extend.ContractInfoRelExtendMapper;
import com.pope.contract.entity.contract.ContractInfo;
import com.pope.contract.entity.contract.ContractInfoRel;
import com.pope.contract.service.contract.ContractInfoRelService;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月25日 下午11:08:08
* 类说明
*/
@Service("contractInfoRelService")
public class ContractInfoRelServiceImpl implements ContractInfoRelService{

	@Autowired
	private ContractInfoRelExtendMapper contractInfoRelExtendMapper;
	@Override
	public List<ContractInfoRel> selectByCondition(ContractInfoRel contractInfoRel) throws Exception {
		return contractInfoRelExtendMapper.selectByCondition(contractInfoRel);
	}

}
