package com.pope.contract.entity.task.extend;

import java.io.Serializable;

import com.pope.contract.entity.task.TaskInfo;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月14日 上午10:26:15
* 类说明
*/
public class TaskInfoExtend extends TaskInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String fxxm_display;
	
	private String rwfpr_display;
	
	private String rwshr_display;
	
	private String rwzt_display;

	public String getFxxm_display() {
		return fxxm_display;
	}

	public void setFxxm_display(String fxxm_display) {
		this.fxxm_display = fxxm_display;
	}

	public String getRwfpr_display() {
		return rwfpr_display;
	}

	public void setRwfpr_display(String rwfpr_display) {
		this.rwfpr_display = rwfpr_display;
	}

	public String getRwshr_display() {
		return rwshr_display;
	}

	public void setRwshr_display(String rwshr_display) {
		this.rwshr_display = rwshr_display;
	}

	public String getRwzt_display() {
		return rwzt_display;
	}

	public void setRwzt_display(String rwzt_display) {
		this.rwzt_display = rwzt_display;
	}
	
	

}
