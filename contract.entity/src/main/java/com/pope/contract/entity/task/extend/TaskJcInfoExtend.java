package com.pope.contract.entity.task.extend;

import java.io.Serializable;

import com.pope.contract.entity.task.TaskJcInfo;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年9月23日 下午11:06:05
* 类说明
*/
public class TaskJcInfoExtend extends TaskJcInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String yplp;
	
	private Integer ypsl;
	
	private String sybh;
	
	private String jcxm;
	
	private String syr;
	
	private String sysj;
	
	private String jcr;
	
	private String jcsj;
	
	private String shry;
	
	private String shsj;

	public String getYplp() {
		return yplp;
	}

	public void setYplp(String yplp) {
		this.yplp = yplp;
	}

	public Integer getYpsl() {
		return ypsl;
	}

	public void setYpsl(Integer ypsl) {
		this.ypsl = ypsl;
	}

	public String getSybh() {
		return sybh;
	}

	public void setSybh(String sybh) {
		this.sybh = sybh;
	}

	public String getJcxm() {
		return jcxm;
	}

	public void setJcxm(String jcxm) {
		this.jcxm = jcxm;
	}

	public String getSyr() {
		return syr;
	}

	public void setSyr(String syr) {
		this.syr = syr;
	}

	public String getSysj() {
		return sysj;
	}

	public void setSysj(String sysj) {
		this.sysj = sysj;
	}

	public String getJcr() {
		return jcr;
	}

	public void setJcr(String jcr) {
		this.jcr = jcr;
	}

	public String getJcsj() {
		return jcsj;
	}

	public void setJcsj(String jcsj) {
		this.jcsj = jcsj;
	}

	public String getShry() {
		return shry;
	}

	public void setShry(String shry) {
		this.shry = shry;
	}

	public String getShsj() {
		return shsj;
	}

	public void setShsj(String shsj) {
		this.shsj = shsj;
	}
	

}
