package com.pope.contract.service.contract;

import java.util.List;

import com.pope.contract.entity.contract.ContractInfo;
import com.pope.contract.entity.contract.extend.ContractInfoExtend;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年8月22日 下午5:41:22 类说明
 */
public interface ContractInfoService {

	int deleteByPrimaryKey(String wid) throws Exception;

	String insert(ContractInfo record,String pcids,String userId) throws Exception;

	ContractInfo selectByPrimaryKey(String wid) throws Exception;

	int updateByPrimaryKeySelective(ContractInfo record) throws Exception;

	ContractInfo selectSingleByCondition(ContractInfo contractInfo) throws Exception;

	List<ContractInfo> selectByCondition(ContractInfo contractInfo) throws Exception;

	ContractInfoExtend selectSingleDisplayByCondition(ContractInfo contractInfo) throws Exception;

	List<ContractInfoExtend> selectDisplayByCondition(ContractInfo contractInfo) throws Exception;
	
	Integer selectMaxDqbh() throws Exception;
	
	void addFxxm(String htid,String pcid,String fxxms,String userId) throws Exception;
	
	
	
}
