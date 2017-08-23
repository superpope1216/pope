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
import com.pope.contract.entity.project.extend.BatchInfoExtend;
import com.pope.contract.entity.supply.GmbInfo;
import com.pope.contract.entity.supply.LqbInfo;
import com.pope.contract.entity.supply.ShbInfo;
import com.pope.contract.entity.supply.SupplyInfo;
import com.pope.contract.entity.supply.extend.SupplyInfoExtend;
import com.pope.contract.service.supply.GmbInfoService;
import com.pope.contract.service.supply.LqbInfoService;
import com.pope.contract.service.supply.ShbInfoService;
import com.pope.contract.service.supply.SupplyInfoService;
import com.pope.contract.web.BaseController;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月15日 下午4:36:25
* 类说明
*/
@Controller
@RequestMapping("supply")
public class SupplyInfoController extends BaseController{

	@Autowired
	private SupplyInfoService supplyInfoService;
	
	@Autowired
	private LqbInfoService lqbInfoService;
	
	@Autowired
	private ShbInfoService shbInfoService;
	
	@Autowired
	private GmbInfoService gmbInfoService;
	@RequestMapping("index")
	public ModelAndView index(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("supply/supplyInfo");
		mv.addObject("buttons",this.getButtonPermission("/supply/index"));
		return mv;
	}
	@RequestMapping("view")
	@ResponseBody
	public Result view(String wid){
		if(StringUtil.isEmpty(wid)){
			SupplyInfo supplyInfo=new SupplyInfo();
			return Result.success(supplyInfo);
		}
		SupplyInfo supplyInfo=supplyInfoService.selectByPrimaryKey(wid);
		return Result.success(supplyInfo);
		
	}
	@RequestMapping("searchPm")
	@ResponseBody
	public Result searchPm(String hcfl) throws Exception{
		if(StringUtil.isEmpty(hcfl)){
			return Result.success(null);
		}
		return Result.success(supplyInfoService.selectPmByCondition(hcfl));
	}
	@RequestMapping("selectByHcflAndPm")
	@ResponseBody
	public Result selectByHcflAndPm(String hcfl,String pm) throws Exception{
		SupplyInfo supplyInfo=new SupplyInfo();
		supplyInfo.setHcfl(hcfl);
		supplyInfo.setPm(pm);
		return Result.success(supplyInfoService.selectSingleByCondition(supplyInfo));
	}
	@RequestMapping("viewDetail")
	@ResponseBody
	public Result viewDetail(String wid){
		SupplyInfo supply=new SupplyInfo();
		supply.setWid(wid);
		List<SupplyInfoExtend> details=supplyInfoService.selectDisplayByCondition(supply);
		return Result.success(details.get(0));
		
	}
	@RequestMapping("list")
	@ResponseBody
	public Result list(Integer startPage){
		PageParam<SupplyInfoExtend> pageParam = new PageParam<SupplyInfoExtend>();
		pageParam.setPage(startPage);
		Page<SupplyInfoExtend> page = PageHelper.startPage(pageParam.getPage(), pageParam.getPageSize());
		List<SupplyInfoExtend> users=supplyInfoService.selectDisplayByCondition(null);
		pageParam.setTotal(page.getTotal());
		pageParam.setTotalPage(pageParam.getTotalPage());
		pageParam.setData(users);
		return Result.success(pageParam);
	}
	@RequestMapping("save")
	@ResponseBody
	public Result save(SupplyInfo supplyInfo) throws Exception{
		if(StringUtil.isEmpty(supplyInfo.getWid())){
			supplyInfoService.insert(supplyInfo);
		}else{
			supplyInfoService.updateByPrimaryKeySelective(supplyInfo);
		}
		return Result.success();
	}
	
	@RequestMapping("toSlb")
	@ResponseBody
	public Result toSlb(String wid) throws Exception{
		SupplyInfo queryInfo=new SupplyInfo();
		queryInfo.setWid(wid);
		SupplyInfoExtend supplyInfo= supplyInfoService.selectDisplayByCondition(queryInfo).get(0);
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
		SupplyInfo queryInfo=new SupplyInfo();
		queryInfo.setWid(wid);
		SupplyInfoExtend supplyInfo= supplyInfoService.selectDisplayByCondition(queryInfo).get(0);
		return Result.success(supplyInfo);
	}
	
	@RequestMapping("saveShb")
	@ResponseBody
	public Result saveShb( ShbInfo shbInfo) throws Exception{
		shbInfoService.insert(shbInfo,this.getUserId());
		return Result.success();
	}
	
	@RequestMapping("deleteSupply")
	@ResponseBody
	public Result deleteSupply(String wid) throws Exception{
		supplyInfoService.deleteByPrimaryKey(wid);
		return Result.success();
	}
	
	@RequestMapping("toGmb")
	@ResponseBody
	public Result toGmb(String wid) throws Exception{
		SupplyInfo queryInfo=new SupplyInfo();
		queryInfo.setWid(wid);
		SupplyInfoExtend supplyInfo= supplyInfoService.selectDisplayByCondition(queryInfo).get(0);
		return Result.success(supplyInfo);
	}
	
	@RequestMapping("saveGmb")
	@ResponseBody
	public Result saveGmb( GmbInfo gmbInfo) throws Exception{
		gmbInfoService.insert(gmbInfo,this.getUserId());
		return Result.success();
	}
	
	
}
