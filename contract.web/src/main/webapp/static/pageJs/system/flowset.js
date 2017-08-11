/**
 * 
 */


$(document).ready(function(){
	var _validater=$("#leaveExamineForm").validate({
		errorPlacement: function(error, element) {
			$(error).insertAfter($(element));
		}
	});
	queryList();
	$("#btnNewLeave").click(function(){
		$("#modelEditLeaveInfo").modal("show");
	});
	setSelectList("");
	doGet(basePath+"/roles/list","",function(data){ 
			if(data && data.data && data.data.roles){
				var _d=data.data.roles;
				var str="";
				for(var i=0;i<_d.length;i++){
					str+="<option value='"+_d[i].wid+"'>"+_d[i].name+"</option>";
					
				}
				$("#leaveExamineForm [name='name']").append(str);
			}
	});
	
	function queryList(){
		doGet(basePath+"/flowset/list","type=01",function(data){
			if(data.data){
				$('#tblUserLeaveInfoTpl').tmpl(data.data).appendTo('#tblUserLeaveTable');
			}
		})
	}
	function setSelectList(value){
		doGetSelect(basePath+"/zdbdetail/list","tableName=T_CONTRACT_SJZD_SHTYPE","#leaveExamineForm [name='shType']",value);
	}
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