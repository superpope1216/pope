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
		getUser("");
	 var editor=UE.getEditor("txtcontent",{toolbars: [[
	                                            'fullscreen', 'source', '|', 'undo', 'redo', '|',
	                                            'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor','|',
	                                             
	                                            'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|',
	                                            
	                                            'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
	                                           
	                                            'simpleupload', 'insertimage','|',
	                                          
	                                           
	                                            'print', 'preview'
	                                        ]]});
	 
	 editor.addListener("ready", function() {
		 select();
	 });
	 $("#btnSelectBm").click(function(){
			if(!zTree){
				setTree();
			}
			showMenu();
			
		});
	 
	 
	 function getUser(userId){
		 doGet(basePath+"/messagesEdit/selectUsers","",function(data){
			 $("#messageReceiveMan").empty();
			 var str="<option value=''>--请选择--</option>";
			 if(data.data && data.data.length>0){
				 for(var i=0;i<data.data.length;i++){
					 var checked="";
					 if(data.data[i].wid==userId){
						 checked=" checked ";
					 }
					 str+="<option "+checked+" value='"+data.data[i].wid+"'>"+data.data[i].name1+"</option>"
				 }
			 }
			 $("#messageReceiveMan").append(str);
		 });
	 }
	 
	 function setSelect(){
		 if(!zTree){
				setTree();
			}
		 
	 }
	 function select(){
		 $("#zdbsForm")[0].reset();
		 doGet(basePath+"/messagesEdit/select","wid="+wid,function(data){
			if(data.data){
				var _data=data.data;
				$("#zdbsForm [name='wid']").val(toStr(_data.wid));
				$("#zdbsForm [name='name']").val(toStr(_data.name));
				doGetSelect2("T_CONTRACT_SJZD_MESSAGE_TYPE","#zdbsForm [name='messageType']",_data.messageType,function(){
					if(toStr(_data.messageType)=="" || toStr(_data.messageType)=="1"){
						$("#divDepart").hide();
						$("#divTeam").hide();
						$("#divPerson").hide();
					}else if(toStr(_data.messageType)=="2"){
						$("#txtDepartment").val(_data.messageReceiveDepart_display);
						$("#messageReceiveDepart").val(_data.messageReceiveDepart);
						$("#divDepart").show();
						$("#divTeam").hide();
						$("#divPerson").hide();
					}else if(toStr(_data.messageType)=="3"){
						$("#txtDepartment").val(_data.messageReceiveDepart_display);
						$("#messageReceiveDepart").val(_data.messageReceiveDepart);
						doGetSelect(basePath+"/departments/selectTeamByDepartment","bm="+_data.messageReceiveDepart,"#messageReceiveTeam",_data.messageReceiveTeam);
						$("#divDepart").show();
						$("#divTeam").show();
						$("#divPerson").hide();
					}else if(toStr(_data.messageType)=="4"){
						$("#messageReceiveMan").val(_data.messageReceiveMan);
						$("#divDepart").hide();
						$("#divTeam").hide();
						$("#divPerson").show()
						//getUser(_data.messageReceiveMan);
					}
					
					
				});
				if(_data.content){
					try{
				UE.getEditor('txtcontent').setContent(_data.content);
					}catch(e){}
				}
			} 
		 });
	 }
	 
	 $("#zdbsForm [name='messageType']").click(function(){
		 var _value=$(this).val();
		 if(toStr(_value)=="" || toStr(_value)=="1"){
				$("#divDepart").hide();
				$("#divTeam").hide();
				$("#divPerson").hide();
			}else if(toStr(_value)=="2"){
				$("#divDepart").show();
				$("#divTeam").hide();
				$("#divPerson").hide();
			}else if(toStr(_value)=="3"){
				$("#divDepart").show();
				$("#divTeam").show();
				$("#divPerson").hide();
			}else if(toStr(_value)=="4"){
				$("#divDepart").hide();
				$("#divTeam").hide();
				$("#divPerson").show();
			}
	 });
	 $("#btnSave").click(function(){
		 if(_validater.form()){
			 if (!UE.getEditor('txtcontent').hasContents()){
				    alert('请先填写消息内容!');
			 }
			 $("#zdbsForm [name='content']").val(UE.getEditor('txtcontent').getContent());
			 doPost(basePath+"/messagesEdit/save",$("#zdbsForm").serializeArray(),function(data){
					window.location.href=basePath+"/messages/index";
				});
		 }
	 });
	 $("#btnBack").click(function(){
		 window.location.href=basePath+"/messages/index";	 
	 })
	 
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
			$("#messageReceiveDepart").val(_id);
			$("#messageReceiveTeam").empty();
			doGetSelect(basePath+"/departments/selectTeamByDepartment","bm="+_id,"#messageReceiveTeam");
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
	 
 });