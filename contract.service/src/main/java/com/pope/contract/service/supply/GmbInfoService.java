package com.pope.contract.service.supply;

import java.util.List;

import com.pope.contract.entity.supply.GmbInfo;
import com.pope.contract.entity.supply.LqbInfo;
import com.pope.contract.entity.supply.extend.GmbInfoExtend;
import com.pope.contract.entity.supply.extend.LqbInfoExtend;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月18日 下午9:58:57
* 类说明
*/
public interface GmbInfoService {
	 int deleteByPrimaryKey(String wid) throws Exception;

	    int insert(GmbInfo record,String userId) throws Exception;

	    GmbInfo selectByPrimaryKey(String wid) throws Exception;

	    int updateByPrimaryKeySelective(GmbInfo record)  throws Exception; 
	    
	    void examinePass(String wid, String userid) throws Exception;
		 void examineNotPass(String wid, String userid) throws Exception;
		 List<GmbInfoExtend> selectWaitTaskInfoByStep(String roleId) throws Exception;
		 
		 List<GmbInfoExtend> selectDispalyTaskInfoByCondition(GmbInfo lqbInfo) throws Exception;
}
