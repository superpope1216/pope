package com.pope.contract.web.util;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.task.TaskInfo;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月15日 下午1:52:19
* 类说明
*/
public class PageUtil<T> {

	private PageParam<T> pageParam;
	private Page<T> page;
	public PageUtil(){
		this(0);
	}
	public PageUtil(Integer startPage){
		if(startPage==null || startPage<0){
			startPage=0;
		}
		pageParam = new PageParam<T>();
		pageParam.setPage(startPage);
		page = PageHelper.startPage(pageParam.getPage(), pageParam.getPageSize());
	}
	
	public PageParam<T> getPageParam(List<T> datas ){
		pageParam.setTotal(page.getTotal());
		pageParam.setTotalPage(pageParam.getTotalPage());
		pageParam.setData(datas);
		return this.pageParam;
	}
	
}
