package com.pope.contract.service.task;

import java.util.List;

import com.pope.contract.entity.task.TaskInfo;
import com.pope.contract.entity.task.TaskInfoDetail;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月14日 上午9:24:23
* 类说明
*/
public interface TaskInfoService {

	void insertTaskInfo(TaskInfo taskInfo,String userId) throws Exception;
	
	List<TaskInfo> selectDispalyTaskInfoByCondition(TaskInfo taskInfo) throws Exception;
	
	List<TaskInfoDetail> selectDispalyTaskInfoDetailByCondition(TaskInfoDetail taskInfo) throws Exception;
}
