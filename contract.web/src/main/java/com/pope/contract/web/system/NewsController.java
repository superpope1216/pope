package com.pope.contract.web.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pope.contract.code.DataStatus;
import com.pope.contract.code.Result;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.custom.extend.CustomInfoExtend;
import com.pope.contract.entity.system.NewsInfo;
import com.pope.contract.service.system.NewsInfoService;
import com.pope.contract.util.StringUtil;
import com.pope.contract.web.BaseController;
import com.pope.contract.web.util.PageUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年9月16日 下午6:45:29
* 类说明
*/
@Controller
@RequestMapping("news")
public class NewsController extends BaseController{
	@Autowired
	private NewsInfoService newsInfoService;
	@RequestMapping("index")
	public String index() throws Exception{
		return "/system/newsmanage";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Result list(Integer startPage) throws Exception{
		PageUtil<NewsInfo> pageUtil = new PageUtil<NewsInfo>(startPage);
		List<NewsInfo> datas=newsInfoService.selectByCondition(null);
		PageParam<NewsInfo> pageParam = pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	@RequestMapping("upordown")
	@ResponseBody
	public Result upordown(String wid,String flag) throws Exception{
		NewsInfo newsInfo=new NewsInfo();
		newsInfo.setWid(wid);
		newsInfo.setOnline(flag);
		newsInfoService.updateByPrimaryKeySelective(newsInfo);
		return Result.success();
	}
	@RequestMapping("delete")
	@ResponseBody
	public Result delete(String wid) throws Exception{
		newsInfoService.deleteByPrimaryKey(wid);
		return Result.success();
	}
}
