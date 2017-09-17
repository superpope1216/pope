package com.pope.contract.dao.system.extend;

import java.util.List;

import com.pope.contract.entity.system.NewsInfo;
import com.pope.contract.entity.system.extend.NewsInfoExtend;

public interface NewsInfoExtendMapper {
    
	List<NewsInfo> selectByCondition(NewsInfoExtend newsInfoExtend);
	
	NewsInfo selectSingleByCondition(NewsInfoExtend newsInfoExtend);
}