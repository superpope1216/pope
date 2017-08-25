package com.pope.contract.dao.contract.extend;

import java.util.List;

import com.pope.contract.entity.contract.ContractInfo;
import com.pope.contract.entity.contract.extend.ContractInfoExtend;

public interface ContractInfoExtendMapper {
    
	ContractInfo selectSingleByCondition(ContractInfo contractInfo);
	
	List<ContractInfo> selectByCondition(ContractInfo contractInfo);
	
	ContractInfoExtend selectSingleDisplayByCondition(ContractInfo contractInfo);
	
	List<ContractInfoExtend> selectDisplayByCondition(ContractInfo contractInfo);
	
	Integer selectMaxDqbh();
}