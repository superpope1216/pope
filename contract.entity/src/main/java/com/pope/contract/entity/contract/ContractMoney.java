package com.pope.contract.entity.contract;

import java.io.Serializable;
import java.math.BigDecimal;

public class ContractMoney implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String wid;

    private String htid;

    private String fxxm;

    private BigDecimal dj;

    private Integer sl;

    private BigDecimal zkjg;

    private BigDecimal zj;

    private String createTime;

    private String createMan;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    public String getHtid() {
        return htid;
    }

    public void setHtid(String htid) {
        this.htid = htid == null ? null : htid.trim();
    }

    public String getFxxm() {
        return fxxm;
    }

    public void setFxxm(String fxxm) {
        this.fxxm = fxxm == null ? null : fxxm.trim();
    }

    public BigDecimal getDj() {
        return dj;
    }

    public void setDj(BigDecimal dj) {
        this.dj = dj;
    }

    public Integer getSl() {
        return sl;
    }

    public void setSl(Integer sl) {
        this.sl = sl;
    }

    public BigDecimal getZkjg() {
        return zkjg;
    }

    public void setZkjg(BigDecimal zkjg) {
        this.zkjg = zkjg;
    }

    public BigDecimal getZj() {
        return zj;
    }

    public void setZj(BigDecimal zj) {
        this.zj = zj;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getCreateMan() {
        return createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan == null ? null : createMan.trim();
    }
}