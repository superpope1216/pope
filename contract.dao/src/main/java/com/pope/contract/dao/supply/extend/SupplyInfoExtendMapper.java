package com.pope.contract.dao.supply.extend;

import java.util.List;

import com.pope.contract.dao.supply.SupplyInfoMapper;
import com.pope.contract.entity.supply.SupplyInfo;
import com.pope.contract.entity.supply.extend.SupplyInfoExtend;

public interface SupplyInfoExtendMapper extends SupplyInfoMapper {
	List<SupplyInfo> selectByCondition(SupplyInfo supplyInfo);
	List<SupplyInfoExtend> selectDisplayByCondition(SupplyInfo supplyInfo);
	Integer selectMaxBh();
}