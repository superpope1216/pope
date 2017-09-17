package com.pope.contract.web.ueditor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.ueditor.ActionEnter;
import com.pope.contract.web.BaseController;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年9月16日 下午6:29:39
* 类说明
*/
@Controller
@RequestMapping(value = "ueditor")
public class UeditorController extends BaseController{
	@RequestMapping(value = "upload")  
    public void config(HttpServletRequest request, HttpServletResponse response) {  
        response.setContentType("application/json");  
        String rootPath = request.getSession().getServletContext().getRealPath("/");  
        try {  
            String exec = new ActionEnter(request, rootPath).exec();  
            PrintWriter writer = response.getWriter();  
            writer.write(exec);  
            writer.flush();  
            writer.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}
