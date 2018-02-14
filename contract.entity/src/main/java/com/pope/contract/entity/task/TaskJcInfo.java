package com.pope.contract.entity.task;

import java.io.Serializable;

public class TaskJcInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String wid;

    private String wtbh;

    private String jcyj;

    private String lyr;

    private String lysj;

    private String bz;

    private String taskid;

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid == null ? null : wid.trim();
    }

    public String getWtbh() {
        return wtbh;
    }

    public void setWtbh(String wtbh) {
        this.wtbh = wtbh == null ? null : wtbh.trim();
    }

    public String getJcyj() {
        return jcyj;
    }

    public void setJcyj(String jcyj) {
        this.jcyj = jcyj == null ? null : jcyj.trim();
    }

    public String getLyr() {
        return lyr;
    }

    public void setLyr(String lyr) {
        this.lyr = lyr == null ? null : lyr.trim();
    }

    public String getLysj() {
        return lysj;
    }

    public void setLysj(String lysj) {
        this.lysj = lysj == null ? null : lysj.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid == null ? null : taskid.trim();
    }
}