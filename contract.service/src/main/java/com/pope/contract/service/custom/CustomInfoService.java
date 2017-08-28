package com.pope.contract.service.custom;

import java.util.List;

import com.pope.contract.entity.custom.CustomInfo;
import com.pope.contract.entity.custom.extend.CustomInfoExtend;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月20日 下午7:15:45
* 类说明
*/
public interface CustomInfoService {
	int deleteByPrimaryKey(String wid);

	 int insert(CustomInfo record,String userId) throws Exception;

    CustomInfo selectByPrimaryKey(String wid);

    int updateByPrimaryKeySelective(CustomInfo record);
    
	CustomInfo  selectSingleByCondition(CustomInfo customInfo);
	
	List<CustomInfo> selectByCondition(CustomInfo customInfo);
	
    CustomInfoExtend selectSingleDisplayByCondition(CustomInfo customInfo);
    
    List<CustomInfoExtend> selectDisplayByCondition(CustomInfo customInfo);
    
    Integer selectMaxBh() throws Exception;
    
  
}
