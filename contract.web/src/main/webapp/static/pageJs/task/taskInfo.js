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
		doGet(basePath+"/task/listTaskInfo","startPage="+pageId,function(data){
			if(data.data.data){
				var _data=data.data.data;
				var _tr="";;
				for(var i=0;i<_data.length;i++){
					_tr+='<tr>';
					_tr+='<td class="text-center"><input type="checkbox" name="chkSingle" value="'+toStr(_data[i].wid)+'" data-rwzt="'+_data[i].rwzt+'"></td>';
					_tr+='<td class="text-center">'+toStr(_data[i].rwmc)+'</td>';
					_tr+='<td class="text-center">'+toStr(_data[i].rwfpr_display)+'</td>';
					_tr+='<td class="text-center">'+toStr(_data[i].jhkssj)+'</td>';
					_tr+='<td class="text-left">'+toStr(_data[i].jhjssj)+'</td>';
					_tr+='<td class="text-left">'+toStr(_data[i].sjkssj)+'</td>';
					_tr+='<td class="text-left">'+toStr(_data[i].sjjssj)+'</td>';
					_tr+='<td class="text-left">'+toStr(_data[i].fxxm_display)+'</td>';
					_tr+='<td class="text-left">'+toStr(_data[i].rwshr_display)+'</td>';
					_tr+='<td class="text-left">'+toStr(_data[i].rwzt_display)+'</td>';
					_tr+='<td class="text-center">';
					_tr+='<div class="btn-group">';
					if(buttonsPermission){
						if(buttonsPermission.indexOf(",btnDetail,")>=0){
							_tr+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnDetail" data-key="'+_data[i].wid+'">详</button>';
						}
						if(buttonsPermission.indexOf(",btnExamine,")>=0){
						_tr+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnExamine" data-key="'+_data[i].wid+'">检</button>';
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
			$("#mainTable").delegate("[data-option='btnExamine']","click",function(){
				var key=$(this).attr("data-key");
				window.location=basePath+"/task/taskDetailsIndex?wid="+key+"&flag=examine";
			});
			$("#mainTable").delegate("[data-option='btnDetail']","click",function(){
				var key=$(this).attr("data-key");
				window.location=basePath+"/task/taskDetailsIndex?wid="+key+"&flag=detail";
			});
			$("#mainTable").delegate("[data-option='btnDelete']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认删除该任务信息吗？",function(e){
					doPost(basePath+"/task/deleteTask","wid="+key,function(data){
						alert("任务删除成功！");
						window.location.reload();
					});
				});
			});
		})
	}
	
	$("#btnSubmit").click(function(){
		var selectData=$("#mainTable [name='chkSingle']:checked");
		if(!selectData ||selectData.length<=0){
			alert("请至少选择一条任务！");
			return;
		}
		var saveData=new Array();
		for(var i=0;i<selectData.length;i++){
			var c_wid=$(selectData[i]).val();
			var c_rwzt=$($(selectData[i])).attr("data-rwzt");
			if(c_rwzt!=4){
				alert("选中的任务存在不为数据报告的任务，请重新选择");
				return false;
			}
			saveData.push({wid:c_wid,value:c_rwzt});
		}
		doPost(basePath+"/task/submitTaskInfo", "datas="+JSON.stringify(saveData), function(data) {
			alert("提交审核成功");
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