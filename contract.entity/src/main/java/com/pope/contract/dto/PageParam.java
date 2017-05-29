package com.pope.contract.dto;

import java.io.Serializable;
import java.util.List;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年5月28日 下午4:43:18
* 类说明
*/
public class PageParam<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer page=0;
	
	private Integer pageSize=10;
	
	private Long total=0L;
	
	private Integer totalPage=0;
	
	private List<T> data;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		if(page==null){
			page=1;
		}else{
			page=page+1;
		}
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Integer getTotalPage() {
		if(total%pageSize>0){
			totalPage=total.intValue()/pageSize+1;
		}else{
			totalPage=total.intValue()/pageSize;
		}
		return this.totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage=totalPage;
	}
	
	
	
	
	

}
