package com.pope.contract.web.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.StringUtil;
import com.pope.contract.code.Result;
import com.pope.contract.entity.system.MessageInfo;
import com.pope.contract.entity.system.NewsInfo;
import com.pope.contract.entity.user.extend.UserInfoExtend;
import com.pope.contract.service.system.MessageInfoService;
import com.pope.contract.service.system.NewsInfoService;
import com.pope.contract.service.user.UserInfoService;
import com.pope.contract.web.BaseController;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年9月16日 下午9:50:58
* 类说明
*/
@Controller
@RequestMapping("messagesEdit")
public class MessagesEditController extends BaseController{

	@Autowired
	private  MessageInfoService messageInfoService;
	
	@Autowired
	private  UserInfoService userInfoService;
	@RequestMapping("index")
	public ModelAndView index(String wid){
		ModelAndView mv=new ModelAndView();
		mv.addObject("wid",wid);
		mv.setViewName("system/messageedit");
		return mv;
	}
	@RequestMapping("select")
	@ResponseBody
	public Result select(String wid) throws Exception{
		MessageInfo newsInfo=null;
		if(StringUtil.isEmpty(wid)){
			newsInfo=new MessageInfo();
		}else{
			newsInfo=messageInfoService.selectDisplayByCondition(wid);
		}
		return Result.success(newsInfo);
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Result save(MessageInfo newsInfo) throws Exception{
		if(StringUtil.isEmpty(newsInfo.getWid())){
			messageInfoService.insertSelective(newsInfo,this.getUserId());
			//newsInfoService.updateByPrimaryKeyWithBLOBs(record);
		}else{
			messageInfoService.updateByPrimaryKeySelective(newsInfo);
		}
		return Result.success();
	}
	
	@RequestMapping("selectUsers")
	@ResponseBody
	public Result selectUsers() throws Exception{
		UserInfoExtend queryUserInfoExtend=new UserInfoExtend();
		return Result.success(userInfoService.selectByCondition(queryUserInfoExtend));
	}
}
