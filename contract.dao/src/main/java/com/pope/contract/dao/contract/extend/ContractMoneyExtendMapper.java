package com.pope.contract.dao.contract.extend;

import java.util.List;

import com.pope.contract.entity.contract.ContractMoney;
import com.pope.contract.entity.contract.extend.ContractMoneyExtend;

public interface ContractMoneyExtendMapper {

	List<ContractMoney> selectByCondition(ContractMoney contractMoney);
	
	ContractMoney selectSingleByCondition(ContractMoney contractMoney);
	
	ContractMoneyExtend selectSingleDispalyByCondition(ContractMoney contractMoney);
	
	List<ContractMoneyExtend> selectDispalyByCondition(ContractMoney contractMoney);
	
	int deleteByCondition(ContractMoney contractMoney);
}