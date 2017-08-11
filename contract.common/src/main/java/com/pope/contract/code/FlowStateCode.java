package com.pope.contract.code;
/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年7月15日 下午12:21:00
* 类说明 当前流程状态
*/
public enum FlowStateCode {

	CG("01", "草稿"),
	DSH("02","待审核"),
	JXZ("03","进行中"),
	YJS("04","已结束"),
	BTG("-99","不通过");
	
    private String code;
    private String msg;

    FlowStateCode(String code, String msg) {
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
