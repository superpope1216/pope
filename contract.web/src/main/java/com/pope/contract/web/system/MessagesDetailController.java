package com.pope.contract.web.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.contract.code.Result;
import com.pope.contract.entity.system.MessageInfo;
import com.pope.contract.entity.system.NewsInfo;
import com.pope.contract.service.system.MessageInfoService;
import com.pope.contract.service.system.NewsInfoService;
import com.pope.contract.web.BaseController;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年9月17日 上午1:22:14
* 类说明
*/
@Controller
@RequestMapping("messagesDetail")
public class MessagesDetailController extends BaseController{

	@Autowired
	private MessageInfoService messageInfoService;
	@RequestMapping("index")
	public ModelAndView index(String wid){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("system/messagesDetail");
		mv.addObject("wid",wid);
		return mv;
	}
	@ResponseBody
	@RequestMapping("select")
	public Result select(String wid) throws Exception{
		MessageInfo messageInfo=messageInfoService.selectByPrimaryKey(wid);
		return Result.success(messageInfo);
	}
}
