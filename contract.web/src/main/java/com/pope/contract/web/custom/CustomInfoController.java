package com.pope.contract.web.custom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.contract.code.DataStatus;
import com.pope.contract.code.Result;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.custom.CustomAccount;
import com.pope.contract.entity.custom.CustomInfo;
import com.pope.contract.entity.custom.extend.CustomInfoExtend;
import com.pope.contract.entity.task.extend.TaskInfoExtend;
import com.pope.contract.service.custom.CustomAccountService;
import com.pope.contract.service.custom.CustomInfoService;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;
import com.pope.contract.web.BaseController;
import com.pope.contract.web.util.PageUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月20日 下午8:54:14
* 类说明
*/
@Controller
@RequestMapping("custom")
public class CustomInfoController extends BaseController{

	@Autowired
	private CustomInfoService customInfoService;
	@Autowired
	private CustomAccountService customAccountService; 
	@RequestMapping("index")
	public ModelAndView index(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("custom/customInfo");
		mv.addObject("buttons",this.getButtonPermission("/custom/index"));
		return mv;
	}
	@RequestMapping("list")
	@ResponseBody
	public Result list(Integer startPage){
		PageUtil<CustomInfoExtend> pageUtil = new PageUtil<CustomInfoExtend>(startPage);
		CustomInfo customInfo=new CustomInfo();
		customInfo.setDatastatus(StringUtil.toStr(DataStatus.normal.getCode()));
		List<CustomInfoExtend> datas=customInfoService.selectDisplayByCondition(customInfo);
		PageParam<CustomInfoExtend> pageParam = pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Result save(CustomInfo customInfo) throws Exception{
		if(StringUtils.isEmpty(customInfo.getWid())){
			customInfoService.insert(customInfo, this.getUserId());
		}else{
			customInfoService.updateByPrimaryKeySelective(customInfo);
		}
		return Result.success();
	}
	@RequestMapping("edit")
	@ResponseBody
	public Result edit(String wid) throws Exception{
		CustomInfo customInfo=null;
		if(StringUtils.isEmpty(wid)){
			customInfo=new CustomInfo();
			Integer max=customInfoService.selectMaxBh();
			String sMax=String.format("%05d",max);
			String month=DateUtil.format(DateUtil.getCurrentDate(),"yyyyMM");
			sMax=month+sMax;
			customInfo.setDqbh(max);
			customInfo.setCustomNumber(sMax);
		}else{
			customInfo=customInfoService.selectByPrimaryKey(wid);
		}
		return Result.success(customInfo);
	}
	@RequestMapping("deleteCustom")
	@ResponseBody
	public Result deleteCustom(String wid) throws Exception{
		CustomInfo customInfo=new CustomInfo();
		customInfo.setWid(wid);
		customInfo.setDatastatus(StringUtil.toStr(DataStatus.delete.getCode()));
		customInfoService.updateByPrimaryKeySelective(customInfo);
		return Result.success();
	}
	
	@RequestMapping("addCustomAccount")
	@ResponseBody
	public Result addCustomAccount(String customId) throws Exception{
		customAccountService.checkAddCustomAccount(customId);
		Integer max=customAccountService.selectMax();
		if(max==null){
			max=0;
		}
		max++;
		String sMax=String.format("%05d",max);
		String month=DateUtil.format(DateUtil.getCurrentDate(),"yyyyMM");
		sMax=month+sMax;
		CustomAccount customAccount=new CustomAccount();
		customAccount.setDqbh(max);
		customAccount.setCustomId(customId);
		customAccount.setAccountNumber(sMax);
		return Result.success(customAccount);
	}
	@RequestMapping("saveCustomAccount")
	@ResponseBody
	public Result saveCustomAccount(CustomAccount customAccount) throws Exception{
		customAccountService.insert(customAccount,this.getUserId());
		return Result.success();
	}
}
