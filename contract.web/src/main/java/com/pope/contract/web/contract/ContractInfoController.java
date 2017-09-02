package com.pope.contract.web.contract;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.pope.contract.entity.project.extend.BatchInfoExtend;
import com.pope.contract.service.contract.ContractInfoService;
import com.pope.contract.util.CommonUtil;
import com.pope.contract.util.ExportExcel;
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
	public Result list(Integer startPage,String querySyr,String queryHtb,String queryYppch,String queryFxxm) throws Exception{
		PageUtil<ContractInfoExtend> pageUtil = new PageUtil<ContractInfoExtend>(startPage);
		ContractInfoExtend contractInfo=new ContractInfoExtend();
		contractInfo.setDatastatus(StringUtil.toStr(DataStatus.normal.getCode()));
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
	public void export(HttpServletResponse response) throws Exception{
		List<ContractInfoExtend> datas =contractInfoService.selectDisplayByCondition(null);
		String[] headers=new String[20];
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
		headers[10]="备注";
		List<List<String>> list=new ArrayList<List<String>>();
		if(CommonUtil.isNotEmptyList(datas)){
			
			for(ContractInfoExtend extend:datas){
				List<String> data=new ArrayList<String>();
				list.add(data);
				data.add(StringUtil.toStr(extend.getHtlx_display()));
				data.add(StringUtil.toStr(extend.getHtmc()));
				data.add(StringUtil.toStr(extend.getHtbh()));
				data.add(StringUtil.toStr(extend.getHtjf_display()));
				data.add(StringUtil.toStr(extend.getHtje()));
				data.add(StringUtil.toStr(extend.getHtzk_display()));
				data.add(StringUtil.toStr(extend.getHtsj()));
				data.add(StringUtil.toStr(extend.getHtzxsj()));
				data.add(StringUtil.toStr(extend.getDfzh()));
				data.add(StringUtil.toStr(extend.getBz()));
				
			}
		}
		ExportExcel.doExportExcel2("样品批次信息","样品批次信息",  headers, list,response);
	}
	
}
