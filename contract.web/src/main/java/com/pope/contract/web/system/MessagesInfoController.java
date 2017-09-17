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
import com.pope.contract.entity.system.MessageInfo;
import com.pope.contract.entity.system.NewsInfo;
import com.pope.contract.service.system.MessageInfoService;
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
@RequestMapping("messages")
public class MessagesInfoController extends BaseController{
	@Autowired
	private MessageInfoService messageInfoService;
	@RequestMapping("index")
	public String index() throws Exception{
		return "/system/messageinfo";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Result list(Integer startPage) throws Exception{
		PageUtil<MessageInfo> pageUtil = new PageUtil<MessageInfo>(startPage);
		List<MessageInfo> datas=messageInfoService.selectByCondition(null);
		PageParam<MessageInfo> pageParam = pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Result delete(String wid) throws Exception{
		messageInfoService.deleteByPrimaryKey(wid);
		return Result.success();
	}
}
