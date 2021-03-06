package com.pope.contract.dao.supply.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.dao.supply.SupplyInfoMapper;
import com.pope.contract.entity.supply.SupplyInfo;
import com.pope.contract.entity.supply.extend.SupplyInfoExtend;

public interface SupplyInfoExtendMapper{
	List<SupplyInfo> selectByCondition(SupplyInfoExtend supplyInfo);
	List<SupplyInfoExtend> selectDisplayByCondition(SupplyInfoExtend supplyInfo);
	Integer selectMaxBh();
	
	List<Map<String,Object>> selectPmByCondition(@Param("hcfl") String hcfl);
	
	SupplyInfo selectSingleByCondition(SupplyInfoExtend supplyInfo);
	
}