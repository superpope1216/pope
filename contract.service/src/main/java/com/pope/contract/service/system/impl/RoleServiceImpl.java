package com.pope.contract.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.contract.dao.system.RoleMapper;
import com.pope.contract.entity.system.Role;
import com.pope.contract.service.system.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	@Override
	public int deleteByPrimaryKey(String wid) {
		return roleMapper.deleteByPrimaryKey(wid);
	}

	@Override
	public int insert(Role record) {
		return roleMapper.insert(record);
	}

	@Override
	public int insertSelective(Role record) {
		return roleMapper.insertSelective(record);
	}

	@Override
	public Role selectByPrimaryKey(String wid) {
		return roleMapper.selectByPrimaryKey(wid);
	}

	@Override
	public int updateByPrimaryKeySelective(Role record) {
		return roleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Role record) {
		return roleMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Role> selectRolesByUserId(String userId) {
		return roleMapper.selectRolesByUserId(userId);
	}

}
