/**
 * 
 */

$(document).ready(function(){
	var _validater=$("#zdbsForm").validate({
		errorPlacement: function(error, element) {
			// Append error within linked label
			$(error).insertAfter($(element));
			//.append(error);
			//$("#mainForm").find( "label[for='" + element.attr( "id" ) + "']" ).append( error );
		},
		rules:{
			orderby:{
				required:true,
				digits:true
			}
		}
	});
	var zTree;
	var setting = {
			view: {
				dblClickExpand: false
			}, 
			callback: {
				onClick: zTreeOnClick
			},
			data: {
				simpleData: {
					enable: true,
					idKey:"wid",
					pIdKey:"pid",
					rootPId:"-1"
				},
				key:{
					name:"name"
				}
			}
		};
	var rootNode={wid:'0',code:"",pid:'-1',name:"字典表"};
	var nodes=new Array();
	nodes.push(rootNode);
	
	doGet(basePath+"/zdbdetail/listZdb","",function(data){
		if(data.data){
			var _d=data.data;
			for(var i=0;i<_d.length;i++){
				_d[i].pid="0";
				nodes.push(_d[i]);
			}
			
		}
		zTree=$.fn.zTree.init($("#zdbTree"), setting, nodes);
		zTree.expandAll(true); 
	});
	
	$("#btnNew").click(function(){
		var selectNodes=zTree.getSelectedNodes();
		if(selectNodes.length<1){
			alert("请选择一个字典表！");
			return;
		}
		if(!selectNodes[0].code){
			alert("请选择一个字典表！");
			return;
		} 
		$("#zdbsForm")[0].reset();
		$("#zdbsForm [name='wid']").val("");
		$("#zdbsForm [name='tableName']").val(selectNodes[0].code);
		$("#modelEditZdbsInfo").modal("show");
		
	});
	$("#btnSaveZdbsInfo").click(function(){
		var url=basePath+"/zdbdetail";
		var wid=$("#zdbsForm [name='wid']").val();
		var _tblName=$("#zdbsForm [name='tableName']").val();;
		var flag="update";
		if(wid){
			url+="/update";
			flag="update";
		}else{
			url+="/insert";
			flag="insert";
		}
		if(_validater.form()){
			doPost(url,$("#zdbsForm").serializeArray(),function(data){
				$("#modelEditZdbsInfo").modal("hide");
				queryList(_tblName);
			});
		}
	});
	function zTreeOnClick(event,treeId,treeNode){
		$("#tblSjzdInfo").empty();
		if(treeNode.code){
			queryList(treeNode.code);
		} 
	}
	
	function queryList(tblName){
		$("#tblSjzdInfo").empty();
		doGet(basePath+"/zdbdetail/list","tableName="+tblName,function(data){
			if(data.data){
				$('#tblSjzdInfoTpl').tmpl(data.data).appendTo('#tblSjzdInfo');
				$("#mainTable").datatable({sortable: true});
			}else{
				$("#mainTable").datatable({sortable: true});
			}
			$("#mainTable").datatable("load");
			$("#datatable-mainTable").delegate("[data-option='editSjzd']","click",function(){
				var key=$(this).attr("data-key");
				$("#zdbsForm")[0].reset();
				$("#zdbsForm [name='wid']").val(key);
				doGet(basePath+"/zdbdetail/select","wid="+key+"&tableName="+tblName,function(data){
					$("#zdbsForm [name='lbdm']").val(data.data.lbdm);
					$("#zdbsForm [name='lbmc']").val(data.data.lbmc);
					$("#zdbsForm [name='tableName']").val(tblName);
					$("#zdbsForm [name='orderby']").val(data.data.orderby);
				});
				$("#modelEditZdbsInfo").modal("show");
			});
			$("#datatable-mainTable").delegate("[data-option='deleteSjzd']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认删除该数据？",function(){
					doPost(basePath+"/zdbdetail/delete","wid="+key+"&tableName="+tblName,function(data){
						queryList(tblName);
					});
				});	
			});
		});
	}
});