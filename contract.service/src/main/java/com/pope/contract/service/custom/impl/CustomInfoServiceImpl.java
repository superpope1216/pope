package com.pope.contract.service.custom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.contract.code.DataStatus;
import com.pope.contract.dao.custom.CustomInfoMapper;
import com.pope.contract.dao.custom.extend.CustomAccountExtendMapper;
import com.pope.contract.dao.custom.extend.CustomInfoExtendMapper;
import com.pope.contract.entity.custom.CustomAccount;
import com.pope.contract.entity.custom.CustomInfo;
import com.pope.contract.entity.custom.extend.CustomAccountExtend;
import com.pope.contract.entity.custom.extend.CustomInfoExtend;
import com.pope.contract.exception.ServiceException;
import com.pope.contract.service.custom.CustomInfoService;
import com.pope.contract.util.CommonUtil;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月20日 下午7:15:45
* 类说明
*/
@Service("customInfoService")
public class CustomInfoServiceImpl implements CustomInfoService{

	@Autowired
	private CustomInfoMapper customInfoMapper;
	
	@Autowired
	private CustomInfoExtendMapper customInfoExtendMapper;
	@Autowired
	private CustomAccountExtendMapper customAccountExtendMapper; 
	@Override
	public int deleteByPrimaryKey(String wid) {
		return customInfoMapper.deleteByPrimaryKey(wid);
	}

	@Override
	public int insert(CustomInfo record,String userId) throws Exception {
		CustomInfo queryCustomInfo=new CustomInfo();
		queryCustomInfo.setDqbh(record.getDqbh());
		List<CustomInfo> list=customInfoExtendMapper.selectByCondition(queryCustomInfo);
		if(CommonUtil.isNotEmptyList(list)){
			throw new ServiceException("该客户编号已存在，请刷新页面重试！");
		}
		record.setWid(StringUtil.getUuId());
		record.setCreateTime(DateUtil.getCurrentDateTimeStr());
		record.setCreateMan(userId);
		record.setDatastatus(StringUtil.toStr(DataStatus.normal.getCode()));
		return customInfoMapper.insert(record);
	}

	@Override
	public CustomInfo selectByPrimaryKey(String wid) {
		return customInfoMapper.selectByPrimaryKey(wid);
	}

	@Override
	public int updateByPrimaryKeySelective(CustomInfo record) {
		return customInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public CustomInfo selectSingleByCondition(CustomInfo customInfo) {
		return customInfoExtendMapper.selectSingleByCondition(customInfo);
	}

	@Override
	public List<CustomInfo> selectByCondition(CustomInfo customInfo) {
		return customInfoExtendMapper.selectByCondition(customInfo);
	}

	@Override
	public CustomInfoExtend selectSingleDisplayByCondition(CustomInfo customInfo) {
		return customInfoExtendMapper.selectSingleDisplayByCondition(customInfo);
	}

	@Override
	public List<CustomInfoExtend> selectDisplayByCondition(CustomInfo customInfo) {
		return customInfoExtendMapper.selectDisplayByCondition(customInfo);
	}
	@Override
	public  Integer selectMaxBh() throws Exception{
		Integer max=customInfoExtendMapper.selectMaxBh();
		if(max==null){
			max=0;
		}
		max++;
		return max; 
				
	}

	
}
