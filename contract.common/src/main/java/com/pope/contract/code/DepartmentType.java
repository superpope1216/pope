package com.pope.contract.code;
/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年6月2日 上午11:26:37
* 类说明 部门类型
*/
public enum DepartmentType {

	 ROOT(0,"学校"),
	 DEPART(1,"部门"),
	 TEAM(2,"小组");
	 private int code;
    private String msg;

    DepartmentType(int code, String msg) {
        this.code = code;
        this.msg = msg;
    } 
	

    public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
