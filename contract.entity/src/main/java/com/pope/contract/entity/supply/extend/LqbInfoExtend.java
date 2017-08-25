package com.pope.contract.entity.supply.extend;

import java.io.Serializable;

import com.pope.contract.entity.supply.LqbInfo;

public class LqbInfoExtend extends LqbInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rwzt_display;

	private String hcfl_display;

	private String hcfl;
	 private String xhppch;

	public String getXhppch() {
		return xhppch;
	}

	public void setXhppch(String xhppch) {
		this.xhppch = xhppch;
	}

	private String pm;
	
	private String userid_display;

	public String getUserid_display() {
		return userid_display;
	}

	public void setUserid_display(String userid_display) {
		this.userid_display = userid_display;
	}

	public String getRwzt_display() {
		return rwzt_display;
	}

	public void setRwzt_display(String rwzt_display) {
		this.rwzt_display = rwzt_display;
	}

	public String getHcfl_display() {
		return hcfl_display;
	}

	public void setHcfl_display(String hcfl_display) {
		this.hcfl_display = hcfl_display;
	}

	public String getHcfl() {
		return hcfl;
	}

	public void setHcfl(String hcfl) {
		this.hcfl = hcfl;
	}

	public String getPm() {
		return pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}
}