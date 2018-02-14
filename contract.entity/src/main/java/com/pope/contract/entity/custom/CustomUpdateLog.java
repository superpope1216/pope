package com.pope.contract.entity.custom;

import java.io.Serializable;
import java.math.BigDecimal;

public class CustomUpdateLog implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String wid;

    private String customId;

    private String accountId;

    private String bankAccount;

    private BigDecimal accountMoney;

    private String createTime;

    private String createMan;

    private Integer updateType;

    private BigDecimal bdMoney;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId == null ? null : customId.trim();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public BigDecimal getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(BigDecimal accountMoney) {
        this.accountMoney = accountMoney;
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

    public Integer getUpdateType() {
        return updateType;
    }

    public void setUpdateType(Integer updateType) {
        this.updateType = updateType;
    }

    public BigDecimal getBdMoney() {
        return bdMoney;
    }

    public void setBdMoney(BigDecimal bdMoney) {
        this.bdMoney = bdMoney;
    }
}