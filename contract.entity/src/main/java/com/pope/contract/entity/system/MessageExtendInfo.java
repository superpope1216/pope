package com.pope.contract.entity.system;

import java.io.Serializable;

public class MessageExtendInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String wid;

    private String bm;

    private String me;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm == null ? null : bm.trim();
    }

    public String getMe() {
        return me;
    }

    public void setMe(String me) {
        this.me = me == null ? null : me.trim();
    }
}