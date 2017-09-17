/**
 * 
 */
$(document).ready(
		function() {
			queryDetail();
			queryDetailList();
			function queryDetailList(pageId){
				if(pageId==undefined){
					pageId=0;
				}
				doGet(basePath+"/customInfoDetail/contractInfoList","startPage="+pageId+"&customId="+wid,function(data){
					if(data.data.data){
						var _data=data.data.data;
						var _tr="";;
						for(var i=0;i<_data.length;i++){
							_tr+='<tr>';
							_tr+='<td class="text-center">'+toStr(_data[i].htsj)+'</td>';
							_tr+='<td class="text-center">'+toStr(_data[i].htbh)+'</td>';
							_tr+='<td class="text-center">'+toStr(_data[i].htmc)+'</td>';
							_tr+='<td class="text-center">'+toStr(_data[i].htlx_display)+'</td>';
							_tr+='<td class="text-left">'+toStr(_data[i].bdMoney)+'</td>';
							_tr+='<td class="text-left">'+toStr(_data[i].accountMoney)+'</td>';
							_tr+='</tr>';
						}
						$('#tblDetailInfo').html(_tr);
					}
					pageHelper("#pageInfo",data.data.page-1,data.data.total,function(pageId){
						queryDetailList(pageId);
					});
					});
					
			}
			function queryDetail() {
				doGet(basePath + "/customInfoDetail/selectCustomInfo", "wid=" + wid, function(data) {
					if (data && data.data) {
						var _d=data.data;
						$("#customForm [name='customName']").html(_d.customName);
						$("#customForm [name='customNumber']").html(_d.customNumber);
						$("#customForm [name='accountNumber']").html(_d.accountNumber);
						$("#customForm [name='bankAccount']").html(_d.bankAccount);
						$("#customForm [name='accountMoney']").html(_d.accountMoney);
					}
				});
			}

			$("#btnSave").click(
					function() {
						if (_validater.form()) {
							var url = basePath + "/batch/saveBatchInfo";
							var datas = $("#userForm").serializeArray();
							doPost(url, datas, function(data) {
								if (data && data.data) {
									alert(data.msg);
									window.location.href=basePath+"/batch/detailIndex?wid="+data.data.wid;
								}
							});
						}
					})
			$("#btnSaveDetailInfo").click(function(){
				if (_validater2.form()) {
					var url = basePath + "/batch/saveDetail";
					var datas = $("#batchDetailForm").serializeArray();
					doPost(url, datas, function(data) {
						alert(data.msg);
						window.location.href=basePath+"/batch/detailIndex?wid="+data.data.pcwid;
					});
				}
			});
			$("#btnLryp").click(function(){
				if(wid==""){
					alert("样品批次还没有保存，请在左侧表单先保存样品批次信息！")
					return;
				}
				$("#modelEdithBatchDetailInfo").modal("show");
				doGet(basePath + "/batch/addDetail", "wid=" + wid,function(data) {
					if (data && data.data) {
						var _details = data.data;
						$("#batchDetailForm [name='ypbh']").val(_details.ypbh);
						$("#batchDetailForm [name='ypph']").val(_details.ypph);
						$("#batchDetailForm [name='dqbh']").val(_details.dqbh);
						doGetSelect(basePath+"/zdbdetail/list","tableName=T_CONTRACT_SJZD_FXXM&lbdms="+toStr(_details.fxxm),
								"#batchDetailForm [name='fxxm']","",function(){
							if(_details.fxxm){
								var aFxxm=_details.fxxm.split(",");
								$("#batchDetailForm [name='fxxm']").multiselect("select",aFxxm);
								
							}else{
								$("#batchDetailForm [name='fxxm']").multiselect();
							}
						});
						$("#batchDetailForm [name='pcwid']").val(_details.pcwid);
						
					}
				});
			});
		})