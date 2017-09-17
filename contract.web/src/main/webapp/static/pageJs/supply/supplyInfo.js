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
				digits:true
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
		doGet(basePath+"/supply/list","startPage="+pageId+"&queryCodition="+$("#queryCondition").val(),function(data){
			if(data.data.data){
				var tbl='';
				var _data=data.data.data;
				for(var i=0;i<_data.length;i++){
					tbl+='<tr>';
					tbl+='<td class="text-center"><input type="checkbox" name="chkSingle" value="'+_data[i].wid+'"></td>';
					tbl+='<td class="text-center">'+toStr(_data[i].pm)+'</td>';
					tbl+='<td class="text-center">'+toStr(_data[i].hcfl_display)+'</td>';
					tbl+='<td class="text-left">'+toStr(_data[i].yxq)+'</td>';
					tbl+='<td class="text-left">'+toStr(_data[i].kc)+'</td>';
					tbl+='<td class="text-left">'+toStr(_data[i].gys)+'</td>';
					tbl+='<td class="text-center">';
					tbl+='<div class="btn-group">';
					if(buttonsPermission){
						if(buttonsPermission.indexOf(",btnDetail,")>=0){
							tbl+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnDetail" data-key="'+_data[i].wid+'">详</button>';
						}
						if(buttonsPermission.indexOf(",btnModify,")>=0 && _data[i].needKl!="1"){
							
							tbl+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnModify" data-key="'+_data[i].wid+'">录</button>';
							
						}
						if(buttonsPermission.indexOf(",btnKl,")>=0 && _data[i].needKl!="1"){
							
							tbl+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnKl" data-key="'+_data[i].wid+'">可领</button>';
							
						}
						if(buttonsPermission.indexOf(",btnDelete,")>=0 && _data[i].needKl!="1"){
							
							tbl+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-danger" data-option="btnDelete" data-key="'+_data[i].wid+'"><i class="icon icon-times"></i></button>';
							
						}
					}
					
          					
					tbl+='	</div>';
					tbl+='</td>';
					tbl+='</tr>';
				}
				$("#tblSupplyInfo").html(tbl);
			}
			
			pageHelper("#pageInfo",data.data.page-1,data.data.total,function(pageId){
				queryList(pageId);
			});
			
			$("#mainTable").delegate("[data-option='btnModify']","click",function(){
				var key=$(this).attr("data-key");
				setEdit(key);
				$("#modelEdithSupplyInfo").modal("show");
			});
			$("#mainTable").delegate("[data-option='btnKl']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认该类耗材加入可领仓库？",function(){
					doPost(basePath+"/supply/kl","wid="+key,function(data){
						window.location.reload();
					})
				});
			});
			$("#mainTable").delegate("[data-option='btnDetail']","click",function(){
				var key=$(this).attr("data-key");
					doGet(basePath+"/supply/viewDetail", "wid="+key, function(data) {
						$("#supplyViewForm [name='hcfl']").html(data.data.hcfl_display);
						$("#supplyViewForm [name='pm']").html(data.data.pm);
						$("#supplyViewForm [name='xhppch']").html(data.data.xhppch);
						$("#supplyViewForm [name='xhplrsj']").html(data.data.xhplrsj);
						$("#supplyViewForm [name='sldw']").html(data.data.sldw_display);
						$("#supplyViewForm [name='dj']").html(data.data.dj);
						$("#supplyViewForm [name='hbdw']").html(data.data.hbdw_display);
						$("#supplyViewForm [name='yxq']").html(data.data.yxq);
						$("#supplyViewForm [name='kc']").html(data.data.kc);
						//$("#supplyViewForm [name='yjsl']").html(data.data.yjsl);
						$("#supplyViewForm [name='gys']").html(data.data.gys);
						$("#supplyViewForm [name='bz']").html(data.data.bz);
					});
					$("#modelViewSupplyInfo").modal("show");
			});
			
			
			$("#mainTable").delegate("[data-option='btnDelete']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认删除该样品批次信息吗？",function(e){
					doPost(basePath+"/supply/deleteSupply","wid="+key,function(data){
						alert("样品批次删除成功！");
						window.location.reload();
					});
				});
			});
		})
	}
	
	$("#supplyForm [name='hcfl']").on("change",function(){
		var _v=$(this).val();
		if(_v){
		doGet(basePath+"/supply/searchPm?hcfl="+_v,"",function(data){
			var dataList = {value: []}
			if(data.data){
				var _d=data.data;
				
				for(var i=0;i<_d.length;i++){
					dataList.value.push({
						"pm":_d[i].PM
					});
				}
			}
			$("#supplyForm [name='pm']").bsSuggest('destroy');
			$("#supplyForm [name='pm']").bsSuggest({
		        ignorecase: true,
		        showHeader: false,
		        autoSelect: true,
		        showBtn: false,     //不显示下拉按钮
		        data: dataList,
		        idField: "pm",
		        keyField: "pm",
		        clearable: true,
		        inputWarnColor:"white"
		 }).on('onDataRequestSuccess', function (e, result) {
		        console.log('从 json.data 参数中获取，不会触发 onDataRequestSuccess 事件', result);
		    }).on('onSetSelectValue', function (e, keyword, data) {
		    	setByHcflAndPm($("#supplyForm [name='hcfl']").val(),$("#supplyForm [name='pm']").val());
		    }).on('onUnsetSelectValue', function () {
		    	setByHcflAndPm($("#supplyForm [name='hcfl']").val(),$("#supplyForm [name='pm']").val());
		    });
		});
		}
		 
	});
	
	function setByHcflAndPm(hcfl,pm){
		doGet(basePath+"/supply/selectByHcflAndPm","hcfl="+hcfl+"&pm="+pm,function(data){
        	if(data.data){
        		//$("#supplyForm [name='hbdw']").val(data.data.hbdw);
        		$("#supplyForm [name='sldw']").val(data.data.sldw);
        	}
        });
	}
	
	$("#btnAdd").click(function(){
		setEdit("");
		$("#modelEdithSupplyInfo").modal("show");
	});
	
	function setEdit(_wid){
		doGet(basePath+"/supply/view","wid="+_wid,function(data){
			if(data && data.data){
				var _d=data.data;
				$("#supplyForm [name='wid']").val(_d.wid);
				doGetSelect2("T_CONTRACT_SJZD_HCFL","#supplyForm [name='hcfl']",_d.hcfl);
				$("#supplyForm [name='pm']").val(_d.pm);
				$("#supplyForm [name='xhppch']").val(_d.xhppch);
				$("#supplyForm [name='xhplrsj']").val(_d.xhplrsj);
				$("#supplyForm [name='kc']").val(_d.kc);
				doGetSelect2("T_CONTRACT_SJZD_SLDW","#supplyForm [name='sldw']",_d.sldw);
				
				$("#supplyForm [name='dj']").val(_d.dj);
				doGetSelect2("T_CONTRACT_SJZD_HBDW","#supplyForm [name='hbdw']",_d.hbdw);
				
				$("#supplyForm [name='yxq']").val(_d.yxq);
				$("#supplyForm [name='yjsl']").val(_d.yjsl);
				$("#supplyForm [name='gys']").val(_d.gys);
				$("#supplyForm [name='bz']").val(_d.bz);
				
				
			}
		});
	}
	
	$("#mainTable [name='selAll']").click(function(){
		if($(this)[0].checked){
			$("#mainTable [name='chkSingle']").prop("checked",true);
		}else{
			$("#mainTable [name='chkSingle']").prop("checked",false);
		}
	});
	
	//发起任务
	$("#btnSaveSlbSupplyInfo").click(function(){
		doPost(basePath+"/supply/saveSlb",$("#slbForm").serializeArray(),function(data){
			alert(data.msg);
			window.location.reload();
		});
	});
	//发起任务
	$("#btnSaveGmbSupplyInfo").click(function(){
		doPost(basePath+"/supply/saveGmb",$("#gbForm").serializeArray(),function(data){
			alert(data.msg);
			window.location.reload();
		});
	});
	
	//发起任务
	$("#btnSaveShbSupplyInfo").click(function(){
		doPost(basePath+"/supply/saveShb",$("#shbForm").serializeArray(),function(data){
			alert(data.msg);
			window.location.reload();
		});
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
			var url=basePath+"/supply/save";
			var datas=$("#supplyForm").serializeArray();
			doPost(url,datas,function(data){
				window.location.reload();
			});
		}
	});
	
	$("#btnExport").click(function(){
		window.open(basePath+"/supply/export");
	})
})