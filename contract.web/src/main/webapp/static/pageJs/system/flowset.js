/**
 * 
 */


$(document).ready(function(){
	var _validater=$("#leaveExamineForm").validate({
		errorPlacement: function(error, element) {
			$(error).insertAfter($(element));
		}
	});
	var _supply_validater=$("#supplyExamineForm").validate({
		errorPlacement: function(error, element) {
			$(error).insertAfter($(element));
		}
	});
	var _task_validater=$("#taskExamineForm").validate({
		errorPlacement: function(error, element) {
			$(error).insertAfter($(element));
		}
	});
	var _contract_validater=$("#contractExamineForm").validate({
		errorPlacement: function(error, element) {
			$(error).insertAfter($(element));
		}
	});
	var _pxgl_validater=$("#pxglExamineForm").validate({
		errorPlacement: function(error, element) {
			$(error).insertAfter($(element));
		}
	});
	$("#btnNewLeave").click(function(){
		
		view("leaveExamineForm","");
		$("#modelEditLeaveInfo").modal("show");
	});
	$("#btnNewTask").click(function(){
		
		view("taskExamineForm","");
		$("#modelEditTaskInfo").modal("show");
	});
	$("#btnNewSupply").click(function(){
		
		view("taskSupplyForm","");
		$("#modelSupplyInfo").modal("show");
	});
	$("#btnNewContract").click(function(){
		
		view("taskContractForm","");
		$("#modelContractInfo").modal("show");
	});
	$("#btnNewPxgl").click(function(){
		
		view("pxglExamineForm","");
		$("#modelPxglInfo").modal("show");
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
				$("#supplyExamineForm [name='name']").append(str);
				$("#contractExamineForm [name='name']").append(str);
				$("#pxglExamineForm [name='name']").append(str);
			}
	});
	setSelectList("");
	
	function view(formName,wid){
		if(formName=="leaveExamineForm"){
			_validater.resetForm();
		}else if(formName=="taskExamineForm"){
			_task_validater.reset();
		}else if(formName=="supplyExamineForm"){
			_supply_validater.resetForm();
		}else if(formName=="contractExamineForm"){
			_contract_validater.resetForm();
		}else if(formName=="pxglExamineForm"){
			_pxgl_validater.resetForm();
		}
		$("#"+formName)[0].reset();
		doGet(basePath+"/flowset/view","wid="+wid,function(data){
			if(data && data.data){
				var _d=data.data;
				$("#"+formName+" [name='wid']").val(_d.wid);
				//$("#"+formName+" [name='type']").val(_d.type);
				$("#"+formName+" [name='px']").val(_d.px);
				$("#"+formName+" [name='shType']").val(_d.shType);
				$("#"+formName+" [name='name']").val(_d.name);
			}
		});
	}
	queryList("01","tblUserLeaveInfoTpl","tblUserLeaveTable","leaveExamineForm","modelEditLeaveInfo");
	queryList("02","tblTaskInfoTpl","tblUserTaskTable","taskExamineForm","modelEditTaskInfo");
	queryList("03","tblTaskInfoTpl","tblSupplyTable","supplyExamineForm","modelSupplyInfo");
	queryList("04","tblTaskInfoTpl","tblContractTable","contractExamineForm","modelContractInfo");
	queryList("05","tblTaskInfoTpl","tblPxglTable","pxglExamineForm","modelPxglInfo");
	function queryList(type,tblTpl,tbl,form,model){
		doGet(basePath+"/flowset/list","type="+type,function(data){
			if(data.data){
				$('#'+tblTpl).tmpl(data.data).appendTo('#'+tbl);
			}
		});
		//编辑
		$("#"+tbl).delegate("[data-option='editZdbs']","click",function(){
			var key=$(this).attr("data-key");
			view(form,key);
			$("#"+model).modal("show");
		});
		$("#"+tbl).delegate("[data-option='deleteZdbs']","click",function(){
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
		save("taskExamineForm",_task_validater);
	});
	$("#btnSaveSupplyInfo").click(function(){
		save("supplyExamineForm",_supply_validater);
	});
	$("#btnSaveLeaveInfo").click(function(){
		save("leaveExamineForm",_validater);
	});
	$("#btnSaveContractInfo").click(function(){
		save("contractExamineForm",_contract_validater);
	});
	$("#btnSavePxglInfo").click(function(){
		save("pxglExamineForm",_pxgl_validater);
	});
	function save(formId,validate){
		var url=basePath+"/flowset";
		var wid=$("#"+formId+" [name='wid']").val();
		var flag="update";
		if(wid){
			url+="/update";
			flag="update";
		}else{
			url+="/insert";
			flag="insert";
		}
		if(validate.form()){
			doPost(url,$("#"+formId).serializeArray(),function(data){
				alert(data.msg);
				window.location.reload();
			});
		}
	}
});