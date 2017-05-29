/**
 * 
 */
$(document).ready(function(){
	
	
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
		var url=basePath+"/users";
		if($("#modelEdithUserInfo [name='wid']").val()==""){
			url+="/insert";
		}else{
			url+="/update";
		}
		doPost(url,$("#modelEdithUserInfo form").serializeArray(),function(data){
			window.location.reload();
		});
	});
})