package com.pope.contract.dao.statics.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.statics.extend.StaticMoneyInfoExtend;



public interface StaticMoneyInfoExtendMapper {

	void deleteByCondition(StaticMoneyInfoExtend staticMoneyInfoExtend);
	List<Map<String,Object>> selectContractStaticByRwzt(@Param("rwzt")List<String> rwzt,@Param("year") Integer year);
	List<Map<String,Object>> selectSupplyStaticByRwzt(@Param("rwzt")List<String> rwzt,@Param("year") Integer year);
	
	
	
	List<StaticMoneyInfoExtend> selectByCondition(StaticMoneyInfoExtend staticMoneyInfoExtend);
	 
	StaticMoneyInfoExtend selectSingleByCondition(StaticMoneyInfoExtend staticMoneyInfoExtend);
}