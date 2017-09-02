package com.pope.contract.dao.contract.extend;

import java.util.List;

import com.pope.contract.entity.contract.ContractInfo;
import com.pope.contract.entity.contract.ContractInfoRel;

public interface ContractInfoRelExtendMapper {
	
	int deleteByCondition(ContractInfoRel contractInfoRel);
	
	List<ContractInfoRel> selectByCondition(ContractInfoRel contractInfoRel);
}