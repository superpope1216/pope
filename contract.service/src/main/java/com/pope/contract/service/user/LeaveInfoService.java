package com.pope.contract.service.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.user.LeaveInfo;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年6月4日 下午7:52:46
* 类说明
*/
public interface LeaveInfoService {
		int deleteByPrimaryKey(String wid,String userId) throws  Exception;

	    int insert(LeaveInfo record,String userId) throws Exception;

	    int insertSelective(LeaveInfo record,String userId) throws Exception;
	    void examineNotPass(String wid,String userId) throws Exception;
	    /**
		 * 审核
		 * @param wid
		 * @param useId
		 * @return
		 * @throws Exception
		 */
		int examinePass(String wid,String userId) throws Exception;

	    LeaveInfo selectByPrimaryKey(String wid);
	    
	    List<LeaveInfo> selectByYhid(String yhid);

	    int updateByPrimaryKeySelective(LeaveInfo record,String userId) throws Exception;

	    int updateByPrimaryKey(LeaveInfo record,String userId) throws Exception;
	    
	    List<LeaveInfo> selectByRoleId(String roldId,List<String> taskStatus,String departId,String teamId) throws Exception;
	    List<LeaveInfo> selectByOtherRoleId(String roldId,List<String> taskStatus,String departId,String teamId) throws Exception;
	    
}
