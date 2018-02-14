/**
 * 
 */
$(document).ready(function(){
	var _validater = $("#roleForm").validate({
		errorPlacement : function(error, element) {
			// Append error within linked label
			$(error).insertAfter($(element));
			// .append(error);
			// $("#mainForm").find( "label[for='" + element.attr( "id" )
			// + "']"
			// ).append( error );
		},
		rules : {
		}
	});
	queryList();
	
	function queryList(){
		doGet(basePath+"/roles/list","",function(data){
			if(data.data){
				$('#tblRoleInfoTpl').tmpl(data.data.roles).appendTo('#tblRoleInfo');
			}
		});
	}
	

	 $("#tblRoleInfo").delegate( "tr", "click", function() {
		 var roleId=$(this).find("[name='wid']").val();
		 $("#tblRoleInfo tr").removeClass("active");
		 $(this).addClass("active");
		 doGet(basePath+"/customAccountAlarm/selectAlaramByPermissionId","perId="+roleId,function(data){
			if(data.data){
				var _data=data.data;
				$("#alarmForm [name='wid']").val(_data.wid);
				$("#alarmForm [name='permissionId']").val(_data.permissionId);
				if(_data.customAccount=="1"){
					$("#alarmForm [name='customAccount']").prop("checked",true);
				}else{
					$("#alarmForm [name='customAccount']").prop("checked",false);
				}
			}
		 });
	 });
	
	$("#btnSavePerms").click(function(){
		var data=$("#alarmForm").serializeArray();
		if($("#alarmForm [name='customAccount']:checked")){
			for(var i=0;i<data.length;i++){
				if(data[i].name=='customAccount'){
					data[i].value="1";
				}
			}
		}else{
			for(var i=0;i<data.length;i++){
				if(data[i].name=='customAccount'){
					data[i].value="1";
				}
			}
		}
		doPost(basePath+"/customAccountAlarm/save",data,function(data){
			alert("保存成功！");
			window.location.reload();
		});
	});
	
});