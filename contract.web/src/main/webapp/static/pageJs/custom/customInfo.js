/**
 * 
 */
$(document).ready(function(){
	var _validater = $("#customForm").validate({
		errorPlacement : function(error, element) {
			// Append error within linked label
			$(error).insertAfter($(element));
			// .append(error);
			// $("#mainForm").find( "label[for='" + element.attr( "id" )
			// + "']"
			// ).append( error );
		}
	});
	
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
				digits:true
			},
		}
	});
	var _currentCustomId="";
	setButtonsDisplay(buttonsPermission);
	queryList();
	$("#btnQuery").click(function(){
		queryList();
	});
	function queryList(pageId){
		if(pageId==undefined || pageId<0){
			pageId=0;
		}
		doGet(basePath+"/custom/list","startPage="+pageId+"&queryCondition="+$("#queryCondition").val(),function(data){
			if(data.data.data){
				var _data=data.data.data;
				var _tr="";;
				for(var i=0;i<_data.length;i++){
					_tr+='<tr>';
					_tr+='<td class="text-center"><input type="checkbox" name="chkSingle" value="'+toStr(_data[i].wid)+'" data-rwzt="'+_data[i].rwzt+'"></td>';
					_tr+='<td class="text-center">'+toStr(_data[i].customNumber)+'</td>';
					_tr+='<td class="text-center">'+toStr(_data[i].customName)+'</td>';
					_tr+='<td class="text-center">'+toStr(_data[i].customType_display)+'</td>';
					_tr+='<td class="text-left">'+toStr(_data[i].companyName)+'</td>';
					_tr+='<td class="text-left">'+toStr(_data[i].contractWay)+'</td>';
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
				_currentCustomId=key;
				setForm(key);
				$("#modelEdidCustomInfo").modal("show");
			});
			$("#mainTable").delegate("[data-option='btnDetail']","click",function(){
				var key=$(this).attr("data-key");
				_currentCustomId=key;
				setViewForm(key);
				queryAccountList(key);
				$("#modelViewCustomInfo").modal("show");
				//window.location=basePath+"/customInfoDetail/index?wid="+key;
			});
			$("#mainTable").delegate("[data-option='btnDelete']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认删除该客户信息吗？",function(e){
					doPost(basePath+"/custom/deleteCustom","wid="+key,function(data){
						alert("客户删除成功！");
						window.location.reload();
					});
				});
				return false;
			});
		})
	}
	
	function setAccountForm(_wid){
		doGet(basePath+"/customAccount/edit","wid="+_wid,function(data){
			$("#customAccountForm [name='wid']").val(data.data.wid);
			$("#customAccountForm [name='dqbh']").val(data.data.dqbh);
			$("#customAccountForm [name='accountNumber']").val(data.data.accountNumber);
			$("#customAccountForm [name='customId']").val(data.data.customId);
			$("#customAccountForm [name='bankAccount']").val(data.data.bankAccount);
			$("#customAccountForm [name='accountMoney']").val(data.data.accountMoney);
			$("#modelAddCustomAccountInfo").modal("show");
		})
	}
	
	$("#btnAdd").click(function(){
		setForm("");
		$("#modelEdidCustomInfo").modal("show");
	});
	
	function queryAccountList(customId){
		doGet(basePath+"/custom/accountList","customId="+customId,function(data){
			if(data.data){
				var _data=data.data;
				var _tr="";;
				for(var i=0;i<_data.length;i++){
					_tr+='<tr>';
					_tr+='<td class="text-center">'+toStr(_data[i].accountNumber)+'</td>';
					_tr+='<td class="text-left">'+toStr(_data[i].bankAccount)+'</td>';
					_tr+='<td class="text-left">'+toStr(_data[i].accountMoney)+'</td>';
					_tr+='<td class="text-center">';
					_tr+='<div class="btn-group">';
					if(buttonsPermission){
						//if(buttonsPermission.indexOf(",btnDetail,")>=0){
							_tr+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnDetail" data-key="'+_data[i].wid+'">详</button>';
						//}
						//if(buttonsPermission.indexOf(",btnModify,")>=0){
						_tr+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnModify" data-key="'+_data[i].wid+'">录</button>';
						//}
						//if(buttonsPermission.indexOf(",btnDelete,")>=0){
						_tr+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-danger" data-option="btnDelete" data-key="'+_data[i].wid+'"><i class="icon icon-times"></i></button>';
						//}
					}
					_tr+='</div>';
					_tr+='</td>';
					_tr+='</tr>';
				}
				$('#tblAccountInfo').html(_tr);
			}
//			pageHelper("#pageInfo",data.data.page-1,data.data.total,function(pageId){
//				queryList(pageId);
//			});
			$("#mainAccountTable").delegate("[data-option='btnModify']","click",function(){
				var key=$(this).attr("data-key");
				setAccountForm(key);
			});
			$("#mainAccountTable").delegate("[data-option='btnDetail']","click",function(){
				var key=$(this).attr("data-key");
				window.location.href=basePath+"/customInfoDetail/index?wid="+key;
			});
			$("#mainAccountTable").delegate("[data-option='btnDelete']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认删除该账户信息吗？",function(e){
					doPost(basePath+"/customInfoDetail/deleteAccount","wid="+key,function(data){
						alert("账户删除成功！");
						queryAccountList(customId);
						//window.location.reload();
					});
				});
			});
		})
	}
	
	$("#btnAddAccount").click(function(){
		doGet(basePath+"/custom/addCustomAccount","customId="+$("#customViewForm [name='wid']").val(),function(data){
			$("#customAccountForm [name='dqbh']").val(data.data.dqbh);
			$("#customAccountForm [name='accountNumber']").val(data.data.accountNumber);
			$("#customAccountForm [name='customId']").val(data.data.customId);
			$("#customAccountForm [name='bankAccount']").val(data.data.bankAccount);
			$("#customAccountForm [name='accountMoney']").val(data.data.accountMoney);
			$("#modelAddCustomAccountInfo").modal("show");
		})
	});
	
	$("#btnSaveCustomAccountInfo").click(function(){
		if (_validater2.form()) {
			doPost(basePath+"/custom/saveCustomAccount", $("#customAccountForm").serializeArray(),function(data){
				//window.location.href=basePath+"/customAccount/index";
				$("#modelAddCustomAccountInfo").modal("hide");
				queryAccountList(_currentCustomId);
				
			});
		}
	})
	
	function setViewForm(_wid){
		doGet(basePath+"/custom/view","wid="+_wid,function(data){
			var _d=data.data;
			$("#customViewForm [name='wid']").val(_d.wid);
			$("#customViewForm [name='customName']").html(_d.customName);
			$("#customViewForm [name='customNumber']").html(_d.customNumber);
			$("#customViewForm [name='customType']").html(_d.customType_display);
			$("#customViewForm [name='contractWay']").html(_d.contractWay);
			$("#customViewForm [name='linkMan']").html(_d.linkMan);
			$("#customViewForm [name='companyName']").html(_d.companyName);
			$("#customViewForm [name='companyAddress']").html(_d.companyAddress);
			$("#customViewForm [name='companyAccount']").html(_d.companyAccount);
			$("#customViewForm [name='companyPreAccount']").html(_d.companyPreAccount);
		})
	}
	function setForm(_wid){
		doGet(basePath+"/custom/edit","wid="+_wid,function(data){
			var _d=data.data;
			$("#customForm [name='wid']").val(_d.wid);
			$("#customForm [name='dqbh']").val(_d.dqbh);
			$("#customForm [name='customName']").val(_d.customName);
			$("#customForm [name='customNumber']").val(_d.customNumber);
			doGetSelect2("T_CONTRACT_SJZD_CUSTOM_TYPE","#customForm [name='customType']",_d.customType);
			$("#customForm [name='contractWay']").val(_d.contractWay);
			$("#customForm [name='linkMan']").val(_d.linkMan);
			$("#customForm [name='companyName']").val(_d.companyName);
			$("#customForm [name='companyAddress']").val(_d.companyAddress);
			$("#customForm [name='companyAccount']").val(_d.companyAccount);
			$("#customForm [name='companyPreAccount']").val(_d.companyPreAccount);
		})
	}
	
	$("#btnSaveCustomInfo").click(function(){
		if (_validater.form()) {
			$("#btnSaveCustomInfo").attr("disabled",true);
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