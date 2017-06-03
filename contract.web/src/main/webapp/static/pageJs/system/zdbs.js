/**
 * 
 */
$(document).ready(function(){
	var _validater=$("#zdbsForm").validate({
		errorPlacement: function(error, element) {
			// Append error within linked label
			$(error).insertAfter($(element));
			//.append(error);
			//$("#mainForm").find( "label[for='" + element.attr( "id" ) + "']" ).append( error );
		},
		rules:{
			orderby:{
				required:true,
				digits:true
			}
		}
	});
	queryList();
	function queryList(){
		doGet(basePath+"/zdbs/list","",function(data){
			if(data.data.data){
				$('#tblZdbsInfoTpl').tmpl(data.data.data).appendTo('#tblZdbsInfo');
				$("#mainTable").datatable({sortable: true});
			}else{
				$("#mainTable").datatable({sortable: true});
			}
			pageHelper("#pageInfo",data.data.page-1,data.data.total,function(){
				
			});
			$("#datatable-mainTable").delegate("[data-option='editZdbs']","click",function(){
				var key=$(this).attr("data-key");
				$("#zdbsForm")[0].reset();
				$("#zdbsForm [name='wid']").val(key);
				doGet(basePath+"/zdbs/select","wid="+key,function(data){
					$("#zdbsForm [name='code']").val(data.data.code);
					$("#zdbsForm [name='name']").val(data.data.name);
					$("#zdbsForm [name='orderby']").val(data.data.orderby);
				});
				$("#modelEditZdbsInfo").modal("show");
			});
			$("#datatable-mainTable").delegate("[data-option='deleteZdbs']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认删除该字典表？",function(){
					doPost(basePath+"/zdbs/delete","wid="+key,function(data){
						window.location.reload();
					});
				});	
			});
			
		})
	}
	
	
	$("#btnSaveZdbsInfo").click(function(){
		var url=basePath+"/zdbs";
		var wid=$("#zdbsForm [name='wid']").val();
		var flag="update";
		if(wid){
			url+="/update";
			flag="update";
		}else{
			url+="/insert";
			flag="insert";
		}
		if(_validater.form()){
			doPost(url,$("#zdbsForm").serializeArray(),function(data){
				alert(data.msg);
				window.location.reload();
			});
		}
	});
	$("#btnNew").click(function(){
		$("#zdbsForm")[0].reset();
		$("#zdbsForm [name='wid']").val("");
		$("#modelEditZdbsInfo").modal("show");
	});
});