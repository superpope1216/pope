/**
 * 
 */
$(document).ready(
		function() {
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
						doGetSelect2("T_CONTRACT_SJZD_HBDW", "#userForm [name='hbdw']", _details.hbdw);

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
						doGetSelect2("T_CONTRACT_SJZD_PCZT", "#userForm [name='pczt']", _details.pczt);
						doGetSelect2("T_CONTRACT_SJZD_FXXM", "#userForm [name='fxxm']", "",function(){
							$("#userForm [name='fxxm']").multiselect();
							if(_details.fxxm){
								var aFxxm=_details.fxxm.split(",");
								$("#userForm [name='fxxm']").multiselect("select",aFxxm);
								
							}else{
								$("#userForm [name='fxxm']").multiselect();
							}
							
							
						});
						$("#userForm [name='hth']").val(_details.hth);
						$("#userForm [name='bz']").val(_details.bz);
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