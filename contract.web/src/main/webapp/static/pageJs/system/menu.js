/**
 * 
 */
$(document).ready(function(){
	var _validater = $("#menuForm").validate({
		errorPlacement : function(error, element) {
			// Append error within linked label
			$(error).insertAfter($(element));
			// .append(error);
			// $("#mainForm").find( "label[for='" + element.attr( "id" )
			// + "']"
			// ).append( error );
		},
		rules : {
		}
	});
	queryMenu();
	var setting = {
			view: {
				dblClickExpand: false
			},
			edit: {
				drag: {
					autoExpandTrigger: true,  
		            prev: dropPrev,  
		            inner: dropInner,  
		            next: dropNext 
		        },  
		            enable: true,  
		            showRemoveBtn: false,  
		            showRenameBtn: false  
		     },
		     callback: {
		    	 	onClick: zTreeOnClick,
					beforeDrag: beforeDrag, //拖拽前：捕获节点被拖拽之前的事件回调函数，并且根据返回值确定是否允许开启拖拽操作  
		            beforeDrop: beforeDrop, //拖拽中：捕获节点操作结束之前的事件回调函数，并且根据返回值确定是否允许此拖拽操作  
		            beforeDragOpen: beforeDragOpen, //拖拽到的目标节点是否展开：用于捕获拖拽节点移动到折叠状态的父节点后，即将自动展开该父节点之前的事件回调函数，并且根据返回值确定是否允许自动展开操作  
		            onDrag: onDrag, //捕获节点被拖拽的事件回调函数  
		            onDrop: onDrop //捕获节点拖拽操作结束的事件回调函数 
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
	$("#btnSaveMenu").click(function(){
		if(_validater.form()){
			doPost(basePath+"/menus/save",$("#menuForm").serializeArray(),function(){
				window.location.reload();
			});
		}
	});
	
	function zTreeOnClick(event,treeId,treeNode){
		$("#menuForm [name='wid']").val(treeNode.wid);
		$("#menuForm [name='name']").val(treeNode.name);
		
	}
	function queryMenu(){
		doGet(basePath+"/menus/selectTree","",function(data){
			if(data.data){
				treeObj=$.fn.zTree.init($("#permissionTree"), setting, data.data);
				treeObj.expandAll(true); 
			}
		});
	}
	

	var log, className = "dark", curDragNodes, autoExpandNode;  
	function dropPrev(treeId, nodes, targetNode) {  
	    var pNode = targetNode.getParentNode();  
	    if (pNode && pNode.dropInner === false) {  
	        return false;  
	    } else {  
	        for (var i=0,l=curDragNodes.length; i<l; i++) {  
	            var curPNode = curDragNodes[i].getParentNode();  
	            if (curPNode && curPNode !== targetNode.getParentNode() && curPNode.childOuter === false) {  
	                return false;  
	            }  
	        }  
	    }  
	    return true;  
	}  

	function dropInner(treeId, nodes, targetNode) {  
	    if (targetNode && targetNode.dropInner === false) {  
	        return false;  
	    } else {  
	        for (var i=0,l=curDragNodes.length; i<l; i++) {  
	            if (!targetNode && curDragNodes[i].dropRoot === false) {  
	                return false;  
	            } else if (curDragNodes[i].parentTId && curDragNodes[i].getParentNode() !== targetNode && curDragNodes[i].getParentNode().childOuter === false) {  
	                return false;  
	            }  
	        }  
	    }  
	    return true;  
	}  

	function dropNext(treeId, nodes, targetNode) {  
	    var pNode = targetNode.getParentNode();  
	    if (pNode && pNode.dropInner === false) {  
	        return false;  
	    } else {  
	        for (var i=0,l=curDragNodes.length; i<l; i++) {  
	            var curPNode = curDragNodes[i].getParentNode();  
	            if (curPNode && curPNode !== targetNode.getParentNode() && curPNode.childOuter === false) {  
	                return false;  
	            }  
	        }  
	    }  
	    return true;  
	}  
	
	//拖拽前：捕获节点被拖拽之前的事件回调函数，并且根据返回值确定是否允许开启拖拽操作
	function beforeDrag(treeId, treeNodes) {
	    className = (className === "dark" ? "":"dark");  
	    for (var i=0,l=treeNodes.length; i<l; i++) {  
	        if (treeNodes[i].drag === false) {  
	            curDragNodes = null;  
	            return false;  
	        } else if (treeNodes[i].parentTId && treeNodes[i].getParentNode().childDrag === false) {  
	            curDragNodes = null;  
	            return false;  
	        }  
	    }  
	    curDragNodes = treeNodes;  
	    return true;  
	}
	//拖拽到的目标节点是否展开：用于捕获拖拽节点移动到折叠状态的父节点后，即将自动展开该父节点之前的事件回调函数，并且根据返回值确定是否允许自动展开操作
	function beforeDragOpen(treeId, treeNode) {  
	    autoExpandNode = treeNode;  
	    return true;  
	}  
	//拖拽中：捕获节点操作结束之前的事件回调函数，并且根据返回值确定是否允许此拖拽操作
	function beforeDrop(treeId, treeNodes, targetNode, moveType, isCopy) {  
	    className = (className === "dark" ? "":"dark");  
	    return true;  
	}  
	//捕获节点被拖拽的事件回调函数
	function onDrag(event, treeId, treeNodes) {  
	    className = (className === "dark" ? "":"dark");  
	}
	//捕获节点拖拽操作结束的事件回调函数
	function onDrop(event, treeId, treeNodes, targetNode, moveType, isCopy) {  
	    className = (className === "dark" ? "":"dark");
	    //获取节点路径
	    var path = "";
		var nodes = null;
		if(treeNodes != null && treeNodes != undefined){
			for(var i=0; i<treeNodes.length; i++){
				nodes = treeNodes[i].getPath();
				if (nodes !== null && nodes !== undefined) {
					for (var j = 0; j < nodes.length; j++) {
						if (nodes[j].WID != "1") {
							path += nodes[j].NAME + ">";
						}
					}
				}
				path = path.substring(0, path.length-1);
				treeNodes[i].PATH = path;
				path = "";
			}
			//获取新的节点排序
			if(moveType == "inner"){
				nodes = targetNode.children;
			}else{
				nodes = targetNode.getParentNode().children;
			}
			
			for(var k=0; k<nodes.length; k++){
				nodes[k].PX = k+1;
			}
			
			doPost(basePath + '/menus/updateMenuSort',"data="+JSON.stringify(nodes),function(data){
				
			})
		}
	}
	
});