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

	ContractInfo selectSingleByCondition(ContractInfoExtend contractInfo) throws Exception;

	List<ContractInfo> selectByCondition(ContractInfoExtend contractInfo) throws Exception;

	ContractInfoExtend selectSingleDisplayByCondition(ContractInfoExtend contractInfo) throws Exception;

	List<ContractInfoExtend> selectDisplayByCondition(ContractInfoExtend contractInfo) throws Exception;
	
	Integer selectMaxDqbh() throws Exception;
	
	void addFxxm(String htid,String pcid,String fxxms,String userId) throws Exception;
	
	void submitContract(String wids,String userId) throws Exception;
	
	List<ContractInfoExtend> selectWaitTaskInfoByStep(String wid) throws Exception;
	
	void examinePass(String wid, String userid) throws Exception;
    void examineNotPass(String wid, String userid) throws Exception;
    
    ContractInfoExtend getNewContractinfo(String pcid,String pcids) throws Exception;
	
	
}
