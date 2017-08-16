package com.pope.contract.code;
/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月14日 下午8:02:50
* 类说明
*/
public enum TaskSonStatusEnum {
	QCL(1, "前处理"), JC(2, "检测"), SJCL(3, "数据处理"), SJBG(4, "完成");
	private int code;
	private String msg;

	TaskSonStatusEnum(int code, String msg) {
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
