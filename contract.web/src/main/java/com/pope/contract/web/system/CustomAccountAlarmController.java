package com.pope.contract.web.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pope.contract.code.Result;
import com.pope.contract.entity.system.AlarmInfo;
import com.pope.contract.service.system.AlarmInfoService;
import com.pope.contract.util.StringUtil;
import com.pope.contract.web.BaseController;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年11月1日 上午11:08:04
* 类说明
*/
@Controller
@RequestMapping("customAccountAlarm")
public class CustomAccountAlarmController extends BaseController {

	@Autowired
	private AlarmInfoService alarmInfoService; 
	@RequestMapping("index")
	public String index(){
		return "system/customAccountAlarm";
	}
	@RequestMapping("selectAlaramByPermissionId")
	@ResponseBody
	public Result selectAlaramByPermissionId(String perId) throws Exception{
		AlarmInfo queryAlarmInfo=new AlarmInfo();
		queryAlarmInfo.setPermissionId(perId);
		AlarmInfo alarmInfo=alarmInfoService.selectSingleByCondition(queryAlarmInfo);
		if(alarmInfo==null){
			alarmInfo=new AlarmInfo();
			alarmInfo.setPermissionId(perId);
		}
	   return Result.success(alarmInfo);
	}
	@RequestMapping("save")
	@ResponseBody
	public Result save(AlarmInfo alarmInfo) throws Exception{
		if(StringUtils.isEmpty(alarmInfo.getWid())){
			alarmInfo.setWid(StringUtil.getUuId());
			alarmInfoService.insertSelective(alarmInfo);
		}else{
			alarmInfoService.updateByPrimaryKeySelective(alarmInfo);
		}
		return Result.success();
	}
}
