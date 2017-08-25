package com.pope.contract.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.pope.contract.code.FlowSetCode;
import com.pope.contract.code.FlowStateCode;
import com.pope.contract.entity.system.FlowSetData;
import com.pope.contract.service.system.FlowSetDataService;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月18日 下午11:02:01
* 类说明
*/
public class BaseService {

	@Autowired
	private FlowSetDataService flowSetDataService;
	protected void saveFlowSetData(int currentStep,String wid,FlowStateCode flowStateCode,FlowSetCode flowSetCode,String userId,String content) throws Exception{
		FlowSetData flowSetData=new FlowSetData(); 
		flowSetData.setCurrentState(flowStateCode.getCode());
		flowSetData.setContent(flowStateCode.getMsg());
		flowSetData.setWid(StringUtil.getUuId());
		flowSetData.setCjsj(DateUtil.getCurrentDateTimeStr());
		flowSetData.setCurrentStep(currentStep);
		flowSetData.setDataId(wid);
		flowSetData.setType(flowSetCode.getCode());
		flowSetData.setShid(userId);
		flowSetData.setContent(content);
		flowSetDataService.insert(flowSetData);
	}
	
}
