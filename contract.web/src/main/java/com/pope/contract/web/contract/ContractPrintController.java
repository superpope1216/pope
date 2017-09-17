package com.pope.contract.web.contract;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.contract.code.Result;
import com.pope.contract.entity.contract.ContractFbsqdInfo;
import com.pope.contract.entity.contract.ContractInfoRel;
import com.pope.contract.entity.contract.ContractMoney;
import com.pope.contract.entity.contract.extend.ContractInfoExtend;
import com.pope.contract.entity.contract.extend.ContractMoneyExtend;
import com.pope.contract.entity.project.extend.BatchInfoExtend;
import com.pope.contract.service.contract.ContractFbsqdInfoService;
import com.pope.contract.service.contract.ContractInfoRelService;
import com.pope.contract.service.contract.ContractInfoService;
import com.pope.contract.service.contract.ContractMoneyService;
import com.pope.contract.service.project.BatchInfoService;
import com.pope.contract.util.CommonUtil;
import com.pope.contract.util.StringUtil;
import com.pope.contract.util.TempleWordUtil;
import com.pope.contract.web.BaseController;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年9月17日 下午5:04:20
* 类说明
*/
@Controller
@RequestMapping("contractPrint")
public class ContractPrintController extends BaseController{

	@Autowired
	private ContractInfoRelService contractInfoRelService;
	@Autowired
	private ContractMoneyService contractMoneyService;
	@Autowired
	private ContractInfoService contractInfoService; 
	@Autowired
	private BatchInfoService batchInfoService;
	@Autowired
	private ContractFbsqdInfoService contractFbsqdInfoService; 
	@RequestMapping("index")
	public ModelAndView index(String wid) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.addObject("wid",wid);
		mv.setViewName("contract/contractPrint");
		
