package com.pope.contract.dao.common;
import org.apache.ibatis.annotations.Param;

public interface CommonDao {

	String selectRwbhBySeqname(@Param(value="seqName") String seqName);
	
	void createSeqRwbh(@Param(value="seqName") String seqName);
}
