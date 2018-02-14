package com.pope.contract.dao.custom.extend;

import java.util.List;

import com.pope.contract.entity.custom.CustomUpdateLog;

public interface CustomUpdateLogExtendMapper {
   
	List<CustomUpdateLog> selectByCondition(CustomUpdateLog customUpdateLog);
	
	CustomUpdateLog selectSingleByCondition(CustomUpdateLog customUpdateLog);
}