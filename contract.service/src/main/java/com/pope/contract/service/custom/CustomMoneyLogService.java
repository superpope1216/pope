package com.pope.contract.service.custom;

import java.util.List;

import com.pope.contract.entity.custom.CustomMoneyLog;
import com.pope.contract.entity.custom.extend.CustomMoneyLogExtend;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年9月4日 下午9:39:58 类说明
 */
public interface CustomMoneyLogService {
	int deleteByPrimaryKey(String wid);

	int insertSelective(CustomMoneyLog record);

	CustomMoneyLog selectByPrimaryKey(String wid);

	int updateByPrimaryKeySelective(CustomMoneyLog record);
	
	CustomMoneyLogExtend selectSingleDisplayByCondition(CustomMoneyLogExtend customInfo);
    
	List<CustomMoneyLogExtend> selectDisplayByCondition(CustomMoneyLogExtend customInfo);
}
