package com.pope.contract.dao.task.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.dao.task.TaskInfoMapper;
import com.pope.contract.entity.task.TaskInfo;
import com.pope.contract.entity.task.TaskInfoDetail;
import com.pope.contract.entity.task.extend.TaskInfoExtend;

public interface TaskInfoExtendMapper extends TaskInfoMapper {
	Integer selectMaxXh() throws Exception;
	
	List<TaskInfoExtend> selectDispalyTaskInfoByCondition(TaskInfo taskInfo) throws Exception;
	
	List<TaskInfo> selectTaskInfoByCondition(TaskInfo taskInfo);
	
	/**
	 * 根据分析人员获取对应的审核权限
	 * @param fxxr
	 * @param shry
	 * @return
	 * @throws Exception
	 */
	List<TaskInfoExtend> selectDispalyTaskInfoByPermission(@Param("fxxr")String  fxxr,@Param("shry")String shry,@Param("rwzt")Integer  rwzt) throws Exception;
	
	List<TaskInfoDetail> selectDispalyTaskInfoDetailByCondition(TaskInfoDetail taskInfo) throws Exception;
	
	/**
	 * 根据当前步骤和任务状态获取任务信息
	 * @param step
	 * @param taskStatus
	 * @return
	 */
	List<TaskInfo> selectDispalyTaskInfoByStep(@Param("step") Integer step,@Param("taskStatus") List<Integer> taskStatus);
}