package com.pope.contract.entity.project.extend;

import java.io.Serializable;

import com.pope.contract.entity.project.BatchInfoDetail;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月13日 下午6:18:24
* 类说明
*/
public class BatchInfoDetailExtend extends BatchInfoDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String fxxm_display;

	public String getFxxm_display() {
		return fxxm_display;
	}

	public void setFxxm_display(String fxxm_display) {
		this.fxxm_display = fxxm_display;
	}
}
