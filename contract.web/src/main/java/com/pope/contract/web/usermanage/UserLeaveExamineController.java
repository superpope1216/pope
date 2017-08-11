package com.pope.contract.web.usermanage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.contract.code.FlowSetCode;
import com.pope.contract.code.FlowStateCode;
import com.pope.contract.code.Result;
import com.pope.contract.dao.user.LeaveInfoMapper;
import com.pope.contract.dto.LoginInfo;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.system.Role;
import com.pope.contract.entity.user.LeaveInfo;
import com.pope.contract.service.user.LeaveInfoService;
import com.pope.contract.util.ConstantUtil;
import com.pope.contract.web.BaseController;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年6月18日 下午5:14:36
* 类说明:用户审核信息
*/
@Controller
@RequestMapping("userleavesexamine")
public class UserLeaveExamineController extends BaseController{

	@Autowired
	private LeaveInfoService leaveInfoService; 
	@RequestMapping("index")
	public String index(){
		return "usermanage/userleaveexamine";
	}
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	@ResponseBody
	public Result listDsh(Integer startPage,HttpServletRequest request) throws Exception{
		LoginInfo loginInfo = (LoginInfo) request.getSession().getAttribute(ConstantUtil.USER_SESSION_NAME);
		Role currentRole = (Role) request.getSession().getAttribute(ConstantUtil.USER_CURRENT_ROLE);
		if(startPage==null ||startPage<0){
			startPage=0;
		}
		List<String> taskStatus=new ArrayList<String>();
		taskStatus.add(FlowStateCode.DSH.getCode());
		taskStatus.add(FlowStateCode.JXZ.getCode());
		PageParam<LeaveInfo> pageParam = new PageParam<LeaveInfo>();
		pageParam.setPage(startPage);
		Page<LeaveInfo> page = PageHelper.startPage(pageParam.getPage(), pageParam.getPageSize());
		List<LeaveInfo> users=leaveInfoService.selectByRoleId(currentRole.getWid(), taskStatus,loginInfo.getDepartment(), loginInfo.getTeam());
		pageParam.setTotal(page.getTotal());
		pageParam.setTotalPage(pageParam.getTotalPage());
		pageParam.setData(users);
		return Result.success(pageParam);
	}
	
	@RequestMapping(value="listOther",method=RequestMethod.GET)
	@ResponseBody
	public Result listOther(String taskStatu,Integer startPage,HttpServletRequest request) throws Exception{
		LoginInfo loginInfo = (LoginInfo) request.getSession().getAttribute(ConstantUtil.USER_SESSION_NAME);
		Role currentRole = (Role) request.getSession().getAttribute(ConstantUtil.USER_CURRENT_ROLE);
		if(startPage==null ||startPage<0){
			startPage=0;
		}
		List<String> taskStatus=new ArrayList<String>();
		taskStatus.add(taskStatu);
		PageParam<LeaveInfo> pageParam = new PageParam<LeaveInfo>();
		pageParam.setPage(startPage);
		Page<LeaveInfo> page = PageHelper.startPage(pageParam.getPage(), pageParam.getPageSize());
		List<LeaveInfo> users=leaveInfoService.selectByOtherRoleId(currentRole.getWid(), taskStatus,loginInfo.getDepartment(), loginInfo.getTeam());
		pageParam.setTotal(page.getTotal());
		pageParam.setTotalPage(pageParam.getTotalPage());
		pageParam.setData(users);
		return Result.success(pageParam);
	}
	
	@RequestMapping(value="examinePass",method=RequestMethod.POST)
	@ResponseBody
	public Result examinePassLeave(String wid) throws Exception{
		leaveInfoService.examinePass(wid, this.getUserId());
		return Result.success();
	}
}
