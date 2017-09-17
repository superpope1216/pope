package com.pope.contract.entity.system.extend;

import java.io.Serializable;

import com.pope.contract.entity.system.MessageInfo;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年9月17日 下午1:48:54
* 类说明
*/
public class MessageInfoExtend extends MessageInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String hasRead;
	
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
