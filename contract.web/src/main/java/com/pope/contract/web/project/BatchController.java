package com.pope.contract.web.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.pope.contract.code.Result;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.project.BatchInfo;
import com.pope.contract.entity.project.BatchInfoDetail;
import com.pope.contract.entity.project.extend.BatchInfoDetailExtend;
import com.pope.contract.entity.project.extend.BatchInfoExtend;
import com.pope.contract.entity.user.UserInfo;
import com.pope.contract.service.project.BatchInfoService;
import com.pope.contract.util.DateUtil;
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
	@RequestMapping("index")
	public String index() {
		return "project/batchInfo";
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
		mv.setViewName("project/batchInfoDetail");;
		return mv;
	}

	
	@RequestMapping(value="list",method=RequestMethod.GET)
	@ResponseBody
	public Result list(Integer startPage) throws Exception{
		if(startPage==null ||startPage<0){
			startPage=0;
		}
		PageParam<BatchInfoExtend> pageParam = new PageParam<BatchInfoExtend>();
		pageParam.setPage(startPage);
		Page<BatchInfoExtend> page = PageHelper.startPage(pageParam.getPage(), pageParam.getPageSize());
		List<BatchInfoExtend> users=batchInfoService.selectDisplayByCondition(null);
		pageParam.setTotal(page.getTotal());
		pageParam.setTotalPage(pageParam.getTotalPage());
		pageParam.setData(users);
		return Result.success(pageParam);
	}
	@RequestMapping("detail")
	@ResponseBody
	public Result details(String wid) throws Exception{
		if(StringUtil.isEmpty(wid)){
			BatchInfo batch=new BatchInfo();
			String max=batchInfoService.selectMax();
			String month=DateUtil.format(DateUtil.getCurrentDate(),"yyyyMM");
			batch.setDqbh(Integer.valueOf(max));
			batch.setYpph(month+max.toString());
			return Result.success(batch);
		}else{
			return Result.success(batchInfoService.selectByPrimaryKey(wid));
		}
	}
	
	@RequestMapping("saveBatchInfo")
	@ResponseBody
	public Result saveBatchInfo(BatchInfo batchInfo) throws Exception{
		if(StringUtil.isEmpty(batchInfo.getWid())){
			batchInfo=batchInfoService.insertBatchInfo(batchInfo);
		}else{
			batchInfoService.updateBatchInfo(batchInfo);
		}
		return Result.success(batchInfo);
	}
	
	@RequestMapping("addDetail")
	@ResponseBody
	public Result addDetail(String wid) throws Exception{
		BatchInfo batchInfo=batchInfoService.selectByPrimaryKey(wid);
		Map<String,Object> map=new HashMap<String,Object>();
		String sMax=batchInfoService.selectDetailMax();
		String max=batchInfo.getYpph()+sMax;
		map.put("ypph", batchInfo.getYpph());
		map.put("dqbh", sMax);
		map.put("ypbh", max);
		map.put("fxxm", batchInfo.getFxxm());
		map.put("pcwid", batchInfo.getWid());
		return Result.success(map);
	}
	
	@RequestMapping("saveDetail")
	@ResponseBody
	public Result saveDetail(BatchInfoDetail batchInfoDetail) throws Exception{
		if(StringUtil.isEmpty(batchInfoDetail.getWid())){
			batchInfoService.insertBatchInfoDetail(batchInfoDetail);
		}else{
			batchInfoService.updateBatchInfoDetail(batchInfoDetail);
		}
		return Result.success();
	}
	
	
	@RequestMapping(value="detail_list",method=RequestMethod.GET)
	@ResponseBody
	public Result detailList(Integer startPage,String pcwid) throws Exception{
		if(startPage==null ||startPage<0){
			startPage=0;
		}
		
		PageParam<BatchInfoDetailExtend> pageParam = new PageParam<BatchInfoDetailExtend>();
		pageParam.setPage(startPage);
		Page<BatchInfoDetailExtend> page = PageHelper.startPage(pageParam.getPage(), pageParam.getPageSize());
		BatchInfoDetail batchInfoDetail=new BatchInfoDetail();
		batchInfoDetail.setPcwid(pcwid);
		List<BatchInfoDetailExtend> users=batchInfoService.selectDetailDisplayByCondition(batchInfoDetail);
		pageParam.setTotal(page.getTotal());
		pageParam.setTotalPage(pageParam.getTotalPage());
		pageParam.setData(users);
		return Result.success(pageParam);
	}
	@RequestMapping("copyBatch")
	@ResponseBody
	public Result copyBatch(String wid) throws Exception{
		String newWid=batchInfoService.copyBatchInfo(wid);
		return Result.success(newWid);
	}
	@RequestMapping("deleteBatch")
	@ResponseBody
	public Result deleteBatch(String wid) throws Exception{
		batchInfoService.deleteBatchInfo(wid);
		return Result.success();
	}
}