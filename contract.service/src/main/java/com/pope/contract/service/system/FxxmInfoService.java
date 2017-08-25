package com.pope.contract.service.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.dao.system.extend.FxxmInfoExtendMapper;
import com.pope.contract.entity.system.FxxmInfo;
import com.pope.contract.entity.system.extend.FxxmExtendInfo;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年8月19日 下午9:54:03 类说明
 */
public interface FxxmInfoService {

	int deleteByPrimaryKey(String wid);

	int insert(FxxmInfo record);

	FxxmInfo selectByPrimaryKey(String wid);

	int updateByPrimaryKeySelective(FxxmInfo record);

	List<FxxmExtendInfo> selectDisplayByCondition(FxxmInfo fxxmInfo);

	FxxmExtendInfo selectSingleDisplayByCondition(FxxmInfo fxxmInfo);

	List<FxxmExtendInfo> selectByBatchId( String batchId) throws Exception;
	
	/**
	 * 根据批次ID获取对应的分析项目信息
	 * @param batchId
	 * @return
	 */
	List<FxxmExtendInfo> selectByBatchDetail(String batchId,String htid) throws Exception;
}
