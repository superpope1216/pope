package com.pope.contract.web.usermanage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.pope.contract.code.FlowSetCode;
import com.pope.contract.code.Result;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.user.LeaveInfo;
import com.pope.contract.entity.user.UserInfo;
import com.pope.contract.service.user.LeaveInfoService;
import com.pope.contract.web.BaseController;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年6月4日 下午8:11:20
* 类说明
*/
@Controller
@RequestMapping("userleaves")
public class UserLeaveController extends BaseController{

	@Autowired
	private LeaveInfoService leaveInfoService;
	@RequestMapping("index")
	public ModelAndView index(String flag){
		ModelAndView mv=new ModelAndView();
		mv.addObject("flowSetType", FlowSetCode.LEAVE.getCode());
		if(StringUtil.isEmpty(flag)){
			flag="";
		}
		mv.addObject("flag", flag);
		mv.setViewName("usermanage/userleaveInfo");
		return mv;
	}
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	@ResponseBody
	public Result list(Integer startPage,String flag,String condition,String shzt) throws Exception{
		if(startPage==null ||startPage<0){
			startPage=0;
		}
		PageParam<LeaveInfo> pageParam = new PageParam<LeaveInfo>();
		pageParam.setPage(startPage);
		Page<LeaveInfo> page = PageHelper.startPage(pageParam.getPage(), pageParam.getPageSize());
		List<LeaveInfo> users=new ArrayList<LeaveInfo>();
		if(StringUtil.isNotEmpty(condition)){
			condition=condition.trim();
		}
		if(StringUtil.isNotEmpty(shzt)){
			shzt=shzt.trim();
		}
		if("manager".equals(flag)){
			users=leaveInfoService.selectByYhid(null,condition,shzt);
		}else{
			users=leaveInfoService.selectByYhid(this.getUserId(),condition,shzt);
		}
		pageParam.setTotal(page.getTotal());
		pageParam.setTotalPage(pageParam.getTotalPage());
		pageParam.setData(users);
		return Result.success(pageParam);
	}
	@RequestMapping(value="insert",method=RequestMethod.POST)
	@ResponseBody
	public Result insert(LeaveInfo leaveInfo) throws Exception{
		leaveInfo.setYhid(this.getUserId());
		leaveInfoService.insert(leaveInfo, this.getUserId());
		return Result.success();
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseBody
	public Result update(LeaveInfo leaveInfo) throws Exception{
		leaveInfoService.updateByPrimaryKeySelective(leaveInfo, this.getUserId());
		return Result.success();
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public Result delete(@RequestParam String wid) throws Exception{
		leaveInfoService.deleteByPrimaryKey(wid, this.getUserId());
		return Result.success();
	}
	@RequestMapping(value="select",method=RequestMethod.GET)
	@ResponseBody
	public Result select(@RequestParam String wid) throws Exception{
		LeaveInfo leave=leaveInfoService.selectByPrimaryKey(wid);
		return Result.success(leave);
	}
}
