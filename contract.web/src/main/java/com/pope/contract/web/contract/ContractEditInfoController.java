package com.pope.contract.web.contract;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.contract.code.Result;
import com.pope.contract.dao.system.extend.FxxmInfoExtendMapper;
import com.pope.contract.entity.contract.ContractInfo;
import com.pope.contract.entity.contract.ContractInfoRel;
import com.pope.contract.entity.contract.ContractMoney;
import com.pope.contract.entity.contract.extend.ContractInfoExtend;
import com.pope.contract.entity.custom.CustomInfo;
import com.pope.contract.entity.custom.extend.CustomInfoExtend;
import com.pope.contract.entity.project.BatchInfo;
import com.pope.contract.entity.project.extend.BatchInfoExtend;
import com.pope.contract.entity.system.extend.FxxmExtendInfo;
import com.pope.contract.service.contract.ContractInfoRelService;
import com.pope.contract.service.contract.ContractInfoService;
import com.pope.contract.service.contract.ContractMoneyService;
import com.pope.contract.service.custom.CustomInfoService;
import com.pope.contract.service.project.BatchInfoService;
import com.pope.contract.service.system.FxxmInfoService;
import com.pope.contract.util.CommonUtil;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;
import com.pope.contract.web.BaseController;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月23日 下午1:10:31
* 类说明
*/
@Controller
@RequestMapping("contractEditInfo")
public class ContractEditInfoController extends BaseController{
	@Autowired
	private BatchInfoService batchInfoService;
	
	@Autowired
	private CustomInfoService customInfoService;
	
	@Autowired
	private FxxmInfoService fxxmInfoService;
	
	@Autowired
	private ContractInfoService contractInfoService;
	
	@Autowired
	private ContractInfoRelService contractInfoRelService;
	
	@Autowired
	private ContractMoneyService contractMoneyService;
	

	
	
	
	@RequestMapping("index")
	public ModelAndView index(String pcids,String firstPcid,String wid){
		ModelAndView mv=new ModelAndView();
		mv.addObject("pcids",pcids);
		mv.addObject("firstPcid",firstPcid);
		mv.addObject("wid",wid);
		mv.setViewName("contract/contractEditInfo");
		return mv;
	}
	
	@RequestMapping("viewIndex")
	public ModelAndView viewIndex(String wid){
		ModelAndView mv=new ModelAndView();
		mv.addObject("pcids","");
		mv.addObject("firstPcid","");
		mv.addObject("wid",wid);
		mv.setViewName("contract/contractViewInfo");
		return mv;
	}
	@RequestMapping("queryForm")
	@ResponseBody
	public Result queryForm(String pcid,String pcids) throws Exception{
		ContractInfoExtend contractInfoExtend=contractInfoService.getNewContractinfo(pcid, pcids);
	    return Result.success(contractInfoExtend);
	}
	@RequestMapping("queryContractInfo")
	@ResponseBody
	public Result queryContractInfo(String wid) throws Exception{
		ContractInfoExtend contractInfo=new ContractInfoExtend();
		contractInfo.setWid(wid);
		ContractInfoExtend contractInfoExtend=contractInfoService.selectSingleDisplayByCondition(contractInfo);
		return Result.success(contractInfoExtend);
	}
	@RequestMapping("queryBatchInfo")
	@ResponseBody
	public Result queryBatchInfo(String pcids,String wid) throws Exception{
		if(!StringUtils.isEmpty(wid)){
			ContractInfoRel contractInfoRel=new ContractInfoRel();
			contractInfoRel.setHtid(wid);
			List<ContractInfoRel> lstRel=contractInfoRelService.selectByCondition(contractInfoRel);
			if(CommonUtil.isNotEmptyList(lstRel)){
				for(ContractInfoRel rel:lstRel){
					pcids+=","+rel.getPcid();
				}
			}
			if(StringUtils.isEmpty(pcids)){
				pcids=pcids.substring(1);
			}
		}
		List<BatchInfoExtend> datas = batchInfoService.selectByWids(pcids);
		return Result.success(datas);
	}
	

	@RequestMapping("queryFxxmByBatchId")
	@ResponseBody
	public Result queryFxxmByBatchId(String pcid,String htid) throws Exception{
		List<FxxmExtendInfo> lstFxxm=fxxmInfoService.selectByBatchDetail(pcid,htid);
		return Result.success(lstFxxm);
	}
	
	@RequestMapping("saveContractInfo")
	@ResponseBody
	public Result saveContractInfo(ContractInfo contractInfo,String pcids) throws Exception{
		String wid=contractInfo.getWid();
		if(StringUtils.isEmpty(contractInfo.getWid())){
			wid=contractInfoService.insert(contractInfo,pcids, this.getUserId());
		}else{
			contractInfoService.updateByPrimaryKeySelective(contractInfo);
		}
		return Result.success(wid);
	}
	
	@RequestMapping("addFxxm")
	@ResponseBody
	public Result addFxxm(String htid,String pcid,String fxxms) throws Exception{
		contractInfoService.addFxxm(htid, pcid, fxxms, this.getUserId());
		return Result.success();
	}
	
	@RequestMapping("listContractFxxmMoney")
	@ResponseBody
	public Result listContractFxxmMoney(String htid) throws Exception{
		ContractMoney contractMoney=new ContractMoney();
		contractMoney.setHtid(htid);
		return Result.success(contractMoneyService.selectDispalyByCondition(contractMoney));
	}
	
}
