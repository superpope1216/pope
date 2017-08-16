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
