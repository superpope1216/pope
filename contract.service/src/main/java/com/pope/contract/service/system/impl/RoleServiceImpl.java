package com.pope.contract.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pope.contract.code.DataStatus;
import com.pope.contract.dao.system.RoleMapper;
import com.pope.contract.entity.system.Role;
import com.pope.contract.service.system.RolePermissionService;
import com.pope.contract.service.system.RoleService;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private RolePermissionService rolePermissionService;
	@Override
	public int deleteByPrimaryKey(String wid) {
		return roleMapper.deleteByPrimaryKey(wid);
	}

	@Override
	public int insert(Role record,String userId) throws Exception {
		record.setWid(StringUtil.getUuId());
		record.setStatus(DataStatus.normal.getCode());
		record.setCreateby(userId);
		record.setCreatetime(DateUtil.getCurrentDate());
		record.setUpdateby(userId);
		record.setUpdatetime(DateUtil.getCurrentDate());
		return roleMapper.insert(record);
	}

	@Override
	public int insertSelective(Role record,String userId) throws Exception {
		record.setWid(StringUtil.getUuId());
		record.setStatus(DataStatus.normal.getCode());
		record.setCreateby(userId);
		record.setCreatetime(DateUtil.getCurrentDate());
		record.setUpdateby(userId);
		record.setUpdatetime(DateUtil.getCurrentDate());
		return roleMapper.insertSelective(record);
	}

	@Override
	public Role selectByPrimaryKey(String wid) {
		return roleMapper.selectByPrimaryKey(wid);
	}

	@Override
	public int updateByPrimaryKeySelective(Role record,String userId) throws Exception{
		record.setUpdateby(userId);
		record.setUpdatetime(DateUtil.getCurrentDate());
		return roleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Role record,String userId) throws Exception {
		record.setUpdateby(userId);
		record.setUpdatetime(DateUtil.getCurrentDate());
		return roleMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Role> selectRolesByUserId(String userId) {
		return roleMapper.selectRolesByUserId(userId);
	}
	
	@Transactional
	@Override
	public int deleteByRoleId(Role role,String userId) throws Exception{
		role.setStatus(DataStatus.delete.getCode());
		role.setUpdatetime(DateUtil.getCurrentDate());
		role.setUpdateby(userId); 
		rolePermissionService.deleteByRoleId(role.getWid());
		
		return roleMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public List<Role> selectAll(){
		return roleMapper.selectAll();
	}
}
