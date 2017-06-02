/**
 * 
 */

$(document).ready(function(){
	var rMenu = $("#rMenu");
	var zTree;
	var setting = {
			view: {
				dblClickExpand: false
			}, 
			callback: {
				onRightClick: OnRightClick,
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
	queryList();
	function queryList(){
		doGet(basePath+"/departments/list","",function(data){
			if(data.data){
				zTree=$.fn.zTree.init($("#departTree"), setting, data.data);
				var node=zTree.getNodeByParam("wid", 1, null);
				setDepartForm("departForm",node);
				zTree.expandAll(true); 
			}
		});
	}
	
	function setDepartForm(formid,_node){
		$("#"+formid+" [name='wid']").val(_node.wid);
		$("#"+formid+" [name='type']").val(_node.type);
		$("#"+formid+" [name='pid']").val(_node.pid);
		$("#"+formid+" [name='bm']").val(_node.bm);
		$("#"+formid+" [name='name']").val(_node.name);
		zTree.selectNode(_node);
	}
	$("#btnSaveDepart").click(function(){
		save("departForm");
	});
	
	$("#btnSaveTeam").click(function(){
		save("teamForm");
	});
	
	function save(formId){
		var url=basePath+"/departments";
		var wid=$("#"+formId+" [name='wid']").val();
		var flag="update";
		if(wid){
			url+="/update";
			flag="update";
		}else{
			url+="/insert";
			flag="insert";
		}
		doPost(url,$("#"+formId+"").serializeArray(),function(data){
			alert(data.msg);
			if(flag=="insert"){
				$("#"+formId+" [name='wid']").val(data.data.wid);
				var newNode=data.data;
				zTree.addNodes(zTree.getSelectedNodes()[0], newNode);
				var _newNode=zTree.getNodeByParam("wid", newNode.wid, null);
				setDepartForm(formId,_newNode);
				
			}
		});
	}
	var treeFlag=0;
	$("#m_addDepart").click(function(){
		hideRMenu();
		var node=zTree.getSelectedNodes()[0];
		$("#departForm")[0].reset();
		$("#departForm [type='hidden']").val("");
		$("#departForm [name='type']").val("1");
		$("#departForm [name='pid']").val(node.wid);
		$("#divDepart").show();
		$("#divTeam").hide();
	});
	
	$("#m_delDepart").click(function(){
		hideRMenu();
		confirm("该部门下所有信息将会同步删除，您确认删除该部门嘛？",function(){
			var node=zTree.getSelectedNodes()[0];
			doPost(basePath+"/departments/delete","wid="+node.wid,function(data){
				var pNode= zTree.getNodeByParam("wid", node.pid, null);
				zTree.removeNode(node);
				zTree.selectNode(pNode);
				setDepartForm("departForm",pNode);
				$("#divDepart").show();
				$("#divTeam").hide();
			})
		});
	});
	
	$("#m_addTeam").click(function(){
		hideRMenu();
		var node=zTree.getSelectedNodes()[0];
		$("#teamForm")[0].reset();
		$("#teamForm [type='hidden']").val("");
		$("#teamForm [name='type']").val("2");
		$("#teamForm [name='pid']").val(node.wid);
		$("#divDepart").hide();
		$("#divTeam").show();
	});
		
	$("#m_delTeam").click(function(){
		hideRMenu();
		confirm("您确认删除该小组嘛？",function(){
			var node=zTree.getSelectedNodes()[0];
			doPost(basePath+"/departments/delete","wid="+node.wid,function(data){
				var pNode= zTree.getNodeByParam("wid", node.pid, null);
				
				zTree.removeNode(node);
				zTree.selectNode(pNode);
				setDepartForm("departForm",pNode);
				$("#divDepart").show();
				$("#divTeam").hide();
			})
		});
	});
	
	function OnRightClick(event, treeId, treeNode) {
		if (!treeNode && event.target.tagName.toLowerCase() != "button" && $(event.target).parents("a").length == 0) {
			zTree.cancelSelectedNode();
			showRMenu(treeNode.type, event.clientX, event.clientY);
		} else if (treeNode && !treeNode.noR) {
			zTree.selectNode(treeNode);
			showRMenu(treeNode.type, event.clientX, event.clientY);
		}
	}
	
	function zTreeOnClick(event,treeId,treeNode){
		if(treeNode.type=="2"){
			$("#divTeam").show();
			$("#divDepart").hide();
			setDepartForm("teamForm",treeNode);
		}else{
			$("#divTeam").hide();
			$("#divDepart").show();
			setDepartForm("departForm",treeNode);
		}
	}

	function showRMenu(type, x, y) {
		$("#rMenu ul").show();
		if (type=="0"){ //全公司
			$("#m_addDepart").show();
			$("#m_delDepart").hide();
			$("#m_addTeam").hide();
			$("#m_delTeam").hide();
			
		} else if(type=="1") {
			$("#m_addDepart").show();
			$("#m_delDepart").show();
			$("#m_addTeam").show();
			$("#m_delTeam").hide();
		}else{
			$("#m_addDepart").hide();
			$("#m_delDepart").hide();
			$("#m_addTeam").hide();
			$("#m_delTeam").show();
		}
		rMenu.css({"top":y+"px", "left":x+"px", "visibility":"visible"}); 
		$("body").bind("mousedown", onBodyMouseDown);
	}
	
	function hideRMenu() {
		if (rMenu) rMenu.css({"visibility": "hidden"});
		$("body").unbind("mousedown", onBodyMouseDown);
	}
	
	function onBodyMouseDown(event){
		if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length>0)) {
			rMenu.css({"visibility" : "hidden"});
		}
	}
});