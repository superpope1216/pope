package com.pope.contract.service.user.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.pope.contract.condition.UserInfoCondition;
import com.pope.contract.dao.user.UserInfoMapper;
import com.pope.contract.dto.LoginInfo;
import com.pope.contract.entity.system.Permission;
import com.pope.contract.entity.system.Role;
import com.pope.contract.entity.user.UserInfo;
import com.pope.contract.service.system.PermissionService;
import com.pope.contract.service.system.RoleService;
import com.pope.contract.service.user.UserInfoService;
import com.pope.contract.util.CommonUtil;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;

	@Override
	public int insert(UserInfo record) {
		return userInfoMapper.insert(record);
	}

	@Override
	public int insertSelective(UserInfo record) {
		return userInfoMapper.insertSelective(record);
	}

	@Override
	public UserInfo selectByPrimaryKey(String wid) {
		return userInfoMapper.selectByPrimaryKey(wid);
	}

	@Override
	public UserInfo selectByGh(String gh) {
		return userInfoMapper.selectByGh(gh);
	}

	@Override
	public LoginInfo login(UserInfo userInfo) {
		LoginInfo loginInfo = new LoginInfo();
		BeanUtils.copyProperties(userInfo, loginInfo);
		List<Role> roles = roleService.selectRolesByUserId(userInfo.getWid());
		if (CommonUtil.isNotEmptyList(roles)) {
			for (Role role : roles) {
				List<Permission> permissions = permissionService
						.selectPermissionByRoles(Collections.singletonList(role));
				role.setPermissions(permissions);
			}
		}
		loginInfo.setRoles(roles);
		return loginInfo;
	}

	@Override
	public int updateByPrimaryKeySelective(UserInfo record) {
		return userInfoMapper.updateByPrimaryKeySelective(record);
	}
	@Override
	public int updateByPrimaryKey(UserInfo record){
		return userInfoMapper.updateByPrimaryKey(record);
	}
	
	@Override
	 public List<UserInfo> selectListByCondition(UserInfoCondition condition){
		 return userInfoMapper.selectListByCondition(condition); 
	 }
}
