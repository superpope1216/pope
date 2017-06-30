package com.pope.contract.web.usermanage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.contract.code.DataStatus;
import com.pope.contract.code.Result;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.user.UserInfo;
import com.pope.contract.service.user.UserInfoService;
import com.pope.contract.util.ConstantUtil;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.StringUtil;
import com.pope.contract.web.BaseController;

@Controller
@RequestMapping("users")
public class UserController extends BaseController{

	@Autowired
	private UserInfoService userInfoService;
	@RequestMapping("index")
	public String index(){
		return "usermanage/userInfo";
	}
	@RequestMapping(value="list",method=RequestMethod.GET)
	@ResponseBody
	public Result list(Integer startPage) throws Exception{
		if(startPage==null ||startPage<0){
			startPage=0;
		}
		
		PageParam<UserInfo> pageParam = new PageParam<UserInfo>();
		pageParam.setPage(startPage);
		Page<UserInfo> page = PageHelper.startPage(pageParam.getPage(), pageParam.getPageSize());
		List<UserInfo> users=userInfoService.selectListByCondition(null);
		pageParam.setTotal(page.getTotal());
		pageParam.setTotalPage(pageParam.getTotalPage());
		pageParam.setData(users);
		return Result.success(pageParam);
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseBody
	public Result update(UserInfo userInfo){
		return null;
	}
	@RequestMapping(value="insert",method=RequestMethod.POST)
	@ResponseBody
	public Result insert(UserInfo userInfo,String userInfoRoles) throws Exception{
		
		userInfoService.insert(userInfo,this.getUserId(),userInfoRoles);
		return Result.success();
	}
	@RequestMapping(value="select",method=RequestMethod.GET)
	@ResponseBody
	public Result select(String wid) throws Exception{
		UserInfo userInfo=userInfoService.selectByPrimaryKey(wid);
		return Result.success(userInfo);
	}
}
