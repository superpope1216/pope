package com.pope.contract.service.user.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pope.contract.code.DataStatus;
import com.pope.contract.condition.UserInfoCondition;
import com.pope.contract.dao.user.UserInfoMapper;
import com.pope.contract.dao.user.UserInfoRoleMapper;
import com.pope.contract.dto.LoginInfo;
import com.pope.contract.entity.system.Permission;
import com.pope.contract.entity.system.Role;
import com.pope.contract.entity.user.UserInfo;
import com.pope.contract.entity.user.UserInfoRole;
import com.pope.contract.service.system.PermissionService;
import com.pope.contract.service.system.RoleService;
import com.pope.contract.service.user.UserInfoService;
import com.pope.contract.util.CommonUtil;
import com.pope.contract.util.ConstantUtil;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserInfoRoleMapper userInfoRoleMapper;
	@Autowired
	private PermissionService permissionService;

	@Override
	@Transactional
	public int insert(UserInfo userInfo,String userId,String userInfoRoles) throws Exception {
		userInfo.setWid(StringUtil.getUuId());
		userInfo.setUpdatetime(DateUtil.getCurrentDate());
		userInfo.setCreateby(userId);
		userInfo.setCreatetime(DateUtil.getCurrentDate());
		userInfo.setUpdateby(userId);
		userInfo.setStatus(DataStatus.normal.getCode());
		userInfo.setPassword(StringUtil.createPassword(ConstantUtil.DEFAULT_PASSWORD, ""));
		int insertCount=userInfoMapper.insert(userInfo);
		userInfoRoleMapper.deleteByUserId(userId);
		List<UserInfoRole> listUserInfoRoles=new ArrayList<UserInfoRole>();
		if(StringUtils.isNotEmpty(userInfoRoles)){
			String[] roles=userInfoRoles.split(",");
			for(int i=0;i<roles.length;i++){
				UserInfoRole userInfoRole=new UserInfoRole();
				userInfoRole.setWid(StringUtil.getUuId());
				userInfoRole.setUserid(userId);
				userInfoRole.setRoleid(roles[i]);
				listUserInfoRoles.add(userInfoRole);
			}
		}
		
		if(CommonUtil.isNotEmptyList(listUserInfoRoles)){
			userInfoRoleMapper.insertUserRole(listUserInfoRoles);
		}
		
		return insertCount;
	}

	@Override
	public int insertSelective(UserInfo userInfo,String userId) throws Exception{
		userInfo.setWid(StringUtil.getUuId());
		userInfo.setUpdatetime(DateUtil.getCurrentDate());
		userInfo.setCreateby(userId);
		userInfo.setCreatetime(DateUtil.getCurrentDate());
		userInfo.setUpdateby(userId);
		userInfo.setStatus(DataStatus.normal.getCode());
		userInfo.setPassword(StringUtil.createPassword(ConstantUtil.DEFAULT_PASSWORD, ""));
		return userInfoMapper.insertSelective(userInfo);
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
	public int updateByPrimaryKeySelective(UserInfo userInfo,String userId,String userInfoRoles) throws Exception{
		userInfo.setUpdatetime(DateUtil.getCurrentDate());
		userInfo.setUpdateby(userId);
		userInfo.setStatus(DataStatus.normal.getCode());
		userInfoRoleMapper.deleteByUserId(userId);
		List<UserInfoRole> listUserInfoRoles=new ArrayList<UserInfoRole>();
		if(StringUtils.isNotEmpty(userInfoRoles)){
			String[] roles=userInfoRoles.split(",");
			for(int i=0;i<roles.length;i++){
				UserInfoRole userInfoRole=new UserInfoRole();
				userInfoRole.setWid(StringUtil.getUuId());
				userInfoRole.setUserid(userId);
				userInfoRole.setRoleid(roles[i]);
				listUserInfoRoles.add(userInfoRole);
			}
		}
		
		if(CommonUtil.isNotEmptyList(listUserInfoRoles)){
			userInfoRoleMapper.insertUserRole(listUserInfoRoles);
		}
		return userInfoMapper.updateByPrimaryKeySelective(userInfo);
	}
	@Override
	public int updateByPrimaryKey(UserInfo userInfo,String userId) throws Exception{
		userInfo.setUpdatetime(DateUtil.getCurrentDate());
		userInfo.setUpdateby(userId);
		userInfo.setStatus(DataStatus.normal.getCode());
		return userInfoMapper.updateByPrimaryKey(userInfo);
	}
	
	@Override
	 public List<UserInfo> selectListByCondition(UserInfoCondition condition){
		 return userInfoMapper.selectListByCondition(condition); 
	 }
	@Transactional
	public int deleteByPrimaryKey(String wid) throws Exception{
		userInfoRoleMapper.deleteByUserId(wid);
		return userInfoMapper.deleteByPrimaryKey(wid);
	}
}
