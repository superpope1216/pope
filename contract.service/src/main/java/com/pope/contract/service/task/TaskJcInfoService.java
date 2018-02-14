package com.pope.contract.service.task;

import com.pope.contract.entity.task.TaskJcInfo;
import com.pope.contract.entity.task.extend.TaskJcInfoExtend;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年9月23日 下午11:24:00 类说明
 */
public interface TaskJcInfoService {
	int deleteByPrimaryKey(String wid) throws Exception;

	int insertSelective(TaskJcInfo record) throws Exception;

	TaskJcInfo selectByPrimaryKey(String wid) throws Exception;

	int updateByPrimaryKeySelective(TaskJcInfo record) throws Exception;
	
	TaskJcInfoExtend showPrint(String taskId) throws Exception;

}
