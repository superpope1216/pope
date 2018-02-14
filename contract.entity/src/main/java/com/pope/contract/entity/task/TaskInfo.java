package com.pope.contract.entity.task;

import java.io.Serializable;

public class TaskInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String wid;

    private String rwlx;

    private String rwmc;

    private String rwbh;

    private String ypph;

    private String fxxm;

    private String rwfpr;

    private String jhkssj;

    private String jhjssj;

    private String sjkssj;

    private String sjjssj;

    private String rwshr;

    private String shwcsj;

    private Integer rwzt;

    private String fj;

    private String bz;

    private Integer dqbh;

    private String pcwid;

    private String datastatus;

    private Integer currentstep;

    private String jcwcsj;

    private String fxry;

    private String shry;
    
    private String cjsj;

    public String getCjsj() {
		return cjsj;
	}

	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}

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

    public String getRwmc() {
        return rwmc;
    }

    public void setRwmc(String rwmc) {
        this.rwmc = rwmc == null ? null : rwmc.trim();
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

    public String getFxxm() {
        return fxxm;
    }

    public void setFxxm(String fxxm) {
        this.fxxm = fxxm == null ? null : fxxm.trim();
    }

    public String getRwfpr() {
        return rwfpr;
    }

    public void setRwfpr(String rwfpr) {
        this.rwfpr = rwfpr == null ? null : rwfpr.trim();
    }

    public String getJhkssj() {
        return jhkssj;
    }

    public void setJhkssj(String jhkssj) {
        this.jhkssj = jhkssj == null ? null : jhkssj.trim();
    }

    public String getJhjssj() {
        return jhjssj;
    }

    public void setJhjssj(String jhjssj) {
        this.jhjssj = jhjssj == null ? null : jhjssj.trim();
    }

    public String getSjkssj() {
        return sjkssj;
    }

    public void setSjkssj(String sjkssj) {
        this.sjkssj = sjkssj == null ? null : sjkssj.trim();
    }

    public String getSjjssj() {
        return sjjssj;
    }

    public void setSjjssj(String sjjssj) {
        this.sjjssj = sjjssj == null ? null : sjjssj.trim();
    }

    public String getRwshr() {
        return rwshr;
    }

    public void setRwshr(String rwshr) {
        this.rwshr = rwshr == null ? null : rwshr.trim();
    }

    public String getShwcsj() {
        return shwcsj;
    }

    public void setShwcsj(String shwcsj) {
        this.shwcsj = shwcsj == null ? null : shwcsj.trim();
    }

    public Integer getRwzt() {
        return rwzt;
    }

    public void setRwzt(Integer rwzt) {
        this.rwzt = rwzt;
    }

    public String getFj() {
        return fj;
    }

    public void setFj(String fj) {
        this.fj = fj == null ? null : fj.trim();
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

    public String getPcwid() {
        return pcwid;
    }

    public void setPcwid(String pcwid) {
        this.pcwid = pcwid == null ? null : pcwid.trim();
    }

    public String getDatastatus() {
        return datastatus;
    }

    public void setDatastatus(String datastatus) {
        this.datastatus = datastatus == null ? null : datastatus.trim();
    }

    public Integer getCurrentstep() {
        return currentstep;
    }

    public void setCurrentstep(Integer currentstep) {
        this.currentstep = currentstep;
    }

    public String getJcwcsj() {
        return jcwcsj;
    }

    public void setJcwcsj(String jcwcsj) {
        this.jcwcsj = jcwcsj == null ? null : jcwcsj.trim();
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