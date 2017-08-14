package com.pope.contract.dao.task.extend;

import java.util.List;

import com.pope.contract.dao.task.TaskInfoDetailMapper;
import com.pope.contract.entity.task.TaskInfoDetail;

public interface TaskInfoDetailExtendMapper extends TaskInfoDetailMapper{
	Integer selectMaxXh() throws Exception;
	
	List<TaskInfoDetail> selectDispalyTaskInfoByCondition(TaskInfoDetail taskInfoDetail) throws Exception;
}