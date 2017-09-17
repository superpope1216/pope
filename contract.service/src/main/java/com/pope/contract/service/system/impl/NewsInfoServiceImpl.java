package com.pope.contract.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.contract.dao.system.NewsInfoMapper;
import com.pope.contract.dao.system.extend.NewsInfoExtendMapper;
import com.pope.contract.entity.system.NewsInfo;
import com.pope.contract.entity.system.extend.NewsInfoExtend;
import com.pope.contract.service.system.NewsInfoService;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年9月16日 下午9:46:16
* 类说明
*/
@Service("newsInfoService")
public class NewsInfoServiceImpl implements NewsInfoService {

	@Autowired
	private NewsInfoMapper newsInfoMapper;
	@Autowired
	private NewsInfoExtendMapper newsInfoExtendMapper;
	@Override
	public int deleteByPrimaryKey(String wid) throws Exception {
		return newsInfoMapper.deleteByPrimaryKey(wid);
	}

	@Override
	public int insertSelective(NewsInfo record,String userId) throws Exception {
		record.setWid(StringUtil.getUuId());
		record.setCreateTime(DateUtil.getCurrentDateStr());
		record.setCreateMan(userId);
		return newsInfoMapper.insertSelective(record);
	}

	@Override
	public NewsInfo selectByPrimaryKey(String wid) throws Exception {
		return newsInfoMapper.selectByPrimaryKey(wid);
	}

	@Override
	public int updateByPrimaryKeySelective(NewsInfo record) throws Exception {
		return newsInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(NewsInfo record) throws Exception {
		return newsInfoMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public List<NewsInfo> selectByCondition(NewsInfoExtend newsInfoExtend) throws Exception {
		return newsInfoExtendMapper.selectByCondition(newsInfoExtend);
	}

	@Override
	public NewsInfo selectSingleByCondition(NewsInfoExtend newsInfoExtend) throws Exception {
		return newsInfoExtendMapper.selectSingleByCondition(newsInfoExtend);
	}

}
