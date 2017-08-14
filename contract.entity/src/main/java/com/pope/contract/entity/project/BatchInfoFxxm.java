package com.pope.contract.entity.project;

import java.io.Serializable;

public class BatchInfoFxxm implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String wid;

    private String fxxmbh;

    private String pwid;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    public String getFxxmbh() {
        return fxxmbh;
    }

    public void setFxxmbh(String fxxmbh) {
        this.fxxmbh = fxxmbh == null ? null : fxxmbh.trim();
    }

    public String getPwid() {
        return pwid;
    }

    public void setPwid(String pwid) {
        this.pwid = pwid == null ? null : pwid.trim();
    }
}