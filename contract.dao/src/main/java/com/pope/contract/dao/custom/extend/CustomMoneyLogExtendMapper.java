package com.pope.contract.dao.custom.extend;

import java.util.List;

import com.pope.contract.entity.custom.CustomInfo;
import com.pope.contract.entity.custom.extend.CustomMoneyLogExtend;

public interface CustomMoneyLogExtendMapper {
	CustomMoneyLogExtend selectSingleDisplayByCondition(CustomMoneyLogExtend customInfo);
	    
	List<CustomMoneyLogExtend> selectDisplayByCondition(CustomMoneyLogExtend customInfo);
}