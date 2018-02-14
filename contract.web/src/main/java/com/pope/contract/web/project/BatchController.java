package com.pope.contract.web.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.contract.code.BatchStateEnum;
import com.pope.contract.code.DataStatus;
import com.pope.contract.code.Result;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.custom.CustomInfo;
import com.pope.contract.entity.custom.extend.CustomInfoExtend;
import com.pope.contract.entity.project.BatchInfo;
import com.pope.contract.entity.project.BatchInfoDetail;
import com.pope.contract.entity.project.extend.BatchInfoDetailExtend;
import com.pope.contract.entity.project.extend.BatchInfoExtend;
import com.pope.contract.entity.user.UserInfo;
import com.pope.contract.exception.ServiceException;
import com.pope.contract.service.custom.CustomInfoService;
import com.pope.contract.service.project.BatchInfoService;
import com.pope.contract.util.CommonUtil;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.ExportExcel;
import com.pope.contract.util.StringUtil;
import com.pope.contract.web.BaseController;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月13日 下午1:52:52
* 类说明
*/
@Controller
@RequestMapping("batch")
public class BatchController extends BaseController{
	@Autowired
	private BatchInfoService batchInfoService;
	
	@Autowired
	private CustomInfoService customInfoService;
	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("buttons",this.getButtonPermission("/batch/index"));
		mv.setViewName("project/batchInfo");
		return mv;
	}
	
	@RequestMapping("checkBatchInfo")
	@ResponseBody
	public Result checkBatchInfo(@RequestParam String wid){
		BatchInfo batchInfo=batchInfoService.selectByPrimaryKey(wid);
		if(BatchStateEnum.DC.getCode()!=StringUtil.toInt(batchInfo.getPczt())){
			return Result.error("当前样品批次状态不是【待测】，请重新确认！");
		}
		return Result.success();
	}
	@RequestMapping("checkContractInfo")
	@ResponseBody
	public Result checkContractInfo(@RequestParam String wids) throws Exception{
		BatchInfo batchInfo=batchInfoService.checkCreateContract(wids);
		return Result.success(batchInfo);
		
	}
	
	
	@RequestMapping("detailIndex")
	public ModelAndView detailIndex(String wid,String type) {
		if(wid==null){
			wid="";
		}
		if(type==null){
			type="";
		}
		ModelAndView mv=new ModelAndView();
		mv.addObject("wid", wid);
		mv.addObject("type", type);
		mv.setViewName("project/batchInfoDetail");
		return mv;
	}
	
	@RequestMapping("detailIndexView")
	public ModelAndView detailIndexView(String wid,String type) {
		if(wid==null){
			wid="";
		}
		if(type==null){
			type="";
		}
		ModelAndView mv=new ModelAndView();
		mv.addObject("wid", wid);
		mv.addObject("type", type);
		mv.setViewName("project/batchInfoDetailView");;
		return mv;
	}

	
	@RequestMapping(value="list",method=RequestMethod.GET)
	@ResponseBody
	public Result list(Integer startPage,String queryCondition) throws Exception{
		if(startPage==null ||startPage<0){
			startPage=0;
		}
		PageParam<BatchInfoExtend> pageParam = new PageParam<BatchInfoExtend>();
		pageParam.setPage(startPage);
		Page<BatchInfoExtend> page = PageHelper.startPage(pageParam.getPage(), pageParam.getPageSize());
		BatchInfoExtend queryInfoExtend=new BatchInfoExtend();
		if(!StringUtils.isEmpty(queryCondition)){
			queryInfoExtend.setQueryCondition(queryCondition.trim());
		}
		queryInfoExtend.setQueryCondition(queryCondition);
		List<BatchInfoExtend> users=batchInfoService.selectDisplayByCondition(queryInfoExtend);
		pageParam.setTotal(page.getTotal());
		pageParam.setTotalPage(pageParam.getTotalPage());
		pageParam.setData(users);
		return Result.success(pageParam);
	}
	@RequestMapping("detail")
	@ResponseBody
	public Result details(String wid) throws Exception{
		if(StringUtils.isEmpty(wid)){
			BatchInfo batch=batchInfoService.getNewBatchInfo();
			return Result.success(batch);
		}else{
			BatchInfoExtend batchInfo=new BatchInfoExtend();
			batchInfo.setWid(wid);
			return Result.success(batchInfoService.selectDisplayByCondition(batchInfo).get(0));
		}
	}
	
	@RequestMapping("detailView")
	@ResponseBody
	public Result detailView(String wid) throws Exception{
			BatchInfoExtend batchInfo=new BatchInfoExtend();
			batchInfo.setWid(wid);
			List<BatchInfoExtend> datas=batchInfoService.selectDisplayByCondition(batchInfo);
			return Result.success(datas.get(0));
		
	}
	
	@RequestMapping("saveBatchInfo")
	@ResponseBody
	public Result saveBatchInfo(BatchInfo batchInfo) throws Exception{
		if(StringUtils.isEmpty(batchInfo.getWid())){
			batchInfo=batchInfoService.insertBatchInfo(batchInfo,this.getUserId());
		}else{
			batchInfoService.updateBatchInfo(batchInfo);
		}
		return Result.success(batchInfo);
	}
	
	@RequestMapping("addDetail")
	@ResponseBody
	public Result addDetail(String wid) throws Exception{
		return Result.success(batchInfoService.getNewBatchInfoDetail(wid));
	}
	
	@RequestMapping("saveDetail")
	@ResponseBody
	public Result saveDetail(BatchInfoDetail batchInfoDetail) throws Exception{
		if(StringUtils.isEmpty(batchInfoDetail.getWid())){
			batchInfoService.insertBatchInfoDetail(batchInfoDetail);
		}else{
			batchInfoService.updateBatchInfoDetail(batchInfoDetail);
		}
		return Result.success(batchInfoDetail);
	}
	
	
	@RequestMapping(value="detail_list",method=RequestMethod.GET)
	@ResponseBody
	public Result detailList(Integer startPage,String pcwid) throws Exception{
		if(startPage==null ||startPage<0){
			startPage=0;
		}
		
		PageParam<BatchInfoDetailExtend> pageParam = new PageParam<BatchInfoDetailExtend>();
		pageParam.setPage(startPage);
		
		List<BatchInfoDetailExtend> users=null;
		if(StringUtils.isEmpty(pcwid)){
			users=new ArrayList<BatchInfoDetailExtend>();
			pageParam.setTotal(0L);
			pageParam.setTotalPage(0);
			
		}else{
			Page<BatchInfoDetailExtend> page = PageHelper.startPage(pageParam.getPage(), pageParam.getPageSize());
			BatchInfoDetail batchInfoDetail=new BatchInfoDetail();
			batchInfoDetail.setPcwid(pcwid);
			users=batchInfoService.selectDetailDisplayByCondition(batchInfoDetail);
			pageParam.setTotal(page.getTotal());
			pageParam.setTotalPage(pageParam.getTotalPage());
		}
		pageParam.setData(users);
		
		return Result.success(pageParam);
	}
	@RequestMapping("copyBatch")
	@ResponseBody
	public Result copyBatch(String wid) throws Exception{
		String newWid=batchInfoService.copyBatchInfo(wid,this.getUserId());
		return Result.success(newWid);
	}
	@RequestMapping("deleteBatch")
	@ResponseBody
	public Result deleteBatch(String wid) throws Exception{
		batchInfoService.deleteBatchInfo(wid);
		return Result.success();
	}
	@RequestMapping("deleteBatchBatchInfo")
	@ResponseBody
	public Result deleteBatchBatchInfo(String wids) throws Exception{
		batchInfoService.deleteBatchBatchInfo(wids);
		return Result.success();
	}
	@RequestMapping("deleteBatchDetail")
	@ResponseBody
	public Result deleteBatchDetail(String wid) throws Exception{
		batchInfoService.deleteBatchInfoDetail(wid);
		return Result.success();
	}
	@RequestMapping("selectCustomInfos")
	@ResponseBody
	public Result selectCustomInfos() throws Exception{
		CustomInfoExtend customInfo=new CustomInfoExtend();
		customInfo.setDatastatus(StringUtil.toStr(DataStatus.normal.getCode()));
		List<CustomInfo> datas=customInfoService.selectByCondition(customInfo);
		return Result.success(datas);
	}
	
	/**
	 * 
	 * @param wid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("guidang")
	@ResponseBody
	public Result guidang(String wid) throws Exception{
		batchInfoService.guidang(wid);
		return Result.success();
	}
	@RequestMapping("export")
	public void export(String condition,HttpServletResponse response) throws Exception{
		BatchInfoExtend batchInfoExtend=new BatchInfoExtend();
		if(!StringUtils.isEmpty(condition)){
			batchInfoExtend.setQueryCondition(condition.trim());
		}
		List<BatchInfoExtend> users=batchInfoService.selectDisplayByCondition(batchInfoExtend);
		String[] headers=new String[20];
		headers[0]="类别";
		headers[1]="二级分类";
		headers[2]="批次名称";
		headers[3]="样品批号";
		headers[4]="数量";
		headers[5]="品牌";
		headers[6]="数量单位";
		headers[7]="存放地";
		headers[8]="单价";
		headers[9]="货币单位";
		headers[10]="控制时间点";
		headers[11]="送样时间点";
		headers[12]="对方单位";
		headers[13]="送样人";
		headers[14]="送样单位";
		headers[15]="送样负责人";
		headers[17]="样品监控状态";
		headers[18]="合同号";
		List<List<String>> list=new ArrayList<List<String>>();
		if(CommonUtil.isNotEmptyList(users)){
			
			for(BatchInfoExtend extend:users){
				List<String> data=new ArrayList<String>();
				list.add(data);
				data.add(StringUtil.toStr(extend.getPclb_display()));
				data.add(StringUtil.toStr(extend.getEjfl()));
				data.add(StringUtil.toStr(extend.getPcmc()));
				data.add(StringUtil.toStr(extend.getYpph()));
				data.add(StringUtil.toStr(extend.getSl()));
				data.add(StringUtil.toStr(extend.getPp()));
				data.add(StringUtil.toStr(extend.getSldw()));
				data.add(StringUtil.toStr(extend.getCfd()));
				data.add(StringUtil.toStr(extend.getDj()));
				data.add(StringUtil.toStr(extend.getHbdw_display()));
				data.add(StringUtil.toStr(extend.getKzsjd()));
				data.add(StringUtil.toStr(extend.getSysj()));
				data.add(StringUtil.toStr(extend.getGys()));
				data.add(StringUtil.toStr(extend.getSyr()));
				data.add(StringUtil.toStr(extend.getSydw_display()));
				data.add(StringUtil.toStr(extend.getSyxmfzr()));
				//data.add(StringUtil.toStr(extend.getShsj()));
				data.add(StringUtil.toStr(extend.getPczt_display()));
				data.add(StringUtil.toStr(extend.getHth()));
				//data.add(StringUtil.toStr(extend.getFxxm()));
				
			}
		}
		ExportExcel.doExportExcel2("样品批次信息","样品批次信息",  headers, list,response);
	}
	
	
	@RequestMapping("overPc")
	@ResponseBody
	public Result overPc(String wid) throws Exception{
			PageParam<BatchInfoDetailExtend> pageParam = new PageParam<BatchInfoDetailExtend>();
			pageParam.setPage(0);
		
			List<BatchInfoDetailExtend> users=null;
			Page<BatchInfoDetailExtend> page = PageHelper.startPage(pageParam.getPage(), pageParam.getPageSize());
			BatchInfoDetail batchInfoDetail=new BatchInfoDetail();
			batchInfoDetail.setPcwid(wid);
			users=batchInfoService.selectDetailDisplayByCondition(batchInfoDetail);
			if(CommonUtil.isEmptyList(users)){
				throw new ServiceException("该批次下还没有建样品，请重新确认");
			}
			BatchInfo batchInfo=new BatchInfo();
			batchInfo.setWid(wid);
			batchInfo.setPczt(StringUtil.toStr(BatchStateEnum.DC.getCode()));
			batchInfoService.updateBatchInfo(batchInfo);
			return Result.success();
		}
}
