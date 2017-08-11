package com.pope.contract.service.system;

import com.pope.contract.entity.system.FlowSetData;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年7月15日 下午12:15:16
* 类说明
*/
public interface FlowSetDataService {
	int deleteByPrimaryKey(String wid);

    int insert(FlowSetData record);

    int insertSelective(FlowSetData record);

    FlowSetData selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(FlowSetData record);

    int updateByPrimaryKey(FlowSetData record);
    
    FlowSetData selectByDataId(String dataId);
}
