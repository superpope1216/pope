package com.pope.contract.service.system;

import java.util.List;

import com.pope.contract.entity.system.NewsInfo;
import com.pope.contract.entity.system.extend.NewsInfoExtend;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年9月16日 下午9:45:57 类说明
 */
public interface NewsInfoService {
	int deleteByPrimaryKey(String wid) throws Exception;

	int insertSelective(NewsInfo record,String userId) throws Exception;

	NewsInfo selectByPrimaryKey(String wid) throws Exception;

	int updateByPrimaryKeySelective(NewsInfo record) throws Exception;

	int updateByPrimaryKeyWithBLOBs(NewsInfo record) throws Exception;
	
List<NewsInfo> selectByCondition(NewsInfoExtend newsInfoExtend) throws Exception;
	
	NewsInfo selectSingleByCondition(NewsInfoExtend newsInfoExtend) throws Exception;
}
