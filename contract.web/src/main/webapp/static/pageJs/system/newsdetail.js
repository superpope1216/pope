/**
 * 
 */
$(document).ready(function(){
	
	doGet(basePath+"/newsDetail/select","wid="+wid,function(data){
		if(data.data){
			$("#newTitle").html(data.data.name);
			$("#newContent").html(data.data.content);
		}
	});
});