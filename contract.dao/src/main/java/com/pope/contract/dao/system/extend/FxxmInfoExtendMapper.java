package com.pope.contract.dao.system.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.dao.system.FxxmInfoMapper;
import com.pope.contract.entity.system.FxxmInfo;
import com.pope.contract.entity.system.extend.FxxmExtendInfo;

public interface FxxmInfoExtendMapper {
	
	List<FxxmExtendInfo> selectDisplayByCondition(FxxmInfo fxxmInfo);
	
	FxxmExtendInfo selectSingleDisplayByCondition(FxxmInfo fxxmInfo);
	
	/**
	 * 根据批次ID获取对应的分析项目信息
	 * @param batchId
	 * @return
	 */
	List<FxxmExtendInfo> selectByBatchId(@Param("batchId") String batchId);
	
	/**
	 * 根据批次ID获取对应的分析项目信息
	 * @param batchId
	 * @return
	 */
	List<FxxmExtendInfo> selectByBatchDetail(@Param("batchId") String batchId,@Param("htid") String htid);
	
}