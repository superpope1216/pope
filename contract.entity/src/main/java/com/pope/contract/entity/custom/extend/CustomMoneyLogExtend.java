package com.pope.contract.entity.custom.extend;

import java.io.Serializable;
import java.math.BigDecimal;

import com.pope.contract.entity.custom.CustomMoneyLog;

public class CustomMoneyLogExtend extends CustomMoneyLog implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String htbh;
	
	private String htmc;
	
	private String htsj;
	
	private String htlx_display;

	public String getHtlx_display() {
		return htlx_display;
	}

	public void setHtlx_display(String htlx_display) {
		this.htlx_display = htlx_display;
	}

	public String getHtbh() {
		return htbh;
	}

	public void setHtbh(String htbh) {
		this.htbh = htbh;
	}

	public String getHtmc() {
		return htmc;
	}

	public void setHtmc(String htmc) {
		this.htmc = htmc;
	}

	public String getHtsj() {
		return htsj;
	}

	public void setHtsj(String htsj) {
		this.htsj = htsj;
	}

	

}