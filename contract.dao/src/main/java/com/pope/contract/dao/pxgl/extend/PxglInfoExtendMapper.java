package com.pope.contract.dao.pxgl.extend;

import java.util.List;

import com.pope.contract.entity.pxgl.PxglInfo;
import com.pope.contract.entity.pxgl.extend.PxglInfoExtend;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年9月10日 下午2:32:20
* 类说明
*/
public interface PxglInfoExtendMapper {

	PxglInfo selectSingleByCondition(PxglInfoExtend pxglInfoExtend);
	
	List<PxglInfo> selectByCondition(PxglInfoExtend pxglInfoExtend);
	
	PxglInfoExtend selectSingleDisplayByCondition(PxglInfoExtend pxglInfoExtend);
	
	List<PxglInfoExtend>  selectDisplayByCondition(PxglInfoExtend pxglInfoExtend);
}
