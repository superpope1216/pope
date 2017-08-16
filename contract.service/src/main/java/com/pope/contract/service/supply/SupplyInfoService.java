package com.pope.contract.service.supply;

import java.util.List;

import com.pope.contract.entity.supply.SupplyInfo;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月15日 下午6:24:53
* 类说明
*/
public interface SupplyInfoService {
	List<SupplyInfo> selectByCondition(SupplyInfo supplyInfo);
	
	List<SupplyInfo> selectDisplayByCondition(SupplyInfo supplyInfo);
}
