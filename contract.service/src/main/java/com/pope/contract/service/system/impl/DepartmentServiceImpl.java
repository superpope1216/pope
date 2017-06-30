package com.pope.contract.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pope.contract.code.DataStatus;
import com.pope.contract.dao.system.DepartmentMapper;
import com.pope.contract.entity.system.Department;
import com.pope.contract.entity.system.Sjzd;
import com.pope.contract.exception.BizException;
import com.pope.contract.service.system.DepartmentService;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年6月2日 上午11:19:09
* 类说明
*/
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Override
	public Department insert(Department record,String userId) throws Exception {
		record.setWid(StringUtil.getUuId());
		record.setStatus(DataStatus.normal.getCode());
		record.setCreateby(userId);
		record.setCreatetime(DateUtil.getCurrentDate());
		record.setUpdateby(userId);
		record.setUpdatetime(DateUtil.getCurrentDate());
		Department department=this.selectByBm(record.getBm());
		if(department!=null){
			throw new BizException("该编码已经存在，请重新确认！");
		}
		departmentMapper.insert(record);
		return record;
	}

	@Override
	public Department insertSelective(Department record,String userId) throws Exception{
		record.setWid(StringUtil.getUuId());
		record.setStatus(DataStatus.normal.getCode());
		record.setCreateby(userId);
		record.setCreatetime(DateUtil.getCurrentDate());
		record.setUpdateby(userId);
		record.setUpdatetime(DateUtil.getCurrentDate());
		Department department=this.selectByBm(record.getBm());
		if(department!=null){
			throw new BizException("该编码已经存在，请重新确认！");
		}
		 departmentMapper.insertSelective(record);
		 return record;
	}
	
	@Override
	public int updateByPrimaryKeySelective(Department record,String userId) throws Exception{
		
		record.setStatus(DataStatus.normal.getCode()); 
		record.setUpdateby(userId);
		record.setUpdatetime(DateUtil.getCurrentDate());
		Department department=this.selectByBm(record.getBm());
		if(department!=null && !department.getWid().equals(record.getWid())){
			throw new BizException("该编码已经存在，请重新确认！");
		}
		return departmentMapper.updateByPrimaryKeySelective(record);
	}
    
	@Override
	public int updateByPrimaryKey(Department record,String userId) throws Exception{
		
		record.setStatus(DataStatus.normal.getCode()); 
		record.setUpdateby(userId);
		record.setUpdatetime(DateUtil.getCurrentDate());
		Department department=this.selectByBm(record.getBm());
		if(department!=null && !department.getWid().equals(record.getWid())){
			throw new BizException("该编码已经存在，请重新确认！");
		}
		return departmentMapper.updateByPrimaryKey(record);
	}
	@Override
	public Department selectByBm(  String bm){
		return departmentMapper.selectByBm(bm);
	}
	@Override
	public List<Department> selectAll(){
		return departmentMapper.selectAll();
	}

	@Override
	@Transactional
	public void deleteByWid(String wid){
		departmentMapper.deleteByPid(wid);
		departmentMapper.deleteByWid(wid);
	}
	@Override
	public List<Department> selectDepartment(){
		return departmentMapper.selectDepartment();
	}

	public List<Sjzd> selectTeamByDepartment(String bm){
		return departmentMapper.selectTeamByDepartment(bm);
	}
}
