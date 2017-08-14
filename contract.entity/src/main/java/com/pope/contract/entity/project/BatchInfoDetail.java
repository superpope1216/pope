package com.pope.contract.entity.project;

public class BatchInfoDetail {
    private String wid;

    private String ypbh;

    private String ypph;

    private String ypyybh;

    private String ypxz;

    private String ypewm;

    private String fxxm;

    private String pcwid;

    private Integer dqbh;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    public String getYpbh() {
        return ypbh;
    }

    public void setYpbh(String ypbh) {
        this.ypbh = ypbh == null ? null : ypbh.trim();
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
}