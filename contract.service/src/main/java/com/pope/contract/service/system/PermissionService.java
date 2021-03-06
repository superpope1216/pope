package com.pope.contract.service.system;

import java.util.List;


import com.pope.contract.entity.system.Permission;
import com.pope.contract.entity.system.Role;

public interface PermissionService {
	 int insert(Permission record);

	    int insertSelective(Permission record);
	    
	    Permission selectByPrimaryKey(String wid);
	    
	    /**
	     * 根据角色获取权限
	     * @param roles
	     * @return
	     */
	    List<Permission> selectPermissionByRoles(List<Role> roles,String level,String pid);
	    
	    List<Permission> selectAll();
	    
	    List<Permission> selectPermissionByRoleAsTree(Role role);
	    
	    List<Permission> selectPermissionByRoleId(  String roleId);
	    
	    List<Permission> selectChildByUrl( String url,String roleId);
	    
	    void updateMenuSort(List<String> wids) throws Exception;
	    
	    int updateByPrimaryKeySelective(Permission record);
}
