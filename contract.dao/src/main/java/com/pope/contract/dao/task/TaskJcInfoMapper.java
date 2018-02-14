package com.pope.contract.dao.task;

import com.pope.contract.entity.task.TaskJcInfo;

public interface TaskJcInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(TaskJcInfo record);

    int insertSelective(TaskJcInfo record);

    TaskJcInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(TaskJcInfo record);

    int updateByPrimaryKey(TaskJcInfo record);
}