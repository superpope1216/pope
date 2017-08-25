package com.pope.contract.dao.supply.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.supply.GmbInfo;
import com.pope.contract.entity.supply.ShbInfo;
import com.pope.contract.entity.supply.extend.GmbInfoExtend;
import com.pope.contract.entity.supply.extend.ShbInfoExtend;

public interface GmbInfoExtendMapper {
    
    List<GmbInfoExtend> selectDispalyInfoByStep(@Param("step") Integer step,@Param("taskStatus") List<Integer> taskStatus) throws Exception;
	
	List<GmbInfoExtend> selectDispalyTaskInfoByCondition(GmbInfo lqbInfo) throws Exception;
}