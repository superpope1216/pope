package com.pope.contract.entity.supply;

import java.io.Serializable;
import java.math.BigDecimal;

public class SupplyInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String wid;

    private String hcfl;

    private String pm;

    private String xhppch;

    private String xhplrsj;

    private BigDecimal yxq;

    private Integer kc;

    private String sldw;

    private BigDecimal dj;

    private String hbdw;

    private String gys;

    private Integer yjsl;

    private String bz;

    private Integer dqbh;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    public String getHcfl() {
        return hcfl;
    }

    public void setHcfl(String hcfl) {
        this.hcfl = hcfl == null ? null : hcfl.trim();
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm == null ? null : pm.trim();
    }

    public String getXhppch() {
        return xhppch;
    }

    public void setXhppch(String xhppch) {
        this.xhppch = xhppch == null ? null : xhppch.trim();
    }

    public String getXhplrsj() {
        return xhplrsj;
    }

    public void setXhplrsj(String xhplrsj) {
        this.xhplrsj = xhplrsj == null ? null : xhplrsj.trim();
    }

    public BigDecimal getYxq() {
        return yxq;
    }

    public void setYxq(BigDecimal yxq) {
        this.yxq = yxq;
    }

    public Integer getKc() {
        return kc;
    }

    public void setKc(Integer kc) {
        this.kc = kc;
    }

    public String getSldw() {
        return sldw;
    }

    public void setSldw(String sldw) {
        this.sldw = sldw == null ? null : sldw.trim();
    }

    public BigDecimal getDj() {
        return dj;
    }

    public void setDj(BigDecimal dj) {
        this.dj = dj;
    }

    public String getHbdw() {
        return hbdw;
    }

    public void setHbdw(String hbdw) {
        this.hbdw = hbdw == null ? null : hbdw.trim();
    }

    public String getGys() {
        return gys;
    }

    public void setGys(String gys) {
        this.gys = gys == null ? null : gys.trim();
    }

    public Integer getYjsl() {
        return yjsl;
    }

    public void setYjsl(Integer yjsl) {
        this.yjsl = yjsl;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public Integer getDqbh() {
        return dqbh;
    }

    public void setDqbh(Integer dqbh) {
        this.dqbh = dqbh;
    }
}