package com.pope.contract.service.task;

import java.util.List;
import java.util.Map;

import com.pope.contract.code.TaskStatusEnum;
import com.pope.contract.entity.task.TaskInfo;
import com.pope.contract.entity.task.TaskInfoDetail;
import com.pope.contract.entity.task.extend.TaskInfoExtend;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月14日 上午9:24:23
* 类说明
*/
public interface TaskInfoService {

	void insertTaskInfo(TaskInfo taskInfo,String userId) throws Exception;
	
	List<TaskInfoExtend> selectDispalyTaskInfoByCondition(TaskInfo taskInfo) throws Exception;
	
	/**
	 * 根据分析人员获取对应的审核权限
	 * @param fxxr
	 * @return
	 * @throws Exception
	 */
	List<TaskInfoExtend> selectDispalyTaskInfoByPermission(String roleName,String  userId,TaskStatusEnum taskStatus) throws Exception;
	
	List<TaskInfoDetail> selectDispalyTaskInfoDetailByCondition(TaskInfoDetail taskInfo) throws Exception;
	
	void submitTaskInfoDetail(String pid,List<Map> datas,String userId) throws Exception;
	
	void submitTaskInfo(List<Map> datas,String userId) throws Exception;
	/**
	 * 根据当前的审核步骤获取任务信息
	 * @param taskInfo
	 * @return
	 * @throws Exception
	 */
	List<TaskInfo> selectWaitTaskInfoByStep(String roleId) throws Exception;
	/**
	 * 审核通过
	 * @param wid
	 * @param userid
	 * @throws Exception
	 */
	void examinePass(String wid,String userid) throws Exception;
	
	/**
	 * 审核通过
	 * @param wid
	 * @param userid
	 * @throws Exception
	 */
	void examineNotPass(String wid,String userid) throws Exception;
	
	List<TaskInfo> selectTaskInfoByCondition(TaskInfo taskInfo);
	
}
