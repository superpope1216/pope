package com.pope.contract.service.supply;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.supply.LqbInfo;
import com.pope.contract.entity.supply.extend.LqbInfoExtend;
import com.pope.contract.entity.supply.extend.SupplyInfoExtend;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年8月18日 下午9:54:17 类说明
 */
public interface LqbInfoService {
	int deleteByPrimaryKey(String wid) throws Exception;

	int insert(LqbInfo record,String userId) throws Exception;

	LqbInfo selectByPrimaryKey(String wid) throws Exception;

	int updateByPrimaryKeySelective(LqbInfo record) throws Exception;
	
	 void examinePass(String wid, String userid) throws Exception;
	 void examineNotPass(String wid, String userid) throws Exception;
	 List<LqbInfoExtend> selectWaitTaskInfoByStep(String roleId) throws Exception;
	 
	 List<LqbInfoExtend> selectDispalyTaskInfoByCondition(LqbInfo lqbInfo) throws Exception;
}
