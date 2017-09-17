package com.pope.contract.dao.custom.extend;

import java.util.List;

import com.pope.contract.dao.custom.CustomInfoMapper;
import com.pope.contract.entity.custom.CustomInfo;
import com.pope.contract.entity.custom.extend.CustomInfoExtend;

public interface CustomInfoExtendMapper {
	
	CustomInfo  selectSingleByCondition(CustomInfoExtend customInfo);
	List<CustomInfo> selectByCondition(CustomInfoExtend customInfo);
	
    CustomInfoExtend selectSingleDisplayByCondition(CustomInfoExtend customInfo);
    
    List<CustomInfoExtend> selectDisplayByCondition(CustomInfoExtend customInfo);
    
    Integer selectMaxBh();
}