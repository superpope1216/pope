/**
 * 
 */
$(document).ready(function(){
	
	queryList();
	var setting = {
			view: {
				dblClickExpand: false
			},
			check: {
				enable: true,
				autoCheckTrigger: true
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
	var treeObj;
	
	function queryList(){
		doGet(basePath+"/roles/list","",function(data){
			if(data.data){
				$('#tblRoleInfoTpl').tmpl(data.data.roles).appendTo('#tblRoleInfo');
				treeObj=$.fn.zTree.init($("#permissionTree"), setting, data.data.perms);
				 
				treeObj.expandAll(true); 
			}
		});
	}
	
	$("#btnNewRole").click(function(){
		$("#modelEdithRoleInfo").modal("show");
	});
	
	$("#btnSaveRoleInfo").click(function(){
		var url=basePath+"/roles";
		if($("#modelEdithRoleInfo [name='wid']").val()==""){
			url+="/insert";
		}else{
			url+="/update";
		}
		doPost(url,$("#modelEdithRoleInfo form").serializeArray(),function(data){
			window.location.reload();
		});
	});
	$("#mainRole tr").click(function(){
		alert($(this).find("[name='wid']").val())
	})
	$("#tblRoleInfo").delegate( "[data-option='editRole']", "click", function() {
		var key=$(this).attr("data-key");
		doGet(basePath+"/roles/select","roleId="+key,function(data){
			if(data.data){
				$("#modelEdithRoleInfo form [name='wid']").val(data.data.wid);
				$("#modelEdithRoleInfo form [name='name']").val(data.data.name);
				$("#modelEdithRoleInfo form [name='description']").val(data.data.description);
				$("#modelEdithRoleInfo").modal("show");
			}
		})
		
		
	});
	$("#tblRoleInfo").delegate( "[data-option='deleteRole']", "click", function() {
		var key=$(this).attr("data-key");
		confirm("您确认删除该角色？",function(){
			doPost(basePath+"/roles/delete","roleId="+key,function(data){
				//alert(data.msg);
				window.location.reload();
			})
		});
	});
	 $("#tblRoleInfo").delegate( "tr", "click", function() {
		 var roleId=$(this).find("[name='wid']").val();
		 $("#tblRoleInfo tr").removeClass("active");
		 $(this).addClass("active");
		 treeObj.checkAllNodes(false);
		 doGet(basePath+"/permissions/permission","roleId="+roleId,function(data){
			if(data.data){
				//var nodes = treeObj.getNodes();
				for(var i=0;i<data.data.length;i++){
					var _d=data.data[i];
					if(_d.level=="4"){
						 var node=treeObj.getNodeByParam("wid",_d.wid,null);
						 if(node){
							 node.checked=true;
							 treeObj.updateNode(node,true)
						 }
					}
				}
			}
		 });
	 });
	
	$("#btnSavePerms").click(function(){
		var nodes = treeObj.getCheckedNodes(true);
		var nodeKey="";
		if(nodes){
			for(var i=0;i<nodes.length;i++){
				nodeKey+=","+nodes[i].wid;
			}
		}
		if(nodeKey){
			nodeKey=nodeKey.substr(1);
		}
		var roleId=$("#tblRoleInfo tr.active [name='wid']").val();
		if(!roleId){
			alert("请先选择一个角色！");
			return;
		}
		doPost(basePath+"/permissions/updateRolePerms","roleId="+roleId+"&perms="+nodeKey,function(data){
			alert("角色保存成功！");
		});
	});
	
});