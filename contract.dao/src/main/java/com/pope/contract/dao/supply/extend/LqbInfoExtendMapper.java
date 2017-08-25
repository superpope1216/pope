package com.pope.contract.dao.supply.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.dao.supply.LqbInfoMapper;
import com.pope.contract.entity.supply.LqbInfo;
import com.pope.contract.entity.supply.extend.LqbInfoExtend;
import com.pope.contract.entity.supply.extend.SupplyInfoExtend;

public interface LqbInfoExtendMapper {
	
	/**
	 * 根据当前步骤和任务状态获取任务信息
	 * @param step
	 * @param taskStatus
	 * @return
	 */
	List<LqbInfoExtend> selectDispalyInfoByStep(@Param("step") Integer step,@Param("taskStatus") List<Integer> taskStatus) throws Exception;
	
	List<LqbInfoExtend> selectDispalyTaskInfoByCondition(LqbInfo lqbInfo) throws Exception;
}