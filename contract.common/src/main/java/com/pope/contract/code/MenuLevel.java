package com.pope.contract.code;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年5月28日 下午12:13:01
* 类说明:菜单层次
*/
public enum MenuLevel {

	 First(1,"根节点"),
	 SECOND(2,"一级菜单"),
	 THREE(3,"二次菜单"),
	 FOUR(4,"功能按钮");
	 private int code;
    private String msg;

	MenuLevel(int code, String msg) {
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
