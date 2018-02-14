package com.pope.contract.web.custom;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.StringUtil;
import com.pope.contract.code.DataStatus;
import com.pope.contract.code.Result;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.contract.extend.ContractInfoExtend;
import com.pope.contract.entity.custom.CustomAccount;
import com.pope.contract.entity.custom.CustomInfo;
import com.pope.contract.entity.custom.CustomUpdateLog;
import com.pope.contract.entity.custom.extend.CustomAccountExtend;
import com.pope.contract.entity.custom.extend.CustomMoneyLogExtend;
import com.pope.contract.service.contract.ContractInfoService;
import com.pope.contract.service.custom.CustomAccountService;
import com.pope.contract.service.custom.CustomInfoService;
import com.pope.contract.service.custom.CustomMoneyLogService;
import com.pope.contract.service.custom.CustomUpdateLogService;
import com.pope.contract.web.BaseController;
import com.pope.contract.web.util.PageUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年9月2日 下午7:59:16
* 类说明
*/
@Controller
@RequestMapping("customInfoDetail")
public class CustomInfoDetailController extends BaseController{

	@Autowired
	private CustomInfoService customInfoService;
	@Autowired
	private CustomMoneyLogService customMoneyLogService; 
	@Autowired
	private CustomAccountService customAccountService;
	@Autowired
	private ContractInfoService contractInfoService;
	
	@Autowired
	private CustomUpdateLogService customUpdateLogService;
	@RequestMapping("index")
	public ModelAndView index(String wid) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("wid",wid);
		mv.setViewName("custom/customInfoDetail");
		return mv;
	}
	
	@RequestMapping("selectCustomInfo")
	@ResponseBody
	public Result selectCustomInfo(String wid) throws Exception{
		CustomAccountExtend queryCustomInfo=new CustomAccountExtend();
		queryCustomInfo.setWid(wid);
		CustomAccountExtend customAccountExtend=customAccountService.selectSingleDisplayByCondition(queryCustomInfo);
		return Result.success(customAccountExtend);
	}
	
	/**
	 * 获取账号余额变动记录
	 * @param accountId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("selectCustomAccountUpdataLog")
	@ResponseBody
	public Result selectCustomAccountUpdataLog(Integer startPage ,String accountId) throws Exception{
		PageUtil<CustomUpdateLog> pageUtil = new PageUtil<CustomUpdateLog>(startPage);
		CustomUpdateLog queryCustomUpdateLog=new CustomUpdateLog();
		queryCustomUpdateLog.setAccountId(accountId);
		List<CustomUpdateLog> datas=customUpdateLogService.selectByCondition(queryCustomUpdateLog);
		PageParam<CustomUpdateLog> pageParam = pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	
	@RequestMapping("selectCustomAccountMoneyLog")
	@ResponseBody
	public Result selectCustomAccountMoneyLog(Integer startPage,String accountId) throws Exception{
		PageUtil<CustomMoneyLogExtend> pageUtil = new PageUtil<CustomMoneyLogExtend>(startPage);
		List<CustomMoneyLogExtend> datas=null;
			CustomMoneyLogExtend queryCutomMoneyLogExtend=new CustomMoneyLogExtend();
			queryCutomMoneyLogExtend.setAccountId(accountId);
			datas=customMoneyLogService.selectDisplayByCondition(queryCutomMoneyLogExtend);
		PageParam<CustomMoneyLogExtend> pageParam = pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	@RequestMapping("deleteAccount")
	@ResponseBody
	public Result deleteAccount(String wid) throws Exception{
		CustomAccount customAccount=new CustomAccount();
		customAccount.setWid(wid);
		customAccount.setDatastatus(com.pope.contract.util.StringUtil.toStr(DataStatus.delete.getCode()));
		customAccountService.updateByPrimaryKeySelective(customAccount, this.getUserId());
		//customAccountService.deleteByPrimaryKey(wid, this.getUserId());
		return Result.success();
	}
}
