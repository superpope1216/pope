package com.pope.contract.service.user.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.contract.code.DataStatus;
import com.pope.contract.dao.user.LeaveInfoMapper;
import com.pope.contract.entity.user.LeaveInfo;
import com.pope.contract.service.user.LeaveInfoService;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年6月4日 下午7:53:39
* 类说明
*/
@Service("leaveInfoService")
public class LeaveInfoServiceImpl implements LeaveInfoService {

	@Autowired
	private LeaveInfoMapper leaveInfoMapper; 
	@Override
	public int deleteByPrimaryKey(String wid,String userId) throws Exception{
		LeaveInfo record=new LeaveInfo();
		record.setWid(wid);
		record.setStatus(DataStatus.delete.getCode()); 
		record.setUpdateby(userId);
		record.setUpdatetime(DateUtil.getCurrentDate());
		return leaveInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int insert(LeaveInfo record,String userId) throws Exception {
		record.setWid(StringUtil.getUuId());
		record.setStatus(DataStatus.normal.getCode());
		record.setCreateby(userId);
		record.setCreatetime(DateUtil.getCurrentDate());
		record.setUpdateby(userId);
		record.setUpdatetime(DateUtil.getCurrentDate());
		record.setTime(caluTime(record.getStarttime(), record.getEndtime()));
		return leaveInfoMapper.insert(record);
	}

	@Override
	public int insertSelective(LeaveInfo record,String userId) throws Exception {
		record.setWid(StringUtil.getUuId());
		record.setStatus(DataStatus.normal.getCode());
		record.setCreateby(userId);
		record.setCreatetime(DateUtil.getCurrentDate());
		record.setUpdateby(userId);
		record.setUpdatetime(DateUtil.getCurrentDate());
		record.setTime(caluTime(record.getStarttime(), record.getEndtime()));
		return leaveInfoMapper.insertSelective(record);
	}

	@Override
	public LeaveInfo selectByPrimaryKey(String wid) {
		return leaveInfoMapper.selectByPrimaryKey(wid);
	}
	@Override
	public List<LeaveInfo> selectByYhid(String yhid){
		return leaveInfoMapper.selectByYhid(yhid);
	}
	@Override
	public int updateByPrimaryKeySelective(LeaveInfo record,String userId) throws Exception {
		record.setUpdateby(userId);
		record.setUpdatetime(DateUtil.getCurrentDate());
		record.setTime(caluTime(record.getStarttime(), record.getEndtime()));
		return leaveInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(LeaveInfo record,String userId) throws Exception {
		record.setUpdateby(userId);
		record.setUpdatetime(DateUtil.getCurrentDate());
		record.setTime(caluTime(record.getStarttime(), record.getEndtime()));
		return leaveInfoMapper.updateByPrimaryKey(record);
	}

	private double caluTime(String start,String end) throws Exception{
		long days=DateUtil.getDaysBetween(start, end);
		Date d1=DateUtil.parseDateTime(start+":00");
		Date d2=DateUtil.parseDateTime(end+":00");
		
		int hours=d2.getHours()-d1.getHours();
		int minus=d2.getMinutes()-d1.getMinutes();
		hours=(int)days*8+hours;
		double dMinus=minus/60;
		return (hours+dMinus);
	}

}
