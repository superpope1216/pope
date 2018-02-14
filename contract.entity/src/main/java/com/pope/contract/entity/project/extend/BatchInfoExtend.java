package com.pope.contract.entity.project.extend;

import java.io.Serializable;

import com.pope.contract.entity.project.BatchInfo;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月13日 下午6:31:05
* 类说明
*/
public class BatchInfoExtend extends BatchInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String pclb_display;
	
	private String hbdw_display;
	
	private String pczt_display;

	private String sydw_display;
	
	private String fxxm_display;
	
	private String queryCondition;
	
	private String fxxmbh;
	
	private String ypsl;
	
	
	public String getYpsl() {
		return ypsl;
	}

	public void setYpsl(String ypsl) {
		this.ypsl = ypsl;
	}

	public String getFxxmbh() {
		return fxxmbh;
	}

	public void setFxxmbh(String fxxmbh) {
		this.fxxmbh = fxxmbh;
	}

	public String getQueryCondition() {
		return queryCondition;
	}

	public void setQueryCondition(String queryCondition) {
		this.queryCondition = queryCondition;
	}

	public String getFxxm_display() {
		return fxxm_display;
	}

	public void setFxxm_display(String fxxm_display) {
		this.fxxm_display = fxxm_display;
	}

	public String getSydw_display() {
		return sydw_display;
	}

	public void setSydw_display(String sydw_display) {
		this.sydw_display = sydw_display;
	}

	public String getPclb_display() {
		return pclb_display;
	}

	public void setPclb_display(String pclb_display) {
		this.pclb_display = pclb_display;
	}


	public String getHbdw_display() {
		return hbdw_display;
	}

	public void setHbdw_display(String hbdw_display) {
		this.hbdw_display = hbdw_display;
	}

	public String getPczt_display() {
		return pczt_display;
	}

	public void setPczt_display(String pczt_display) {
		this.pczt_display = pczt_display;
	}
	

}
