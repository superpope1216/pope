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

	    LeaveInfo selectByPrimaryKey(String wid);
	    
	    List<LeaveInfo> selectByYhid(String yhid);

	    int updateByPrimaryKeySelective(LeaveInfo record,String userId) throws Exception;

	    int updateByPrimaryKey(LeaveInfo record,String userId) throws Exception;
}
