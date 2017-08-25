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
	function queryList(pageId){
		$("#tblZdbsInfo").empty();
		if(pageId==undefined){
			pageId=0;
		}
		var url=basePath+"/zdbs/list";
		doGet(url,"startPage="+pageId,function(data){
			var tbl="";
			if(data.data.data){
				
				for(var i=0;i<data.data.data.length;i++){
					var _d=data.data.data[i];
					tbl+='<tr>';	
					tbl+='<td class="text-center"><input type="hidden" name="wid" value="'+_d.wid+'">'+_d.code+'</td>';
					tbl+='<td class="text-left">'+toStr(_d.name)+'</td>';
					tbl+='<td class="text-center">'+toStr(_d.orderby)+'</td>';
					tbl+='<td class="text-center">';
					if(toStr(_d.canDelete)!="1"){
						tbl+='<a href="javascript:void(0);"  data-key="'+_d.wid+'" data-option="editZdbs" class="text-danger"><i class="icon-edit"></i></a>';
						tbl+='<a href="javascript:void(0);" data-key="'+_d.wid+'" data-option="deleteZdbs" class="text-danger"><i class="icon-trash"></i></a></td>';
					}
					tbl+='</tr>';
				}
				
				
			}else{
			}
			$('#tblZdbsInfo').html(tbl);
			pageHelper("#pageInfo",data.data.page-1,data.data.total,function(pageId){
				queryList(pageId);
			});
			$("#mainTable").delegate("[data-option='editZdbs']","click",function(){
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
			$("#mainTable").delegate("[data-option='deleteZdbs']","click",function(){
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