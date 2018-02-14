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
			},
			fxdj:{
				required:true,
				digits:true,
				min:0
			},
			zk:{
				required:true,
				number:true,
				min:0,
				max:1
			}
			
		}
	});
	queryList();
	function queryList(pageId){
		$("#tblZdbsInfo").empty();
		if(pageId==undefined){
			pageId=0;
		}
		var url=basePath+"/fxxmInfo/list";
		doGet(url,"startPage="+pageId,function(data){
			if(data.data.data){
				$('#tblZdbsInfoTpl').tmpl(data.data.data).appendTo('#tblZdbsInfo');
			}else{
			}
			pageHelper("#pageInfo",data.data.page-1,data.data.total,function(pageId){
				queryList(pageId);
			});
			$("#mainTable").delegate("[data-option='editZdbs']","click",function(){
				var key=$(this).attr("data-key");
				$("#zdbsForm")[0].reset();
				_validater.resetForm();
				$("#zdbsForm [name='wid']").val(key);
				setForm(key);
				$("#modelEditZdbsInfo").modal("show");
			});
			$("#mainTable").delegate("[data-option='deleteZdbs']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认删除该记录吗？",function(){
					doPost(basePath+"/fxxmInfo/delete","wid="+key,function(data){
						window.location.reload();
					});
				});	
			});
			
		})
	}
	
	
	$("#btnSaveZdbsInfo").click(function(){
		var url=basePath+"/fxxmInfo/save";
		if(_validater.form()){
			doPost(url,$("#zdbsForm").serializeArray(),function(data){
				alert(data.msg);
				window.location.reload();
			});
		}
		return false;
	});
	$("#btnNew").click(function(){
		$("#zdbsForm")[0].reset();
		_validater.resetForm();
		$("#zdbsForm [name='wid']").val("");
		setForm("");
		$("#modelEditZdbsInfo").modal("show");
	});
	
	function setForm(_wid){
		doGet(basePath+"/fxxmInfo/select","wid="+_wid,function(data){
			var _d=data.data;
			$("#zdbsForm [name='wid']").val(_d.wid);
			$("#zdbsForm [name='lbmc']").val(_d.lbmc);
			$("#zdbsForm [name='fxxlb']").val(_d.fxxlb);
			$("#zdbsForm [name='fxdj']").val(_d.fxdj);
			$("#zdbsForm [name='fxyj']").val(_d.fxyj);
			$("#zdbsForm [name='orderby']").val(_d.orderby);
			$("#zdbsForm [name='bz']").val(_d.bz);
			$("#zdbsForm [name='zk']").val(_d.zk);
			doGetUserSelect(basePath+"/fxxmInfo/selectFxry","","#zdbsForm [name='fxry']",_d.fxry);
			doGetUserSelect(basePath+"/fxxmInfo/selectShry","","#zdbsForm [name='shry']",_d.shry);
			
		});
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
});