package com.pope.contract.entity.custom.extend;

import java.io.Serializable;

import com.pope.contract.entity.custom.CustomInfo;

public class CustomInfoExtend extends CustomInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String customType_display;
    
    private String queryCondition;

	public String getQueryCondition() {
		return queryCondition;
	}

	public void setQueryCondition(String queryCondition) {
		this.queryCondition = queryCondition;
	}

	public String getCustomType_display() {
		return customType_display;
	}

	public void setCustomType_display(String customType_display) {
		this.customType_display = customType_display;
	}
}