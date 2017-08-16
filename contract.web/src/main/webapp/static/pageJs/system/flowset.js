/**
 * 
 */


$(document).ready(function(){
	var _validater=$("#leaveExamineForm").validate({
		errorPlacement: function(error, element) {
			$(error).insertAfter($(element));
		}
	});
	var _task_validater=$("#taskExamineForm").validate({
		errorPlacement: function(error, element) {
			$(error).insertAfter($(element));
		}
	});
	queryList();
	queryTaskList();
	$("#btnNewLeave").click(function(){
		view("leaveExamineForm","");
		$("#modelEditLeaveInfo").modal("show");
	});
	$("#btnNewTask").click(function(){
		view("taskExamineForm","");
		$("#modelEditTaskInfo").modal("show");
	});
	doGet(basePath+"/roles/list","",function(data){ 
			if(data && data.data && data.data.roles){
				var _d=data.data.roles;
				var str="";
				str+="<option value=''>---请选择---</option>";
				for(var i=0;i<_d.length;i++){
					str+="<option value='"+_d[i].wid+"'>"+_d[i].name+"</option>"; 
				}
				$("#leaveExamineForm [name='name']").append(str);
				$("#taskExamineForm [name='name']").append(str);
			}
	});
	
	function view(formName,wid){
		doGet(basePath+"/flowset/view","wid="+wid,function(data){
			if(data && data.data){
				var _d=data.data;
				$("#"+formName+" [name='wid']").val(_d.wid);
				$("#"+formName+" [name='type']").val(_d.type);
				$("#"+formName+" [name='px']").val(_d.px);
				$("#"+formName+" [name='shType']").val(_d.shType);
				$("#"+formName+" [name='name']").val(_d.name);
			}
		});
	}
	function queryList(){
		doGet(basePath+"/flowset/list","type=01",function(data){
			if(data.data){
				$('#tblUserLeaveInfoTpl').tmpl(data.data).appendTo('#tblUserLeaveTable');
			}
		});
		//编辑
		$("#tblUserLeaveInfoTpl").delegate("[data-option='editZdbs']","click",function(){
			var key=$(this).attr("data-key");
			view("leaveExamineForm",key);
			$("#modelEditLeaveInfo").modal("show");
		});
		$("#tblUserLeaveInfoTpl").delegate("[data-option='deleteZdbs']","click",function(){
			var key=$(this).attr("data-key");
			confirm("您确认删除该记录？",function(){
				doPost(basePath+"/flowset/delete","wid="+key,function(data){
					window.location.reload();
				});
			});
			
		});
	}
	
	function queryTaskList(){
		doGet(basePath+"/flowset/list","type=02",function(data){
			if(data.data){
				$('#tblTaskInfoTpl').tmpl(data.data).appendTo('#tblUserTaskTable');
			}
		});
		//编辑
		$("#tblUserTaskTable").delegate("[data-option='editZdbs']","click",function(){
			var key=$(this).attr("data-key");
			view("taskExamineForm",key);
			$("#modelEditTaskInfo").modal("show");
		});
		$("#tblUserTaskTable").delegate("[data-option='deleteZdbs']","click",function(){
			var key=$(this).attr("data-key");
			confirm("您确认删除该记录？",function(){
				doPost(basePath+"/flowset/delete","wid="+key,function(data){
					window.location.reload();
				});
			});
		});
	}
	function setSelectList(value){
		doGetSelect(basePath+"/zdbdetail/list","tableName=T_CONTRACT_SJZD_SHTYPE","#leaveExamineForm [name='shType']",value);
	}
	
	$("#btnSaveTaskInfo").click(function(){
		var url=basePath+"/flowset";
		var wid=$("#taskExamineForm [name='wid']").val();
		var flag="update";
		if(wid){
			url+="/update";
			flag="update";
		}else{
			url+="/insert";
			flag="insert";
		}
		if(_task_validater.form()){
			doPost(url,$("#taskExamineForm").serializeArray(),function(data){
				alert(data.msg);
				window.location.reload();
			});
		}
	});
	$("#btnSaveLeaveInfo").click(function(){
		var url=basePath+"/flowset";
		var wid=$("#leaveExamineForm [name='wid']").val();
		var flag="update";
		if(wid){
			url+="/update";
			flag="update";
		}else{
			url+="/insert";
			flag="insert";
		}
		if(_validater.form()){
			doPost(url,$("#leaveExamineForm").serializeArray(),function(data){
				alert(data.msg);
				window.location.reload();
			});
		}
	});
});