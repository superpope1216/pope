package com.pope.contract.condition;

import java.io.Serializable;
import java.util.Date;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年5月28日 下午4:45:57
* 类说明
*/
public class UserInfoCondition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
    
	private String gh;

    private String phone;

    private String email;

    private String birthday;

    private String department;

    private String team;

    private String degree;

    private String jobcategory;

    private String job;

    private String contractvalidity;

    private String contracttime;

    private Integer status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGh() {
		return gh;
	}

	public void setGh(String gh) {
		this.gh = gh;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getJobcategory() {
		return jobcategory;
	}

	public void setJobcategory(String jobcategory) {
		this.jobcategory = jobcategory;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getContractvalidity() {
		return contractvalidity;
	}

	public void setContractvalidity(String contractvalidity) {
		this.contractvalidity = contractvalidity;
	}

	public String getContracttime() {
		return contracttime;
	}

	public void setContracttime(String contracttime) {
		this.contracttime = contracttime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

    
}
