package com.pope.contract.web.supply;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.pope.contract.code.Result;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.custom.extend.CustomInfoExtend;
import com.pope.contract.entity.project.extend.BatchInfoExtend;
import com.pope.contract.entity.supply.GmbInfo;
import com.pope.contract.entity.supply.LqbInfo;
import com.pope.contract.entity.supply.ShbInfo;
import com.pope.contract.entity.supply.SupplyInfo;
import com.pope.contract.entity.supply.SupplyTotalInfo;
import com.pope.contract.entity.supply.extend.SupplyInfoExtend;
import com.pope.contract.entity.supply.extend.SupplyTotalInfoExtend;
import com.pope.contract.service.supply.GmbInfoService;
import com.pope.contract.service.supply.LqbInfoService;
import com.pope.contract.service.supply.ShbInfoService;
import com.pope.contract.service.supply.SupplyInfoService;
import com.pope.contract.service.supply.SupplyTotalInfoService;
import com.pope.contract.web.BaseController;
import com.pope.contract.web.util.PageUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月15日 下午4:36:25
* 类说明
*/
@Controller
@RequestMapping("supplyTotal")
public class SupplyTotalInfoController extends BaseController{

	@Autowired
	private SupplyTotalInfoService supplyTotalInfoService;
	
	@Autowired
	private LqbInfoService lqbInfoService;
	
	@Autowired
	private ShbInfoService shbInfoService;
	
	@Autowired
	private GmbInfoService gmbInfoService;
	@RequestMapping("index")
	public ModelAndView index(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("supply/supplyTotalInfo");
		mv.addObject("buttons",this.getButtonPermission("/supplyTotal/index"));
		return mv;
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Result list(Integer startPage,String queryCodition){
		PageUtil<SupplyTotalInfoExtend> pageUtil = new PageUtil<SupplyTotalInfoExtend>(startPage);
		SupplyTotalInfoExtend supplyTotalInfoExtend=new SupplyTotalInfoExtend();
		if(!StringUtil.isEmpty(queryCodition)){
			queryCodition=queryCodition.trim();
			supplyTotalInfoExtend.setQueryCondition(queryCodition);
		}
		List<SupplyTotalInfoExtend> users=supplyTotalInfoService.selectDisplayByCondition(supplyTotalInfoExtend);
		PageParam<SupplyTotalInfoExtend> pageParam = pageUtil.getPageParam(users);
		return Result.success(pageParam);
	}
	@RequestMapping("select")
	@ResponseBody
	public Result select(String wid) throws Exception{
		SupplyTotalInfoExtend supplyTotalInfoExtend=new SupplyTotalInfoExtend();
		supplyTotalInfoExtend.setWid(wid);
		return Result.success(supplyTotalInfoService.selectDisplayByCondition(supplyTotalInfoExtend).get(0));
	}
	
	@RequestMapping("toSlb")
	@ResponseBody
	public Result toSlb(String wid) throws Exception{
		SupplyTotalInfoExtend queryInfo=new SupplyTotalInfoExtend();
		queryInfo.setWid(wid);
		SupplyTotalInfoExtend supplyInfo= supplyTotalInfoService.selectDisplayByCondition(queryInfo).get(0);
		return Result.success(supplyInfo);
	}
	
	@RequestMapping("saveSlb")
	@ResponseBody
	public Result saveSlb( LqbInfo lqbInfo) throws Exception{
		if(StringUtils.isEmpty(lqbInfo.getWid())){
			lqbInfoService.insert(lqbInfo,this.getUserId());	
		}else{
			lqbInfoService.updateByPrimaryKeySelective(lqbInfo);
		}
		
		return Result.success();
	}
	
	@RequestMapping("toShb")
	@ResponseBody
	public Result toShb(String wid) throws Exception{
		SupplyTotalInfoExtend queryInfo=new SupplyTotalInfoExtend();
		queryInfo.setWid(wid);
		SupplyTotalInfoExtend supplyInfo= supplyTotalInfoService.selectDisplayByCondition(queryInfo).get(0);
		return Result.success(supplyInfo);
	}
	
	@RequestMapping("saveShb")
	@ResponseBody
	public Result saveShb( ShbInfo shbInfo) throws Exception{
		shbInfoService.insert(shbInfo,this.getUserId());
		return Result.success();
	}
	
	
	@RequestMapping("toGmb")
	@ResponseBody
	public Result toGmb(String wid) throws Exception{
		SupplyTotalInfoExtend queryInfo=new SupplyTotalInfoExtend();
		queryInfo.setWid(wid);
		SupplyTotalInfoExtend supplyInfo= supplyTotalInfoService.selectDisplayByCondition(queryInfo).get(0);
		return Result.success(supplyInfo);
	}
	
	@RequestMapping("saveGmb")
	@ResponseBody
	public Result saveGmb( GmbInfo gmbInfo) throws Exception{
		gmbInfoService.insert(gmbInfo,this.getUserId());
		return Result.success();
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Result save(SupplyTotalInfo supplyTotalInfo) throws Exception{
		supplyTotalInfoService.updateByPrimaryKeySelective(supplyTotalInfo);
		return Result.success();
	}
	
}
