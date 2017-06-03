package com.pope.contract.entity.system;

import java.io.Serializable;

public class Sjzd implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String wid;

    private String lbdm;

    private String lbmc;

    private Integer status;

    private Integer orderby;
    
    private String tableName;

    public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
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
}