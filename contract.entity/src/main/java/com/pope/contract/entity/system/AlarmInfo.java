package com.pope.contract.entity.system;

import java.io.Serializable;

public class AlarmInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String wid;

    private String permissionId;

    private String customAccount;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }

    public String getCustomAccount() {
        return customAccount;
    }

    public void setCustomAccount(String customAccount) {
        this.customAccount = customAccount == null ? null : customAccount.trim();
    }
}