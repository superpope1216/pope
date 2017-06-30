package com.pope.contract.web.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pope.contract.code.Result;
import com.pope.contract.entity.system.Department;
import com.pope.contract.entity.system.Sjzd;
import com.pope.contract.service.system.DepartmentService;
import com.pope.contract.web.BaseController;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年6月2日 上午11:21:38
* 类说明
*/
@Controller
@RequestMapping("departments")
public class DepartmentController extends BaseController {
	@Autowired
	private DepartmentService departmentService;
	@RequestMapping(value="index",method=RequestMethod.GET)
	public String index(){
		return "system/department";
	}
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	@ResponseBody
	public Result list() throws Exception{

		return Result.success(departmentService.selectAll());
	}
	@RequestMapping(value="insert",method=RequestMethod.POST)
	@ResponseBody
	public Result insert(Department department) throws Exception{
		department=departmentService.insert(department, this.getUserId());
		return Result.success(department);
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseBody
	public Result update(Department department) throws Exception{
		departmentService.updateByPrimaryKeySelective(department, this.getUserId());
		return Result.success();
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public Result delete(@RequestParam String wid) throws Exception{
		departmentService.deleteByWid(wid);
		return Result.success();
	}
	
	
	@RequestMapping(value="select",method=RequestMethod.GET)
	@ResponseBody
	public Result select() throws Exception{
		return null;
	}
	@RequestMapping(value="selectDepartment",method=RequestMethod.GET)
	@ResponseBody
	public Result selectDepartment() throws Exception{
		List<Department> departs=departmentService.selectDepartment();
		return Result.success(departs);
	}
	@RequestMapping(value="selectTeamByDepartment",method=RequestMethod.GET)
	@ResponseBody
	public Result selectTeamByDepartment(@RequestParam String bm){
		List<Sjzd> teams=departmentService.selectTeamByDepartment(bm);
		return Result.success(teams);
	}
	
	
}