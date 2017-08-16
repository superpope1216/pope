package com.pope.contract.code;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年8月13日 下午9:35:07 类说明
 */
public enum TaskStatusEnum {
	QCL(1, "前处理"), JC(2, "检测"), SJCL(3, "数据处理"), SJBG(4, "数据报告"), SH(100, "待审核"),
	SHJXZ(101,"审核进行中"),
	SHTG(102,"已结束"),
	SHBTG(-99,"不通过");;
	private int code;
	private String msg;

	TaskStatusEnum(int code, String msg) {
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
