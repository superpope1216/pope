package com.pope.contract.dao.system;

import com.pope.contract.entity.system.FlowSetData;

public interface FlowSetDataMapper {
    int deleteByPrimaryKey(String wid);

    int insert(FlowSetData record);

    int insertSelective(FlowSetData record);

    FlowSetData selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(FlowSetData record);

    int updateByPrimaryKey(FlowSetData record);
    /**
     * 根据数据ID获取流程最后的审核嘻嘻你
     * @param dataId
     * @return
     */
    FlowSetData selectByDataId(String dataId);
}