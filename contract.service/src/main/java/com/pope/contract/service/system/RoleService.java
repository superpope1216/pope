package com.pope.contract.service.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.system.Role;

public interface RoleService {
	 int deleteByPrimaryKey(String wid);

	    int insert(Role record);

	    int insertSelective(Role record);

	    Role selectByPrimaryKey(String wid);

	    int updateByPrimaryKeySelective(Role record);

	    int updateByPrimaryKey(Role record);
	    
	    /**
	     * 根据用户ID获取用户的角色
	     * @param userId
	     * @return
	     */
	    List<Role> selectRolesByUserId(  String userId);
}
