package com.pope.contract.entity.contract.extend;

import java.io.Serializable;

import com.pope.contract.entity.contract.ContractInfo;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月22日 下午5:16:17
* 类说明
*/
public class ContractInfoExtend extends ContractInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String htlx_display;
	
	private String htzk_display;
	
	private String htzt_display;
	
	private String querySyr;
	
	private String queryHth;
	
	private String queryYppch;
	
	private String queryFxxh;
	
	public String getQuerySyr() {
		return querySyr;
	}

	public void setQuerySyr(String querySyr) {
		this.querySyr = querySyr;
	}

	public String getQueryHth() {
		return queryHth;
	}

	public void setQueryHth(String queryHth) {
		this.queryHth = queryHth;
	}

	public String getQueryYppch() {
		return queryYppch;
	}

	public void setQueryYppch(String queryYppch) {
		this.queryYppch = queryYppch;
	}

	public String getQueryFxxh() {
		return queryFxxh;
	}

	public void setQueryFxxh(String queryFxxh) {
		this.queryFxxh = queryFxxh;
	}

	public String getHtzt_display() {
		return htzt_display;
	}

	public void setHtzt_display(String htzt_display) {
		this.htzt_display = htzt_display;
	}

	private String htjf_display;
	
	
	
	public String getHtjf_display() {
		return htjf_display;
	}

	public void setHtjf_display(String htjf_display) {
		this.htjf_display = htjf_display;
	}

	private String rwzt_display;

	public String getHtlx_display() {
		return htlx_display;
	}

	public void setHtlx_display(String htlx_display) {
		this.htlx_display = htlx_display;
	}

	public String getHtzk_display() {
		return htzk_display;
	}

	public void setHtzk_display(String htzk_display) {
		this.htzk_display = htzk_display;
	}

	public String getRwzt_display() {
		return rwzt_display;
	}

	public void setRwzt_display(String rwzt_display) {
		this.rwzt_display = rwzt_display;
	}

}
