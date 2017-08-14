/**
 * 
 */
$(document).ready(function(){
	
	
	var selRwzt="";
	doSyncGet(basePath+"/zdbdetail/list","tableName=T_CONTRACT_SJZD_TASKSTATUS",function(data){
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
	
	function queryList(){
		$("#tblUserInfo").empty();
		doGet(basePath+"/task/listTaskDetailInfo","pwid="+pwid,function(data){
			if(data.data){
				var tbl="";
				for(var i=0;i<data.data.data.length;i++){
					var d=data.data.data[i];
					tbl+='<tr>';
					tbl+='<td class="text-center"><input type="checkbox" name="chkSingle" value="'+d.wid+'"/></td>';
					tbl+='<td class="text-center">'+d.ypbh+'</td>';
					tbl+='<td class="text-center">'+d.ypph+'</td>';
					tbl+='<td class="text-left">'+d.ypyybh+'</td>';
					tbl+='<td class="text-left">'+d.ypxz+'</td>';
					tbl+='<td class="text-left">'+d.ypewm+'</td>';
					tbl+='<td class="text-left">'+d.fxxm_display+'</td>';
					tbl+='<td class="text-left">'+createSelect(d.wid,d.rwzt)+'</td>';
					tbl+='</tr>';
				}
				$("#tblUserInfo").append(tbl);
				//$("#mainTable").datatable({checkable: true});
			}else{
				//$("#mainTable").datatable({checkable: true});
			}
		})
	}
	
	$("#mainTable [name='selAll']").click(function(){
		if($(this)[0].checked){
			$("#mainTable [name='chkSingle']").prop("checked",true);
		}else{
			$("#mainTable [name='chkSingle']").prop("checked",false);
		}
	});
});