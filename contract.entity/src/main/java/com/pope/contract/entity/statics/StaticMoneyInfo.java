package com.pope.contract.entity.statics;

import java.io.Serializable;
import java.math.BigDecimal;

public class StaticMoneyInfo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String wid;

    private Integer dataYear;

    private Integer dataMonth;

    private String dataYearMonth;

    private BigDecimal sr;

    private BigDecimal wrz;

    private BigDecimal zc;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    public Integer getDataYear() {
        return dataYear;
    }

    public void setDataYear(Integer dataYear) {
        this.dataYear = dataYear;
    }

    public Integer getDataMonth() {
        return dataMonth;
    }

    public void setDataMonth(Integer dataMonth) {
        this.dataMonth = dataMonth;
    }

    public String getDataYearMonth() {
        return dataYearMonth;
    }

    public void setDataYearMonth(String dataYearMonth) {
        this.dataYearMonth = dataYearMonth == null ? null : dataYearMonth.trim();
    }

    public BigDecimal getSr() {
        return sr;
    }

    public void setSr(BigDecimal sr) {
        this.sr = sr;
    }

    public BigDecimal getWrz() {
        return wrz;
    }

    public void setWrz(BigDecimal wrz) {
        this.wrz = wrz;
    }

    public BigDecimal getZc() {
        return zc;
    }

    public void setZc(BigDecimal zc) {
        this.zc = zc;
    }
}