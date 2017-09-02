package com.pope.contract.code;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年8月26日 上午10:32:20 类说明
 */
public enum DataOperatorEnum {

	ADD(1, "新增"), MODIFY(2, "修改"), DELETE(3, "删除");
	private int code;
	private String msg;

	DataOperatorEnum(int code, String msg) {
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
