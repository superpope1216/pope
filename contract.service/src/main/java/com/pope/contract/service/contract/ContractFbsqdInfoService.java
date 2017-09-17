package com.pope.contract.service.contract;

import java.util.List;

import com.pope.contract.entity.contract.ContractFbsqdInfo;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年9月17日 下午7:40:50 类说明
 */
public interface ContractFbsqdInfoService {
	int deleteByPrimaryKey(String wid) throws Exception;

	int insertSelective(ContractFbsqdInfo record) throws Exception;

	ContractFbsqdInfo selectByPrimaryKey(String wid) throws Exception;

	int updateByPrimaryKeySelective(ContractFbsqdInfo record) throws Exception;
	ContractFbsqdInfo selectSingleByCondition(ContractFbsqdInfo contractFbsqdInfo) throws Exception;
}
