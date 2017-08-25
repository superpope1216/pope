package com.pope.contract.dao.supply.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.supply.LqbInfo;
import com.pope.contract.entity.supply.ShbInfo;
import com.pope.contract.entity.supply.extend.LqbInfoExtend;
import com.pope.contract.entity.supply.extend.ShbInfoExtend;

public interface ShbInfoExtendMapper {
    
List<ShbInfoExtend> selectDispalyInfoByStep(@Param("step") Integer step,@Param("taskStatus") List<Integer> taskStatus) throws Exception;
	
	List<ShbInfoExtend> selectDispalyTaskInfoByCondition(ShbInfo lqbInfo) throws Exception;
}