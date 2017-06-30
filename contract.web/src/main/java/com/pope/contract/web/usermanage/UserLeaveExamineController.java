package com.pope.contract.web.usermanage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年6月18日 下午5:14:36
* 类说明:用户审核信息
*/
@Controller
@RequestMapping("userleavesexamine")
public class UserLeaveExamineController {

	@RequestMapping("index")
	public String index(){
		return "usermanage/userleaveexamine";
	}
}
