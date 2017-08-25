package com.pope.contract.entity.contract.extend;

import java.io.Serializable;
import java.math.BigDecimal;

import com.pope.contract.entity.contract.ContractMoney;

public class ContractMoneyExtend extends ContractMoney implements Serializable{
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