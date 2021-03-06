package com.pope.contract.web.first;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.RoleList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pope.contract.code.DataStatus;
import com.pope.contract.code.Result;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.system.AlarmInfo;
import com.pope.contract.entity.system.MessageInfo;
import com.pope.contract.entity.system.NewsInfo;
import com.pope.contract.entity.system.Role;
import com.pope.contract.entity.system.extend.MessageInfoExtend;
import com.pope.contract.entity.system.extend.NewsInfoExtend;
import com.pope.contract.service.system.AlarmInfoService;
import com.pope.contract.service.system.MessageInfoService;
import com.pope.contract.service.system.NewsInfoService;
import com.pope.contract.util.CommonUtil;
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
@RequestMapping("center")
public class CenterController extends BaseController{

	@Autowired
	private NewsInfoService newsInfoService;
	
	@Autowired
	private MessageInfoService messageInfoService;
	
	@Autowired
	private AlarmInfoService alarmInfoService; 
	@RequestMapping("index")
	public String index() throws Exception{
		
		return "/center/centerInfo";
	}
	

	@RequestMapping("newsList")
	@ResponseBody
	public Result newsList(Integer startPage) throws Exception{
		PageUtil<NewsInfo> pageUtil = new PageUtil<NewsInfo>(startPage);
		NewsInfoExtend newsInfoExtend=new NewsInfoExtend();
		newsInfoExtend.setBeginTime(DateUtil.getCurrentDateStr());
		newsInfoExtend.setEndTime(DateUtil.getCurrentDateStr());
		newsInfoExtend.setOnline(StringUtil.toStr(DataStatus.normal.getCode()));
		List<NewsInfo> datas=newsInfoService.selectByCondition(newsInfoExtend);
		PageParam<NewsInfo> pageParam = pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping("messagesList")
	@ResponseBody
	public Result messagesList(Integer startPage) throws Exception{
		PageUtil<MessageInfo> pageUtil = new PageUtil<MessageInfo>(startPage);
		MessageInfoExtend messageInfoExtend=new MessageInfoExtend();
		messageInfoExtend.setHasRead("0");
		messageInfoExtend.setUserId(this.getUserId());
		messageInfoExtend.setMessageReceiveDepart(this.getLoginInfo().getDepartment());
		messageInfoExtend.setMessageReceiveTeam(this.getLoginInfo().getTeam());
		messageInfoExtend.setMessageReceiveMan(this.getLoginInfo().getWid());
		
		List<String> rolelist=new ArrayList<String>();
		List<Role> roleData=this.getLoginInfo().getRoles();
		if(CommonUtil.isNotEmptyList(roleData)){
			for(Role role:roleData){
				rolelist.add(role.getWid());
			}
		}
		if(CommonUtil.isEmptyList(rolelist)){
			messageInfoExtend.setAccountRole("0");
		}else{
			List<AlarmInfo> alarmList=alarmInfoService.selectByRoles(rolelist);
			if(CommonUtil.isNotEmptyList(alarmList)){
				for(AlarmInfo alarmInfo:alarmList){
					if("1".equals(alarmInfo.getCustomAccount())){
						messageInfoExtend.setAccountRole("1");
					}
				}
				
			}else{
				messageInfoExtend.setAccountRole("0");
			}
		}
		List<MessageInfo> datas=messageInfoService.selectAllPersonByCondition(messageInfoExtend);
		PageParam<MessageInfo> pageParam = pageUtil.getPageParam(datas);
		return Result.success(pageParam);
	}
	
	@RequestMapping("messageCount")
	@ResponseBody
	private Result messageCount() throws Exception{
		MessageInfoExtend messageInfoExtend=new MessageInfoExtend();
		messageInfoExtend.setHasRead("0");
		messageInfoExtend.setUserId(this.getUserId());
		messageInfoExtend.setMessageReceiveDepart(this.getLoginInfo().getDepartment());
		messageInfoExtend.setMessageReceiveTeam(this.getLoginInfo().getTeam());
		messageInfoExtend.setMessageReceiveMan(this.getLoginInfo().getWid());
		List<String> rolelist=new ArrayList<String>();
		List<Role> roleData=this.getLoginInfo().getRoles();
		if(CommonUtil.isNotEmptyList(roleData)){
			for(Role role:roleData){
				rolelist.add(role.getWid());
			}
		}
		if(CommonUtil.isEmptyList(rolelist)){
			messageInfoExtend.setAccountRole("0");
		}else{
			List<AlarmInfo> alarmList=alarmInfoService.selectByRoles(rolelist);
			if(CommonUtil.isNotEmptyList(alarmList)){
				for(AlarmInfo alarmInfo:alarmList){
					if("1".equals(alarmInfo.getCustomAccount())){
						messageInfoExtend.setAccountRole("1");
					}
				}
				
			}else{
				messageInfoExtend.setAccountRole("0");
			}
		}
		Integer count=messageInfoService.selectAllPersonCountByCondition(messageInfoExtend);
		if(count==null){
			count=0;
		}
		return Result.success(count);
	}
}
