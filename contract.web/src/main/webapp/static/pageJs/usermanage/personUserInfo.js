/**
 * 
 */
$(document).ready(function(){
	var _validater=$("#userViewForm").validate({
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
	queryUserInfo();
	function queryUserInfo(){
		doGet(basePath+"/personUserInfo/select","",function(data){
			if(data && data.data ){
				var _userData=data.data;
				$("#userViewForm [name='gh']").html(_userData.gh);
				$("#userViewForm [name='name1']").html(_userData.name1);
				$("#userViewForm [name='phone']").html(_userData.phone);
				$("#userViewForm [name='email']").html(_userData.email);
				$("#userViewForm [name='department']").html(_userData.department_display);
				$("#userViewForm [name='team']").html(_userData.team_display);
				$("#userViewForm [name='jobcategory']").html(_userData.jobcategory_display);
				$("#userViewForm [name='birthday']").html(_userData.birthday);
				$("#userViewForm [name='degree']").html(_userData.degree);
				$("#userViewForm [name='job']").html(_userData.job);
				$("#userViewForm [name='contractvalidity']").html(_userData.contractvalidity);
				$("#userViewForm [name='contracttime']").html(_userData.contracttime);
				$("#userViewForm [name='userInfoRole']").html(_userData.userInfoRole);
				
			}
		});
	}
	
	$("#btnModify").click(function(){ 
		doGet(basePath+"/personUserInfo/select","",function(data){
			if(data && data.data ){
				var _userData=data.data;
				$("#userForm [name='wid']").val(_userData.wid);
				$("#userForm [name='gh']").val(_userData.gh);
				$("#userForm [name='name1']").val(_userData.name1);
				$("#userForm [name='phone']").val(_userData.phone);
				$("#userForm [name='email']").val(_userData.email);
				$("#userForm [name='department']").val(_userData.department);
				$("#userForm [name='txtDepartment']").val(_userData.txtDepartment);
				$("#txtDepartment").val(_userData.department_display);
				$("#department").val(_userData.department);
				doGetSelect(basePath+"/departments/selectTeamByDepartment","bm="+_userData.department,"#team",_userData.team);
				doGetSelect2("T_CONTRACT_SJZD_ZWLB","#userForm [name='jobcategory']",_userData.jobcategory);
				$("#userForm [name='birthday']").val(_userData.birthday);
				$("#userForm [name='degree']").val(_userData.degree);
				$("#userForm [name='job']").val(_userData.job);
				$("#userForm [name='contractvalidity']").val(_userData.contractvalidity);
				$("#userForm [name='contracttime']").val(_userData.contracttime);
				
			}
		});
		$("#modelEdithUserInfo").modal("show");
	});
	
	$("#btnSelectBm").click(function(){
		if(!zTree){
			setTree();
		}
		showMenu();
		
	});
	$("#btnQuery").click(function(){
		if($.trim($("#queryCondition").val())!=""){
			queryList($.trim($("#queryCondition").val()));
		}
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
			var url=basePath+"/personUserInfo/save";
			var datas=$("#modelEdithUserInfo form").serializeArray();
			doPost(url,datas,function(data){
				window.location.reload();
			});
		}
	});
})