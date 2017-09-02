package com.pope.contract.service.supply;

import java.util.List;

import com.pope.contract.entity.supply.SupplyInfo;
import com.pope.contract.entity.supply.SupplyTotalInfo;
import com.pope.contract.entity.supply.extend.SupplyInfoExtend;
import com.pope.contract.entity.supply.extend.SupplyTotalInfoExtend;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年8月15日 下午6:24:53 类说明
 */
public interface SupplyTotalInfoService {
	void deleteByPrimaryKey(String wid);

	SupplyTotalInfo insert(SupplyTotalInfo record);

	void updateByPrimaryKeySelective(SupplyTotalInfo record);

	SupplyTotalInfo selectByPrimaryKey(String wid);

	List<SupplyTotalInfo> selectByCondition(SupplyTotalInfoExtend supplyInfo);

	List<SupplyTotalInfoExtend> selectDisplayByCondition(SupplyTotalInfoExtend supplyInfo);
	
}
