package com.pope.contract.web.contract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.contract.code.DataStatus;
import com.pope.contract.code.Result;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.contract.ContractInfo;
import com.pope.contract.entity.contract.extend.ContractInfoExtend;
import com.pope.contract.entity.custom.extend.CustomInfoExtend;
import com.pope.contract.service.contract.ContractInfoService;
import com.pope.contract.util.StringUtil;
import com.pope.contract.web.BaseController;
import com.pope.contract.web.util.PageUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月22日 下午5:49:13
* 类说明
*/
@Controller
@RequestMapping("contractInfo")
public class ContractInfoController extends BaseController{

	@Autowired
	private ContractInfoService contractInfoService;
	@RequestMapping("index")
	public ModelAndView index(String pcid){
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("contract/contractInfo");
		mv.addObject("buttons",this.getButtonPermission("/contractInfo/index"));
		return mv;
	}
	
	@RequestMapping("add")
	public ModelAndView add(String pcids){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("contract/contractEditInfo");
		return mv;
	}
	@RequestMapping("list")
	@ResponseBody
	public Result list(Integer startPage) throws Exception{
		PageUtil<ContractInfoExtend> pageUtil = new PageUtil<ContractInfoExtend>(startPage);
		ContractInfo contractInfo=new ContractInfo();
		contractInfo.setDatastatus(StringUtil.toStr(DataStatus.normal.getCode()));
		List<ContractInfoExtend> datas =contractInfoService.selectDisplayByCondition(contractInfo);
		PageParam<ContractInfoExtend> pageParam = pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
}
