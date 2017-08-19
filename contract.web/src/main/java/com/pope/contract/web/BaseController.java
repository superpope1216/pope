package com.pope.contract.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.support.MethodArgumentTypeMismatchException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.pope.contract.code.MenuLevel;
import com.pope.contract.code.ResponseCode;
import com.pope.contract.code.Result;
import com.pope.contract.dto.LoginInfo;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.system.Permission;
import com.pope.contract.entity.system.Role;
import com.pope.contract.exception.BizException;
import com.pope.contract.exception.ServiceException;
import com.pope.contract.service.system.PermissionService;
import com.pope.contract.util.CommonUtil;
import com.pope.contract.util.ConstantUtil;
import com.pope.contract.util.StringUtil;

public class BaseController {
	private static final Logger log = LoggerFactory.getLogger(BaseController.class);

	@Autowired
	protected PermissionService permissionService;
	public <T> Page<T> begPage(Integer startPage,PageParam<T> pageParam){
		
		if(startPage==null ||startPage<0){
			startPage=0;
		}
		pageParam.setPage(startPage);
		Page<T> page = PageHelper.startPage(pageParam.getPage(), pageParam.getPageSize());
		return  page;
	}
	public <T,V>   void endPage(PageParam<T> pageParam,Page<T> page,List<T> datas){
		pageParam.setTotal(page.getTotal());
		pageParam.setTotalPage(pageParam.getTotalPage());
		pageParam.setData(datas);
	}
	public String getUserId() {
		HttpServletRequest request = this.getRequest();
		LoginInfo loginInfo = (LoginInfo) WebUtils.getSessionAttribute(request, ConstantUtil.USER_SESSION_NAME);

		return loginInfo.getWid();
	}

	public LoginInfo getLoginInfo() {
		HttpServletRequest request = this.getRequest();
		if (request.getSession().getAttribute(ConstantUtil.USER_SESSION_NAME) != null) {
			return (LoginInfo) request.getSession().getAttribute(ConstantUtil.USER_SESSION_NAME);
		}
		return null;
	}
	
	protected String getButtonPermission(String url){ 
		List<Permission> listPers=permissionService.selectChildByUrl(url,this.getRole().getWid());
		StringBuilder buttons=new StringBuilder();
		if(CommonUtil.isNotEmptyList(listPers)){
			for(Permission per:listPers){
				if(per.getLevel()==MenuLevel.FOUR.getCode()){
					buttons.append(per.getUrl()+",");
					
				}
			}
		}
		String value=buttons.toString();
		if(!StringUtils.isEmpty(value)){
			value=","+value;
		}
		return value;
	}

	public Role getRole() {
		HttpServletRequest request = this.getRequest();
		if (request.getSession().getAttribute(ConstantUtil.USER_CURRENT_ROLE) != null) {
			return (Role) request.getSession().getAttribute(ConstantUtil.USER_CURRENT_ROLE);

		}
		return null;
	}

	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return request;
	}

	// 根据请求类型,响应不同类型
	@ExceptionHandler(Exception.class)
	public void exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception)
			throws IOException, ServletException {
		log.error("exception occur : \n {}", StringUtil.exceptionDetail(exception));
		if (request.getHeader("Accept").contains("application/json")) {
			log.debug("qingqiu");
			Result result = Result.error();
			if (exception instanceof IncorrectCredentialsException) {
				result = Result.instance(ResponseCode.password_incorrect.getCode(),
						ResponseCode.password_incorrect.getMsg());
				// 账号不存在
			} else if (exception instanceof UnknownAccountException) {
				result = Result.instance(ResponseCode.unknown_account.getCode(), ResponseCode.unknown_account.getMsg());
				// 未授权
			} else if (exception instanceof UnauthorizedException) {
				result = Result.instance(ResponseCode.unauthorized.getCode(), ResponseCode.unauthorized.getMsg());
				// 未登录
			} else if (exception instanceof UnauthenticatedException) {
				result = Result.instance(ResponseCode.unauthenticated.getCode(), ResponseCode.unauthenticated.getMsg());
				// 缺少参数
			} else if (exception instanceof MissingServletRequestParameterException) {
				result = Result.instance(ResponseCode.missing_parameter.getCode(),
						ResponseCode.missing_parameter.getMsg());
				// 参数格式错误
			} else if ((exception instanceof MethodArgumentTypeMismatchException)) {
				result = Result.instance(ResponseCode.param_format_error.getCode(),
						ResponseCode.param_format_error.getMsg());
				// ip限制
			} else if (exception instanceof BizException) {
				result = Result.instance(ResponseCode.code_already_exist.getCode(),
						ResponseCode.code_already_exist.getMsg());
			}else if(exception instanceof ServiceException){
				result=Result.error(exception.getMessage());
			}
			else if (exception.getCause().getMessage().contains("system.exception.ForbiddenIpException")) {
				result = Result.instance(ResponseCode.forbidden_ip.getCode(), ResponseCode.forbidden_ip.getMsg());
				// 其他错误
			}
			// 调试时输出异常日志
			// if (systemService.selectDataItemByKey("error_detail",
			// 2L).equals("true")) {
			// result.setData(StringUtil.exceptionDetail(exception));
			// }
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().append(new Gson().toJson(result));
			response.getWriter().flush();
			response.getWriter().close();
		} else {
			// String basePath = systemService.selectDataItemByKey("basePath",
			// 4L);
			String url = "/error/internalError";

			if (exception instanceof UnauthorizedException) {
				url = "/error/unAuthorization";
			}
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			response.sendRedirect(request.getContextPath() + url);
		}
	}
}
