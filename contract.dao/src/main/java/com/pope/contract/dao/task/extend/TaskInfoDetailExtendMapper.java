package com.pope.contract.dao.task.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.dao.task.TaskInfoDetailMapper;
import com.pope.contract.entity.task.TaskInfoDetail;

public interface TaskInfoDetailExtendMapper {
	Integer selectMaxXh() throws Exception;
	
	Integer selectMinZtByPid(@Param("frwid")String pid,@Param("existRecords")List<String> existRecords) throws Exception;
	List<TaskInfoDetail> selectDispalyTaskInfoByCondition(TaskInfoDetail taskInfoDetail) throws Exception;
	
	Integer selectNotDclTask(@Param("frwid") String frwid);
	
	void deleteTaskDetailByTaskId(@Param("frwid") String frwid);
}