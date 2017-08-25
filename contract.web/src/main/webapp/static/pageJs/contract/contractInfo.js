/**
 * 
 */
$(document).ready(function(){
	setButtonsDisplay(buttonsPermission);
	queryList();
	function queryList(pageId){
		if(pageId==undefined || pageId<0){
			pageId=0;
		}
		doGet(basePath+"/contractInfo/list","startPage="+pageId,function(data){
			if(data.data.data){
				var _data=data.data.data;
				var _tr="";;
				for(var i=0;i<_data.length;i++){
					_tr+='<tr>';
					_tr+='<td class="text-center"><input type="checkbox" name="chkSingle" value="'+toStr(_data[i].wid)+'" data-rwzt="'+_data[i].rwzt+'"></td>';
					_tr+='<td class="text-center">'+toStr(_data[i].htsj)+'</td>';
					_tr+='<td class="text-center">'+toStr(_data[i].htmc)+'</td>';
					_tr+='<td class="text-center">'+toStr(_data[i].htbh)+'</td>';
					_tr+='<td class="text-left">'+toStr(_data[i].htlx_display)+'</td>';
					_tr+='<td class="text-left">'+toStr(_data[i].htjf)+'</td>';
					_tr+='<td class="text-left">'+toStr(_data[i].dfzh)+'</td>';
					_tr+='<td class="text-left">'+toStr(_data[i].htje)+'</td>';
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
				window.location=basePath+"/contractEditInfo/index?wid="+key;
			});
			$("#mainTable").delegate("[data-option='btnDetail']","click",function(){
				var key=$(this).attr("data-key");
				setForm(key);
				$("#modelEdidCustomInfo").modal("show");
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
		
		doPost(basePath+"/custom/save", $("#customForm").serializeArray(),function(data){
			window.location.reload();
		});
	});
	
	
	$("#mainTable [name='selAll']").click(function(){
		if($(this)[0].checked){
			$("#mainTable [name='chkSingle']").prop("checked",true);
		}else{
			$("#mainTable [name='chkSingle']").prop("checked",false);
		}
	});
});