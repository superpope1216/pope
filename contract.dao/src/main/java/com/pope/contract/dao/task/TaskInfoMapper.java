package com.pope.contract.dao.task;

import com.pope.contract.entity.task.TaskInfo;

public interface TaskInfoMapper {
    int deleteByPrimaryKey(String wid);

    int insert(TaskInfo record);

    int insertSelective(TaskInfo record);

    TaskInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(TaskInfo record);

    int updateByPrimaryKey(TaskInfo record);
}