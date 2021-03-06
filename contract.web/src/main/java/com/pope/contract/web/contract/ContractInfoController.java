package com.pope.contract.web.contract;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.contract.code.ContractStateEnum;
import com.pope.contract.code.DataStatus;
import com.pope.contract.code.Result;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.contract.ContractInfo;
import com.pope.contract.entity.contract.extend.ContractInfoExtend;
import com.pope.contract.entity.custom.extend.CustomInfoExtend;
import com.pope.contract.entity.project.extend.BatchInfoExtend;
import com.pope.contract.service.contract.ContractInfoService;
import com.pope.contract.util.CommonUtil;
import com.pope.contract.util.ExportExcel;
import com.pope.contract.util.StringUtil;
import com.pope.contract.util.TempleWordUtil;
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
	
	@RequestMapping("guidang")
	@ResponseBody
	public Result guidang(String wid) throws Exception{
		ContractInfo contractInfo=new ContractInfo();
		contractInfo.setWid(wid);
		contractInfo.setRwzt(ContractStateEnum.YGD.getCode());
		contractInfoService.updateByPrimaryKeySelective(contractInfo);
		return Result.success();
	}
	@RequestMapping("add")
	public ModelAndView add(String pcids){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("contract/contractEditInfo");
		return mv;
	}
	@RequestMapping("list")
	@ResponseBody
	public Result list(Integer startPage,String querySyr,String queryHtb,String queryYppch,String queryFxxm) throws Exception{
		PageUtil<ContractInfoExtend> pageUtil = new PageUtil<ContractInfoExtend>(startPage);
		ContractInfoExtend contractInfo=new ContractInfoExtend();
		contractInfo.setDatastatus(StringUtil.toStr(DataStatus.normal.getCode()));
		if(!StringUtils.isEmpty(querySyr)){
			querySyr=querySyr.trim();
		}
		if(!StringUtils.isEmpty(queryHtb)){
			queryHtb=queryHtb.trim();
		}
		if(!StringUtils.isEmpty(queryYppch)){
			queryYppch=queryYppch.trim();
		}
		if(!StringUtils.isEmpty(queryFxxm)){
			queryFxxm=queryFxxm.trim();
		}
		contractInfo.setQueryFxxh(queryFxxm);
		contractInfo.setQueryHth(queryHtb);
		contractInfo.setQuerySyr(querySyr);
		contractInfo.setQueryYppch(queryYppch);
		List<ContractInfoExtend> datas =contractInfoService.selectDisplayByCondition(contractInfo);
		PageParam<ContractInfoExtend> pageParam = pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	/**
	 * 提交审核
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("submitContract")
	@ResponseBody
	public Result submitContract(String wids) throws Exception{
		contractInfoService.submitContract(wids, this.getUserId());
		return Result.success();
		
	}
	

	@RequestMapping("export")
	public void export(String querySyr,String queryHtb,String queryYppch,String queryFxxm,HttpServletResponse response) throws Exception{
		ContractInfoExtend contractInfo=new ContractInfoExtend();
		contractInfo.setDatastatus(StringUtil.toStr(DataStatus.normal.getCode()));
		contractInfo.setQueryFxxh(queryFxxm);
		contractInfo.setQueryHth(queryHtb);
		contractInfo.setQuerySyr(querySyr);
		contractInfo.setQueryYppch(queryYppch);
		List<ContractInfoExtend> datas =contractInfoService.selectDisplayByCondition(contractInfo);
		String[] headers=new String[12];
		headers[0]="合同类型";
		headers[1]="合同名称";
		headers[2]="合同编号";
		headers[3]="合同甲方";
		headers[4]="项目负责人";
		headers[5]="合同金额";
		headers[6]="合同折扣";
		headers[7]="合同时间";
		headers[8]="合同执行时间";
		headers[9]="对方账号";
		headers[10]="合同状态";
		headers[11]="备注";
		List<List<String>> list=new ArrayList<List<String>>();
		if(CommonUtil.isNotEmptyList(datas)){
			
			for(ContractInfoExtend extend:datas){
				List<String> data=new ArrayList<String>();
				list.add(data);
				data.add(StringUtil.toStr(extend.getHtlx_display()));
				data.add(StringUtil.toStr(extend.getHtmc()));
				data.add(StringUtil.toStr(extend.getHtbh()));
				data.add(StringUtil.toStr(extend.getHtjf_display()));
				data.add(StringUtil.toStr(extend.getXmfzr()));
				
				data.add(StringUtil.toStr(extend.getHtje()));
				data.add(StringUtil.toStr(extend.getHtzk_display()));
				data.add(StringUtil.toStr(extend.getHtsj()));
				data.add(StringUtil.toStr(extend.getHtzxsj()));
				data.add(StringUtil.toStr(extend.getDfzh()));
				data.add(StringUtil.toStr(extend.getHtzt_display()));
				data.add(StringUtil.toStr(extend.getBz()));
				
			}
		}
		ExportExcel.doExportExcel2("合同信息","合同信息",  headers, list,response);
	}
	
	@ResponseBody
	@RequestMapping("delete")
	public Result delete(String wid) throws Exception{
		contractInfoService.deleteContractInfo(wid);
		return Result.success();
	}
	
	
}
