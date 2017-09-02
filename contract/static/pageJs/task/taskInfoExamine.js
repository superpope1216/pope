/**
 * 
 */
$(document).ready(function(){
	queryList();
	//queryJxz();
	queryShtg();
	queryShbtg();
	function queryList(){
		$("#tblTaskInfo").empty();
		doGet(basePath+"/taskExamine/listDsh","",function(data){
			if(data.data.data){
				$('#tblTaskInfoTpl').tmpl(data.data.data).appendTo('#tblTaskInfo');
				// $("#mainTable").datatable({checkable: true});
			}else{
				// $("#mainTable").datatable({checkable: true});
			}
			$("#mainTable").delegate("[data-option='pass']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认该项目任务审核通过吗？",function(data){
					doPost(basePath+"/taskExamine/examinePass", "wid="+key, function(data) {
						window.location.reload();
					});
				});
			});
			$("#mainTable").delegate("[data-option='notPass']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认该项目任务审核不通过吗？",function(data){
					doPost(basePath+"/taskExamine/examineNotPass", "wid="+key, function(data) {
						window.location.reload();
					});
				});
			});
		})
	}
	
	function queryJxz(){
		$("#tblJxzTaskInfo").empty();
		doGet(basePath+"/taskExamine/listJxz","",function(data){
			if(data.data.data){
				$('#tblTaskInfoTpl2').tmpl(data.data.data).appendTo('#tblJxzTaskInfo');
				// $("#mainTable").datatable({checkable: true});
			}
		});
	}
	
	function queryShtg(){
		$("#tblYwcTaskInfo").empty();
		doGet(basePath+"/taskExamine/listShtg","",function(data){
			if(data.data.data){
				$('#tblTaskInfoTpl2').tmpl(data.data.data).appendTo('#tblYwcTaskInfo');
				// $("#mainTable").datatable({checkable: true});
			}
		});
	}
	
	function queryShbtg(){
		$("#tblBtgTaskInfo").empty();
		doGet(basePath+"/taskExamine/listShbtg","",function(data){
			if(data.data.data){
				$('#tblTaskInfoTpl2').tmpl(data.data.data).appendTo('#tblBtgTaskInfo');
				// $("#mainTable").datatable({checkable: true});
			}
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
		doPost(basePath+"/task/submitTaskInfo", "datas="+JSON.stringify(saveData), function(data) {
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