		return mv;
	}
	
	@RequestMapping("select")
	@ResponseBody
	public Result select(String htid) throws Exception{
		ContractFbsqdInfo queryCntractFbsqdInfo=new ContractFbsqdInfo();
		queryCntractFbsqdInfo.setHtid(htid);
		ContractFbsqdInfo cntractFbsqdInfo=contractFbsqdInfoService.selectSingleByCondition(queryCntractFbsqdInfo);
		if(cntractFbsqdInfo==null){
			cntractFbsqdInfo=new ContractFbsqdInfo();
			ContractInfoRel queryContractInfoRel=new ContractInfoRel();
			queryContractInfoRel.setHtid(htid);
			List<ContractInfoRel> rels= contractInfoRelService.selectByCondition(queryContractInfoRel);
			if(CommonUtil.isNotEmptyList(rels)){
				ContractInfoRel contractInfoRel=rels.get(0);
				
				BatchInfoExtend queryBatchInfoExtend=new BatchInfoExtend();
				queryBatchInfoExtend.setWid(contractInfoRel.getPcid());
				List<BatchInfoExtend> batchInfos=batchInfoService.selectDisplayByCondition(queryBatchInfoExtend);
				if(CommonUtil.isNotEmptyList(batchInfos)){
					BatchInfoExtend batchInfoExtend=batchInfos.get(0);
					cntractFbsqdInfo.setYplb(batchInfoExtend.getPclb_display());
					cntractFbsqdInfo.setSyr(batchInfoExtend.getSyr());
					cntractFbsqdInfo.setWtsj(batchInfoExtend.getSysj());
				}
			}
			ContractMoney queryContractMoney=new ContractMoney();
			queryContractMoney.setHtid(htid);
			List<ContractMoneyExtend> lstContractFxxm=contractMoneyService.selectDispalyByCondition(queryContractMoney);
			if(CommonUtil.isNotEmptyList(lstContractFxxm)){
				int count=0;
				String fxxm="";
				for(ContractMoneyExtend aContractMoneyExtend:lstContractFxxm){
					count+=StringUtil.toInt(aContractMoneyExtend.getSl());
					fxxm+=","+aContractMoneyExtend.getFxxm_display();
				}
				if(!StringUtils.isEmpty(fxxm)){
					fxxm=fxxm.substring(1);
				}
				cntractFbsqdInfo.setYpsl(count);
				cntractFbsqdInfo.setFbxm(fxxm);
				
				
			}
			
			ContractInfoExtend queryContractInfoExtend=new ContractInfoExtend();
			queryContractInfoExtend.setWid(htid);
			ContractInfoExtend contractInfoExtend=contractInfoService.selectSingleDisplayByCondition(queryContractInfoExtend);
			cntractFbsqdInfo.setFbbh(contractInfoExtend.getHtbh());
			cntractFbsqdInfo.setFbsj(contractInfoExtend.getHtsj());
			 
			cntractFbsqdInfo.setHtid(htid);
		}
		return Result.success(cntractFbsqdInfo);
	}
	
	@ResponseBody
	@RequestMapping("save")
	public Result save(ContractFbsqdInfo contractFbsqdInfo) throws Exception{
		if(StringUtils.isEmpty(contractFbsqdInfo.getWid())){
			contractFbsqdInfoService.insertSelective(contractFbsqdInfo);
		}else{
			contractFbsqdInfoService.updateByPrimaryKeySelective(contractFbsqdInfo);
		}
		return Result.success();
	}
	
	@RequestMapping("download")
	public void download(String wid,HttpServletResponse response, HttpServletRequest request) throws Exception{
		String templatePath = request.getServletContext().getRealPath("") + "/static/fbsqb.docx";
		
	    String fileName = new String("分包申请表".getBytes("utf-8"), "ISO8859-1") + ".docx";
	    /*数据*/
	    Map<String, Object> params = new HashMap<String, Object>();  
	    ContractFbsqdInfo queryCntractFbsqdInfo=new ContractFbsqdInfo();
		queryCntractFbsqdInfo.setHtid(wid);
		ContractFbsqdInfo cntractFbsqdInfo=contractFbsqdInfoService.selectSingleByCondition(queryCntractFbsqdInfo);
	    params.put("${yplb}", cntractFbsqdInfo.getYplb());
	    params.put("${ypsl}",StringUtil.toStr(cntractFbsqdInfo.getYpsl()));
	    params.put("${wtbh}", cntractFbsqdInfo.getWtbh());
	    params.put("${fbbh}", cntractFbsqdInfo.getFbbh());
	    params.put("${fbxm}", cntractFbsqdInfo.getFbxm());
	    params.put("${fbsys}", cntractFbsqdInfo.getFbsys());
	    params.put("${syr}", cntractFbsqdInfo.getSyr());
	    params.put("${wtsj}", cntractFbsqdInfo.getWtsj());
	    params.put("${lyr}", cntractFbsqdInfo.getLyr());
	    params.put("${fbsj}", cntractFbsqdInfo.getFbsj());
	    params.put("${sqr}", cntractFbsqdInfo.getSqr());
	    params.put("${syszg}", cntractFbsqdInfo.getSyszg());
	    params.put("${fbkxxfx}", cntractFbsqdInfo.getFbkxxfx());
//	    params.put("${sex}", "bbbb");

	   TempleWordUtil wordUtil = new TempleWordUtil();

	    XWPFDocument doc;  
	    InputStream is = new FileInputStream(templatePath);
	  //  is = getClass().getClassLoader().getResourceAsStream(templatePath);  
	    doc = new XWPFDocument(is);   //只能使用.docx的

	    wordUtil.replaceInPara(doc, params);  
	    //替换表格里面的变量  
	    wordUtil.replaceInTable(doc, params);  
	    OutputStream os = response.getOutputStream();  

	    response.setContentType("application/vnd.ms-excel");  
	    response.setHeader("Content-disposition", "attachment;filename=" + fileName);  

	    doc.write(os);  

	    wordUtil.close(os);  
	    wordUtil.close(is);  

	    os.flush();  
	    os.close();  
	}
	
}
