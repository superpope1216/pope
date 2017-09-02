package com.pope.contract.service.statics;

import java.util.List;

import com.pope.contract.entity.statics.extend.StaticMoneyInfoExtend;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月27日 下午7:29:36
* 类说明
*/
public interface StaticMoneyService {

	 void calcuMoney() throws Exception;
	 
	 List<StaticMoneyInfoExtend> selectByCondition(StaticMoneyInfoExtend staticMoneyInfoExtend);
	 
	 StaticMoneyInfoExtend selectSingleByCondition(StaticMoneyInfoExtend staticMoneyInfoExtend);
	
}
