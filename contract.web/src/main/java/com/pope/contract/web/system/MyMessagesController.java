package com.pope.contract.web.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pope.contract.code.DataStatus;
import com.pope.contract.code.Result;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.system.MessageInfo;
import com.pope.contract.entity.system.NewsInfo;
import com.pope.contract.entity.system.extend.MessageInfoExtend;
import com.pope.contract.entity.system.extend.NewsInfoExtend;
import com.pope.contract.service.system.MessageInfoService;
import com.pope.contract.service.system.NewsInfoService;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;
import com.pope.contract.web.BaseController;
import com.pope.contract.web.util.PageUtil;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年9月16日 下午11:30:17
* 类说明
*/

@Controller
@RequestMapping("myMessages")
public class MyMessagesController extends BaseController{

	
	@Autowired
	private MessageInfoService messageInfoService;
	@RequestMapping("index")
	public String index() throws Exception{
		
		return "/system/mymessages";
	}
	

	
	@RequestMapping("messagesList")
	@ResponseBody
	public Result messagesList(Integer startPage) throws Exception{
		PageUtil<MessageInfo> pageUtil = new PageUtil<MessageInfo>(startPage);
		MessageInfoExtend messageInfoExtend=new MessageInfoExtend();
		messageInfoExtend.setHasRead("0");
		messageInfoExtend.setUserId(this.getUserId());
		List<MessageInfo> datas=messageInfoService.selectByCondition(messageInfoExtend);
		PageParam<MessageInfo> pageParam = pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
}
