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
	
	function queryList(){
		doGet(basePath+"/permissions/list","",function(data){
			if(data.data){
				$('#tblRoleInfoTpl').tmpl(data.data.roles).appendTo('#tblRoleInfo');
				var treeObj=$.fn.zTree.init($("#permissionTree"), setting, data.data.perms);
				 
				treeObj.expandAll(true); 
			}
		});
	}
	
	$("#mainRole tr").click(function(){
		alert($(this).find("[name='wid']").val())
	})
	
	 $("#tblRoleInfo").delegate( "tr", "click", function() {
		 var roleId=$(this).find("[name='wid']").val();
		 $("#tblRoleInfo tr").removeClass("active");
		 $(this).addClass("active");
		 doGet(basePath+"/permissions/permission","roleId="+roleId,function(data){
			if(data.data){
				var treeObj = $.fn.zTree.getZTreeObj("permissionTree");
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
		var treeObj = $.fn.zTree.getZTreeObj("permissionTree");
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