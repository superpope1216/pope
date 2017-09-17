package com.pope.contract.entity.pxgl.extend;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.pope.contract.entity.pxgl.PxglInfo;

public class PxglInfoExtend extends PxglInfo implements Serializable{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName;
	
	private String gh;
	
	private String pxlx_display;
	
	private String rwzt_display;
	
	public String getRwzt_display() {
		return rwzt_display;
	}

	public void setRwzt_display(String rwzt_display) {
		this.rwzt_display = rwzt_display;
	}

	private List<String> rwztList;

	public List<String> getRwztList() {
		return rwztList;
	}

	public void setRwztList(List<String> rwztList) {
		this.rwztList = rwztList;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGh() {
		return gh;
	}

	public void setGh(String gh) {
		this.gh = gh;
	}

	public String getPxlx_display() {
		return pxlx_display;
	}

	public void setPxlx_display(String pxlx_display) {
		this.pxlx_display = pxlx_display;
	}
	
}