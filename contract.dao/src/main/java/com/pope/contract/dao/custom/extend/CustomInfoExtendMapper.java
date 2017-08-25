package com.pope.contract.dao.custom.extend;

import java.util.List;

import com.pope.contract.dao.custom.CustomInfoMapper;
import com.pope.contract.entity.custom.CustomInfo;
import com.pope.contract.entity.custom.extend.CustomInfoExtend;

public interface CustomInfoExtendMapper {
	
	CustomInfo  selectSingleByCondition(CustomInfo customInfo);
	List<CustomInfo> selectByCondition(CustomInfo customInfo);
	
    CustomInfoExtend selectSingleDisplayByCondition(CustomInfo customInfo);
    
    List<CustomInfoExtend> selectDisplayByCondition(CustomInfo customInfo);
    
    Integer selectMaxBh();
}