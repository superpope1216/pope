package com.pope.contract.entity.project.extend;

import java.io.Serializable;

import com.pope.contract.entity.project.BatchInfoDetailFxxm;

public class BatchInfoDetailFxxmExtend extends BatchInfoDetailFxxm implements Serializable{
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