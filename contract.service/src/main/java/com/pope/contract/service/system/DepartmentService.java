package com.pope.contract.service.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pope.contract.entity.system.Department;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年6月2日 上午11:18:40
* 类说明
*/
public interface DepartmentService {
	Department insert(Department record,String  userId) throws Exception;

	Department insertSelective(Department record,String userId) throws Exception;
    int updateByPrimaryKeySelective(Department record,String userId) throws Exception;
    
    int updateByPrimaryKey(Department record,String userId) throws Exception;
    
    Department selectByBm(  String bm);
    
    
    List<Department> selectAll();
    
    void deleteByWid(String wid);
}
