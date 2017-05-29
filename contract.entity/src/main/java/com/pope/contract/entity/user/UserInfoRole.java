package com.pope.contract.entity.user;

import java.io.Serializable;

public class UserInfoRole implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String wid;

    private String userid;

    private String roleid;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }
}