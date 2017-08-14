package com.pope.contract.entity.user.extend;

import java.io.Serializable;

import com.pope.contract.entity.user.UserInfo;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月14日 下午1:29:37
* 类说明
*/
public class UserInfoExtend extends UserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String department_display;
	
	private String team_display;

	public String getDepartment_display() {
		return department_display;
	}

	public void setDepartment_display(String department_display) {
		this.department_display = department_display;
	}

	public String getTeam_display() {
		return team_display;
	}

	public void setTeam_display(String team_display) {
		this.team_display = team_display;
	}
	
	

}
