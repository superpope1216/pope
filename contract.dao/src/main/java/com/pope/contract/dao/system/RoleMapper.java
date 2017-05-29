package com.pope.contract.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.system.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(String wid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(Role record);
    
    List<Role> selectAll();

    int updateByPrimaryKey(Role record);
    
    /**
     * 根据用户ID获取用户的角色
     * @param userId
     * @return
     */
    List<Role> selectRolesByUserId(@Param(value="userId") String userId);
    
    
}