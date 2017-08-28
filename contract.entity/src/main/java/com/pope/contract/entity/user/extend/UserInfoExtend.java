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
	
	private String jobcategory_display;
	
	private String role;
	
	private String queryCondition;

	public String getQueryCondition() {
		return queryCondition;
	}

	public void setQueryCondition(String queryCondition) {
		this.queryCondition = queryCondition;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getJobcategory_display() {
		return jobcategory_display;
	}

	public void setJobcategory_display(String jobcategory_display) {
		this.jobcategory_display = jobcategory_display;
	}

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
