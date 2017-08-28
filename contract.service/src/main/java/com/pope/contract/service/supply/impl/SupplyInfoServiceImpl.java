package com.pope.contract.service.supply.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pope.contract.dao.supply.SupplyInfoMapper;
import com.pope.contract.dao.supply.SupplyTotalInfoMapper;
import com.pope.contract.dao.supply.extend.SupplyInfoExtendMapper;
import com.pope.contract.dao.supply.extend.SupplyTotalInfoExtendMapper;
import com.pope.contract.entity.supply.SupplyInfo;
import com.pope.contract.entity.supply.SupplyTotalInfo;
import com.pope.contract.entity.supply.extend.SupplyInfoExtend;
import com.pope.contract.exception.ServiceException;
import com.pope.contract.service.supply.SupplyInfoService;
import com.pope.contract.util.CommonUtil;
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
	
	@Autowired
	private SupplyTotalInfoMapper supplyTotalInfoMapper;
	@Autowired
	private SupplyTotalInfoExtendMapper supplyTotalInfoExtendMapper;
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
	@Transactional
	public SupplyInfo insert(SupplyInfo record) throws Exception{
		record.setWid(StringUtil.getUuId());
		Integer max=this.supplyInfoExtendMapper.selectMaxBh();
		if(max==null){
			max=0;
		}
		max++;
		record.setDqbh(max);
		SupplyInfo querySupplyInfo=new SupplyInfo();
		querySupplyInfo.setHcfl(record.getHcfl());
		querySupplyInfo.setPm(record.getPm());
		SupplyInfo oldSupplyInfo=supplyInfoExtendMapper.selectSingleByCondition(querySupplyInfo);
		SupplyTotalInfo supplyTotalInfo=null;
		if(oldSupplyInfo!=null){
			if(!record.getSldw().equals(oldSupplyInfo.getSldw()) ){
				throw new ServiceException("同一分类同一品名的数量单位不一致，请重新确认！");
			}
			record.setFid(oldSupplyInfo.getFid());
			supplyTotalInfo=supplyTotalInfoMapper.selectByPrimaryKey(oldSupplyInfo.getFid());
			
			supplyTotalInfo.setKc(supplyTotalInfo.getKc()+record.getKc());
			supplyTotalInfo.setYjsl(supplyTotalInfo.getYjsl()+record.getYjsl());
			supplyTotalInfoMapper.updateByPrimaryKeySelective(supplyTotalInfo);
			
		}else{
			supplyTotalInfo=new SupplyTotalInfo();
			String pid=StringUtil.getUuId();
			record.setFid(pid);
			supplyTotalInfo.setWid(pid);
			supplyTotalInfo.setHcfl(record.getHcfl());
			supplyTotalInfo.setPm(record.getPm());
			supplyTotalInfo.setSldw(record.getSldw());
			supplyTotalInfo.setKc(record.getKc());
			supplyTotalInfo.setYjsl(record.getYjsl());
			supplyTotalInfo.setDj(record.getDj());
			supplyTotalInfo.setHbdw(record.getHbdw());
			supplyTotalInfo.setSldw(record.getSldw());
			supplyTotalInfoMapper.insert(supplyTotalInfo);
		}
		supplyInfoMapper.insert(record);
		return record;
	}
	
	
	@Override
	@Transactional
	public void updateByPrimaryKeySelective(SupplyInfo record) {
//		SupplyInfo querySupplyInfo=new SupplyInfo();
//		querySupplyInfo.setHcfl(record.getHcfl());
//		querySupplyInfo.setPm(record.getPm());
//		List<SupplyInfo> lst=supplyInfoExtendMapper.selectByCondition(querySupplyInfo);
//		SupplyInfo oldSupplyInfo=supplyInfoExtendMapper.selectSingleByCondition(querySupplyInfo);
//		SupplyTotalInfo supplyTotalInfo=null;
//		if(CommonUtil.isNotEmptyList(lst) && lst.size()>1){
//			if(!record.getSldw().equals(oldSupplyInfo.getSldw()) ){
//				throw new ServiceException("同一分类同一品名的数量单位不一致，请重新确认！");
//			}
//			record.setFid(oldSupplyInfo.getFid());
//			supplyTotalInfo=supplyTotalInfoMapper.selectByPrimaryKey(oldSupplyInfo.getWid());
//			supplyTotalInfo.setKc(supplyTotalInfo.getKc()+record.getKc()-);
//			supplyTotalInfo.setYjsl(supplyTotalInfo.getYjsl()+record.getYjsl());
//			supplyTotalInfoMapper.updateByPrimaryKeySelective(supplyTotalInfo);
//			
//		}
		supplyInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public SupplyInfo selectByPrimaryKey(String wid) {
		return supplyInfoMapper.selectByPrimaryKey(wid);
	}

	
	public List<Map<String,Object>> selectPmByCondition(String hcpl) throws Exception{
		return supplyInfoExtendMapper.selectPmByCondition(hcpl);
	}
	
	public SupplyInfo selectSingleByCondition(SupplyInfo supplyInfo) throws Exception{
		return supplyInfoExtendMapper.selectSingleByCondition(supplyInfo);
	}
}
