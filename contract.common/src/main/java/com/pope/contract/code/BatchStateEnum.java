package com.pope.contract.code;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年8月14日 下午4:05:29 类说明
 */
public enum BatchStateEnum {

	XJ(1, "新建"), DC(2, "待测"), JCZ(3, "检测中"), YGD(4, "已归档");
	private int code;
	private String msg;

	BatchStateEnum(int code, String msg) {
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
