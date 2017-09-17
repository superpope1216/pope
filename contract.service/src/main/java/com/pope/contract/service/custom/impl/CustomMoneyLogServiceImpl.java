package com.pope.contract.service.custom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.contract.dao.custom.CustomMoneyLogMapper;
import com.pope.contract.dao.custom.extend.CustomMoneyLogExtendMapper;
import com.pope.contract.entity.custom.CustomMoneyLog;
import com.pope.contract.entity.custom.extend.CustomMoneyLogExtend;
import com.pope.contract.service.custom.CustomMoneyLogService;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年9月4日 下午9:40:46 类说明
 */
@Service("customMoneyLogService")
public class CustomMoneyLogServiceImpl implements CustomMoneyLogService {

	@Autowired
	private CustomMoneyLogMapper customMoneyLogMapper;
	@Autowired
	private CustomMoneyLogExtendMapper customMoneyLogExtendMapper;

	@Override
	public int deleteByPrimaryKey(String wid) {
		return customMoneyLogMapper.deleteByPrimaryKey(wid);
	}

	@Override
	public int insertSelective(CustomMoneyLog record) {
		return customMoneyLogMapper.insertSelective(record);
	}

	@Override
	public CustomMoneyLog selectByPrimaryKey(String wid) {
		return customMoneyLogMapper.selectByPrimaryKey(wid);
	}

	@Override
	public int updateByPrimaryKeySelective(CustomMoneyLog record) {
		return customMoneyLogMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public CustomMoneyLogExtend selectSingleDisplayByCondition(CustomMoneyLogExtend customInfo) {
		return customMoneyLogExtendMapper.selectSingleDisplayByCondition(customInfo);
	}

	@Override
	public List<CustomMoneyLogExtend> selectDisplayByCondition(CustomMoneyLogExtend customInfo) {
		return customMoneyLogExtendMapper.selectDisplayByCondition(customInfo);
	}

}
