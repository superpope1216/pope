/**
 * 
 */
$(document).ready(
		function() {
			if(wid){
				$("#btnEdit").show();
				$("#btnSave").hide();
				$("#userForm").hide();
				$("#userFormView").show();
			}else{
				$("#btnEdit").hide();
				$("#btnSave").show();
				$("#userForm").show();
				$("#userFormView").hide();
			}
			$("#btnEdit").click(function(){
				$("#userForm").show();
				$("#btnSave").show();
				$("#btnEdit").hide();
				$("#userFormView").hide();
			});
			var _validater = $("#userForm").validate({
				errorPlacement : function(error, element) {
					// Append error within linked label
					$(error).insertAfter($(element));
					// .append(error);
					// $("#mainForm").find( "label[for='" + element.attr( "id" )
					// + "']"
					// ).append( error );
				},
				rules : {
					phone : {
						required : true,
						isMobile : true
					},
					email : {
						required : true,
						email : true
					},
					sl:{
						digits:true
					},
					dj:{
						number:true,
						min:0
					}
				}
			});
			var _validater2 = $("#batchDetailForm").validate({
				errorPlacement : function(error, element) {
					// Append error within linked label
					$(error).insertAfter($(element));
					// .append(error);
					// $("#mainForm").find( "label[for='" + element.attr( "id" )
					// + "']"
					// ).append( error );
				},
				rules : {
					phone : {
						required : true,
						isMobile : true
					},
					email : {
						required : true,
						email : true
					}
				}
			});
			queryDetail();
			
			queryDetailList();
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
					$("#mainTable").delegate("[data-option='delete']","click",function(){
						var key=$(this).attr("data-key");
						if(confirm("您确认删除该样品吗",function(data){
							doPost(basePath+"/batch/deleteBatchDetail", "wid="+key, function(data) {
								window.location=basePath+"/batch/detailIndex?wid="+wid;
							});
						}));
					});
				});
				
			}
			function queryDetail() {
				doGet(basePath + "/batch/detail", "wid=" + wid, function(data) {
					if (data && data.data) {
						setFormView(data);
						var _details = data.data;
						$("#userForm [name='wid']").val(_details.wid);
						$("#userForm [name='dqbh']").val(_details.dqbh);
						doGetSelect2("T_CONTRACT_SJZD_PCLB", "#userForm [name='pclb']", _details.pclb);
						$("#userForm [name='ejfl']").val(_details.ejfl);
						$("#userForm [name='pcmc']").val(_details.pcmc);
						$("#userForm [name='ypph']").val(_details.ypph);
						$("#userForm [name='sl']").val(_details.sl);
						doGetSelect2("T_CONTRACT_SJZD_PP",
								"#userForm [name='pp']", _details.pp);
						doGetSelect2("T_CONTRACT_SJZD_SLDW", "#userForm [name='sldw']", _details.sldw);

						$("#userForm [name='cfd']").val(_details.cfd);
						$("#userForm [name='dj']").val(_details.dj);
						 doGet(basePath+"/zdbdetail/list","tableName=T_CONTRACT_SJZD_HBDW",function(data3){
							 $("#userForm [name='hbdw']").empty();
							 var str="<option value=''>--请选择--</option>";
							 if(data3.data && data3.data.length>0){
								 for(var i=0;i<data3.data.length;i++){
									 var checked="";
									if(_details.hbdw && _details.hbdw==data3.data[i].lbdm){
										checked=" selected='selected' ";
									}
									 str+="<option "+checked+" value='"+data3.data[i].lbdm+"'>"+data3.data[i].lbmc+"</option>"
								 }
							 }
							 $("#userForm [name='hbdw']").append(str);
							 if(!_details.wid){
								 $("#userForm [name='hbdw']").prop('selectedIndex', 1);
							 }
						 });
						$("#userForm [name='kzsjd']").val(_details.kzsjd);
						$("#userForm [name='sysj']").val(_details.sysj);
						$("#userForm [name='gys']").val(_details.gys);
						$("#userForm [name='syr']").val(_details.syr);
						//doGetSelect2("T_CONTRACT_SJZD_SYDW", "#userForm [name='sydw']", _details.sydw);
						doGet(basePath+"/batch/selectCustomInfos","",function(data){
							if(data.data){
								var _d=data.data;
								var _dSelect="";
								 var str="<option value=''>--请选择--</option>";
								 if(data.data && data.data.length>0){
									 for(var i=0;i<data.data.length;i++){
										 var checked="";
										if(_details.sydw && _details.sydw==data.data[i].customNumber){
											checked=" selected='selected' ";
										}
										 str+="<option "+checked+" value='"+data.data[i].customNumber+"'>"+data.data[i].customName+"</option>"
									 }
								 }
								 $("#userForm [name='sydw']").html(str);
							}
						});
						$("#userForm [name='syxmfzr']").val(_details.syxmfzr);
						$("#userForm [name='shsj']").val(_details.shsj);
						//doGetSelect2("T_CONTRACT_SJZD_PCZT", "#userForm [name='pczt']", _details.pczt);
						doGet(basePath+"/zdbdetail/list","tableName=T_CONTRACT_SJZD_FXXM",function(data){
							if(data && data.data){
								var _d=data.data;
								var str="";
								for(var i=0;i<_d.length;i++){
									str+="<option value='"+_d[i].lbdm+"'>"+_d[i].lbmc+"</option>";
								}
								$("#userForm [name='fxxm']").html(str);
								$("#userForm [name='fxxm']").multiselect({includeSelectAllOption:true,selectAllText:"全选"});
								if(_details.fxxm){
									var aFxxm=_details.fxxm.split(",");
									$("#userForm [name='fxxm']").multiselect("select",aFxxm);
								}
								
							}
						})
						
//						doGetSelect2("T_CONTRACT_SJZD_FXXM", "#userForm [name='fxxm']", "",function(){
//							$("#userForm [name='fxxm']").multiselect();
//							if(_details.fxxm){
//								var aFxxm=_details.fxxm.split(",");
//								$("#userForm [name='fxxm']").multiselect("select",aFxxm);
//								
//							}else{
//								$("#userForm [name='fxxm']").multiselect();
//							}
//							
//							
//						});
						//$("#userForm [name='hth']").val(_details.hth);
						$("#userForm [name='bz']").val(_details.bz);
					}
				});
			}
			function setFormView(data){
				if(!data.data){
					return;
				}
				var _details = data.data;
				$("#userFormView [name='pclb_display']").html(_details.pclb_display);
				$("#userFormView [name='ejfl']").html(_details.ejfl);
				$("#userFormView [name='pcmc']").html(_details.pcmc);
				$("#userFormView [name='ypph']").html(_details.ypph);
				$("#userFormView [name='sl']").html(_details.sl);
				$("#userFormView [name='pp_display']").html(_details.pp);
				$("#userFormView [name='sldw_display']").html(_details.sldw);
				$("#userFormView [name='cfd']").html(_details.cfd);
				$("#userFormView [name='dj']").html(_details.dj);
				$("#userFormView [name='hbdw_display']").html(_details.hbdw);
				$("#userFormView [name='fxxm_display']").html(_details.fxxm_display);
				
				$("#userFormView [name='kzsjd']").html(_details.kzsjd);
				$("#userFormView [name='sysj']").html(_details.sysj);
				$("#userFormView [name='gys']").html(_details.gys);
				$("#userFormView [name='syr']").html(_details.syr);
				$("#userFormView [name='sydw_display']").html(_details.sydw_display);
				$("#userFormView [name='syxmfzr']").html(_details.syxmfzr);
				$("#userFormView [name='shsj']").html(_details.shsj);
				$("#userFormView [name='pczt_display']").html(_details.pczt_display);
				$("#userFormView [name='hth']").html(_details.hth);
				$("#userFormView [name='bz']").html(_details.bz);
			}
			$("#btnLrjs").click(function(){
				if(wid==""){
					alert("样品批次还没有保存，请在左侧表单先保存样品批次信息！")
					return;
				}
				confirm("确认该批次录入结束吗？",function(){
					doPost(basePath+"/batch/overPc","wid="+wid,function(data){
						window.location.href=basePath+"/batch/index";
					})
				});
			});
			$("#btnSave").click(
					function() {
						if (_validater.form()) {
							var url = basePath + "/batch/saveBatchInfo";
							var datas = $("#userForm").serializeArray();
							$("#btnSave").attr("disabled",true);
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
						doGet(basePath+"/zdbdetail/list","tableName=T_CONTRACT_SJZD_FXXM&lbdms="+toStr(_details.fxxm),function(data){

							if(data && data.data){
								var str="";
								for(var i=0;i<data.data.length;i++){
									str+="<option value='"+data.data[i].lbdm+"'>"+data.data[i].lbmc+"</option>";
								}
								$("#batchDetailForm [name='fxxm']").html(str);
								$("#batchDetailForm [name='fxxm']").multiselect({includeSelectAllOption:true,selectAllText:"全选"});
								
								if(_details.fxxm){
									var aFxxm=_details.fxxm.split(",");
									$("#batchDetailForm [name='fxxm']").multiselect("select",aFxxm);
									
								}else{
									$("#batchDetailForm [name='fxxm']").multiselect();
								}
							};
						})
//						doGetSelect(basePath+"/zdbdetail/list","tableName=T_CONTRACT_SJZD_FXXM&lbdms="+toStr(_details.fxxm),
//								"#batchDetailForm [name='fxxm']","",function(){
//							$("#batchDetailForm [name='fxxm']").multiselect({includeSelectAllOption:true,selectAllText:"全选"});
//							
//						});
						$("#batchDetailForm [name='pcwid']").val(_details.pcwid);
						
					}
				});
			});
		})