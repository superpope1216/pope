package com.pope.contract.web.supply;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pope.contract.code.Result;
import com.pope.contract.web.BaseController;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年8月15日 下午4:36:25
* 类说明
*/
@Controller
@RequestMapping("supply")
public class SupplyInfoController extends BaseController{

	@RequestMapping("index")
	public String index(){
		return "supply/supplyInfo";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Result list(){
		
		return Result.success();
	}
}
