package com.pope.contract.dao.project.extend;

import java.util.List;

import com.pope.contract.entity.project.BatchInfoFxxm;

public interface BatchInfoFxxmExtendMapper{
    
	List<BatchInfoFxxm> selectByCondition(BatchInfoFxxm batchInfoFxxm);
	
	void deleteByCondition(BatchInfoFxxm batchInfoFxxm);
	
    
}