package com.pope.contract.web.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pope.contract.code.Result;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.system.FxxmInfo;
import com.pope.contract.entity.system.extend.FxxmExtendInfo;
import com.pope.contract.entity.task.TaskInfo;
import com.pope.contract.entity.user.UserInfo;
import com.pope.contract.service.system.FxxmInfoService;
import com.pope.contract.service.user.UserInfoService;
import com.pope.contract.util.ConstantUtil;
import com.pope.contract.web.util.PageUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月19日 下午10:14:30
* 类说明
*/
@Controller
@RequestMapping("fxxmInfo")
public class FxxmInfoController {

	@Autowired
	private FxxmInfoService fxxmInfoService;
	@Autowired
	private UserInfoService userInfoService;
	
	
	@RequestMapping("index")
	public String index(){
		return "system/fxxmInfo";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Result list(Integer startPage){
		PageUtil<FxxmExtendInfo> pageUtil=new PageUtil<FxxmExtendInfo>(startPage);
		List<FxxmExtendInfo> datas=fxxmInfoService.selectDisplayByCondition(null);
		PageParam<FxxmExtendInfo> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	

	@RequestMapping("selectFxry")
	@ResponseBody
	public Result selectFxry(){
		List<UserInfo> datas=userInfoService.selectByRoleName(ConstantUtil.FXRY_ROLE_NAME);
		return Result.success(datas);
	}
	
	@RequestMapping("selectShry")
	@ResponseBody
	public Result selectShry(){
		List<UserInfo> datas=userInfoService.selectByRoleName(ConstantUtil.SHRY_ROLE_NAME);
		return Result.success(datas);
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Result save(FxxmInfo fxxmInfo){
		if(StringUtils.isEmpty(fxxmInfo.getWid())){
			fxxmInfoService.insert(fxxmInfo);
		}else{
			fxxmInfoService.updateByPrimaryKeySelective(fxxmInfo);
		}
		return Result.success();
	}
	@RequestMapping("select")
	@ResponseBody
	public Result select(String wid){
		FxxmInfo fxxmInfo=null;
		if(StringUtils.isEmpty(wid)){
			fxxmInfo=new FxxmExtendInfo();
		}else{
			fxxmInfo =fxxmInfoService.selectByPrimaryKey(wid);
		}
		return Result.success(fxxmInfo);
		
	}
	@RequestMapping("delete")
	@ResponseBody
	public Result delete (String wid){
		fxxmInfoService.deleteByPrimaryKey(wid);
		return Result.success();
	}
}
