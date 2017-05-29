package com.pope.contract.service.system.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pope.contract.dao.system.RolePermissionMapper;
import com.pope.contract.entity.system.RolePermission;
import com.pope.contract.service.system.RolePermissionService;
import com.pope.contract.util.CommonUtil;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年5月29日 下午7:16:40
* 类说明
*/
@Service("rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {

	@Autowired
	private RolePermissionMapper rolePermissionMapper; 
	@Override
	public int insert(RolePermission record) {
		return rolePermissionMapper.insert(record);
	}

	@Override
	public int insertSelective(RolePermission record) {
		return rolePermissionMapper.insertSelective(record);
	}

	@Override
	public int deleteByRoleId(String roleId) {
		return rolePermissionMapper.deleteByRoleId(roleId);
	}
	
	@Override
	@Transactional
	public void updatePermissionsByRoleId(String roleId,String perms){
		this.deleteByRoleId(roleId);
		List<String> lstPerms=StringUtil.str2List(perms, ",");
		List<RolePermission> lstRolePermission=new ArrayList<RolePermission>();
		if(CommonUtil.isNotEmptyList(lstPerms)){
			for(String p:lstPerms){
				RolePermission rp=new RolePermission();
				rp.setWid(StringUtil.getUuId());
				rp.setRoleid(roleId);
				rp.setPermissionid(p);
				lstRolePermission.add(rp);
			}
			rolePermissionMapper.bathInsert(lstRolePermission);
		}
	}

}
