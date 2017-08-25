package com.pope.contract.entity.supply;

import java.io.Serializable;

public class LqbInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String wid;

    private Integer lysl;

    private Integer ghsl;

    private String userid;

    private String sqsj;

    private String rwzt;

    private Integer curentstep;

    private String bz;

    private String hcid;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    public Integer getLysl() {
        return lysl;
    }

    public void setLysl(Integer lysl) {
        this.lysl = lysl;
    }

    public Integer getGhsl() {
        return ghsl;
    }

    public void setGhsl(Integer ghsl) {
        this.ghsl = ghsl;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getSqsj() {
        return sqsj;
    }

    public void setSqsj(String sqsj) {
        this.sqsj = sqsj == null ? null : sqsj.trim();
    }

    public String getRwzt() {
        return rwzt;
    }

    public void setRwzt(String rwzt) {
        this.rwzt = rwzt == null ? null : rwzt.trim();
    }

    public Integer getCurentstep() {
        return curentstep;
    }

    public void setCurentstep(Integer curentstep) {
        this.curentstep = curentstep;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public String getHcid() {
        return hcid;
    }

    public void setHcid(String hcid) {
        this.hcid = hcid == null ? null : hcid.trim();
    }
}