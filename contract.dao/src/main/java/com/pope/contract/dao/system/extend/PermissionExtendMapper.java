package com.pope.contract.dao.system.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.dao.system.PermissionMapper;
import com.pope.contract.entity.system.Permission;
import com.pope.contract.entity.system.Role;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月19日 下午7:04:11
* 类说明
*/
public interface PermissionExtendMapper {
	 /**
     * 根据角色获取权限
     * @param roles
     * @return
     */
    List<Permission> selectPermissionByRoles(@Param(value="list") List<Role> roles,@Param(value="level") String level,@Param(value="pid") String pid);
    
    List<Permission> selectAll();
    
    List<Permission> selectPermissionByRoleAsTree(Role role);
    
    List<Permission> selectPermissionByRoleId(@Param(value="roleId") String roleId);
    
    List<Permission> selectChildByUrl(@Param(value="url") String url,@Param(value="roleId") String roleId);
    
    List<Permission> selectPermissionByPid (@Param(value="pid") String pid);
}
