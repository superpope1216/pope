/**
 * 
 */
$(document).ready(function(){
	
	doGet(basePath+"/messagesDetail/select","wid="+wid,function(data){
		if(data.data){
			$("#newTitle").html(data.data.name);
			$("#newContent").html(data.data.content);
		}
	});
});