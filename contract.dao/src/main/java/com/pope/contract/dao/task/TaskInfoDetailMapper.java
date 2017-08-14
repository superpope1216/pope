package com.pope.contract.dao.task;

import com.pope.contract.entity.task.TaskInfoDetail;

public interface TaskInfoDetailMapper {
    int deleteByPrimaryKey(String wid);

    int insert(TaskInfoDetail record);

    int insertSelective(TaskInfoDetail record);

    TaskInfoDetail selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(TaskInfoDetail record);

    int updateByPrimaryKey(TaskInfoDetail record);
}