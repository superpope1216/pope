package com.pope.contract.service.supply.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.contract.dao.supply.SupplyInfoMapper;
import com.pope.contract.dao.supply.extend.SupplyInfoExtendMapper;
import com.pope.contract.entity.supply.SupplyInfo;
import com.pope.contract.entity.supply.extend.SupplyInfoExtend;
import com.pope.contract.service.supply.SupplyInfoService;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月15日 下午6:25:09
* 类说明
*/
@Service("supplyInfoService")
public class SupplyInfoServiceImpl implements SupplyInfoService{

	@Autowired
	private SupplyInfoMapper supplyInfoMapper;
	@Autowired
	private SupplyInfoExtendMapper supplyInfoExtendMapper;
	@Override
	public List<SupplyInfo> selectByCondition(SupplyInfo supplyInfo) {
		return supplyInfoExtendMapper.selectByCondition(supplyInfo);
	}

	@Override
	public List<SupplyInfoExtend> selectDisplayByCondition(SupplyInfo supplyInfo) {
		return supplyInfoExtendMapper.selectDisplayByCondition(supplyInfo);
	}

	@Override
	public void deleteByPrimaryKey(String wid) {
		 supplyInfoMapper.deleteByPrimaryKey(wid);
	}

	@Override
	public SupplyInfo insert(SupplyInfo record) {
		record.setWid(StringUtil.getUuId());
		Integer max=this.supplyInfoExtendMapper.selectMaxBh();
		if(max==null){
			max=0;
		}
		max++;
		record.setDqbh(max);
		supplyInfoMapper.insert(record);
		return record;
	}

	@Override
	public void updateByPrimaryKeySelective(SupplyInfo record) {
		supplyInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public SupplyInfo selectByPrimaryKey(String wid) {
		return supplyInfoMapper.selectByPrimaryKey(wid);
	}

}
