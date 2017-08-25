package com.pope.contract.service.supply;

import java.util.List;

import com.pope.contract.entity.supply.LqbInfo;
import com.pope.contract.entity.supply.ShbInfo;
import com.pope.contract.entity.supply.extend.LqbInfoExtend;
import com.pope.contract.entity.supply.extend.ShbInfoExtend;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月18日 下午9:58:24
* 类说明
*/
public interface ShbInfoService {
	 int deleteByPrimaryKey(String wid) throws Exception;

	    int insert(ShbInfo record,String userId) throws Exception;


	    ShbInfo selectByPrimaryKey(String wid) throws Exception;

	    int updateByPrimaryKeySelective(ShbInfo record) throws Exception;
	    void examinePass(String wid, String userid) throws Exception;
		 void examineNotPass(String wid, String userid) throws Exception;
		 List<ShbInfoExtend> selectWaitTaskInfoByStep(String roleId) throws Exception;
		 
		 List<ShbInfoExtend> selectDispalyTaskInfoByCondition(ShbInfo lqbInfo) throws Exception;

}
