package com.pope.contract.code;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年8月13日 下午9:35:07 类说明
 */
public enum TaskStatusEnum {
	QCL("01", "前处理"), JC("02", "检测"), SJCL("03", "数据处理"), SJBG("04", "数据报告"), SH("05", "审核");
	private String code;
	private String msg;

	TaskStatusEnum(String code, String msg) {
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
