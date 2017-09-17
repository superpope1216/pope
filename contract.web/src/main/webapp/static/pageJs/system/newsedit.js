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
		 
		 doGet(basePath+"/newsEdit/select","wid="+wid,function(data){
			if(data.data){
				var _data=data.data;
				$("#zdbsForm [name='wid']").val(toStr(_data.wid));
				$("#zdbsForm [name='name']").val(toStr(_data.name));
				UE.getEditor('txtcontent').setContent(_data.content);
				$("#zdbsForm [name='beginTime']").val(toStr(_data.beginTime));
				$("#zdbsForm [name='endTime']").val(toStr(_data.endTime));
			} 
		 });
	 }
	 $("#btnSave").click(function(){
		 if(_validater.form()){
			 if (!UE.getEditor('txtcontent').hasContents()){
				    alert('请先填写新闻内容!');
			 }
			 $("#zdbsForm [name='content']").val(UE.getEditor('txtcontent').getContent());
			 doPost(basePath+"/newsEdit/save",$("#zdbsForm").serializeArray(),function(data){
					window.location.href=basePath+"/news/index";
				});
		 }
	 });
	 $("#btnBack").click(function(){
		 window.location.href=basePath+"/news/index";	 
	 })
	 
 });