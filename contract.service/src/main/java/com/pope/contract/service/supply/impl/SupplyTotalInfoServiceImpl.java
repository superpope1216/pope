package com.pope.contract.service.supply.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.contract.dao.supply.SupplyInfoMapper;
import com.pope.contract.dao.supply.SupplyTotalInfoMapper;
import com.pope.contract.dao.supply.extend.SupplyInfoExtendMapper;
import com.pope.contract.dao.supply.extend.SupplyTotalInfoExtendMapper;
import com.pope.contract.entity.supply.SupplyInfo;
import com.pope.contract.entity.supply.SupplyTotalInfo;
import com.pope.contract.entity.supply.extend.SupplyInfoExtend;
import com.pope.contract.entity.supply.extend.SupplyTotalInfoExtend;
import com.pope.contract.service.supply.SupplyInfoService;
import com.pope.contract.service.supply.SupplyTotalInfoService;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月15日 下午6:25:09
* 类说明
*/
@Service("supplyTotalInfoService")
public class SupplyTotalInfoServiceImpl implements SupplyTotalInfoService{

	@Autowired
	private SupplyTotalInfoMapper supplyInfoMapper;
	@Autowired
	private SupplyTotalInfoExtendMapper supplyInfoExtendMapper;
	@Override
	public List<SupplyTotalInfo> selectByCondition(SupplyTotalInfoExtend supplyInfo) {
		return supplyInfoExtendMapper.selectByCondition(supplyInfo);
	}

	@Override
	public List<SupplyTotalInfoExtend> selectDisplayByCondition(SupplyTotalInfoExtend supplyInfo) {
		return supplyInfoExtendMapper.selectDisplayByCondition(supplyInfo);
	}

	@Override
	public void deleteByPrimaryKey(String wid) {
		 supplyInfoMapper.deleteByPrimaryKey(wid);
	}

	@Override
	public SupplyTotalInfo insert(SupplyTotalInfo record) {
		record.setWid(StringUtil.getUuId());
		supplyInfoMapper.insert(record);
		return record;
	}

	@Override
	public void updateByPrimaryKeySelective(SupplyTotalInfo record) {
		supplyInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public SupplyTotalInfo selectByPrimaryKey(String wid) {
		return supplyInfoMapper.selectByPrimaryKey(wid);
	}

}
