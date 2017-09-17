package com.pope.contract.service.pxgl;

import java.util.List;

import com.pope.contract.entity.pxgl.PxglInfo;
import com.pope.contract.entity.pxgl.extend.PxglInfoExtend;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年9月10日 下午2:53:55 类说明
 */
public interface PxglInfoService {
	int deleteByPrimaryKey(String wid);

	int insertSelective(PxglInfo record,String flag) throws Exception;

	PxglInfo selectByPrimaryKey(String wid);

	int updateByPrimaryKeySelective(PxglInfo record,String flag) throws Exception;

	PxglInfo selectSingleByCondition(PxglInfoExtend pxglInfoExtend);

	List<PxglInfo> selectByCondition(PxglInfoExtend pxglInfoExtend);

	PxglInfoExtend selectSingleDisplayByCondition(PxglInfoExtend pxglInfoExtend);

	List<PxglInfoExtend> selectDisplayByCondition(PxglInfoExtend pxglInfoExtend);
	
	void examinePass(String wid, String userid) throws Exception ;
	
	void examineNotPass(String wid, String userid) throws Exception ;
}
