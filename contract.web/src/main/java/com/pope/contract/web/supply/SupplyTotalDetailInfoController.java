package com.pope.contract.web.supply;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.contract.code.FlowStateCode;
import com.pope.contract.code.Result;
import com.pope.contract.code.TaskStatusEnum;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.supply.GmbInfo;
import com.pope.contract.entity.supply.LqbInfo;
import com.pope.contract.entity.supply.ShbInfo;
import com.pope.contract.entity.supply.extend.GmbInfoExtend;
import com.pope.contract.entity.supply.extend.LqbInfoExtend;
import com.pope.contract.entity.supply.extend.ShbInfoExtend;
import com.pope.contract.service.supply.GmbInfoService;
import com.pope.contract.service.supply.LqbInfoService;
import com.pope.contract.service.supply.ShbInfoService;
import com.pope.contract.util.ConstantUtil;
import com.pope.contract.util.StringUtil;
import com.pope.contract.web.BaseController;
import com.pope.contract.web.util.PageUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月26日 下午11:20:17
* 类说明
*/
@Controller
@RequestMapping("supplyTotalDetailInfo")
public class SupplyTotalDetailInfoController extends BaseController {
	@Autowired
	private LqbInfoService lqbInfoService;
	

	@Autowired
	private GmbInfoService gmbInfoService;
	@Autowired
	private ShbInfoService shbInfoService;
	@RequestMapping("index")
	public ModelAndView index(String hcid){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("supply/supplyTotalDetailInfo");
		mv.addObject("hcid",hcid);
		return mv;
	}
	@ResponseBody
	@RequestMapping("listLyd")
	public Result listLyd(Integer startPage,String hcid) throws Exception{
		LqbInfo taskInfo=new LqbInfo();
		if(!this.getRole().getName().equals(ConstantUtil.SYSTEM_MANAGE)){
			taskInfo.setUserid(this.getUserId());
		}
		if(!StringUtils.isEmpty(hcid)){
			taskInfo.setHcid(hcid);
		}
		PageUtil<LqbInfoExtend> pageUtil=new PageUtil<LqbInfoExtend>(startPage);
		List<LqbInfoExtend> datas=lqbInfoService.selectDispalyTaskInfoByCondition(taskInfo);
		PageParam<LqbInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping("listShd")
	@ResponseBody
	public Result listShd(Integer startPage,String hcid) throws Exception{
		ShbInfo taskInfo=new ShbInfo();
		if(!this.getRole().getName().equals(ConstantUtil.SYSTEM_MANAGE)){
			taskInfo.setUserid(this.getUserId());
		}
		if(!StringUtils.isEmpty(hcid)){
			taskInfo.setHcid(hcid);
		}
		PageUtil<ShbInfoExtend> pageUtil=new PageUtil<ShbInfoExtend>(startPage);
		List<ShbInfoExtend> datas=shbInfoService.selectDispalyTaskInfoByCondition(taskInfo);
		PageParam<ShbInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping("listSgd")
	@ResponseBody
	public Result listSgd(Integer startPage,String hcid) throws Exception{
		GmbInfo taskInfo=new GmbInfo();
		if(!this.getRole().getName().equals(ConstantUtil.SYSTEM_MANAGE)){
			taskInfo.setUserid(this.getUserId());
		}
		if(!StringUtils.isEmpty(hcid)){
			taskInfo.setHcid(hcid);
		}
		PageUtil<GmbInfoExtend> pageUtil=new PageUtil<GmbInfoExtend>(startPage);
		List<GmbInfoExtend> datas=gmbInfoService.selectDispalyTaskInfoByCondition(taskInfo);
		PageParam<GmbInfoExtend> pageParam=pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
}
