package com.pope.contract.service.system;

import java.util.List;

import com.pope.contract.entity.system.FlowSet;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年6月25日 下午8:55:50
* 类说明
*/
public interface FlowSetService {
	  int deleteByPrimaryKey(String wid) throws Exception;

	    int insert(FlowSet record)  throws Exception;

	    int insertSelective(FlowSet record)  throws Exception;

	    FlowSet selectByPrimaryKey(String wid)  throws Exception;
	    
	    List<FlowSet> list(FlowSet flowSet) throws Exception;

	    int updateByPrimaryKeySelective(FlowSet record)  throws Exception;

	    int updateByPrimaryKey(FlowSet record)  throws Exception;
}
