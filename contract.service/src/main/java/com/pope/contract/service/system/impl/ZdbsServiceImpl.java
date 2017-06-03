package com.pope.contract.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.contract.code.DataStatus;
import com.pope.contract.dao.system.ZdbsMapper;
import com.pope.contract.entity.system.Zdbs;
import com.pope.contract.service.system.ZdbsService;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年6月3日 下午3:11:11
* 类说明
*/
@Service("zdbsService")
public class ZdbsServiceImpl implements ZdbsService {

	@Autowired
	private ZdbsMapper zdbsMapper;
	@Override
	public int deleteByPrimaryKey(String wid, String userId) throws Exception {
		Zdbs zdbs=new Zdbs();
		zdbs.setWid(wid);
		zdbs.setUpdateby(userId);
		zdbs.setUpdatetime(DateUtil.getCurrentDate());
		zdbs.setStatus(DataStatus.delete.getCode());
		return zdbsMapper.updateByPrimaryKeySelective(zdbs);
	}

	@Override
	public int insert(Zdbs record, String userId) throws Exception {
		record.setWid(StringUtil.getUuId());
		record.setStatus(DataStatus.normal.getCode());
		record.setCreateby(userId);
		record.setCreatetime(DateUtil.getCurrentDate());
		record.setUpdateby(userId);
		record.setUpdatetime(DateUtil.getCurrentDate());
		return zdbsMapper.insert(record);
	}

	@Override
	public int insertSelective(Zdbs record, String userId) throws Exception {
		record.setWid(StringUtil.getUuId());
		record.setStatus(DataStatus.normal.getCode());
		record.setCreateby(userId);
		record.setCreatetime(DateUtil.getCurrentDate());
		record.setUpdateby(userId);
		record.setUpdatetime(DateUtil.getCurrentDate());
		return zdbsMapper.insertSelective(record);
	}

	@Override
	public Zdbs selectByPrimaryKey(String wid) {
		return zdbsMapper.selectByPrimaryKey(wid);
	}

	@Override
    public List<Zdbs> selectAll(){
	   return zdbsMapper.selectAll();
   }
	@Override
	public int updateByPrimaryKeySelective(Zdbs record, String userId) throws Exception {
		
		record.setStatus(DataStatus.normal.getCode());
		record.setUpdateby(userId);
		record.setUpdatetime(DateUtil.getCurrentDate());
		return zdbsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Zdbs record, String userId) throws Exception {

		record.setStatus(DataStatus.normal.getCode());
		record.setUpdateby(userId);
		record.setUpdatetime(DateUtil.getCurrentDate());
		return zdbsMapper.updateByPrimaryKey(record);
	}

}
