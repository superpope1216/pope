package com.pope.contract.entity.pxgl;

import java.io.Serializable;
import java.math.BigDecimal;

public class PxglInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String wid;

    private String pxlx;

    private String pxmc;

    private String begtime;

    private String endtime;

    private BigDecimal pxfy;

    private String bz;

    private String by10;

    private String by9;

    private String by8;

    private String by7;

    private String by6;

    private String by5;

    private String by4;

    private String by3;

    private String by1;

    private String by2;

    private Integer currentstep;

    private Integer rwzt;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    public String getPxlx() {
        return pxlx;
    }

    public void setPxlx(String pxlx) {
        this.pxlx = pxlx == null ? null : pxlx.trim();
    }

    public String getPxmc() {
        return pxmc;
    }

    public void setPxmc(String pxmc) {
        this.pxmc = pxmc == null ? null : pxmc.trim();
    }

    public String getBegtime() {
        return begtime;
    }

    public void setBegtime(String begtime) {
        this.begtime = begtime == null ? null : begtime.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public BigDecimal getPxfy() {
        return pxfy;
    }

    public void setPxfy(BigDecimal pxfy) {
        this.pxfy = pxfy;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public String getBy10() {
        return by10;
    }

    public void setBy10(String by10) {
        this.by10 = by10 == null ? null : by10.trim();
    }

    public String getBy9() {
        return by9;
    }

    public void setBy9(String by9) {
        this.by9 = by9 == null ? null : by9.trim();
    }

    public String getBy8() {
        return by8;
    }

    public void setBy8(String by8) {
        this.by8 = by8 == null ? null : by8.trim();
    }

    public String getBy7() {
        return by7;
    }

    public void setBy7(String by7) {
        this.by7 = by7 == null ? null : by7.trim();
    }

    public String getBy6() {
        return by6;
    }

    public void setBy6(String by6) {
        this.by6 = by6 == null ? null : by6.trim();
    }

    public String getBy5() {
        return by5;
    }

    public void setBy5(String by5) {
        this.by5 = by5 == null ? null : by5.trim();
    }

    public String getBy4() {
        return by4;
    }

    public void setBy4(String by4) {
        this.by4 = by4 == null ? null : by4.trim();
    }

    public String getBy3() {
        return by3;
    }

    public void setBy3(String by3) {
        this.by3 = by3 == null ? null : by3.trim();
    }

    public String getBy1() {
        return by1;
    }

    public void setBy1(String by1) {
        this.by1 = by1 == null ? null : by1.trim();
    }

    public String getBy2() {
        return by2;
    }

    public void setBy2(String by2) {
        this.by2 = by2 == null ? null : by2.trim();
    }

    public Integer getCurrentstep() {
        return currentstep;
    }

    public void setCurrentstep(Integer currentstep) {
        this.currentstep = currentstep;
    }

    public Integer getRwzt() {
        return rwzt;
    }

    public void setRwzt(Integer rwzt) {
        this.rwzt = rwzt;
    }
}