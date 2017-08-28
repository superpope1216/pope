package com.pope.contract.dao.contract.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.contract.ContractInfo;
import com.pope.contract.entity.contract.extend.ContractInfoExtend;

public interface ContractInfoExtendMapper {
    
	ContractInfo selectSingleByCondition(ContractInfo contractInfo);
	
	List<ContractInfo> selectByCondition(ContractInfo contractInfo);
	
	ContractInfoExtend selectSingleDisplayByCondition(ContractInfo contractInfo);
	
	List<ContractInfoExtend> selectDisplayByCondition(ContractInfo contractInfo);
	
	Integer selectMaxDqbh();
	
	List<ContractInfoExtend> selectDispalyInfoByStep(@Param("step") Integer step,@Param("taskStatus") List<Integer> taskStatus) throws Exception;
}