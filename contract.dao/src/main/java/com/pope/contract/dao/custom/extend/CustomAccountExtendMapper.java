package com.pope.contract.dao.custom.extend;

import java.util.List;

import com.pope.contract.entity.custom.CustomAccount;
import com.pope.contract.entity.custom.extend.CustomAccountExtend;

public interface CustomAccountExtendMapper {
   
	CustomAccount selectSingleByCondition(CustomAccountExtend customAccountExtend);
	
	List<CustomAccount> selectByCondition(CustomAccountExtend customAccountExtend);
	
	 CustomAccountExtend  selectSingleDisplayByCondition(CustomAccountExtend customAccountExtend);
	
	List<CustomAccountExtend> selectByDisplayCondition(CustomAccountExtend customAccountExtend);
	
	Integer selectMax();
}