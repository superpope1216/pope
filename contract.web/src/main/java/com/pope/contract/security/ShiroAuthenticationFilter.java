package com.pope.contract.security;

import com.google.gson.Gson;
import com.pope.contract.code.ResponseCode;
import com.pope.contract.code.Result;

import org.apache.shiro.web.filter.authc.PassThruAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @Description 登录过滤器
 */
public class ShiroAuthenticationFilter extends PassThruAuthenticationFilter {
    private static Logger log = LoggerFactory.getLogger(ShiroAuthorizationFilter.class);

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            return true;
        } else {
            saveRequest(request);
            if (((HttpServletRequest) request).getHeader("Accept").contains("application/json")) {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json;charset=UTF-8");
                Result result = new Result(ResponseCode.unauthenticated.getCode(), ResponseCode.unauthenticated.getMsg());
                response.getWriter().append(new Gson().toJson(result));
                response.getWriter().flush();
                response.getWriter().close();
            } else {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=UTF-8");
                ((HttpServletResponse) response).sendRedirect(request.getServletContext().getContextPath()+"/login.jsp");
            }
            return false;
        }
    }
}
