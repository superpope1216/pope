package com.pope.contract.service.system.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pope.contract.code.DataStatus;
import com.pope.contract.dao.system.SjzdMapper;
import com.pope.contract.entity.system.Sjzd;
import com.pope.contract.entity.system.Zdbs;
import com.pope.contract.exception.ServiceException;
import com.pope.contract.service.system.SjzdService;
import com.pope.contract.util.CommonUtil;
import com.pope.contract.util.ConstantUtil;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年6月3日 下午6:33:15
* 类说明
*/
@Service("sjzdService")
public class SjzdServiceImpl implements SjzdService {

	@Autowired
	private SjzdMapper sjzdMapper;
	@Override
	public int deleteByPrimaryKey(String tableName,String wid) throws Exception {
		if(tableName.trim().equals(ConstantUtil.TABLE_HTLX)){
			 Sjzd oldSjzd=sjzdMapper.selectByPrimaryKey(tableName, wid);
			 if(oldSjzd.getLbdm().equals(ConstantUtil.HTLX_WB)){
				 throw new ServiceException("该分类为系统默认，无法删除");
			 }
		}
		Sjzd sjzd=new Sjzd();
		sjzd.setWid(wid); 
		sjzd.setTableName(tableName);
		sjzd.setStatus(DataStatus.delete.getCode());
		return sjzdMapper.updateByPrimaryKeySelective(sjzd);
	}
	
	@Override
	public int insert(Sjzd record ) throws Exception {
		List<Sjzd> lstOld=sjzdMapper.selectAll(record.getTableName(), Arrays.asList(record.getLbdm()));
		if(CommonUtil.isNotEmptyList(lstOld)){
			 throw new ServiceException("该类别已存在，请重新确认！"); 
		}
		record.setWid(StringUtil.getUuId());
		record.setStatus(DataStatus.normal.getCode());
		return sjzdMapper.insert(record);
	}

	@Override
	public int insertSelective(Sjzd record ) throws Exception {
		List<Sjzd> lstOld=sjzdMapper.selectAll(record.getTableName(), Arrays.asList(record.getLbdm()));
		if(CommonUtil.isNotEmptyList(lstOld)){
			 throw new ServiceException("该类别已存在，请重新确认！"); 
		}
		record.setWid(StringUtil.getUuId());
		record.setStatus(DataStatus.normal.getCode());
		return sjzdMapper.insert(record);
	}

	@Override
	public Sjzd selectByPrimaryKey(String tableName,String wid) {
		return sjzdMapper.selectByPrimaryKey(tableName, wid);
	}

	public List<Sjzd> selectAll(String tableName,String lbdms){
		List<String> lstLbdm=null;
		
		if(StringUtils.isNotEmpty(lbdms)){
			lstLbdm=new ArrayList<String>();
			String[] sLbdms=lbdms.split(",");
			for(String s:sLbdms){
				lstLbdm.add(s);
			}
		}
		return sjzdMapper.selectAll(tableName,lstLbdm);
	}
	@Override
	public int updateByPrimaryKeySelective(Sjzd record ) throws Exception {
		
		 if(record.getTableName().equals(ConstantUtil.TABLE_HTLX)){
			 Sjzd oldSjzd=sjzdMapper.selectByPrimaryKey(record.getTableName(), record.getWid());
			 if(oldSjzd.getLbdm().equals(ConstantUtil.HTLX_WB) && !oldSjzd.getLbdm().equals(record.getLbdm())){
				 throw new ServiceException("该分类为系统默认，无法修改");
			 }
		 }
		 List<Sjzd> lstOld=sjzdMapper.selectAll(record.getTableName(), Arrays.asList(record.getLbdm()));
			if(CommonUtil.isNotEmptyList(lstOld)){
				for(Sjzd sjzd:lstOld){
					if(!sjzd.getWid().equals(record.getWid())){
						throw new ServiceException("该类别已存在，请重新确认！");
					}
				}
				  
			}
		return sjzdMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Sjzd record ) throws Exception {
		return sjzdMapper.updateByPrimaryKeySelective(record);
	}
	
	public List<Sjzd> selectRwzt(){
		return sjzdMapper.selectRwzt();
	}

	@Override
	public List<Sjzd> selectUsers() {
		return sjzdMapper.selectUsers();
	}

}
