package com.pope.contract.service.supply;

import java.util.List;

import com.pope.contract.entity.supply.SupplyInfo;
import com.pope.contract.entity.supply.extend.SupplyInfoExtend;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年8月15日 下午6:24:53 类说明
 */
public interface SupplyInfoService {
	void deleteByPrimaryKey(String wid);

	SupplyInfo insert(SupplyInfo record);

	void updateByPrimaryKeySelective(SupplyInfo record);

	SupplyInfo selectByPrimaryKey(String wid);

	List<SupplyInfo> selectByCondition(SupplyInfo supplyInfo);

	List<SupplyInfoExtend> selectDisplayByCondition(SupplyInfo supplyInfo);
	
}
