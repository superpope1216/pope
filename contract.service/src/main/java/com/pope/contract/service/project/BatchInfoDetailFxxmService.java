package com.pope.contract.service.project;

import java.util.List;


import com.pope.contract.entity.project.BatchInfoDetailFxxm; 
import com.pope.contract.entity.project.extend.BatchInfoDetailFxxmExtend;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月26日 上午1:38:00
* 类说明
*/
public interface BatchInfoDetailFxxmService {
	List<BatchInfoDetailFxxm> selectByCondition(BatchInfoDetailFxxm batchInfoFxxm);

	void deleteByCondition(BatchInfoDetailFxxm batchInfoFxxm);
	
	Integer selectFxxmCountByPcid(String pcid,String fxxm);
	
	List<BatchInfoDetailFxxmExtend> selectFxxmDisplayByPcid( String pcid,  String fxxm) throws Exception;
}
