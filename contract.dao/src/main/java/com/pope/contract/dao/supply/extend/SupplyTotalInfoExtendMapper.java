package com.pope.contract.dao.supply.extend;

import java.util.List;

import com.pope.contract.dao.supply.SupplyTotalInfoMapper;
import com.pope.contract.entity.supply.SupplyTotalInfo;
import com.pope.contract.entity.supply.extend.SupplyTotalInfoExtend;

public interface SupplyTotalInfoExtendMapper {
	List<SupplyTotalInfo> selectByCondition(SupplyTotalInfo supplyTotalInfo);
	List<SupplyTotalInfoExtend> selectDisplayByCondition(SupplyTotalInfo supplyTotalInfo);
}