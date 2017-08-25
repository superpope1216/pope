package com.pope.contract.dao.project.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.dao.project.BatchInfoMapper;
import com.pope.contract.entity.project.BatchInfo;
import com.pope.contract.entity.project.BatchInfoDetail;
import com.pope.contract.entity.project.extend.BatchInfoExtend;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月13日 下午2:00:53
* 类说明
*/
public interface BatchInfoExtendMapper {

	List<BatchInfo> selectByCondition(BatchInfo batchInfo);
	
	List<BatchInfoExtend> selectByWids(@Param("wids") List<String> wids);
	List<BatchInfoExtend> selectDisplayByCondition(BatchInfoExtend batchInfo);
	Integer selectMaxDqbh();
}
