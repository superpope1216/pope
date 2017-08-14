package com.pope.contract.entity.task.extend;

import com.pope.contract.entity.task.TaskInfoDetail;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月14日 上午10:26:25
* 类说明
*/
public class TaskInfoDetailExtend extends TaskInfoDetail {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String fxxm_display;
	
	private String rwzt_display;

	public String getRwzt_display() {
		return rwzt_display;
	}

	public void setRwzt_display(String rwzt_display) {
		this.rwzt_display = rwzt_display;
	}

	public String getFxxm_display() {
		return fxxm_display;
	}

	public void setFxxm_display(String fxxm_display) {
		this.fxxm_display = fxxm_display;
	}
}
