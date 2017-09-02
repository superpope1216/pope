package com.pope.contract.web.usermanage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pope.contract.code.Result;
import com.pope.contract.entity.user.UserInfo;
import com.pope.contract.entity.user.extend.UserInfoExtend;
import com.pope.contract.service.user.UserInfoService;
import com.pope.contract.web.BaseController;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月26日 下午5:33:03
* 类说明
*/
@Controller
@RequestMapping("personUserInfo")
public class PersonUserInfoController extends BaseController{
	@Autowired
	private UserInfoService userInfoService;
	@RequestMapping("index")
	public String index(){
		return "usermanage/personUserInfo";
	}
	
	@RequestMapping("select")
	@ResponseBody
	public Result select() throws Exception{
		UserInfoExtend queryInfo=new UserInfoExtend();
		queryInfo.setWid(this.getUserId());
		List<UserInfoExtend> users=userInfoService.selectDisplayByCondition(queryInfo);
		return Result.success(users.get(0));
	}
	@RequestMapping("save")
	@ResponseBody
	public Result save(UserInfo userInfo) throws Exception{
		userInfo.setWid(this.getUserId());
		userInfo.setGh(null);
		userInfoService.updateByPrimaryKeySelective(userInfo);
		return Result.success();
	}
	
}
