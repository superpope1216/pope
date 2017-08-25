package com.pope.contract.dao.project.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.dao.project.BatchInfoDetailMapper;
import com.pope.contract.entity.project.BatchInfo;
import com.pope.contract.entity.project.BatchInfoDetail;
import com.pope.contract.entity.project.extend.BatchInfoDetailExtend;

public interface BatchInfoDetailExtendMapper  {
	List<BatchInfoDetail> selectByCondition(BatchInfoDetail batchInfo);
	
	List<BatchInfoDetailExtend> selectDisplayByCondition(BatchInfoDetail batchInfo);
	
	void deleteByPcid(@Param("pcid")String pcid);
	Integer selectMaxDqbh();
}