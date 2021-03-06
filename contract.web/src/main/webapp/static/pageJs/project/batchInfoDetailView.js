/**
 * 
 */
$(document).ready(
		function() {
			queryDetail();
			
			queryDetailList();
			
			queryTaskList();
			function queryDetailList(pageId){
				if(pageId==undefined){
					pageId=0;
				}
				doGet(basePath + "/batch/detail_list", "startPage="+pageId+"&pcwid=" + wid, function(data) {
					if(data && data.data){
						$('#tblDetailInfoTpl').tmpl(data.data.data).appendTo('#tblDetailInfo'); 
					}
					pageHelper("#pageInfo",data.data.page-1,data.data.total,function(pageId){
						queryDetailList(pageId);
					});
				});
				
			}
			
			function queryTaskList(pageId){
				if(pageId==undefined || pageId<0){
					pageId=0;
				}
				doGet(basePath+"/task/listTaskInfo?startPage="+pageId,"pcwid="+wid,function(data){
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
							_tr+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnDetail" data-key="'+_data[i].wid+'">详</button>';
							_tr+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnExamine" data-key="'+_data[i].wid+'">检</button>';
							if(_data[i].rwzt==1){
								_tr+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-danger" data-option="btnDelete" data-key="'+_data[i].wid+'"><i class="icon icon-times"></i></button>';
							}
							_tr+='</div>';
							_tr+='</td>';
							_tr+='</tr>';
						}
						$('#tblTaskDetailInfo').html(_tr);
					}
					pageHelper("#taskPageInfo",data.data.page-1,data.data.total,function(pageId){
						queryTaskList(pageId);
					});
					$("#mainTaskTable").delegate("[data-option='btnExamine']","click",function(){
						var key=$(this).attr("data-key");
						window.location=basePath+"/task/taskDetailsIndex?wid="+key+"&flag=examine";
					});
					$("#mainTaskTable").delegate("[data-option='btnDetail']","click",function(){
						var key=$(this).attr("data-key");
						window.location=basePath+"/task/taskDetailsIndex?wid="+key+"&flag=detail";
					});
					$("#mainTaskTable").delegate("[data-option='btnDelete']","click",function(){
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
			function queryDetail() {
				doGet(basePath + "/batch/detailView", "wid=" + wid, function(data) {
					if (data && data.data) {
						var _details = data.data;
						doGetSelect2("T_CONTRACT_SJZD_PCLB", "#userForm [name='pclb']", _details.pclb);
						$("#userForm [name='pclb_display']").html(_details.pclb_display);
						$("#userForm [name='ejfl']").html(_details.ejfl);
						$("#userForm [name='pcmc']").html(_details.pcmc);
						$("#userForm [name='ypph']").html(_details.ypph);
						$("#userForm [name='sl']").html(_details.sl);
						$("#userForm [name='pp_display']").html(_details.pp);
						$("#userForm [name='sldw_display']").html(_details.sldw);
						$("#userForm [name='cfd']").html(_details.cfd);
						$("#userForm [name='dj']").html(_details.dj);
						$("#userForm [name='hbdw_display']").html(_details.hbdw);
						$("#userForm [name='fxxm_display']").html(_details.fxxm_display);
						
						$("#userForm [name='kzsjd']").html(_details.kzsjd);
						$("#userForm [name='sysj']").html(_details.sysj);
						$("#userForm [name='gys']").html(_details.gys);
						$("#userForm [name='syr']").html(_details.syr);
						$("#userForm [name='sydw_display']").html(_details.sydw_display);
						$("#userForm [name='syxmfzr']").html(_details.syxmfzr);
						$("#userForm [name='shsj']").html(_details.shsj);
						$("#userForm [name='pczt_display']").html(_details.pczt_display);
						$("#userForm [name='hth']").html(_details.hth);
						$("#userForm [name='bz']").html(_details.bz);
					}
				});
			}
			
			$("#btnSubmit").click(function(){
				var selectData=$("#mainTaskTable [name='chkSingle']:checked");
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
			
			$("#btnPrint").click(function(){
				var selectData=$("#mainTaskTable [name='chkSingle']:checked");
				if(!selectData ||selectData.length<=0){
					alert("每次只能选择一条任务，请重新选择！");
					return;
				}
				if(selectData.length>1){
					alert("每次只能选择一条任务，请重新选择！");
					return;
					
				}
				window.open(basePath+"/taskPrint/index?wid="+$(selectData[0]).val());
			});
			
			$("#mainTaskTable [name='selAll']").click(function(){
				if($(this)[0].checked){
					$("#mainTaskTable [name='chkSingle']").prop("checked",true);
				}else{
					$("#mainTaskTable [name='chkSingle']").prop("checked",false);
				}
			});
			$("#btnTask").click(function(){
				doGet(basePath+"/batch/checkBatchInfo","wid="+wid,function(data){
					window.location=basePath+"/task/taskadd?wid="+wid;
				});
			});

		})