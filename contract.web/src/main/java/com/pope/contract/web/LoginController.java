package com.pope.contract.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pope.contract.code.ResponseCode;
import com.pope.contract.code.Result;
import com.pope.contract.dto.LoginInfo;
import com.pope.contract.entity.user.UserInfo;
import com.pope.contract.service.user.UserInfoService;
import com.pope.contract.util.ConstantUtil; 


@Controller
@RequestMapping("login")
public class LoginController extends BaseController{
	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private UserInfoService userInfoService;
	@RequestMapping(value="index",method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="welcome",method=RequestMethod.GET)
	public String index2(){
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public Result login(@RequestParam String loginName,
	                        @RequestParam String password, 
	                        HttpServletRequest request) throws Exception {
	      
	 		UserInfo user=userInfoService.selectByGh(loginName);
	        if (user == null) {
	            return Result.instance(ResponseCode.unknown_account.getCode(), ResponseCode.unknown_account.getMsg());
	        }
	        if (user.getStatus() == 3) {
	            return Result.instance(ResponseCode.forbidden_account.getCode(), ResponseCode.forbidden_account.getMsg());
	        }
	        Subject subject = SecurityUtils.getSubject();
	        subject.login(new UsernamePasswordToken(loginName, password));
	        LoginInfo loginInfo = userInfoService.login(user);
	        subject.getSession().setAttribute(ConstantUtil.USER_SESSION_NAME, loginInfo);
	        LOG.debug("登录成功");
	        return Result.success(loginInfo);
	    }
}
