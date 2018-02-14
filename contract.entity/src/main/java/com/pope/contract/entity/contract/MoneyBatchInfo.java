package com.pope.contract.entity.contract;

import java.io.Serializable;

public class MoneyBatchInfo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String wid;

    private String moneyId;

    private String pcwid;

    private String detailId;

    private String detailFxxmId;

    private String htId;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    public String getMoneyId() {
        return moneyId;
    }

    public void setMoneyId(String moneyId) {
        this.moneyId = moneyId == null ? null : moneyId.trim();
    }

    public String getPcwid() {
        return pcwid;
    }

    public void setPcwid(String pcwid) {
        this.pcwid = pcwid == null ? null : pcwid.trim();
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId == null ? null : detailId.trim();
    }

    public String getDetailFxxmId() {
        return detailFxxmId;
    }

    public void setDetailFxxmId(String detailFxxmId) {
        this.detailFxxmId = detailFxxmId == null ? null : detailFxxmId.trim();
    }

    public String getHtId() {
        return htId;
    }

    public void setHtId(String htId) {
        this.htId = htId == null ? null : htId.trim();
    }
}