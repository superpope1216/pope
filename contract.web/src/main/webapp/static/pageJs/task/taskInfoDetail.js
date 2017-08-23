/**
 * 
 */
$(document).ready(function(){
	var selRwzt="";
	if(flag=="examine"){
		$("#btnSave").show();
		$("#selRwzt").show();
	}
	doSyncGet(basePath+"/zdbdetail/list","tableName=T_CONTRACT_SJZD_TASKSTATUS_DETAIL",function(data){
		selRwzt=data.data;
	});
	setQueryRwzt();
	queryList();
	function setQueryRwzt(){
		if(selRwzt){
			var str="";
			for(var i=0;i<selRwzt.length;i++){
			 	str+="<option  value='"+selRwzt[i].lbdm+"'>"+selRwzt[i].lbmc+"</option>"
			}
			$("#selRwzt").append(str);
		}
	}
	
	function createSelect(id,value){
		var str="";
		str+='<select name="selRwzt" data-value="selRwzt'+id+'" class="form-control" >';
		if(selRwzt){
			for(var i=0;i<selRwzt.length;i++){
				var checked=" "
				if(value==selRwzt[i].lbdm){
					checked=" selected='selected' ";
				}
			 	str+="<option "+checked+" value='"+selRwzt[i].lbdm+"'>"+selRwzt[i].lbmc+"</option>"
			}
		}
		str+="</select>";
		return str;
	}
	
	function queryList(pageId){
		if(pageId==undefined){
			pageId=0;
		}
		$("#tblUserInfo").empty();
		doGet(basePath+"/task/listTaskDetailInfo","startPage="+pageId+"&pwid="+pwid,function(data){
			if(data.data){
				var tbl="";
				for(var i=0;i<data.data.data.length;i++){
					var d=data.data.data[i];
					tbl+='<tr>';
					if(flag=="examine"){
						tbl+='<td class="text-center"><input type="hidden" data-rwzt="hidRwzt'+d.wid+'" value="'+d.rwzt+'"><input type="checkbox" name="chkSingle" value="'+d.wid+'"/></td>';
					}
					tbl+='<td class="text-center">'+toStr(d.ypbh)+'</td>';
					tbl+='<td class="text-center">'+toStr(d.ypph)+'</td>';
					tbl+='<td class="text-left">'+toStr(d.ypyybh)+'</td>';
					tbl+='<td class="text-left">'+toStr(d.ypxz)+'</td>';
					tbl+='<td class="text-left">'+toStr(d.ypewm)+'</td>';
					tbl+='<td class="text-left">'+toStr(d.fxxm_display)+'</td>';
					tbl+='<td class="text-left">'+toStr(d.rwzt_display)+'</td>';
					if(flag=="examine"){
					tbl+='<td class="text-center">';
					tbl+='<div class="btn-group">';
					var btnName="";
					if(d.rwzt=="1"){
						btnName="检测";
						tbl+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnJc" data-key="'+d.wid+'">'+btnName+'</button>';
					}else if(d.rwzt=="2"){
						btnName="数据处理";
						tbl+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnSjcl" data-key="'+d.wid+'">'+btnName+'</button>';
					}else if(d.rwzt=="3"){
						btnName="完成";
						tbl+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnWc" data-key="'+d.wid+'">'+btnName+'</button>';
					}
					tbl+='</div>';
					tbl+='</td>';
					}
					//tbl+='<td class="text-left">'+createSelect(d.wid,d.rwzt)+'</td>';
					tbl+='</tr>';
				}
				$("#tblUserInfo").append(tbl);
				$("#mainTable").delegate("[data-option='btnJc']","click",function(){
					var key=$(this).attr("data-key");
					var saveData=new Array();
					saveData.push({wid:key,value:2});
					doPost(basePath+"/task/submitTaskInfoDetail", "pid="+pwid+"&datas="+JSON.stringify(saveData), function(data) {
						alert("提交成功");
						window.location.reload();
					});
				});
				$("#mainTable").delegate("[data-option='btnSjcl']","click",function(){
					var key=$(this).attr("data-key");
					var saveData=new Array();
					saveData.push({wid:key,value:3});
					doPost(basePath+"/task/submitTaskInfoDetail", "pid="+pwid+"&datas="+JSON.stringify(saveData), function(data) {
						alert("提交成功");
						window.location.reload();
					});
				});
				$("#mainTable").delegate("[data-option='btnWc']","click",function(){
					var key=$(this).attr("data-key");
					var saveData=new Array();
					saveData.push({wid:key,value:4});
					doPost(basePath+"/task/submitTaskInfoDetail", "pid="+pwid+"&datas="+JSON.stringify(saveData), function(data) {
						alert("提交成功");
						window.location.reload();
					});
				});
				//$("#mainTable").datatable({checkable: true});
			}
			pageHelper("#pageInfo",data.data.page-1,data.data.total,function(pageId){
				queryList(pageId);
			});
		})
	}
	
	$("#btnSave").click(function(){
		var selectData=$("#mainTable [name='chkSingle']:checked");
		
		if(!selectData ||selectData.length<=0){
			alert("请至少选择一条任务！");
			return;
		}
		var selRwzt=$("#selRwzt").val();
		if(!selRwzt){
			alert("请选择一个任务状态！");
			return;
		}
		var saveData=new Array();
		for(var i=0;i<selectData.length;i++){
			var c_wid=selectData[i].value;
			var c_value=$("#mainTable [data-rwzt='hidRwzt"+c_wid+"'").val();
			if(parseInt(c_value)>=parseInt(selRwzt)){
				alert("存在任务状态不满足提交条件的记录，请重新确认！");
				return;
			}
			if((parseInt(c_value)+1)!=parseInt(selRwzt)){
				alert("存在任务状态不满足提交条件的记录，请重新确认！");
				return;
			}
			
			c_value=selRwzt;
			
			saveData.push({wid:c_wid,value:c_value});
		}
		doPost(basePath+"/task/submitTaskInfoDetail", "pid="+pwid+"&datas="+JSON.stringify(saveData), function(data) {
			alert("提交成功");
			window.location.reload();
		});
		
	});
	
	$("#btnBack").click(function(){
		window.location=basePath+"/task/index"
	});
	$("#mainTable [name='selAll']").click(function(){
		if($(this)[0].checked){
			$("#mainTable [name='chkSingle']").prop("checked",true);
		}else{
			$("#mainTable [name='chkSingle']").prop("checked",false);
		}
	});
});