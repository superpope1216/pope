/**
 * 
 */
$(document).ready(function(){
	var _validater=$("#userForm").validate({
		errorPlacement: function(error, element) {
			// Append error within linked label
			$(error).insertAfter($(element));
			//.append(error);
			//$("#mainForm").find( "label[for='" + element.attr( "id" ) + "']" ).append( error );
		},
		rules:{
			phone:{
				required:true,
				isMobile:true
			},
			email:{
				required:true,
				email:true
			}
		}
	});
	
	queryList();
	function queryList(){
		doGet(basePath+"/users/list","",function(data){
			if(data.data.data){
				$('#tblUserInfoTpl').tmpl(data.data.data).appendTo('#tblUserInfo');
				$("#mainTable").datatable({sortable: true});
			}else{
				$("#mainTable").datatable({sortable: true});
			}
		})
	}
	$("#btnNew").click(function(){
		$("#modelEdithUserInfo").modal("show");
	})
	
	
	$("#btnSaveUserInfo").click(function(){
		if(_validater.form()){
			var url=basePath+"/users";
			if($("#modelEdithUserInfo [name='wid']").val()==""){
				url+="/insert";
			}else{
				url+="/update";
			}
			doPost(url,$("#modelEdithUserInfo form").serializeArray(),function(data){
				window.location.reload();
			});
		}
	});
})