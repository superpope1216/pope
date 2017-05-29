package com.pope.contract.service.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.system.Role;

public interface RoleService {
	 int deleteByPrimaryKey(String wid);

	    int insert(Role record,String userId) throws Exception;

	    int insertSelective(Role record,String userId) throws Exception;

	    Role selectByPrimaryKey(String wid);

	    int  updateByPrimaryKeySelective(Role record,String userId) throws Exception;

	    int updateByPrimaryKey(Role record,String userId) throws Exception;
	    
	    int  deleteByRoleId(Role role,String userId) throws Exception;
	    
	    /**
	     * 根据用户ID获取用户的角色
	     * @param userId
	     * @return
	     */
	    List<Role> selectRolesByUserId(  String userId);
	    
	    List<Role> selectAll();
}
