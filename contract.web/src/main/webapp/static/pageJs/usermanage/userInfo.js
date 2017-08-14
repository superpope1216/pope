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
	
	function queryList(pageId,name){
		$('#tblUserInfo').empty();
		if(name==undefined){
			name="";
		}
		if(pageId==undefined){
			pageId=0;
		}
		doGet(basePath+"/users/list","queryName="+name+"&startPage="+pageId,function(data){
			if(data.data.data){
				$('#tblUserInfoTpl').tmpl(data.data.data).appendTo('#tblUserInfo');
				//$("#mainTable").datatable({sortable: true});
			}else{
				//$("#mainTable").datatable({sortable: true});
			}
			pageHelper("#pageInfo",data.data.page-1,data.data.total,function(pageId){
				queryList(pageId,name);
			});
			$("#mainTable").delegate("[data-option='editUser']","click",function(){
				$("#userForm")[0].reset();
				var key=$(this).attr("data-key");
				doGet(basePath+"/users/select","wid="+key,function(data){
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
						$("#userForm [name='userInfoRole']").val(_userData.userInfoRole);
						
					}
				});
				$("#modelEdithUserInfo").modal("show");
			});
			$("#mainTable").delegate("[data-option='deleteUser']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认删除该用户信息吗？",function(e){
					doPost(basePath+"/users/delete","wid="+key,function(data){
						alert("用户删除成功！");
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
		$("#userForm")[0].reset();
		doGetSelect2("T_CONTRACT_SJZD_ZWLB","#userForm [name='jobcategory']");
		$("#modelEdithUserInfo").modal("show");
		
	})
	
	
	
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