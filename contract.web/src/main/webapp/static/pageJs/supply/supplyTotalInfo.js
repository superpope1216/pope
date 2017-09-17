/**
 * 
 */
$(document).ready(function(){
	var _validater=$("#supplyForm").validate({
		errorPlacement: function(error, element) {
			// Append error within linked label
			$(error).insertAfter($(element));
			//.append(error);
			//$("#mainForm").find( "label[for='" + element.attr( "id" ) + "']" ).append( error );
		},
		rules:{
			kc:{
				required:true,
				digits:true
			},
			dj:{
				required:true,
				number:true,
				min:0
			},
			yjsl:{
				required:true,
				digits:true,
				min:0
			}
		}
	});
	
	var _validaterslbForm=$("#slbForm").validate({
		errorPlacement: function(error, element) {
			// Append error within linked label
			$(error).insertAfter($(element));
			//.append(error);
			//$("#mainForm").find( "label[for='" + element.attr( "id" ) + "']" ).append( error );
		},
		rules:{
			ghsl:{
				required:true,
				number:true,
				min:0
			},
			lysl:{
				required:true,
				number:true,
				min:0
			}
		}
	});
	
	var _validatergbForm=$("#gbForm").validate({
		errorPlacement: function(error, element) {
			// Append error within linked label
			$(error).insertAfter($(element));
			//.append(error);
			//$("#mainForm").find( "label[for='" + element.attr( "id" ) + "']" ).append( error );
		},
		rules:{
			lysl:{
				required:true,
				number:true,
				min:0
			}
		}
	});
	
	var _validatershbForm=$("#shbForm").validate({
		errorPlacement: function(error, element) {
			// Append error within linked label
			$(error).insertAfter($(element));
			//.append(error);
			//$("#mainForm").find( "label[for='" + element.attr( "id" ) + "']" ).append( error );
		},
		rules:{
			lysl:{
				required:true,
				number:true,
				min:0
			}
		}
	});
	
	setButtonsDisplay(buttonsPermission);
	queryList();
	
	function queryList(pageId){
		$("#tblSupplyInfo").empty();
		if(pageId==undefined){
			pageId=0;
		}
		doGet(basePath+"/supplyTotal/list","startPage="+pageId+"&queryCodition="+$("#queryCondition").val(),function(data){
			if(data.data.data){
				var _d=data.data.data;
				var tbl="";
				for(var i=0;i<_d.length;i++){
					tbl+='<tr>';
					
					tbl+='<td class="text-center">'+toStr(_d[i].pm)+'</td>';
					tbl+='<td class="text-center">'+toStr(_d[i].hcfl_display)+'</td>'; 
					tbl+='<td class="text-left">'+toStr(_d[i].kc)+'</td>';
					tbl+='<td class="text-left">'+toStr(_d[i].sldw_display)+'</td>';
					tbl+='<td class="text-left">'+toStr(_d[i].yjsl)+'</td>';
					tbl+='<td class="text-center">';
					tbl+='	<div class="btn-group">';
					if(buttonsPermission){
						if(buttonsPermission.indexOf(",btnLqb,")>=0){
							tbl+='<button type="button" class="btn btn-xs btn-primary" data-option="btnLqb" data-key="'+_d[i].wid+'">领</button>';
						}
						if(buttonsPermission.indexOf(",btnGmb,")>=0){
							tbl+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnGmb" data-key="'+_d[i].wid+'">买</button>';
						}
						if(buttonsPermission.indexOf(",btnShb,")>=0){
							tbl+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnShb" data-key="'+_d[i].wid+'">损</button>';
						}
						if(buttonsPermission.indexOf(",btnDetail,")>=0){
							tbl+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnDetail" data-key="'+_d[i].wid+'">详</button>';
						}
						if(buttonsPermission.indexOf(",btnYjsz,")>=0){
							tbl+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-danger" data-option="btnYjsz" data-key="'+_d[i].wid+'">预警</button>';
						}
					tbl+='</div>';
					tbl+='</td>';
					tbl+='</tr>';
				}

				$("#tblSupplyInfo").html(tbl);
			}
			}
			
			pageHelper("#pageInfo",data.data.page-1,data.data.total,function(pageId){
				queryList(pageId);
			});
			$("#mainTable").delegate("[data-option='btnLqb']","click",function(){
				var key=$(this).attr("data-key");
				doGet(basePath+"/supplyTotal/toShb","wid="+key,function(data){
					$("#slbForm [name='hcfl']").html(data.data.hcfl_display);
					$("#slbForm [name='pm']").html(data.data.pm);
					$("#slbForm [name='kc']").html(data.data.kc);
					$("#slbForm [name='hcid']").val(data.data.wid);
					$("#modelSlbSupplyInfo").modal("show");
				});
				
			});
			$("#mainTable").delegate("[data-option='btnGmb']","click",function(){
				var key=$(this).attr("data-key");
					doGet(basePath+"/supplyTotal/toGmb","wid="+key,function(data){
						$("#gbForm [name='hcfl']").html(data.data.hcfl_display);
						$("#gbForm [name='pm']").html(data.data.pm);
						$("#gbForm [name='kc']").html(data.data.kc);
						$("#gbForm [name='hcid']").val(data.data.wid);
						$("#modelGmbSupplyInfo").modal("show");
					});
			});
			$("#mainTable").delegate("[data-option='btnShb']","click",function(){
				var key=$(this).attr("data-key");
				doGet(basePath+"/supplyTotal/toGmb","wid="+key,function(data){
					$("#shbForm [name='hcfl']").html(data.data.hcfl_display);
					$("#shbForm [name='pm']").html(data.data.pm);
					$("#shbForm [name='kc']").html(data.data.kc);
					$("#shbForm [name='hcid']").val(data.data.wid);
					$("#modelShbSupplyInfo").modal("show");
				});
			});
			
			$("#mainTable").delegate("[data-option='btnYjsz']","click",function(){
				var key=$(this).attr("data-key");
				setEdit(key);
				
			});
			$("#mainTable").delegate("[data-option='btnEdit']","click",function(){
				var key=$(this).attr("data-key");
				setEdit(key);
				$("#modelEdithSupplyInfo").modal("show");
			});
			$("#mainTable").delegate("[data-option='btnDetail']","click",function(){
				var key=$(this).attr("data-key");
				window.location=basePath+"/supplyTotalDetailInfo/index?hcid="+key;
			});
			
		});
	}
	
	
	$("#btnNew").click(function(){
		setEdit("");
		$("#modelEdithSupplyInfo").modal("show");
	});
	
	function setEdit(_wid){
		
		doGet(basePath+"/supplyTotal/select","wid="+_wid,function(data){
			if(data && data.data){
				var _d=data.data;
				$("#supplyForm [name='wid']").val(_d.wid);
				$("#supplyForm [name='hcfl']").html(_d.hcfl_display);
				$("#supplyForm [name='pm']").html(_d.pm);
				$("#supplyForm [name='kc']").html(_d.kc);
				$("#supplyForm [name='sldw']").html(_d.sldw_display);
				$("#supplyForm [name='dj']").html(_d.dj);
				$("#supplyForm [name='hbdw']").html(_d.hbdw_display);
				$("#supplyForm [name='yjsl']").val(_d.yjsl);
				$("#modelEdithSupplyInfo").modal("show");
				
			}
		});
	}
	
	
	//发起任务
	$("#btnSaveSlbSupplyInfo").click(function(){
		if(_validaterslbForm.form()){
		doPost(basePath+"/supplyTotal/saveSlb",$("#slbForm").serializeArray(),function(data){
			alert(data.msg);
			window.location.reload();
		});
		}
	});
	//发起任务
	$("#btnSaveGmbSupplyInfo").click(function(){
		if(_validatergbForm.form()){
		doPost(basePath+"/supplyTotal/saveGmb",$("#gbForm").serializeArray(),function(data){
			alert(data.msg);
			window.location.reload();
		});
		}
	});
	
	//发起任务
	$("#btnSaveShbSupplyInfo").click(function(){
		if(_validatershbForm.form()){
		doPost(basePath+"/supplyTotal/saveShb",$("#shbForm").serializeArray(),function(data){
			alert(data.msg);
			window.location.reload();
		});
		}
	});
	
	$("#btnSelectBm").click(function(){
		if(!zTree){
			setTree();
		}
		showMenu();
		
	});
	$("#btnQuery").click(function(){
		queryList("0");
		return false;
	});
	
	$("#btnSaveSupplyInfo").click(function(){
		if(_validater.form()){
			var url=basePath+"/supplyTotal/save";
			var datas=$("#supplyForm").serializeArray();
			doPost(url,datas,function(data){
				window.location.reload();
			});
		}
	});
})