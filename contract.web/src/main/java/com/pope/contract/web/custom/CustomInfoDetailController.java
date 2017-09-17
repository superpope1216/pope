package com.pope.contract.web.custom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.pope.contract.code.Result;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.contract.extend.ContractInfoExtend;
import com.pope.contract.entity.custom.CustomInfo;
import com.pope.contract.entity.custom.extend.CustomAccountExtend;
import com.pope.contract.entity.custom.extend.CustomMoneyLogExtend;
import com.pope.contract.service.contract.ContractInfoService;
import com.pope.contract.service.custom.CustomAccountService;
import com.pope.contract.service.custom.CustomInfoService;
import com.pope.contract.service.custom.CustomMoneyLogService;
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
	
	@RequestMapping("contractInfoList")
	@ResponseBody
	public Result contractInfoList(Integer startPage,String customId) throws Exception{
		CustomAccountExtend queryAccountInfo=new CustomAccountExtend();
		queryAccountInfo.setWid(customId);
		CustomAccountExtend customAccountExtend=customAccountService.selectSingleDisplayByCondition(queryAccountInfo);
		
		CustomMoneyLogExtend queryCutomMoneyLogExtend=new CustomMoneyLogExtend();
		queryCutomMoneyLogExtend.setCustomId(customAccountExtend.getCustomId());
		
		CustomAccountExtend queryCustomInfo=new CustomAccountExtend();
		queryCustomInfo.setCustomId(customAccountExtend.getCustomId());
		//CustomAccountExtend customAccountExtend=customAccountService.selectSingleDisplayByCondition(queryCustomInfo);
		
		PageUtil<CustomMoneyLogExtend> pageUtil = new PageUtil<CustomMoneyLogExtend>(startPage);
		List<CustomMoneyLogExtend> datas=customMoneyLogService.selectDisplayByCondition(queryCutomMoneyLogExtend);
		PageParam<CustomMoneyLogExtend> pageParam = pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
}
