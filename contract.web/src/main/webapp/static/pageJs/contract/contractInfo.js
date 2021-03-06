/**
 * 
 */
$(document) .ready(
				function() {
					setButtonsDisplay(buttonsPermission);
					doGetSelect2("T_CONTRACT_SJZD_FXXM", "#queryFxxm", "");
					queryList();
					
					$("#btnQuery").click(function(){
						queryList("0");
					});
					function queryList(pageId) {
						if (pageId == undefined || pageId < 0) {
							pageId = 0;
						}
						doGet(
								basePath + "/contractInfo/list",
								"startPage=" + pageId+"&querySyr="+$("#querySyr").val()+"&queryHtb="+$("#queryHtb").val()+"&queryYppch="+$("#queryYppch").val()+"&queryFxxm="+$("#queryFxxm").val(),
								function(data) {
									if (data.data.data) {
										var _data = data.data.data;
										var _tr = ""; 
										for (var i = 0; i < _data.length; i++) {
											_tr += '<tr>';
											_tr += '<td class="text-center"><input type="checkbox" name="chkSingle" value="'
													+ toStr(_data[i].wid)
													+ '" data-rwzt="'
													+ _data[i].rwzt + '"></td>';
											_tr += '<td class="text-center">'
													+ toStr(_data[i].htsj)
													+ '</td>';
											_tr += '<td class="text-center">'
													+ toStr(_data[i].htmc)
													+ '</td>';
											_tr += '<td class="text-center">'
													+ toStr(_data[i].htbh)
													+ '</td>';
											_tr += '<td class="text-left">'
													+ toStr(_data[i].htlx_display)
													+ '</td>';
											_tr += '<td class="text-left">'
													+ toStr(_data[i].htjf)
													+ '</td>';
											_tr += '<td class="text-left">'
													+ toStr(_data[i].dfzh)
													+ '</td>';
											_tr += '<td class="text-left">'
													+ toStr(_data[i].htje)
													+ '</td>';
											_tr += '<td class="text-center">'
													+ toStr(_data[i].htzt_display)
													+ '</td>';
											_tr += '<td class="text-center">';
											_tr += '<div class="btn-group">';
											if (buttonsPermission) {
												if (buttonsPermission.indexOf(",btnDetail,") >= 0) {
													_tr += '<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnDetail" data-key="'
															+ _data[i].wid
															+ '">详</button>';
												}
												if (buttonsPermission.indexOf(",btnModify,") >= 0) {
													if (_data[i].rwzt=="1" || _data[i].rwzt=="-99"){
													_tr += '<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnModify" data-key="'
															+ _data[i].wid
															+ '">录</button>';
													}
												}
												if(_data[i].rwzt=="102" ){
												_tr += '<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnGui" data-key="'
													+ _data[i].wid
													+ '">归</button>';
												}
												if (buttonsPermission .indexOf(",btnDelete,") >= 0) {
													if (_data[i].rwzt=="1" || _data[i].rwzt=="-99"){
														_tr += '<button type="button" style="margin-left:4px;" class="btn btn-xs btn-danger" data-option="btnDelete" data-key="'
																+ _data[i].wid
																+ '"><i class="icon icon-times"></i></button>';
													}
												}
												
												
												
											}
											_tr += '</div>';
											_tr += '</td>';
											_tr += '</tr>';
										}
										$('#tblUserInfo').html(_tr);
									}
									pageHelper("#pageInfo", data.data.page - 1,
											data.data.total, function(pageId) {
												queryList(pageId);
											});
									$("#mainTable").delegate("[data-option='btnModify']","click",function() {
														var key = $(this).attr("data-key");
														window.location = basePath+ "/contractEditInfo/index?wid="+ key;
													});
									$("#mainTable").delegate("[data-option='btnDetail']","click",function() {
												var key = $(this).attr("data-key");
												window.location = basePath+ "/contractEditInfo/viewIndex?wid="+ key;
											});
									$("#mainTable").delegate("[data-option='btnGui']","click",function() {
										var key = $(this).attr("data-key");
										confirm("您确认归档该合同信息吗？",function(e) {
											doPost(basePath+ "/contractInfo/guidang","wid="+ key,function(data) {
														window.location.reload();
													});
										});
									});
									
									$("#mainTable").delegate("[data-option='btnDelete']","click",function() {
														var key = $(this).attr("data-key");
														confirm("您确认删除该合同信息吗？",function(e) {
																	doPost(basePath+ "/contractInfo/delete","wid="+ key,function(data) {
																				window.location.reload();
																			});
														});
									});
								})
					}
					/**
					 * 导出
					 */
					$("#btnExport").click(function(){
						window.open(basePath+"/contractInfo/export?querySyr="+$("#querySyr").val()+"&queryHtb="+$("#queryHtb").val()+"&queryYppch="+$("#queryYppch").val()+"&queryFxxm="+$("#queryFxxm").val());
					});
					
					$("#btnDownload").click(function(){
						var selectContractId = $("#mainTable [name='chkSingle']:checked");
						if (selectContractId.length <= 0) {
							alert("请至少选择一条合同下载分包申请表！");
							return;
						}
						if(selectContractId.length>1){
							alert("只能选择一条记录，请重新确认！");
							return ;
						}
						var _wid=selectContractId[0].value;
						window.open(basePath+"/contractPrint/index?wid="+_wid)
						//doGet(basePath+"/contractInfo/download","wid="+_wid,function(data){
							
						//});
					});

					/**
					 * 提交审核
					 */
					$("#btnSubmit") .click(function() {
							var selectContractId = $("#mainTable [name='chkSingle']:checked");
							if (selectContractId.length <= 0) {
								alert("请至少选择一条合同提交审核！");
								return;
							}
							var wids="";
							for(var i=0;i<selectContractId.length;i++){
								wids+=","+selectContractId[i].value;
							}
							if(wids){
								wids=wids.substr(1);
								doPost(basePath+"/contractInfo/submitContract","wids="+wids,function(data){
									window.location.reload();
								});
							}
						});

					$("#mainTable [name='selAll']").click(
							function() {
								if ($(this)[0].checked) {
									$("#mainTable [name='chkSingle']").prop(
											"checked", true);
								} else {
									$("#mainTable [name='chkSingle']").prop(
											"checked", false);
								}
							});
				});