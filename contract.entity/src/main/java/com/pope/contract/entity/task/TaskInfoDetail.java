package com.pope.contract.entity.task;

import java.io.Serializable;

public class TaskInfoDetail implements Serializable {
	 /**
		 * 
		 */
	 private static final long serialVersionUID = 1L;
	private String wid;

    private String rwlx;

    private String ypbh;

    private String frwbh;

    private String rwbh;

    private String ypph;

    private String ypyybh;

    private String ypxz;

    private String ypewm;

    private String fxxm;

    private String pcwid;

    private Integer dqbh;

    private String rwfpr;

    private String jssj;

    private Integer rwzt;

    private String datastatus;

    private String frwid;

    private String pcxqid;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    public String getRwlx() {
        return rwlx;
    }

    public void setRwlx(String rwlx) {
        this.rwlx = rwlx == null ? null : rwlx.trim();
    }

    public String getYpbh() {
        return ypbh;
    }

    public void setYpbh(String ypbh) {
        this.ypbh = ypbh == null ? null : ypbh.trim();
    }

    public String getFrwbh() {
        return frwbh;
    }

    public void setFrwbh(String frwbh) {
        this.frwbh = frwbh == null ? null : frwbh.trim();
    }

    public String getRwbh() {
        return rwbh;
    }

    public void setRwbh(String rwbh) {
        this.rwbh = rwbh == null ? null : rwbh.trim();
    }

    public String getYpph() {
        return ypph;
    }

    public void setYpph(String ypph) {
        this.ypph = ypph == null ? null : ypph.trim();
    }

    public String getYpyybh() {
        return ypyybh;
    }

    public void setYpyybh(String ypyybh) {
        this.ypyybh = ypyybh == null ? null : ypyybh.trim();
    }

    public String getYpxz() {
        return ypxz;
    }

    public void setYpxz(String ypxz) {
        this.ypxz = ypxz == null ? null : ypxz.trim();
    }

    public String getYpewm() {
        return ypewm;
    }

    public void setYpewm(String ypewm) {
        this.ypewm = ypewm == null ? null : ypewm.trim();
    }

    public String getFxxm() {
        return fxxm;
    }

    public void setFxxm(String fxxm) {
        this.fxxm = fxxm == null ? null : fxxm.trim();
    }

    public String getPcwid() {
        return pcwid;
    }

    public void setPcwid(String pcwid) {
        this.pcwid = pcwid == null ? null : pcwid.trim();
    }

    public Integer getDqbh() {
        return dqbh;
    }

    public void setDqbh(Integer dqbh) {
        this.dqbh = dqbh;
    }

    public String getRwfpr() {
        return rwfpr;
    }

    public void setRwfpr(String rwfpr) {
        this.rwfpr = rwfpr == null ? null : rwfpr.trim();
    }

    public String getJssj() {
        return jssj;
    }

    public void setJssj(String jssj) {
        this.jssj = jssj == null ? null : jssj.trim();
    }

    public Integer getRwzt() {
        return rwzt;
    }

    public void setRwzt(Integer rwzt) {
        this.rwzt = rwzt;
    }

    public String getDatastatus() {
        return datastatus;
    }

    public void setDatastatus(String datastatus) {
        this.datastatus = datastatus == null ? null : datastatus.trim();
    }

    public String getFrwid() {
        return frwid;
    }

    public void setFrwid(String frwid) {
        this.frwid = frwid == null ? null : frwid.trim();
    }

    public String getPcxqid() {
        return pcxqid;
    }

    public void setPcxqid(String pcxqid) {
        this.pcxqid = pcxqid == null ? null : pcxqid.trim();
    }
}