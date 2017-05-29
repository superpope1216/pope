package com.pope.contract.web.system;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pope.contract.entity.system.Role;
import com.pope.contract.web.BaseController;

@Controller
@RequestMapping("system")
public class SystemController extends BaseController {

	@RequestMapping("index")
	
	public String index(){
		//SecurityUtils.getSubject().checkPermission("sytem:index");
		return "index";
	}
}
