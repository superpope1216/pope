package com.pope.contract.entity.system.extend;

import java.io.Serializable;
import java.math.BigDecimal;

import com.pope.contract.entity.system.FxxmInfo;

public class FxxmExtendInfo extends FxxmInfo implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String fxry_display;

    private String shry_display;
    
    private String zk_display;

	public String getZk_display() {
		return zk_display;
	}

	public void setZk_display(String zk_display) {
		this.zk_display = zk_display;
	}

	public String getFxry_display() {
		return fxry_display;
	}

	public void setFxry_display(String fxry_display) {
		this.fxry_display = fxry_display;
	}

	public String getShry_display() {
		return shry_display;
	}

	public void setShry_display(String shry_display) {
		this.shry_display = shry_display;
	}

}