package com.pope.contract.web.pxgl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.contract.code.Result;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.pxgl.PxglInfo;
import com.pope.contract.entity.pxgl.extend.PxglInfoExtend;
import com.pope.contract.entity.user.extend.UserInfoExtend;
import com.pope.contract.service.pxgl.PxglInfoService;
import com.pope.contract.util.StringUtil;
import com.pope.contract.web.BaseController;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年9月10日 下午3:00:06
* 类说明
*/
@Controller
@RequestMapping("pxglInfo")
public class PxglInfoController extends BaseController{

	@Autowired
	private PxglInfoService pxglInfoService;
	@RequestMapping("index")
	public ModelAndView index() throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("pxgl/pxglInfo");
		mv.addObject("buttons",this.getButtonPermission("/pxglInfo/index"));
		return mv;
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Result list(Integer startPage,String pxlx,String pxmc,String pxr,String pxzt){
		if(startPage==null ||startPage<0){
			startPage=0;
		}
		PxglInfoExtend queryInfo=new PxglInfoExtend();
		if(!StringUtils.isEmpty(pxlx)){
			queryInfo.setPxlx(pxlx);
		}
		if(!StringUtils.isEmpty(pxmc)){
			queryInfo.setPxmc(pxmc);
		}
		if(!StringUtils.isEmpty(pxr)){
			queryInfo.setUserName(pxr);
		}
		if(!StringUtils.isEmpty(pxzt)){
			queryInfo.setRwzt(StringUtil.toInt(pxzt));
		}
		PageParam<PxglInfoExtend> pageParam = new PageParam<PxglInfoExtend>();
		pageParam.setPage(startPage);
		Page<PxglInfoExtend> page = PageHelper.startPage(pageParam.getPage(), pageParam.getPageSize());
		List<PxglInfoExtend> users=pxglInfoService.selectDisplayByCondition(queryInfo);
		pageParam.setTotal(page.getTotal());
		pageParam.setTotalPage(pageParam.getTotalPage());
		pageParam.setData(users);
		return Result.success(pageParam);
		
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Result save(PxglInfo pxglInfo,String flag) throws Exception{
		if(StringUtils.isEmpty(pxglInfo.getWid())){
			
			this.pxglInfoService.insertSelective(pxglInfo, flag);
		}else{
			this.pxglInfoService.updateByPrimaryKeySelective(pxglInfo,flag);
		}
		return Result.success();
	}
	@RequestMapping("edit")
	@ResponseBody
	public Result edit(String wid) throws Exception{
		if(StringUtils.isEmpty(wid)){
			return Result.success(new PxglInfo());
		}else{
			return Result.success(this.pxglInfoService.selectByPrimaryKey(wid));
		}
	}
	@RequestMapping("delete")
	@ResponseBody
	public Result delete(String wid) throws Exception{
		return Result.success(this.pxglInfoService.deleteByPrimaryKey(wid));
	}
}
