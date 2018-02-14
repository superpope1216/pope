package com.pope.contract.web.usermanage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pope.contract.code.DataStatus;
import com.pope.contract.code.Result;
import com.pope.contract.dto.PageParam;
import com.pope.contract.entity.project.extend.BatchInfoExtend;
import com.pope.contract.entity.user.UserInfo;
import com.pope.contract.entity.user.UserInfoRole;
import com.pope.contract.entity.user.extend.UserInfoExtend;
import com.pope.contract.service.user.UserInfoService;
import com.pope.contract.util.CommonUtil;
import com.pope.contract.util.ConstantUtil;
import com.pope.contract.util.DateUtil;
import com.pope.contract.util.ExportExcel;
import com.pope.contract.util.StringUtil;
import com.pope.contract.web.BaseController;

@Controller
@RequestMapping("users")
public class UserController extends BaseController{

	@Autowired
	private UserInfoService userInfoService;
	@RequestMapping("index")
	public ModelAndView index(){
		ModelAndView mv=new ModelAndView();
		mv.addObject("buttons",this.getButtonPermission("/users/index"));
		mv.setViewName("usermanage/userInfo");
		return mv;
	}
	@RequestMapping(value="list",method=RequestMethod.GET)
	@ResponseBody
	public Result list(String queryName,Integer startPage) throws Exception{
		if(startPage==null ||startPage<0){
			startPage=0;
		}
		UserInfoExtend queryInfo=new UserInfoExtend();
		if(!StringUtils.isEmpty(queryName)){
			queryName=queryName.trim();
			queryInfo.setQueryCondition(queryName);
		}
		PageParam<UserInfoExtend> pageParam = new PageParam<UserInfoExtend>();
		pageParam.setPage(startPage);
		Page<UserInfoExtend> page = PageHelper.startPage(pageParam.getPage(), pageParam.getPageSize());
		List<UserInfoExtend> users=userInfoService.selectDisplayByCondition(queryInfo);
		pageParam.setTotal(page.getTotal());
		pageParam.setTotalPage(pageParam.getTotalPage());
		pageParam.setData(users);
		return Result.success(pageParam);
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseBody
	public Result update(UserInfo userInfo,String userInfoRoles) throws Exception{
		userInfoService.updateByPrimaryKeySelective(userInfo,this.getUserId(),userInfoRoles);
		return Result.success();
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public Result delete (String wid) throws Exception{
		userInfoService.deleteByPrimaryKey(wid);
		return Result.success();
	}
	@RequestMapping(value="insert",method=RequestMethod.POST)
	@ResponseBody
	public Result insert(UserInfo userInfo,String userInfoRoles) throws Exception{
		
		userInfoService.insert(userInfo,this.getUserId(),userInfoRoles);
		return Result.success();
	}
	@RequestMapping(value="select",method=RequestMethod.GET)
	@ResponseBody
	public Result select(String wid) throws Exception{
		UserInfoExtend queryInfo=new UserInfoExtend();
		queryInfo.setWid(wid);
		List<UserInfoExtend> users=userInfoService.selectDisplayByCondition(queryInfo);
		UserInfoExtend user=users.get(0);
		UserInfoRole queryUserInfoRole=new UserInfoRole();
		queryUserInfoRole.setUserid(user.getWid());
		List<UserInfoRole> lstRoles=userInfoService.selectUserInfoRole(queryUserInfoRole);
		if(CommonUtil.isNotEmptyList(lstRoles)){
			
			List<String> lst=new ArrayList<String>();
			for(UserInfoRole userInfoRole:lstRoles){
				lst.add(userInfoRole.getRoleid());
			}
			String roles=StringUtil.join(lst);
			user.setRole(roles);
		}
		return Result.success(user);
	}
	
	@RequestMapping("export")
	public void export(HttpServletResponse response) throws Exception{
		List<UserInfoExtend> users=userInfoService.selectDisplayByCondition(null);
		String[] headers=new String[12];
		headers[0]="姓名";
		headers[1]="工号";
		headers[2]="手机号";
		headers[3]="邮箱地址";
		headers[4]="部门信息";
		headers[5]="小组";
		headers[6]="出生年月";
		headers[7]="学位";
		headers[8]="职位类别";
		headers[9]="职位";
		headers[10]="合同有效期";
		headers[11]="合同签订时间";
		
		List<List<String>> list=new ArrayList<List<String>>();
		if(CommonUtil.isNotEmptyList(users)){
			
			for(UserInfoExtend extend:users){
				List<String> data=new ArrayList<String>();
				list.add(data);
				data.add(StringUtil.toStr(extend.getName1()));
				data.add(StringUtil.toStr(extend.getGh()));
				data.add(StringUtil.toStr(extend.getPhone()));
				data.add(StringUtil.toStr(extend.getEmail()));
				data.add(StringUtil.toStr(extend.getDepartment_display()));
				data.add(StringUtil.toStr(extend.getTeam_display()));
				data.add(StringUtil.toStr(extend.getBirthday()));
				data.add(StringUtil.toStr(extend.getDegree()));
				data.add(StringUtil.toStr(extend.getJobcategory_display()));
				data.add(StringUtil.toStr(extend.getJob()));
				data.add(StringUtil.toStr(extend.getContractvalidity()));
				data.add(StringUtil.toStr(extend.getContracttime()));	
			}
		}
		ExportExcel.doExportExcel2("人员基本信息","人员基本信息",  headers, list,response);
	}
}
