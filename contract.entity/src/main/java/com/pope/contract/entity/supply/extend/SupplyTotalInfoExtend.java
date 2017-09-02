package com.pope.contract.entity.supply.extend;

import java.io.Serializable;
import java.math.BigDecimal;

import com.pope.contract.entity.supply.SupplyInfo;
import com.pope.contract.entity.supply.SupplyTotalInfo;

public class SupplyTotalInfoExtend extends SupplyTotalInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 private String hcfl_display;
	 
	 private String sldw_display;
	 
	 private String hbdw_display;
	 
	 private String queryCondition;

	public String getQueryCondition() {
		return queryCondition;
	}

	public void setQueryCondition(String queryCondition) {
		this.queryCondition = queryCondition;
	}

	public String getHcfl_display() {
		return hcfl_display;
	}

	public void setHcfl_display(String hcfl_display) {
		this.hcfl_display = hcfl_display;
	}

	public String getSldw_display() {
		return sldw_display;
	}

	public void setSldw_display(String sldw_display) {
		this.sldw_display = sldw_display;
	}

	public String getHbdw_display() {
		return hbdw_display;
	}

	public void setHbdw_display(String hbdw_display) {
		this.hbdw_display = hbdw_display;
	}
}