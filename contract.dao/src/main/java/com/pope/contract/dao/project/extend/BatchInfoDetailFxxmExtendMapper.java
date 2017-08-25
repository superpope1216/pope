package com.pope.contract.dao.project.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.project.BatchInfoDetailFxxm;
import com.pope.contract.entity.project.extend.BatchInfoDetailFxxmExtend;

public interface BatchInfoDetailFxxmExtendMapper{
	List<BatchInfoDetailFxxm> selectByCondition(BatchInfoDetailFxxm batchInfoFxxm);

	void deleteByCondition(BatchInfoDetailFxxm batchInfoFxxm);
	
	Integer selectFxxmCountByPcid(@Param("pcid")String pcid,@Param("fxxm") String fxxm);
	
	List<BatchInfoDetailFxxmExtend> selectFxxmDisplayByPcid(@Param("pcid")String pcid,@Param("fxxm") String fxxm);
}