package com.pope.contract.entity.system;

import java.io.Serializable;
import java.math.BigDecimal;

public class FxxmInfo implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String wid;

    private String lbdm;

    private String lbmc;

    private Integer status;

    private Integer orderby;

    private BigDecimal fxdj;
    
    private BigDecimal zk;


	private String fxyj;

    private String fxxlb;

    private String bz;

    private String fxry;

    private String shry;

    

    public BigDecimal getZk() {
		return zk;
	}

	public void setZk(BigDecimal zk) {
		this.zk = zk;
	}
    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    public String getLbdm() {
        return lbdm;
    }

    public void setLbdm(String lbdm) {
        this.lbdm = lbdm == null ? null : lbdm.trim();
    }

    public String getLbmc() {
        return lbmc;
    }

    public void setLbmc(String lbmc) {
        this.lbmc = lbmc == null ? null : lbmc.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    public BigDecimal getFxdj() {
        return fxdj;
    }

    public void setFxdj(BigDecimal fxdj) {
        this.fxdj = fxdj;
    }

    public String getFxyj() {
        return fxyj;
    }

    public void setFxyj(String fxyj) {
        this.fxyj = fxyj == null ? null : fxyj.trim();
    }

    public String getFxxlb() {
        return fxxlb;
    }

    public void setFxxlb(String fxxlb) {
        this.fxxlb = fxxlb == null ? null : fxxlb.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public String getFxry() {
        return fxry;
    }

    public void setFxry(String fxry) {
        this.fxry = fxry == null ? null : fxry.trim();
    }

    public String getShry() {
        return shry;
    }

    public void setShry(String shry) {
        this.shry = shry == null ? null : shry.trim();
    }
}