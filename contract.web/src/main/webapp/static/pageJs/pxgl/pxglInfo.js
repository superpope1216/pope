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
			pxfy:{
				required:true,
				number:true
			}
		}
	});
	setButtonsDisplay(buttonsPermission);
	queryList();
	//queryRole();
	doGetSelect2("T_CONTRACT_SJZD_PXLX","#queryContractForm [name='queryPxlx']");
	doGet(basePath+"/zdbdetail/selectRwzt","",function(data){
		$("#queryContractForm [name='queryRwzt']").empty();
		 var str="<option value=''>--请选择--</option>";
		if(data.data && data.data.length>0){
			 for(var i=0;i<data.data.length;i++){
				 str+="<option  value='"+data.data[i].lbdm+"'>"+data.data[i].lbmc+"</option>"
			 }
		 }
		$("#queryContractForm [name='queryRwzt']").append(str);
	});
	$("#btnQuery").click(function(){
		queryList();
	});
	function queryList(pageId){
		$('#tblUserInfo').empty();
		if(pageId==undefined){
			pageId=0;
		}
		var params="startPage="+pageId;
		params+="&pxlx="+$("#queryContractForm [name='queryPxlx']").val();
		params+="&pxmc="+$("#queryContractForm [name='queryPxmc']").val();
		params+="&pxr="+$("#queryContractForm [name='queryMan']").val();
		params+="&pxzt="+$("#queryContractForm [name='queryRwzt']").val();
		doGet(basePath+"/pxglInfo/list",params,function(data){
			if(data.data.data){
				var _data=data.data.data;
				var tbl="";
				for(var i=0;i<_data.length;i++){
					tbl+='<tr>';
					tbl+='<td class="text-center">'+toStr(_data[i].pxlx_display)+'</td>';
					tbl+='<td class="text-center">'+toStr(_data[i].pxmc)+'</td>';
					tbl+='<td class="text-left">'+toStr(_data[i].userName)+'</td>';
					tbl+='<td class="text-left">'+toStr(_data[i].begtime)+'</td>';
					tbl+='<td class="text-left">'+toStr(_data[i].endtime)+'</td>';
					tbl+='<td class="text-left">'+toStr(_data[i].pxfy)+'</td>';
					tbl+='<td class="text-left">'+toStr(_data[i].rwzt_display)+'</td>';
					tbl+='<td class="text-center">';
					tbl+='<div class="btn-group">';
					if(buttonsPermission){
						if(buttonsPermission.indexOf(",btnDetail,")>=0){
							tbl+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnDetail" data-key="'+_data[i].wid+'">详</button>';
						}
						if(buttonsPermission.indexOf(",btnModify,")>=0){
							if(_data[i].rwzt==1){
								tbl+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnModify" data-key="'+_data[i].wid+'">录</button>';
							}
						}
						if(buttonsPermission.indexOf(",btnDelete,")>=0){
							if(_data[i].rwzt==1){
								tbl+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-danger" data-option="btnDelete" data-key="'+_data[i].wid+'"><i class="icon icon-times"></i></button>';
							}
						}
					}
					tbl+='</div>';
					tbl+='</td>';
					tbl+='</tr>';
				}
				$("#tblUserInfo").html(tbl);
				//$("#mainTable").datatable({sortable: true});
			}
			pageHelper("#pageInfo",data.data.page-1,data.data.total,function(pageId){
				queryList(pageId);
			});
			$("#mainTable").delegate("[data-option='btnModify']","click",function(){
				$("#userForm")[0].reset();
				var key=$(this).attr("data-key");
				setForm(key);
				$("#modelEdithUserInfo").modal("show");
			});
			$("#mainTable").delegate("[data-option='btnDelete']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认删除该培训信息吗？",function(e){
					doPost(basePath+"/pxglInfo/delete","wid="+key,function(data){
						
						window.location.reload();
					});
				});
			});
		})
	}
	
	$("#btnExport").click(function(){
		window.open(basePath+"/users/export");
	});
	$("#btnAdd").click(function(){
		$("#userForm")[0].reset();
		setForm("");
		$("#modelEdithUserInfo").modal("show");
	})
	
	function setForm(wid){
		doGet(basePath+"/pxglInfo/edit","wid="+wid,function(data){
			$("#userForm [name='wid']").val(toStr(data.data.wid));
			doGetSelect2("T_CONTRACT_SJZD_PXLX","#userForm [name='pxlx']",data.data.pxlx);
			$("#userForm [name='pxmc']").val(toStr(data.data.pxmc));
			$("#userForm [name='begtime']").val(toStr(data.data.begtime));
			$("#userForm [name='endtime']").val(toStr(data.data.endtime));
			$("#userForm [name='pxfy']").val(toStr(data.data.pxfy));
			$("#userForm [name='bz']").val(toStr(data.data.bz));
			doGet(basePath+"/zdbdetail/selectUsers","",function(data2){
				$("#userForm [name='by1']").empty();
				 var str="<option value=''>--请选择--</option>";
				if(data2.data && data2.data.length>0){
					 for(var i=0;i<data2.data.length;i++){
						 var selected="";
						 if(data2.data[i].lbdm==data.data.by1){
							 selected=" selected ";
						 }
						 str+="<option "+selected+"  value='"+data2.data[i].lbdm+"'>"+data2.data[i].lbmc+"</option>"
					 }
				 }
				$("#userForm [name='by1']").append(str);
			});
		});
	}
	
	
	
	$("#btnSelectBm").click(function(){
		if(!zTree){
			setTree();
		}
		showMenu();
		
	});
	$("#btnQuery").click(function(){
			queryList(0,$.trim($("#queryCondition").val()));
		
		return false;
	});
	
	$("#btnSubmitUserInfo").click(function(){
		if(_validater.form()){
			var url=basePath+"/pxglInfo/save";
			var datas=$("#modelEdithUserInfo form").serializeArray();
			datas.push({"name":"flag","value":"2"});
			doPost(url,datas,function(data){
				window.location.reload();
			});
		}
	});
	$("#btnSaveUserInfo").click(function(){
		if(_validater.form()){
			var url=basePath+"/pxglInfo/save";
			var datas=$("#modelEdithUserInfo form").serializeArray();
			datas.push({"name":"flag","value":"1"});
			doPost(url,datas,function(data){
				window.location.reload();
			});
		}
	});
})