package com.pope.contract.number;

import com.pope.contract.util.DateUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月30日 下午8:21:25
* 类说明
*/
public class GenernalKey {

	
	public static String getCurrentMonth() throws Exception{
		int month=DateUtil.getCurrentDate().getMonth()+1;
		if(month<10){
			return "0"+month;
		}
		return month+"";
	}
	/**
	 * 获取样品编号
	 * @param max
	 * @return
	 * @throws Exception
	 */
	public static String getBatchKey(Integer max) throws Exception{
		String number=String.format("%06d",max);
		return "SN"+DateUtil.getCurrentYearStr()+""+getCurrentMonth()+""+number;
	}
	
	public static String getBatchDetailKey(Integer max,String batchNum) throws Exception{
		return batchNum+String.format("%03d", max);
	}
	
	/**
	 * 获取合同编号
	 * @param max
	 * @param batchNum
	 * @return
	 * @throws Exception
	 */
	public static String getContractKey(Integer max,String batchNum) throws Exception{
		return "HT"+DateUtil.getCurrentYearStr()+""+getCurrentMonth()+String.format("%06d", max);
	}
}
