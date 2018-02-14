package com.pope.contract.service.system.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pope.contract.dao.system.PermissionMapper;
import com.pope.contract.dao.system.extend.PermissionExtendMapper;
import com.pope.contract.entity.system.Permission;
import com.pope.contract.entity.system.Role;
import com.pope.contract.service.system.PermissionService;
import com.pope.contract.util.CommonUtil;

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
	public Permission selectByPrimaryKey(String wid) {
		return permissionMapper.selectByPrimaryKey(wid);
	}
	@Override
	public int insertSelective(Permission record) {
		return permissionMapper.insertSelective(record);
	}

	@Override
	public List<Permission> selectPermissionByRoles(List<Role> roles,String level,String pid) {
		return permissionExtendMapper.selectPermissionByRoles(roles,level,pid);
	}
	
	 public int updateByPrimaryKeySelective(Permission record){
		 return permissionMapper.updateByPrimaryKeySelective(record);
	 }
	 @Override
	 public List<Permission> selectAll() {
		 List<Permission> persAll=new ArrayList<Permission>();
		 getTreeChild("-1",persAll);
		 return persAll;
		 //return permissionExtendMapper.selectAll();
	 }
	 
	 private void getTreeChild(String pid,List<Permission> persAll){
		 List<Permission> permissionList= permissionExtendMapper.selectPermissionByPid(pid);
		 
		 if(CommonUtil.isNotEmptyList(permissionList)){
			 for(Permission one:permissionList){
				 if(one.getLevel()!=4){
					getTreeChild(one.getWid(),persAll);
				 }
				 persAll.add(one);
			 }
			 
		 }
		 
	 }
	 
	 
	 @Override
	 public List<Permission> selectPermissionByRoleAsTree(Role role){
		 return permissionExtendMapper.selectPermissionByRoleAsTree(role);
	 }
	 @Override
	public List<Permission> selectPermissionByRoleId( String roleId){
		 return permissionExtendMapper.selectPermissionByRoleId(roleId);
	 }
	 @Override
	 public List<Permission> selectChildByUrl( String url,String roleId){
		 return permissionExtendMapper.selectChildByUrl(url,roleId);
	 }
	 @Transactional
	 public void updateMenuSort(List<String> wids) throws Exception{
		 if(CommonUtil.isNotEmptyList(wids)){
			 for(int i=0;i<wids.size();i++){
				 String wid=wids.get(i).split(",")[0];
				 String pid=wids.get(i).split(",")[1];
				 Permission permission=new Permission();
				 permission.setWid(wid);
				 permission.setPid(pid);
				 permission.setOrderby((i+1));
				 permissionMapper.updateByPrimaryKeySelective(permission);
			 }
		 }
	 }
}
