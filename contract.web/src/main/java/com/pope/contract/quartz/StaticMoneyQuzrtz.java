package com.pope.contract.quartz;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.pope.contract.service.statics.StaticMoneyService;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月27日 下午6:55:22
* 类说明
*/
public class StaticMoneyQuzrtz {

	private static final Logger LOG=org.slf4j.LoggerFactory.getLogger(StaticMoneyQuzrtz.class);
	
	@Autowired
	private StaticMoneyService staticMoneyService;
	public void staticMoney() throws Exception{
		LOG.info("=======================123");
		staticMoneyService.calcuMoney();
	}
}
