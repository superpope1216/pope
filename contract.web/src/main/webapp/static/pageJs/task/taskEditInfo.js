/**
 * 
 */
$(document).ready(function(){
	var _validater=$("#taskForm").validate({
		errorPlacement: function(error, element) {
			$(error).insertAfter($(element));
		}
	});
	queryDetail();
	
	function queryDetail(){
		doGet(basePath+"/task/taskaddView?wid="+pcid,"",function(data){
			if(data && data.data){
				var _detail=data.data;
				$("#taskForm [name='pcwid']").val(_detail.wid);
				$("#taskForm [name='ypph']").val(_detail.ypph);
				doGetSelect2("T_CONTRACT_SJZD_FXXM", "#taskForm [name='fxxm']", _detail.fxxm);
			}
		});
	}
	
	$("#btnSave").click(function(){
		if(_validater.form()){
			var url = basePath + "/task/save";
			var datas = $("#taskForm").serializeArray();
			doPost(url, datas, function(data) {
					window.location = basePath + "/task/index";
			});
		}
	});
});