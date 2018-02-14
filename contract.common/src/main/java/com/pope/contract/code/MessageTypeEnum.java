package com.pope.contract.code;
/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年9月25日 下午9:14:49
* 类说明
*/
public enum MessageTypeEnum {

	 ALL(1,"全部"),
	 DEPART(2,"部门"),
	 TEAM(3,"小组"),
	 PERSON(4,"个人");
	 private int code;
    private String msg;

    MessageTypeEnum(int code, String msg) {
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
