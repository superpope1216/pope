package com.pope.contract.entity.contract;

import java.io.Serializable;

public class ContractFbsqdInfo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String wid;

    private String yplb;

    private Integer ypsl;

    private String wtbh;

    private String fbbh;

    private String fbxm;

    private String fbsys;

    private String syr;

    private String wtsj;

    private String lyr;

    private String fbsj;

    private String sqr;

    private String syszg;

    private String fbkxxfx;

    private String htid;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    public String getYplb() {
        return yplb;
    }

    public void setYplb(String yplb) {
        this.yplb = yplb == null ? null : yplb.trim();
    }

    public Integer getYpsl() {
        return ypsl;
    }

    public void setYpsl(Integer ypsl) {
        this.ypsl = ypsl;
    }

    public String getWtbh() {
        return wtbh;
    }

    public void setWtbh(String wtbh) {
        this.wtbh = wtbh == null ? null : wtbh.trim();
    }

    public String getFbbh() {
        return fbbh;
    }

    public void setFbbh(String fbbh) {
        this.fbbh = fbbh == null ? null : fbbh.trim();
    }

    public String getFbxm() {
        return fbxm;
    }

    public void setFbxm(String fbxm) {
        this.fbxm = fbxm == null ? null : fbxm.trim();
    }

    public String getFbsys() {
        return fbsys;
    }

    public void setFbsys(String fbsys) {
        this.fbsys = fbsys == null ? null : fbsys.trim();
    }

    public String getSyr() {
        return syr;
    }

    public void setSyr(String syr) {
        this.syr = syr == null ? null : syr.trim();
    }

    public String getWtsj() {
        return wtsj;
    }

    public void setWtsj(String wtsj) {
        this.wtsj = wtsj == null ? null : wtsj.trim();
    }

    public String getLyr() {
        return lyr;
    }

    public void setLyr(String lyr) {
        this.lyr = lyr == null ? null : lyr.trim();
    }

    public String getFbsj() {
        return fbsj;
    }

    public void setFbsj(String fbsj) {
        this.fbsj = fbsj == null ? null : fbsj.trim();
    }

    public String getSqr() {
        return sqr;
    }

    public void setSqr(String sqr) {
        this.sqr = sqr == null ? null : sqr.trim();
    }

    public String getSyszg() {
        return syszg;
    }

    public void setSyszg(String syszg) {
        this.syszg = syszg == null ? null : syszg.trim();
    }

    public String getFbkxxfx() {
        return fbkxxfx;
    }

    public void setFbkxxfx(String fbkxxfx) {
        this.fbkxxfx = fbkxxfx == null ? null : fbkxxfx.trim();
    }

    public String getHtid() {
        return htid;
    }

    public void setHtid(String htid) {
        this.htid = htid == null ? null : htid.trim();
    }
}