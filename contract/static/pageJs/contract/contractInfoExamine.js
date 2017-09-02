/**
 * 
 */
$(document).ready(function(){
	queryList();
	queryJxz();
	queryShtg();
	queryShbtg();
	function queryList(pageId){
		if(pageId==undefined){
			pageId=0;
		}
		$("#tblTaskInfo").empty();
		doGet(basePath+"/contractInfoExamine/listDsh","startPage="+pageId,function(data){
			if(data.data.data){
				var _data = data.data.data;
				var _tr = ""; 
				for (var i = 0; i < _data.length; i++) {
					_tr += '<tr>';
					_tr += '<td class="text-center">'+ toStr(_data[i].htsj)+ '</td>';
					_tr += '<td class="text-center">'+ toStr(_data[i].htmc)	+ '</td>';
					_tr += '<td class="text-center">'+ toStr(_data[i].htbh)	+ '</td>';
					_tr += '<td class="text-left">'	+ toStr(_data[i].htlx_display)+ '</td>';
					_tr += '<td class="text-left">'	+ toStr(_data[i].htjf)+ '</td>';
					_tr += '<td class="text-left">'	+ toStr(_data[i].dfzh)+ '</td>';
					_tr += '<td class="text-center">'+ toStr(_data[i].htje)	+ '</td>';
					_tr += '<td class="text-center">';
					_tr += '<div class="btn-group">';
					_tr += '<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="pass" data-key="'+_data[i].wid+'">通过</button>';
					_tr += '<button type="button" style="margin-left:4px;" class="btn btn-xs btn-danger" data-option="notPass" data-key="'+_data[i].wid+'"><i class="icon icon-times"></i>不通过</button>';
					_tr += '<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnDetail" data-key="'
						+ _data[i].wid
						+ '">详</button>';
					_tr += '</div>';
					_tr+="</td>";
					_tr+="</tr>";
						
				}
				$("#tblTaskInfo").html(_tr);
				// $("#mainTable").datatable({checkable: true});
			}
			pageHelper("#pageInfo",data.data.page-1,data.data.total,function(pageId){
				queryList(pageId);
			});
			$("#mainTable").delegate("[data-option='pass']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认该合同审核通过吗？",function(data){
					doPost(basePath+"/contractInfoExamine/examinePass", "wid="+key, function(data) {
						window.location.reload();
					});
				});
			});
			$("#mainTable").delegate("[data-option='btnDetail']","click",function(){
				var key = $(this).attr("data-key");
				window.location = basePath+ "/contractEditInfo/viewIndex?wid="+ key;
			});
			$("#mainTable").delegate("[data-option='notPass']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认该合同审核不通过吗？",function(data){
					doPost(basePath+"/contractInfoExamine/examineNotPass", "wid="+key, function(data) {
						window.location.reload();
					});
				});
			});
		})
	}
	
	function queryJxz(pageId){
		if(pageId==undefined){
			pageId=0;
		}
		$("#tblJxzTaskInfo").empty();
		doGet(basePath+"/contractInfoExamine/listJxz","startPage="+pageId,function(data){
			if(data.data.data){
				var _data = data.data.data;
				var _tr = ""; 
				for (var i = 0; i < _data.length; i++) {
					_tr += '<tr>';
					_tr += '<td class="text-center">'+ toStr(_data[i].htsj)+ '</td>';
					_tr += '<td class="text-center">'+ toStr(_data[i].htmc)	+ '</td>';
					_tr += '<td class="text-center">'+ toStr(_data[i].htbh)	+ '</td>';
					_tr += '<td class="text-left">'	+ toStr(_data[i].htlx_display)+ '</td>';
					_tr += '<td class="text-left">'	+ toStr(_data[i].htjf)+ '</td>';
					_tr += '<td class="text-left">'	+ toStr(_data[i].dfzh)+ '</td>';
					_tr += '<td class="text-center">'+ toStr(_data[i].htje)	+ '</td>';
					_tr += '<td class="text-center">';
					_tr += '<div class="btn-group">';
					_tr += '<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnDetail" data-key="'
						+ _data[i].wid
						+ '">详</button>';
					_tr += '</div>';
					_tr+="</td>";
					_tr+="</tr>";
						
				}
				$("#tblJxzTaskInfo").html(_tr);
			}
			$("#tblJxzTaskInfo").delegate("[data-option='btnDetail']","click",function(){
				var key = $(this).attr("data-key");
				window.location = basePath+ "/contractEditInfo/viewIndex?wid="+ key;
			});
			pageHelper("#jxzPageInfo",data.data.page-1,data.data.total,function(pageId){
				queryJxz(pageId);
			});
		});
	}
	
	function queryShtg(pageId){
		if(pageId==undefined){
			pageId=0;
		}
		$("#tblYwcTaskInfo").empty();
		doGet(basePath+"/contractInfoExamine/listShtg","startPage="+pageId,function(data){
			if(data.data.data){
				var _data = data.data.data;
				var _tr = ""; 
				for (var i = 0; i < _data.length; i++) {
					_tr += '<tr>';
					_tr += '<td class="text-center">'+ toStr(_data[i].htsj)+ '</td>';
					_tr += '<td class="text-center">'+ toStr(_data[i].htmc)	+ '</td>';
					_tr += '<td class="text-center">'+ toStr(_data[i].htbh)	+ '</td>';
					_tr += '<td class="text-left">'	+ toStr(_data[i].htlx_display)+ '</td>';
					_tr += '<td class="text-left">'	+ toStr(_data[i].htjf)+ '</td>';
					_tr += '<td class="text-left">'	+ toStr(_data[i].dfzh)+ '</td>';
					_tr += '<td class="text-center">'+ toStr(_data[i].htje)	+ '</td>';
					_tr += '<td class="text-center">';
					_tr += '<div class="btn-group">';
					_tr += '<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnDetail" data-key="'
						+ _data[i].wid
						+ '">详</button>';
					_tr += '</div>';
					_tr+="</td>";
					_tr+="</tr>";
						
				}
				$("#tblYwcTaskInfo").html(_tr);
				$("#tblYwcTaskInfo").delegate("[data-option='btnDetail']","click",function(){
					var key = $(this).attr("data-key");
					window.location = basePath+ "/contractEditInfo/viewIndex?wid="+ key;
				});
			}
			pageHelper("#ywcPageInfo",data.data.page-1,data.data.total,function(pageId){
				queryShtg(pageId);
			});
			
		});
	}
	
	function queryShbtg(pageId){
		if(pageId==undefined){
			pageId=0;
		}
		$("#tblBtgTaskInfo").empty();
		doGet(basePath+"/contractInfoExamine/listShbtg","startPage="+pageId,function(data){
			if(data.data.data){
				var _data = data.data.data;
				var _tr = ""; 
				for (var i = 0; i < _data.length; i++) {
					_tr += '<tr>';
					_tr += '<td class="text-center">'+ toStr(_data[i].htsj)+ '</td>';
					_tr += '<td class="text-center">'+ toStr(_data[i].htmc)	+ '</td>';
					_tr += '<td class="text-center">'+ toStr(_data[i].htbh)	+ '</td>';
					_tr += '<td class="text-left">'	+ toStr(_data[i].htlx_display)+ '</td>';
					_tr += '<td class="text-left">'	+ toStr(_data[i].htjf)+ '</td>';
					_tr += '<td class="text-left">'	+ toStr(_data[i].dfzh)+ '</td>';
					_tr += '<td class="text-center">'+ toStr(_data[i].htje)	+ '</td>';
					_tr += '<td class="text-center">';
					_tr += '<div class="btn-group">';
					_tr += '<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnDetail" data-key="'
						+ _data[i].wid
						+ '">详</button>';
					_tr += '</div>';
					_tr+="</td>";
					_tr+="</tr>";
						
				}
				$("#tblBtgTaskInfo").html(_tr);
				$("#tblBtgTaskInfo").delegate("[data-option='btnDetail']","click",function(){
					var key = $(this).attr("data-key");
					window.location = basePath+ "/contractEditInfo/viewIndex?wid="+ key;
				});
			}
			pageHelper("#btgPageInfo",data.data.page-1,data.data.total,function(pageId){
				queryShbtg(pageId);
			});
		});
	}
	
	$("#btnSubmitSh").click(function(){
		var selectData=$("#mainTable [name='chkSingle']:checked");
		if(!selectData ||selectData.length<=0){
			alert("请至少选择一条任务！");
			return;
		}
		var saveData=new Array();
		for(var i=0;i<selectData.length;i++){
			var c_wid=$(selectData[i]).val();
			var c_rwzt=$($(selectData[i])).attr("data-rwzt");
			if(c_rwzt!=4){
				alert("选中的任务存在不为数据报告的任务，请重新选择");
				return false;
			}
			saveData.push({wid:c_wid,value:c_rwzt});
		}
		doPost(basePath+"/contractInfoExamine/submitTaskInfo", "datas="+JSON.stringify(saveData), function(data) {
			alert("提交成功");
			window.location.reload();
		});
	});
	
	
	$("#mainTable [name='selAll']").click(function(){
		if($(this)[0].checked){
			$("#mainTable [name='chkSingle']").prop("checked",true);
		}else{
			$("#mainTable [name='chkSingle']").prop("checked",false);
		}
	});
});