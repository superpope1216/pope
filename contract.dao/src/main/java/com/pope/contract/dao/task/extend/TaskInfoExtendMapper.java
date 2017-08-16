package com.pope.contract.dao.task.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.dao.task.TaskInfoMapper;
import com.pope.contract.entity.task.TaskInfo;

public interface TaskInfoExtendMapper extends TaskInfoMapper {
	Integer selectMaxXh() throws Exception;
	
	List<TaskInfo> selectDispalyTaskInfoByCondition(TaskInfo taskInfo) throws Exception;
	
	/**
	 * 根据当前步骤和任务状态获取任务信息
	 * @param step
	 * @param taskStatus
	 * @return
	 */
	List<TaskInfo> selectDispalyTaskInfoByStep(@Param("step") Integer step,@Param("taskStatus") List<Integer> taskStatus);
}