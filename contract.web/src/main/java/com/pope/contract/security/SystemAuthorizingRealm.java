package com.pope.contract.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.StringUtil;
import com.pope.contract.entity.system.Permission;
import com.pope.contract.entity.system.Role;
import com.pope.contract.entity.user.UserInfo;
import com.pope.contract.service.system.PermissionService;
import com.pope.contract.service.system.RoleService;
import com.pope.contract.service.user.UserInfoService;
import com.pope.contract.util.CommonUtil;

public class SystemAuthorizingRealm extends AuthorizingRealm {

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PermissionService permissionService;
	private static Logger LOG = LoggerFactory.getLogger(SystemAuthorizingRealm.class);

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		LOG.debug("开始查询授权信息");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		String gh = (String) principalCollection.getPrimaryPrincipal();
		UserInfo userInfo = userInfoService.selectByGh(gh);
		Set<String> permissions = new HashSet<String>();
		Set<String> roles = new HashSet<String>();
		List<Role> lstRoles = roleService.selectRolesByUserId(userInfo.getWid());// 角色
		if (CommonUtil.isNotEmptyList(lstRoles)) {
			for (Role role : lstRoles) {
				roles.add(role.getWid());
			}
		}

		List<Permission> lstPermission =null;
		if(CommonUtil.isNotEmptyList(lstRoles)){
			lstPermission= permissionService.selectPermissionByRoles(lstRoles);
		}
		if (CommonUtil.isNotEmptyList(lstPermission)) {
			for (Permission p : lstPermission) {
				if(StringUtil.isNotEmpty(p.getCode())){
					permissions.add(p.getCode());
				}
			}
		}
		info.addRoles(roles);
		info.addStringPermissions(permissions);
		LOG.debug("角色信息: \n {}", roles.toString());
		LOG.debug("权限信息: \n{}", permissions.toString());
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		 LOG.debug("登录验证");
		 UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken)authenticationToken;
	     String gh = usernamePasswordToken.getUsername();
	     if(StringUtil.isEmpty(gh)){
	    	 throw new AccountException("用户不存在");
	     }
	     UserInfo userInfo = userInfoService.selectByGh(gh);
	     if (userInfo == null) {  
	            throw new UnknownAccountException("用户不存在");  
	     } 
	     AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(gh, userInfo.getPassword(), getName());
		return authenticationInfo;
	}

}
