package com.pope.contract.service.system.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.pope.contract.dao.system.PermissionMapper;
import com.pope.contract.dao.system.extend.PermissionExtendMapper;
import com.pope.contract.entity.system.Permission;
import com.pope.contract.entity.system.Role;
import com.pope.contract.service.system.PermissionService;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper; 
	@Autowired
	private PermissionExtendMapper permissionExtendMapper;
	@Override
	public int insert(Permission record) {
		return permissionMapper.insert(record);
	}

	@Override
	public int insertSelective(Permission record) {
		return permissionMapper.insertSelective(record);
	}

	@Override
	public List<Permission> selectPermissionByRoles(List<Role> roles) {
		return permissionExtendMapper.selectPermissionByRoles(roles);
	}
	
	 @Override
	 public List<Permission> selectAll(){
		 return permissionExtendMapper.selectAll();
	 }
	 
	 @Override
	 public List<Permission> selectPermissionByRoleAsTree(Role role){
		 return permissionExtendMapper.selectPermissionByRoleAsTree(role);
	 }
	 @Override
	public List<Permission> selectPermissionByRoleId(  String roleId){
		 return permissionExtendMapper.selectPermissionByRoleId(roleId);
	 }
	 @Override
	 public List<Permission> selectChildByUrl( String url,String roleId){
		 return permissionExtendMapper.selectChildByUrl(url,roleId);
	 }
}
