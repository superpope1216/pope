/**
 * 
 */

$(document).ready(function(){
	
	$("#btnLogin").click(function(){
		doPost(basePath+"/login/login",$("#loginForm").serializeArray(),function(data){
			location.href = basePath + "/login/welcome";
		})
	});
});