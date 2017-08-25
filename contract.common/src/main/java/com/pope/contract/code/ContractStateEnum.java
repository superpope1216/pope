package com.pope.contract.code;
/**合同状态
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月25日 下午10:45:15
* 类说明
*/
public enum ContractStateEnum {
	WFK(1, "未付款"), DSH(2, "待审核"), JXZ(3, "进行中"), SHTG(4, "审核通过"),
	SHBTG(-99,"不通过");;
	private int code;
	private String msg;

	ContractStateEnum(int code, String msg) {
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