package com.pope.contract.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.contract.code.DataStatus;
import com.pope.contract.dao.system.FxxmInfoMapper;
import com.pope.contract.dao.system.extend.FxxmInfoExtendMapper;
import com.pope.contract.entity.system.FxxmInfo;
import com.pope.contract.entity.system.extend.FxxmExtendInfo;
import com.pope.contract.service.system.FxxmInfoService;
import com.pope.contract.util.StringUtil;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年8月19日 下午9:54:37 类说明
 */
@Service("fxxmInfoService")
public class FxxmInfoServiceImpl implements FxxmInfoService {

	@Autowired
	private FxxmInfoMapper fxxmInfoMapper;

	@Autowired
	private FxxmInfoExtendMapper fxxmInfoExtendMapper;

	@Override
	public int deleteByPrimaryKey(String wid) {
		return fxxmInfoMapper.deleteByPrimaryKey(wid);
	}

	@Override
	public int insert(FxxmInfo record) {
		String wid=StringUtil.getUuId();
		record.setWid(wid);
		record.setLbdm(wid);
		record.setStatus(DataStatus.normal.getCode());
		return fxxmInfoMapper.insert(record);
	}

	@Override
	public FxxmInfo selectByPrimaryKey(String wid) {
		return fxxmInfoMapper.selectByPrimaryKey(wid);
	}

	@Override
	public int updateByPrimaryKeySelective(FxxmInfo record) {
		return fxxmInfoMapper.updateByPrimaryKeySelective(record);
	}

	public List<FxxmExtendInfo> selectDisplayByCondition(FxxmInfo fxxmInfo) {
		return fxxmInfoExtendMapper.selectDisplayByCondition(fxxmInfo);
	}

	public FxxmExtendInfo selectSingleDisplayByCondition(FxxmInfo fxxmInfo) {
		return fxxmInfoExtendMapper.selectSingleDisplayByCondition(fxxmInfo);
	}
	
	public List<FxxmExtendInfo> selectByBatchId( String batchId) throws Exception{
		return fxxmInfoExtendMapper.selectByBatchId(batchId);
	}

	@Override
	public List<FxxmExtendInfo> selectByBatchDetail(String batchId,String htid) throws Exception {
		return fxxmInfoExtendMapper.selectByBatchDetail(batchId,htid);
	}
}
