package com.pope.contract.dao.contract.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.contract.ContractInfo;
import com.pope.contract.entity.contract.extend.ContractInfoExtend;

public interface ContractInfoExtendMapper {
    
	ContractInfo selectSingleByCondition(ContractInfoExtend contractInfo);
	
	List<ContractInfo> selectByCondition(ContractInfoExtend contractInfo);
	
	ContractInfoExtend selectSingleDisplayByCondition(ContractInfoExtend contractInfo);
	
	List<ContractInfoExtend> selectDisplayByCondition(ContractInfoExtend contractInfo);
	
	Integer selectMaxDqbh();
	
	List<ContractInfoExtend> selectDispalyInfoByStep(@Param("step") Integer step,@Param("taskStatus") List<Integer> taskStatus) throws Exception;
}