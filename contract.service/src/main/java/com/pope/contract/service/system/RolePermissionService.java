package com.pope.contract.service.system;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.pope.contract.entity.system.RolePermission;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年5月29日 下午7:16:29
* 类说明
*/
public interface RolePermissionService {
	int insert(RolePermission record);

    int insertSelective(RolePermission record);
    
    int deleteByRoleId( String roleId);
    
	void updatePermissionsByRoleId(String roleId,String perms);
}
