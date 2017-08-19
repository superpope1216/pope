package com.pope.contract.code;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年6月25日 下午8:29:09 类说明:流程标志
 */
public enum FlowSetCode {
	LEAVE("01", "请假流程"), TASK("02", "项目任务流程"),SUPPLY("03","耗材审核");
	private String code;
	private String msg;

	FlowSetCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
