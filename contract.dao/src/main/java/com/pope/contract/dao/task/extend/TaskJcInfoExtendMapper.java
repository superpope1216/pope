package com.pope.contract.dao.task.extend;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.task.TaskJcInfo;

public interface TaskJcInfoExtendMapper {

	TaskJcInfo selectByTaskId(@Param("taskid") String taskid);
}