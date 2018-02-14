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
			phone:{
				required:true,
				isMobile:true
			},
			email:{
				required:true,
				email:true
			},
			
		}
	});
	
	var setting = {
			view: {
				dblClickExpand: false
			},
			data: {
				simpleData: {
					enable: true,
					idKey:"wid",
					pIdKey:"pid",
					rootPId:"-1"
				}
			},
			callback: {
				beforeClick: beforeClick,
				onClick: onClick
			}
		};
	var zTree;
	setButtonsDisplay(buttonsPermission);
	queryList(0,"");
	queryRole();
	
	function queryList(pageId,queryCondition){
		$("#tblUserInfo").empty();
		if(pageId==undefined){
			pageId=0;
		}
		doGet(basePath+"/batch/list","startPage="+pageId+"&queryCondition="+queryCondition,function(data){
			if(data.data.data){
				var _data=data.data.data;
				var _tr="";
				for(var i=0;i<_data.length;i++){
					_tr+='<tr>';
					_tr+='<td class="text-center"><input type="checkbox" name="chkSingle" value="'+_data[i].wid+'"></td>';
					_tr+='<td class="text-center">'+toStr(_data[i].ypph)+'</td>';
					_tr+='<td class="text-center">'+toStr(_data[i].pcmc)+'</td>';
					_tr+='<td class="text-center">'+toStr(_data[i].pclb_display)+'</td>';
					_tr+='<td class="text-center">'+toStr(_data[i].syr)+'</td>';
					_tr+='<td class="text-left">'+toStr(_data[i].sl)+'</td>';
					_tr+='<td class="text-left">'+toStr(_data[i].sldw)+'</td>';
					_tr+='<td class="text-left">'+toStr(_data[i].cfd)+'</td>';
					_tr+='<td class="text-left">'+toStr(_data[i].sydw_display)+'</td>';
					_tr+='<td class="text-left">'+toStr(_data[i].pczt_display)+'</td>';
					_tr+='<td class="text-left">'+toStr(_data[i].sysj)+'</td>';
					_tr+='<td class="text-center">';
					_tr+='<div class="btn-group">';
					if(buttonsPermission){
						if(buttonsPermission.indexOf(",btnCopyBatch,")>=0){
							_tr+='<button type="button" class="btn btn-xs btn-primary" data-option="btnCopyBatch" data-key="'+_data[i].wid+'">复</button>';
						}
						if(buttonsPermission.indexOf(",btnViewDetail,")>=0){
							
							_tr+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnViewDetail" data-key="'+_data[i].wid+'">详</button>';
							
						}
						if(buttonsPermission.indexOf(",btnModifyBatch,")>=0){
							if(_data[i].pczt=="1"){
								_tr+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnModifyBatch" data-key="'+_data[i].wid+'">录</button>';
							}
						}
						if(buttonsPermission.indexOf(",btnFileBatch,")>=0){
								_tr+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnFileBatch" data-key="'+_data[i].wid+'">归</button>';
						}
						if(buttonsPermission.indexOf(",btnDeletebatch,")>=0){
							if(_data[i].pczt=="1"){
								_tr+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-danger" data-option="btnDeletebatch" data-key="'+_data[i].wid+'"><i class="icon icon-times"></i></button>';
							}
						}
					}
					_tr+='</div>';
					_tr+='</td>';
					_tr+='</tr>';
				};
				$("#tblUserInfo").html(_tr);
			}
			
			pageHelper("#pageInfo",data.data.page-1,data.data.total,function(pageId){
				queryList(pageId);
			});
			$("#mainTable").delegate("[data-option='btnCopyBatch']","click",function(){
				var key=$(this).attr("data-key");
				if(confirm("您确认复制该样品批次吗",function(data){
					doPost(basePath+"/batch/copyBatch", "wid="+key, function(data) {
						window.location=basePath+"/batch/detailIndex?wid="+data.data;
					});
				}));
			});
			$("#mainTable").delegate("[data-option='btnViewDetail']","click",function(){
				var key=$(this).attr("data-key");
				window.location=basePath+"/batch/detailIndexView?wid="+key;
			});
			$("#mainTable").delegate("[data-option='btnModifyBatch']","click",function(){
				var key=$(this).attr("data-key");
				window.location=basePath+"/batch/detailIndex?wid="+key;
			});
			$("#mainTable").delegate("[data-option='btnFileBatch']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认该样品批次归档吗？",function(e){
						doPost(basePath+"/batch/guidang","wid="+key,function(){
							alert("归档成功！");
							window.location.reload();
						})
				});
				
			});
			$("#mainTable").delegate("[data-option='btnDeletebatch']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认删除该样品批次信息吗？",function(e){
					doPost(basePath+"/batch/deleteBatch","wid="+key,function(data){
						alert("样品批次删除成功！");
						window.location.reload();
					});
				});
			});
		})
	}
	
	function queryRole(){
		doGet(basePath+"/roles/list","",function(data){
			if(data && data.data && data.data.roles){
				var _d=data.data.roles;
				var str="";
				for(var i=0;i<_d.length;i++){
					str+="<option value='"+_d[i].wid+"'>"+_d[i].name+"</option>";
					
				}
				$("#userInfoRole").append(str);
				$("#userInfoRole").multiselect();
			}
		})
	}
	$("#btnAddBatch").click(function(){
		window.location=basePath+"/batch/detailIndex?wid=";
		
	});
	
	$("#mainTable [name='selAll']").click(function(){
		if($(this)[0].checked){
			$("#mainTable [name='chkSingle']").prop("checked",true);
		}else{
			$("#mainTable [name='chkSingle']").prop("checked",false);
		}
	});
	
	$("#btnBatchDelete").click(function(){
		var selectRows=$("#mainTable [name='chkSingle']:checked");
		if(selectRows.size()<=0){
			alert("请至少选择一条样品批次！");
			return false;
		}
		var strSelectedId="";
		for(var i=0;i<selectRows.size();i++){
			strSelectedId+=","+selectRows[i].value;
		}
		if(strSelectedId){
			strSelectedId=strSelectedId.substr(1);
		}
		confirm("您确认删除选中的该样品批次信息吗？",function(e){
			doGet(basePath+"/batch/deleteBatchBatchInfo","wids="+strSelectedId,function(data){
			window.location.reload();
		});
		});
	});
	//发起任务
	$("#btnAddTask").click(function(){
		var selectRows=$("#mainTable [name='chkSingle']:checked");
		if(selectRows.size()<=0){
			alert("请选择一条样品批次！");
			return false;
		}
		if(selectRows.size()>1){
			alert("每次只能选择一条任务，请重新选择！");
			return false;
		}
		doGet(basePath+"/batch/checkBatchInfo","wid="+selectRows[0].value,function(data){
			window.location=basePath+"/task/taskadd?wid="+selectRows[0].value;
		});
	});
	//发起合同
	$("#btnDraftContract").click(function(){
		var selectRows=$("#mainTable [name='chkSingle']:checked");
		if(selectRows.size()<=0){
			alert("请选择一条样品批次！");
			return false;
		}
		var strSelectedId="";
		for(var i=0;i<selectRows.size();i++){
			strSelectedId+=","+selectRows[i].value;
		}
		if(strSelectedId){
			strSelectedId=strSelectedId.substr(1);
		}
		doPost(basePath+"/batch/checkContractInfo","wids="+strSelectedId,function(data){
			window.location=basePath+"/contractEditInfo/index?pcids="+strSelectedId+"&firstPcid="+data.data.wid;
		});
	});
	
	
	$("#btnSelectBm").click(function(){
		if(!zTree){
			setTree();
		}
		showMenu();
		
	});
	$("#btnQuery").click(function(){
		var queryCondition=$.trim($("#queryCondition").val());
		queryList(0,queryCondition);
		return false;
	});
	
	$("#btnExport").click(function(){
		var queryCondition=$.trim($("#queryCondition").val());
		window.open(basePath+"/batch/export?condition="+queryCondition);
	});
	function setTree(){
		doGet(basePath+"/departments/selectDepartment","",function(data){
			zTree= $.fn.zTree.init($("#treeDemo"), setting, data.data);
		});
	}
	function onClick(e, treeId, treeNode) {
		nodes = zTree.getSelectedNodes(),
		v = "";
		var _id="";
		nodes.sort(function compare(a,b){return a.id-b.id;});
		for (var i=0, l=nodes.length; i<l; i++) {
			v += nodes[i].name + ",";
			_id+=nodes[i].bm + ",";
		}
		if (v.length > 0 ) v = v.substring(0, v.length-1);
		if(_id.length>0)  _id = _id.substring(0, _id.length-1);
		$("#txtDepartment").val(v);
		$("#department").val(_id);
		$("#team").empty();
		doGetSelect(basePath+"/departments/selectTeamByDepartment","bm="+_id,"#team");
		hideMenu();
	}
	function beforeClick(treeId, treeNode) {
		//var check = (treeNode && !treeNode.isParent);
		//if (!check) alert("请选择非文件夹选项！");
		return true;
	}
	function showMenu() {
		var cityObj = $("#txtDepartment");
		var cityOffset = $("#txtDepartment").offset();
		$("#menuContent").css({width:cityObj.width()+"px",left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast"); 
		$("body").bind("mousedown", onBodyDown);
	}
	function hideMenu() {
		$("#menuContent").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}
	function onBodyDown(event) {
		if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
			hideMenu();
		}
	}
	$("#btnSaveUserInfo").click(function(){
		if(_validater.form()){
			var url=basePath+"/users";
			if($("#modelEdithUserInfo [name='wid']").val()==""){
				url+="/insert";
			}else{
				url+="/update";
			}
			var datas=$("#modelEdithUserInfo form").serializeArray();
			var userInfoRoles="";
			for(var i=datas.length-1;i>=0;i--){
				if(datas[i].name=="userInfoRole"){
					userInfoRoles+=","+datas[i].value;
					datas.splice(i,1);
				}
			}
			if(userInfoRoles){
				userInfoRoles=userInfoRoles.substr(1);
			}
			datas.push({"name":"userInfoRoles","value":userInfoRoles});
			doPost(url,datas,function(data){
				alert(data.msg);
				window.location.reload();
			});
		}
	});
})