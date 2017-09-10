/**
 * 
 */
$(document).ready(function(){
	var _validater=$("#levelForm").validate({
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
	
	setZdb();
	
	function setZdb(){
		doGetSelect(basePath+"/zdbdetail/list","tableName=T_CONTRACT_SJZD_QJLX","#modelEdithLevelInfo [name='type']")
	}
	function queryList(startPage){
		$("#tblLevelInfo").html("");
		if(startPage==undefined){
			startPage=0;
		}
		doGet(basePath+"/userleaves/list","startPage="+startPage,function(data){
			if(data.data.data){
				$('#tblLevelInfoTpl').tmpl(data.data.data).appendTo('#tblLevelInfo');
				//$("#mainTable").datatable({sortable: true});
			}else{
				//$("#mainTable").datatable({sortable: true});
			}
			pageHelper("#pageInfo",data.data.page-1,data.data.total,function(pageId){
				queryList(pageId);
			});
			$("#mainTable").delegate("[data-option='editLeave']","click",function(){
				var key=$(this).attr("data-key");
				$("#levelForm")[0].reset();
				$("#levelForm [name='wid']").val(key);
				doGet(basePath+"/userleaves/select","wid="+key,function(data){
					$("#levelForm [name='type']").val(data.data.type);
					$("#levelForm [name='name']").val(data.data.name);
					$("#levelForm [name='starttime']").val(data.data.starttime);
					$("#levelForm [name='endtime']").val(data.data.endtime);
					$("#levelForm [name='content']").val(data.data.content);
				});
				$("#modelEdithLevelInfo").modal("show");
			});
			$("#mainTable").delegate("[data-option='deleteLeave']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认删除该数据？",function(){
					doPost(basePath+"/userleaves/delete","wid="+key,function(data){
						window.location.reload();
					});
				});	
			});
		})
	}
	$("#btnNew").click(function(){
		$("#levelForm")[0].reset();
		$("#levelForm [name='wid']").val("");
		$("#modelEdithLevelInfo").modal("show");
	}); 
	
	$("#btnShLeaveInfo").click(function(){
		if(_validater.form()){
			$("#levelForm [name='taskstatus']").val("02");
			var url=basePath+"/userleaves";
			if($("#levelForm [name='wid']").val()==""){
				url+="/insert";
			}else{
				url+="/update";
			}
			doPost(url,$("#levelForm").serializeArray(),function(data){
				window.location.reload();
			});
		}
	});
	$("#btnSaveLeaveInfo").click(function(){
		if(_validater.form()){
			$("#levelForm [name='taskstatus']").val("01");
			var url=basePath+"/userleaves";
			if($("#levelForm [name='wid']").val()==""){
				url+="/insert";
			}else{
				url+="/update";
			}
			doPost(url,$("#levelForm").serializeArray(),function(data){
				window.location.reload();
			});
		}
	});
})