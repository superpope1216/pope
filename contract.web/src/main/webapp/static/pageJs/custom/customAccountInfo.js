/**
 * 
 */
$(document).ready(function(){
	
	var _validater2 = $("#customAccountForm").validate({
		errorPlacement : function(error, element) {
			// Append error within linked label
			$(error).insertAfter($(element));
			// .append(error);
			// $("#mainForm").find( "label[for='" + element.attr( "id" )
			// + "']"
			// ).append( error );
		},
		rules : {
			accountMoney:{
				required : true,
				number:true,
				range:[-9999999,9999999]
			},
		}
	});
	$("#btnQuery").click(function(){
		queryList();
	});
	setButtonsDisplay(buttonsPermission);
	queryList();
	function queryList(pageId){
		if(pageId==undefined || pageId<0){
			pageId=0;
		}
		doGet(basePath+"/customAccount/list","startPage="+pageId+"&queryCondition="+$("#queryCondition").val(),function(data){
			if(data.data.data){
				var _data=data.data.data;
				var _tr="";;
				for(var i=0;i<_data.length;i++){
					_tr+='<tr>';
					
					//_tr+='<td class="text-center">'+toStr(_data[i].customNumber)+'</td>';
					_tr+='<td class="text-center">'+toStr(_data[i].customName)+'</td>';
					_tr+='<td class="text-center">'+toStr(_data[i].accountNumber)+'</td>';
					_tr+='<td class="text-left">'+toStr(_data[i].bankAccount)+'</td>';
					_tr+='<td class="text-left">'+toStr(_data[i].accountMoney)+'</td>';
					_tr+='<td class="text-center">';
					_tr+='<div class="btn-group">';
					if(buttonsPermission){
						if(buttonsPermission.indexOf(",btnDetail,")>=0){
							_tr+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnDetail" data-key="'+_data[i].wid+'">详</button>';
						}
						if(buttonsPermission.indexOf(",btnModify,")>=0){
						_tr+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnModify" data-key="'+_data[i].wid+'">录</button>';
						}
						if(buttonsPermission.indexOf(",btnDelete,")>=0){
						_tr+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-danger" data-option="btnDelete" data-key="'+_data[i].wid+'"><i class="icon icon-times"></i></button>';
						}
					}
					_tr+='</div>';
					_tr+='</td>';
					_tr+='</tr>';
				}
				$('#tblUserInfo').html(_tr);
			}
			pageHelper("#pageInfo",data.data.page-1,data.data.total,function(pageId){
				queryList(pageId);
			});
			$("#mainTable").delegate("[data-option='btnModify']","click",function(){
				var key=$(this).attr("data-key");
				setForm(key);
				$("#modelEdidCustomInfo").modal("show");
			});
			$("#mainTable").delegate("[data-option='btnDetail']","click",function(){
				var key=$(this).attr("data-key");
				window.location.href=basePath+"/customInfoDetail/index?wid="+key;
			});
			$("#mainTable").delegate("[data-option='btnDelete']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认删除该客户信息吗？",function(e){
					doPost(basePath+"/custom/deleteCustom","wid="+key,function(data){
						alert("客户删除成功！");
						window.location.reload();
					});
				});
			});
		})
	}
	
	$("#btnAdd").click(function(){
		setForm("");
		$("#modelEdidCustomInfo").modal("show");
	});
	
	$("#btnAddAccount").click(function(){
		var selectCustom=$("#tblUserInfo [name='chkSingle']:checked");
		if(selectCustom.length<=0){
			alert("请选择一条客户记录");
			return false;	
		}
		if(selectCustom.length>1){
			alert("每次只能创建一个客户账户");
			return false;	
		}
		doGet(basePath+"/custom/addCustomAccount","customId="+selectCustom[0].value,function(data){
			$("#customAccountForm [name='dqbh']").val(data.data.dqbh);
			$("#customAccountForm [name='accountNumber']").val(data.data.accountNumber);
			$("#modelAddCustomAccountInfo").modal("show");
		})
	});
	
	$("#btnSaveCustomAccountInfo").click(function(){
		if (_validater2.form()) {
			doPost(basePath+"/customAccount/saveCustomAccount", $("#customAccountForm").serializeArray(),function(data){
				window.location.reload();
			});
		}
	})
	
	function setForm(_wid){
		doGet(basePath+"/customAccount/edit","wid="+_wid,function(data){
			$("#customAccountForm [name='wid']").val(data.data.wid);
			$("#customAccountForm [name='dqbh']").val(data.data.dqbh);
			$("#customAccountForm [name='accountNumber']").val(data.data.accountNumber);
			$("#customAccountForm [name='customId']").val(data.data.customId);
			$("#customAccountForm [name='bankAccount']").val(data.data.bankAccount);
			//$("#customAccountForm [name='accountMoney']").val(data.data.accountMoney);
			$("#modelAddCustomAccountInfo").modal("show");
		})
	}
	
	$("#btnSaveCustomInfo").click(function(){
		if (_validater.form()) {
			doPost(basePath+"/custom/save", $("#customForm").serializeArray(),function(data){
				window.location.reload();
			});
		}
		
	});
	
	
	$("#mainTable [name='selAll']").click(function(){
		if($(this)[0].checked){
			$("#mainTable [name='chkSingle']").prop("checked",true);
		}else{
			$("#mainTable [name='chkSingle']").prop("checked",false);
		}
	});
});