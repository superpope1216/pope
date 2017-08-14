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
			}
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
	queryList();
	queryRole();
	
	function queryList(){
		doGet(basePath+"/batch/list","",function(data){
			if(data.data.data){
				$('#tblUserInfoTpl').tmpl(data.data.data).appendTo('#tblUserInfo');
				//$("#mainTable").datatable({checkable: true});
			}else{
				//$("#mainTable").datatable({checkable: true});
			}
			$("#mainTable").delegate("[data-option='copy']","click",function(){
				var key=$(this).attr("data-key");
				if(confirm("您确认复制该样品批次吗",function(data){
					doPost(basePath+"/batch/copyBatch", "wid="+key, function(data) {
						window.location=basePath+"/batch/detailIndex?wid="+data.data;
					});
				}));
			});
			$("#mainTable").delegate("[data-option='detail']","click",function(){
				var key=$(this).attr("data-key");
				window.location=basePath+"/batch/detailIndex?wid="+key;
			});
			$("#mainTable").delegate("[data-option='lu']","click",function(){
				var key=$(this).attr("data-key");
				window.location=basePath+"/batch/detailIndex?wid="+key;
			});
			$("#mainTable").delegate("[data-option='gui']","click",function(){
				var key=$(this).attr("data-key");
				
			});
			$("#mainTable").delegate("[data-option='delete']","click",function(){
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
	$("#btnNew").click(function(){
		window.location=basePath+"/batch/detailIndex?wid=";
		
	});
	
	$("#mainTable [name='selAll']").click(function(){
		if($(this)[0].checked){
			$("#mainTable [name='chkSingle']").prop("checked",true);
		}else{
			$("#mainTable [name='chkSingle']").prop("checked",false);
		}
	});
	
	//发起任务
	$("#btnFqrw").click(function(){
		var selectRows=$("#mainTable [name='chkSingle']:checked");
		if(selectRows.size()<=0){
			alert("请选择一条样品批次！");
			return false;
		}
		if(selectRows.size()>1){
			alert("每次只能选择一条任务，请重新选择！");
			return false;
		}
		
		window.location=basePath+"/task/taskadd?wid="+selectRows[0].value;
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
				window.location.reload();
			});
		}
	});
})