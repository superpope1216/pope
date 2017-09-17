package com.pope.contract.service.supply;

import java.util.List;
import java.util.Map;

import com.pope.contract.entity.supply.SupplyInfo;
import com.pope.contract.entity.supply.extend.SupplyInfoExtend;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年8月15日 下午6:24:53 类说明
 */
public interface SupplyInfoService {
	void deleteByPrimaryKey(String wid);

	SupplyInfo insert(SupplyInfo record) throws Exception;

	void updateByPrimaryKeySelective(SupplyInfo record) throws Exception;

	SupplyInfo selectByPrimaryKey(String wid);

	List<SupplyInfo> selectByCondition(SupplyInfoExtend supplyInfo);
	
	SupplyInfo selectSingleByCondition(SupplyInfoExtend supplyInfo) throws Exception;

	List<SupplyInfoExtend> selectDisplayByCondition(SupplyInfoExtend supplyInfo);
	
	List<Map<String,Object>> selectPmByCondition(String hcfl) throws Exception;
	
	
	void kl(String wid) throws Exception;
	
}
