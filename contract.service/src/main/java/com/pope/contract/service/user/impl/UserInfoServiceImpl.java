package com.pope.contract.service.user.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.entity.StringEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pope.contract.code.DataStatus;
import com.pope.contract.code.MenuLevel;
import com.pope.contract.condition.UserInfoCondition;
import com.pope.contract.dao.user.UserInfoMapper;
import com.pope.contract.dao.user.UserInfoRoleMapper;
import com.pope.contract.dao.user.extend.UserInfoExtendMapper;
import com.pope.contract.dto.LoginInfo;
import com.pope.contract.entity.system.Permission;
import com.pope.contract.entity.system.Role;
import com.pope.contract.entity.user.UserInfo;
import com.pope.contract.entity.user.UserInfoRole;
import com.pope.contract.entity.user.extend.UserInfoExtend;
import com.pope.contract.exception.ServiceException;
import com.pope.contract.service.system.PermissionService;
import com.pope.contract.service.system.RoleService;
import com.pope.contract.service.user.UserInfoService;
import com.pope.contract.util.CommonUtil;
import com.pope.contract.util.ConstantUtil;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringEncrypt;
import com.pope.contract.util.StringUtil;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private UserInfoExtendMapper userInfoExtendMapper; 

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserInfoRoleMapper userInfoRoleMapper;
	
	@Autowired
	private com.pope.contract.dao.user.extend.UserInfoRoleExtendMapper UserInfoRoleExtendMapper;
	@Autowired
	private PermissionService permissionService;

	@Override
	@Transactional
	public int insert(UserInfo userInfo, String userId, String userInfoRoles) throws Exception {
		UserInfoExtend queryUserInfoExtend=new UserInfoExtend();
		queryUserInfoExtend.setGh(userInfo.getGh());
		UserInfo oldUserInfo=userInfoExtendMapper.selectSingleByCondition(queryUserInfoExtend);
		if(oldUserInfo!=null){
			throw new ServiceException("该工号已存在，请重新确认！");
		}
		String wid=StringUtil.getUuId();
		userInfo.setWid(wid);
		userInfo.setUpdatetime(DateUtil.getCurrentDate());
		userInfo.setCreateby(userId);
		userInfo.setCreatetime(DateUtil.getCurrentDate());
		userInfo.setUpdateby(userId);
		userInfo.setDatastatus(DataStatus.normal.getCode());
		userInfo.setPassword(StringEncrypt.encrypt(ConstantUtil.DEFAULT_PASSWORD));
		int insertCount = userInfoMapper.insert(userInfo);
		//userInfoRoleMapper.deleteByUserId(userId);
		List<UserInfoRole> listUserInfoRoles = new ArrayList<UserInfoRole>();
		if (StringUtils.isNotEmpty(userInfoRoles)) {
			String[] roles = userInfoRoles.split(",");
			for (int i = 0; i < roles.length; i++) {
				UserInfoRole userInfoRole = new UserInfoRole();
				userInfoRole.setWid(StringUtil.getUuId());
				userInfoRole.setUserid(wid);
				userInfoRole.setRoleid(roles[i]);
				listUserInfoRoles.add(userInfoRole);
			}
		}

		if (CommonUtil.isNotEmptyList(listUserInfoRoles)) {
			userInfoRoleMapper.insertUserRole(listUserInfoRoles);
		}

		return insertCount;
	}

	@Override
	public UserInfo selectByPrimaryKey(String wid) {
		return userInfoMapper.selectByPrimaryKey(wid);
	}

	@Override
	public LoginInfo login(UserInfo userInfo) {
		LoginInfo loginInfo = new LoginInfo();
		BeanUtils.copyProperties(userInfo, loginInfo);
		loginInfo.setName(userInfo.getName1());
		List<Role> roles = roleService.selectRolesByUserId(userInfo.getWid());
		if (CommonUtil.isNotEmptyList(roles)) {
			for (Role role : roles) {
				List<Permission> permissions = permissionService.selectPermissionByRoles(Collections.singletonList(role),StringUtil.toStr(MenuLevel.SECOND.getCode()),"");
				List<Permission> newPermission = new ArrayList<Permission>();
				if (CommonUtil.isNotEmptyList(permissions)) {
					for (Permission per : permissions) {
						newPermission.add(per);
						List<Permission> threePermission = permissionService.selectPermissionByRoles(Collections.singletonList(role),StringUtil.toStr(MenuLevel.THREE.getCode()),per.getWid());
						per.setList(threePermission);
						if(CommonUtil.isNotEmptyList(threePermission)){
							for(Permission threeP:threePermission){
								List<Permission> fourPermission = permissionService.selectPermissionByRoles(Collections.singletonList(role),StringUtil.toStr(MenuLevel.FOUR.getCode()),threeP.getWid());
								threeP.setList(fourPermission);
							}
						}
					}
				}
				role.setPermissions(newPermission);
			}
		}
		loginInfo.setRoles(roles);
		return loginInfo;
	}

	@Override
	public int updateByPrimaryKeySelective(UserInfo userInfo, String userId, String userInfoRoles) throws Exception {
		
		UserInfoExtend queryUserInfoExtend=new UserInfoExtend();
		queryUserInfoExtend.setGh(userInfo.getGh());
		UserInfo oldUserInfo=userInfoExtendMapper.selectSingleByCondition(queryUserInfoExtend);
		if(oldUserInfo!=null && !oldUserInfo.getGh().equals(userInfo.getGh())){
			throw new ServiceException("该工号已存在，请重新确认！");
		} 
		userInfo.setUpdatetime(DateUtil.getCurrentDate());
		userInfo.setUpdateby(userId);
		userInfo.setDatastatus(DataStatus.normal.getCode());
		userInfoRoleMapper.deleteByUserId(userInfo.getWid());
		List<UserInfoRole> listUserInfoRoles = new ArrayList<UserInfoRole>();
		if (StringUtils.isNotEmpty(userInfoRoles)) {
			String[] roles = userInfoRoles.split(",");
			for (int i = 0; i < roles.length; i++) {
				UserInfoRole userInfoRole = new UserInfoRole();
				userInfoRole.setWid(StringUtil.getUuId());
				userInfoRole.setUserid(userInfo.getWid());
				userInfoRole.setRoleid(roles[i]);
				listUserInfoRoles.add(userInfoRole);
			}
		}

		if (CommonUtil.isNotEmptyList(listUserInfoRoles)) {
			userInfoRoleMapper.insertUserRole(listUserInfoRoles);
		}
		return userInfoMapper.updateByPrimaryKeySelective(userInfo);
	}


	@Transactional
	public int deleteByPrimaryKey(String wid) throws Exception {
		userInfoRoleMapper.deleteByUserId(wid);
		return userInfoMapper.deleteByPrimaryKey(wid);
	}

	@Override
	public List<UserInfoExtend> selectDisplayByCondition(UserInfoExtend userInfo) throws Exception {
		return userInfoExtendMapper.selectDisplayByCondition(userInfo);
	}
	@Override
	public List<UserInfo> selectByRoleName(String name){
		return userInfoExtendMapper.selectByRoleName(name);
	}

	@Override
	public int updateByPrimaryKeySelective(UserInfo record) throws Exception {
		return userInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<UserInfoRole> selectUserInfoRole(UserInfoRole userInfoRole) throws Exception {
		return UserInfoRoleExtendMapper.selectByCondition(userInfoRole);
	}

	@Override
	public UserInfoExtend selectSingleDisplayByCondition(UserInfoExtend user) throws Exception {
		return userInfoExtendMapper.selectSingleDisplayByCondition(user);
	}

	@Override
	public List<UserInfo> selectByCondition(UserInfoExtend user) throws Exception {
		return userInfoExtendMapper.selectByCondition(user);
	}

	@Override
	public UserInfo selectSingleByCondition(UserInfoExtend user) throws Exception {
		return userInfoExtendMapper.selectSingleByCondition(user);
	}
	
	public void savePassword(String userId,String oldPassword,String newPassword) throws Exception{
		
		UserInfo userInfo=this.userInfoMapper.selectByPrimaryKey(userId);
		if(!userInfo.getPassword().equals(StringEncrypt.encrypt(oldPassword))){
			throw new ServiceException("输入的原，密码不正确，请重新确认！");
		}
		UserInfo saveUserInfo=new UserInfo();
		saveUserInfo.setWid(userId);
		saveUserInfo.setPassword(StringEncrypt.encrypt(newPassword));
		this.userInfoMapper.updateByPrimaryKeySelective(saveUserInfo);
	}
}
