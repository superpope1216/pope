package com.pope.contract.entity.system;

import java.io.Serializable;

public class MessageInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String wid;

    private String name;

    private String createTime;

    private String createMan;

    private String messageType;

    private String taskId;

    private String messageReceiveDepart;

    private String messageReceiveTeam;

    private String messageReceiveMan;

    private String content;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType == null ? null : messageType.trim();
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getMessageReceiveDepart() {
        return messageReceiveDepart;
    }

    public void setMessageReceiveDepart(String messageReceiveDepart) {
        this.messageReceiveDepart = messageReceiveDepart == null ? null : messageReceiveDepart.trim();
    }

    public String getMessageReceiveTeam() {
        return messageReceiveTeam;
    }

    public void setMessageReceiveTeam(String messageReceiveTeam) {
        this.messageReceiveTeam = messageReceiveTeam == null ? null : messageReceiveTeam.trim();
    }

    public String getMessageReceiveMan() {
        return messageReceiveMan;
    }

    public void setMessageReceiveMan(String messageReceiveMan) {
        this.messageReceiveMan = messageReceiveMan == null ? null : messageReceiveMan.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}