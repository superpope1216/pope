package com.pope.contract.service.custom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.contract.dao.custom.CustomUpdateLogMapper;
import com.pope.contract.dao.custom.extend.CustomUpdateLogExtendMapper;
import com.pope.contract.entity.custom.CustomUpdateLog;
import com.pope.contract.service.custom.CustomUpdateLogService;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年10月28日 下午4:50:58
* 类说明
*/
@Service("customUpdateLogService")
public class CustomUpdateLogServiceImpl implements CustomUpdateLogService {

	@Autowired
	private CustomUpdateLogMapper customUpdateLogMapper;
	@Autowired
	private CustomUpdateLogExtendMapper customUpdateLogExtendMapper;
	public int deleteByPrimaryKey(String wid) throws Exception{
		return customUpdateLogMapper.deleteByPrimaryKey(wid);
	}

	public int insert(CustomUpdateLog record) throws Exception{
    	return customUpdateLogMapper.insert(record);
    }

	public int insertSelective(CustomUpdateLog record) throws Exception{
    	return customUpdateLogMapper.insertSelective(record);
    }

	public CustomUpdateLog selectByPrimaryKey(String wid) throws Exception{
    	return customUpdateLogMapper.selectByPrimaryKey(wid);
    }

	public int updateByPrimaryKeySelective(CustomUpdateLog record)throws Exception{
    	return customUpdateLogMapper.updateByPrimaryKeySelective(record);
    }

	public int updateByPrimaryKey(CustomUpdateLog record) throws Exception{
    	return customUpdateLogMapper.updateByPrimaryKey(record);
    }

	@Override
	public List<CustomUpdateLog> selectByCondition(CustomUpdateLog customUpdateLog) throws Exception {
		return customUpdateLogExtendMapper.selectByCondition(customUpdateLog);
	}

	@Override
	public CustomUpdateLog selectSingleByCondition(CustomUpdateLog customUpdateLog) throws Exception {
		return customUpdateLogExtendMapper.selectSingleByCondition(customUpdateLog);
	}
}
