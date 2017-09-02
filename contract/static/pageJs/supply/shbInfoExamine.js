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
		doGet(basePath+"/shbExamine/listDsh","startPage="+pageId,function(data){
			if(data.data.data){
				$('#tblTaskInfoTpl').tmpl(data.data.data).appendTo('#tblTaskInfo');
				// $("#mainTable").datatable({checkable: true});
			}else{
				// $("#mainTable").datatable({checkable: true});
			}
			pageHelper("#pageInfo",data.data.page-1,data.data.total,function(pageId){
				queryList(pageId);
			});
			$("#mainTable").delegate("[data-option='pass']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认该项目任务审核通过吗？",function(data){
					doPost(basePath+"/shbExamine/examinePass", "wid="+key, function(data) {
						window.location.reload();
					});
				});
			});
			$("#mainTable").delegate("[data-option='notPass']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认该项目任务审核不通过吗？",function(data){
					doPost(basePath+"/shbExamine/examineNotPass", "wid="+key, function(data) {
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
		doGet(basePath+"/shbExamine/listJxz","startPage="+pageId,function(data){
			if(data.data.data){
				$('#tblTaskInfoTpl2').tmpl(data.data.data).appendTo('#tblJxzTaskInfo');
				// $("#mainTable").datatable({checkable: true});
			}
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
		doGet(basePath+"/shbExamine/listShtg","startPage="+pageId,function(data){
			if(data.data.data){
				$('#tblTaskInfoTpl2').tmpl(data.data.data).appendTo('#tblYwcTaskInfo');
				// $("#mainTable").datatable({checkable: true});
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
		doGet(basePath+"/shbExamine/listShbtg","startPage="+pageId,function(data){
			if(data.data.data){
				$('#tblTaskInfoTpl2').tmpl(data.data.data).appendTo('#tblBtgTaskInfo');
				// $("#mainTable").datatable({checkable: true});
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
		doPost(basePath+"/shbExamine/submitTaskInfo", "datas="+JSON.stringify(saveData), function(data) {
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