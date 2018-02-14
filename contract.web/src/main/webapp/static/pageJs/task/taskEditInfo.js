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
		if(taskId){
			doGet(basePath+"/task/taskaddView2?taskId="+taskId,"",function(data){
				if(data && data.data){
					var _detail=data.data;
					$("#taskForm [name='wid']").val(_detail.wid);
					$("#taskForm [name='pcwid']").val(_detail.pcwid);
					$("#taskForm [name='ypph']").val(_detail.ypph);
					$("#taskForm [name='jhkssj']").val(_detail.jhkssj);
					$("#taskForm [name='jhjssj']").val(_detail.jhjssj);
					doGetUserSelect(basePath+"/fxxmInfo/selectFxry","","#taskForm [name='rwfpr']",_detail.rwfpr);
					doGetUserSelect(basePath+"/fxxmInfo/selectShry","","#taskForm [name='rwshr']",_detail.rwshr);
					doGetSelect(basePath+"/task/selectFxxm","pcid="+pcid+"&taskId="+taskId,"#taskForm [name='fxxm']",_detail.fxxm);
					//doGetSelect2("T_CONTRACT_SJZD_FXXM", "#taskForm [name='fxxm']", _detail.fxxm);
				}
			});
		}else{
			doGet(basePath+"/task/taskaddView?wid="+pcid+"&taskId="+taskId,"",function(data){
				if(data && data.data){
					var _detail=data.data;
					$("#taskForm [name='pcwid']").val(_detail.wid);
					$("#taskForm [name='ypph']").val(_detail.ypph);
					$("#taskForm [name='pcwid']").val(pcid);
				
					doGetUserSelect(basePath+"/fxxmInfo/selectFxry","","#taskForm [name='rwfpr']",_detail.rwfpr);
					doGetUserSelect(basePath+"/fxxmInfo/selectShry","","#taskForm [name='rwshr']",_detail.rwshr);
					doGetSelect(basePath+"/task/selectFxxm","pcid="+pcid,"#taskForm [name='fxxm']",_detail.fxxm);
					//doGetSelect2("T_CONTRACT_SJZD_FXXM", "#taskForm [name='fxxm']", _detail.fxxm);
				}
			});
		}
	
	}
	 function doGetUserSelect(url,params,obj,data2,callBack){
		 $(obj).empty();
		 doGet(url,params,function(data){
			 var str="<option value=''>--请选择--</option>";
			 if(data.data && data.data.length>0){
				 for(var i=0;i<data.data.length;i++){
					 var checked="";
					if(data2 && data2==data.data[i].wid){
						checked=" selected='selected' ";
					}
					 str+="<option "+checked+" value='"+data.data[i].wid+"'>"+data.data[i].name1+"</option>"
				 }
			 }
			 $(obj).append(str);
			 if(callBack){
					 callBack();
			}
		 });
	 }
	 
	 $("#taskForm [name='fxxm']").change(function(){
		var _value=$(this).val();
		if(_value==""){
			$("#rwfpr").val("");
			$("#rwshr").val("");
		}else{
			doGet(basePath+"/task/selectFxxmById","wid="+_value,function(data){
				if(data && data.data){
					$("#taskForm [name='rwfpr']").val(data.data.fxry);
					$("#taskForm [name='rwshr']").val(data.data.shry);
				}
			});
		}
	 });
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