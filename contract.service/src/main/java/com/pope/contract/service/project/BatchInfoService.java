package com.pope.contract.service.project;

import java.util.List;

import com.pope.contract.entity.project.BatchInfo;
import com.pope.contract.entity.project.BatchInfoDetail;
import com.pope.contract.entity.project.extend.BatchInfoDetailExtend;
import com.pope.contract.entity.project.extend.BatchInfoExtend;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月13日 下午1:59:42
* 类说明
*/
public interface BatchInfoService {
	List<BatchInfo> selectByCondition(BatchInfo batchInfo);
	
	List<BatchInfoExtend> selectDisplayByCondition(BatchInfo batchInfo);
	
	BatchInfo selectByPrimaryKey(String wid);
	
	
	BatchInfo insertBatchInfo(BatchInfo batchInfo) throws Exception;
	
	int updateBatchInfo(BatchInfo batchInfo) throws Exception;
	
	void deleteBatchInfo(String wid) throws Exception;
	
	String selectMax() throws Exception;
	
	String selectDetailMax() throws Exception;
	
	List<BatchInfoDetail> selectDetailByCondition(BatchInfoDetail batchInfoDetail) throws Exception;
	
	List<BatchInfoDetailExtend> selectDetailDisplayByCondition(BatchInfoDetail batchInfoDetail) throws Exception;
	void insertBatchInfoDetail(BatchInfoDetail batchInfoDetail) throws Exception;
	
	void updateBatchInfoDetail(BatchInfoDetail batchInfo) throws Exception;
	
	void deleteBatchInfoDetail(String wid) throws Exception;
	
	String copyBatchInfo(String wid) throws Exception;
}
