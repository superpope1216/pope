package com.pope.contract.dao.task.extend;

import java.util.List;

import com.pope.contract.dao.task.TaskInfoMapper;
import com.pope.contract.entity.task.TaskInfo;

public interface TaskInfoExtendMapper extends TaskInfoMapper {
	Integer selectMaxXh() throws Exception;
	
	List<TaskInfo> selectDispalyTaskInfoByCondition(TaskInfo taskInfo) throws Exception;
}