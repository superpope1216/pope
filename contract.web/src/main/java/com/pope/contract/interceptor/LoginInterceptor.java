package com.pope.contract.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pope.contract.util.ConstantUtil;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年8月13日 上午11:37:32 类说明
 */
public class LoginInterceptor implements HandlerInterceptor {
	private List<String> excludedUrls;

	public List<String> getExcludedUrls() {
		return excludedUrls;
	}

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		String url = request.getRequestURI();
		for (String url2 : excludedUrls) {
			if (url.contains(url2)) {
				return true;
			}
		}
		if (url.indexOf("login/login") >= 0) {
			return true;
		}
		HttpSession session = request.getSession();
		if (session.getAttribute(ConstantUtil.USER_SESSION_NAME) != null) {
			return true;
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
