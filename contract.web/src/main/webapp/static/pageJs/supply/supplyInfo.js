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
			phone:{
				required:true,
				isMobile:true
			},
			email:{
				required:true,
				email:true
			}
		}
	});
	queryList();
	
	function queryList(pageId){
		$("#tblSupplyInfo").empty();
		if(pageId==undefined){
			pageId=0;
		}
		doGet(basePath+"/supply/list","startPage="+pageId,function(data){
			if(data.data.data){
				$('#tblSupplyInfoTpl').tmpl(data.data.data).appendTo('#tblSupplyInfo');
				//$("#mainTable").datatable({checkable: true});
			}else{
				//$("#mainTable").datatable({checkable: true});
			}
			
			pageHelper("#pageInfo",data.data.page-1,data.data.total,function(pageId){
				queryList(pageId);
			});
			$("#mainTable").delegate("[data-option='btnLing']","click",function(){
				var key=$(this).attr("data-key");
				doGet(basePath+"/supply/toShb","wid="+key,function(data){
					$("#slbForm [name='hcfl']").html(data.data.hcfl_display);
					$("#slbForm [name='pm']").html(data.data.pm);
					$("#slbForm [name='kc']").html(data.data.kc);
					$("#slbForm [name='hcid']").val(data.data.wid);
					$("#modelSlbSupplyInfo").modal("show");
				});
				
			});
			$("#mainTable").delegate("[data-option='btnMai']","click",function(){
				var key=$(this).attr("data-key");
					doGet(basePath+"/supply/toGmb","wid="+key,function(data){
						$("#gbForm [name='hcfl']").html(data.data.hcfl_display);
						$("#gbForm [name='pm']").html(data.data.pm);
						$("#gbForm [name='kc']").html(data.data.kc);
						$("#gbForm [name='hcid']").val(data.data.wid);
						$("#modelGmbSupplyInfo").modal("show");
					});
			});
			$("#mainTable").delegate("[data-option='btnSun']","click",function(){
				var key=$(this).attr("data-key");
				doGet(basePath+"/supply/toGmb","wid="+key,function(data){
					$("#shbForm [name='hcfl']").html(data.data.hcfl_display);
					$("#shbForm [name='pm']").html(data.data.pm);
					$("#shbForm [name='kc']").html(data.data.kc);
					$("#shbForm [name='hcid']").val(data.data.wid);
					$("#modelShbSupplyInfo").modal("show");
				});
			});
			$("#mainTable").delegate("[data-option='btnEdit']","click",function(){
				var key=$(this).attr("data-key");
				setEdit(key);
				$("#modelEdithSupplyInfo").modal("show");
			});
			$("#mainTable").delegate("[data-option='btnView']","click",function(){
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
						$("#supplyViewForm [name='yjsl']").html(data.data.yjsl);
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
	
	$("#btnNew").click(function(){
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
		alert("123");
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
})