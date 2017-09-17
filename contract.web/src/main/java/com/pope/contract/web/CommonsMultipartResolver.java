package com.pope.contract.web;
/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年9月16日 下午9:00:54
* 类说明
*/
public class CommonsMultipartResolver  extends org.springframework.web.multipart.commons.CommonsMultipartResolver {

    @Override  
      public boolean isMultipart(javax.servlet.http.HttpServletRequest request) {  
       String uri = request.getRequestURI();  
       System.out.println(uri);
       //过滤使用百度UEditor的URI  
       if (uri.indexOf("ueditor/upload") > 0) {     //此处拦截路径即为上面编写的controller路径
        System.out.println("commonsMultipartResolver 放行");
        return false;  
       }  
       System.out.println("commonsMultipartResolver 拦截");
       return super.isMultipart(request);  
      }  
}