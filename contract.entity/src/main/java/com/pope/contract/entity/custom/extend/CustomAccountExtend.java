package com.pope.contract.entity.custom.extend;

import java.io.Serializable;
import java.math.BigDecimal;

import com.pope.contract.entity.custom.CustomAccount;

public class CustomAccountExtend extends CustomAccount implements Serializable {
  

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String customName;

    private String customNumber;
    
    private String queryCondition;

	public String getQueryCondition() {
		return queryCondition;
	}

	public void setQueryCondition(String queryCondition) {
		this.queryCondition = queryCondition;
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public String getCustomNumber() {
		return customNumber;
	}

	public void setCustomNumber(String customNumber) {
		this.customNumber = customNumber;
	}
}