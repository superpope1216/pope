package com.pope.contract.web.task;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pope.contract.code.Result;
import com.pope.contract.entity.contract.ContractFbsqdInfo;
import com.pope.contract.entity.task.TaskJcInfo;
import com.pope.contract.entity.task.extend.TaskJcInfoExtend;
import com.pope.contract.service.task.TaskJcInfoService;
import com.pope.contract.util.StringUtil;
import com.pope.contract.util.TempleWordUtil;
import com.pope.contract.web.BaseController;

/**
* @author zhanglingyun E-mail:
* @version 创建时间：2017年9月23日 下午11:13:25
* 类说明
*/
@Controller
@RequestMapping("taskPrint")
public class TaskPrintController extends BaseController{

	@Autowired
	private TaskJcInfoService taskJcInfoService;
	@RequestMapping("index")
	public ModelAndView index(String wid) throws Exception{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("task/taskPrint");
		mv.addObject("wid",wid);
		return mv;
	}
	
	@RequestMapping("select")
	@ResponseBody
	public Result select(String taskId) throws Exception{
		TaskJcInfoExtend taskJcInfoExtend=taskJcInfoService.showPrint(taskId);
		return Result.success(taskJcInfoExtend);
	}
	
	@ResponseBody
	@RequestMapping("save")
	public Result save(TaskJcInfo taskJcInfo) throws Exception{
		if(StringUtils.isEmpty(taskJcInfo.getWid())){
			taskJcInfo.setWid(StringUtil.getUuId());
			taskJcInfoService.insertSelective(taskJcInfo);
		}else{
			taskJcInfoService.updateByPrimaryKeySelective(taskJcInfo);
		}
		return Result.success();
	}
	
	@RequestMapping("download")
	public void download(String taskId,HttpServletResponse response, HttpServletRequest request) throws Exception{
		String templatePath = request.getServletContext().getRealPath("") + "/static/rwjcsqb.docx";
		
	    String fileName = new String("任务检测申请表".getBytes("utf-8"), "ISO8859-1") + ".docx";
	    /*数据*/
	    Map<String, Object> params = new HashMap<String, Object>();  
	    TaskJcInfoExtend taskJcInfoExtend=taskJcInfoService.showPrint(taskId);
	    params.put("${yplp}", taskJcInfoExtend.getYplp());
	    params.put("${ypsl}",StringUtil.toStr(taskJcInfoExtend.getYpsl()));
	    params.put("${wtbh}", taskJcInfoExtend.getWtbh());
	    params.put("${sybh}", taskJcInfoExtend.getSybh());
	    params.put("${jcxm}", taskJcInfoExtend.getJcxm());
	    params.put("${jcyj}", taskJcInfoExtend.getJcyj());
	    params.put("${syr}", taskJcInfoExtend.getSyr());
	    params.put("${sysj}", taskJcInfoExtend.getSysj());
	    params.put("${lyr}", taskJcInfoExtend.getLyr());
	    params.put("${lysj}", taskJcInfoExtend.getLysj());
	    params.put("${jcr}", taskJcInfoExtend.getJcr());
	    params.put("${jcsj}", taskJcInfoExtend.getJcsj());
	    params.put("${shry}", taskJcInfoExtend.getShry());
	    params.put("${shsj}", taskJcInfoExtend.getShsj());
	    params.put("${bz}", taskJcInfoExtend.getBz());
//	    params.put("${sex}", "bbbb");

	   TempleWordUtil wordUtil = new TempleWordUtil();

	    XWPFDocument doc;  
	    InputStream is = new FileInputStream(templatePath);
	  //  is = getClass().getClassLoader().getResourceAsStream(templatePath);  
	    doc = new XWPFDocument(is);   //只能使用.docx的

	    wordUtil.replaceInPara(doc, params);  
	    //替换表格里面的变量  
	    wordUtil.replaceInTable(doc, params);  
	    OutputStream os = response.getOutputStream();  

	    response.setContentType("application/vnd.ms-excel");  
	    response.setHeader("Content-disposition", "attachment;filename=" + fileName);  

	    doc.write(os);  

	    wordUtil.close(os);  
	    wordUtil.close(is);  

	    os.flush();  
	    os.close();  
	}
}
