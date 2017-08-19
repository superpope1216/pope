/**
 * 
 */
$(document).ready(function(){
	queryList();
	function queryList(pageId){
		if(pageId==undefined || pageId<0){
			pageId=0;
		}
		doGet(basePath+"/task/listTaskInfo","startPage="+pageId,function(data){
			if(data.data.data){
				$('#tblUserInfoTpl').tmpl(data.data.data).appendTo('#tblUserInfo');
				// $("#mainTable").datatable({checkable: true});
			}else{
				// $("#mainTable").datatable({checkable: true});
			}
			$("#mainTable").delegate("[data-option='copy']","click",function(){
				var key=$(this).attr("data-key");
				if(confirm("您确认复制该样品批次吗",function(data){
					doPost(basePath+"/batch/copyBatch", "wid="+key, function(data) {
						window.location=basePath+"/batch/detailIndex?wid="+data.data;
					});
				}));
			});
			$("#mainTable").delegate("[data-option='detail']","click",function(){
				var key=$(this).attr("data-key");
				window.location=basePath+"/task/taskDetailsIndex?wid="+key;
			});
			$("#mainTable").delegate("[data-option='lu']","click",function(){
				var key=$(this).attr("data-key");
				window.location=basePath+"/batch/detailIndex?wid="+key;
			});
			$("#mainTable").delegate("[data-option='gui']","click",function(){
				var key=$(this).attr("data-key");
				
			});
			$("#mainTable").delegate("[data-option='delete']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认删除该样品批次信息吗？",function(e){
					doPost(basePath+"/batch/deleteBatch","wid="+key,function(data){
						alert("样品批次删除成功！");
						window.location.reload();
					});
				});
			});
		})
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