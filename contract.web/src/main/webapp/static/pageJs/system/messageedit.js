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
	 function select(){
		 
		 doGet(basePath+"/messagesEdit/select","wid="+wid,function(data){
			if(data.data){
				var _data=data.data;
				$("#zdbsForm [name='wid']").val(toStr(_data.wid));
				$("#zdbsForm [name='name']").val(toStr(_data.name));
				UE.getEditor('txtcontent').setContent(_data.content);
			} 
		 });
	 }
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
	 
 });