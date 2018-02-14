package com.pope.contract.entity.system.extend;

import java.io.Serializable;

import com.pope.contract.entity.system.MessageInfo;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年9月17日 下午1:48:54 类说明
 */
public class MessageInfoExtend extends MessageInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String hasRead;

	private String messageReceiveDepart_display;
	
	private String accountRole;

	public String getAccountRole() {
		return accountRole;
	}

	public void setAccountRole(String accountRole) {
		this.accountRole = accountRole;
	}

	public String getMessageReceiveDepart_display() {
		return messageReceiveDepart_display;
	}

	public void setMessageReceiveDepart_display(String messageReceiveDepart_display) {
		this.messageReceiveDepart_display = messageReceiveDepart_display;
	}

	public String getMessageReceiveTeam_display() {
		return messageReceiveTeam_display;
	}

	public void setMessageReceiveTeam_display(String messageReceiveTeam_display) {
		this.messageReceiveTeam_display = messageReceiveTeam_display;
	}

	public String getMessageReceiveMan_display() {
		return messageReceiveMan_display;
	}

	public void setMessageReceiveMan_display(String messageReceiveMan_display) {
		this.messageReceiveMan_display = messageReceiveMan_display;
	}

	private String messageReceiveTeam_display;

	private String messageReceiveMan_display;

	public String getHasRead() {
		return hasRead;
	}

	public void setHasRead(String hasRead) {
		this.hasRead = hasRead;
	}

	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
