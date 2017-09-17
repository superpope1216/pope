/**
 * 
 */

$(document).ready(function(){
	
	$("#btnLogin").click(function(){
		doPost(basePath+"/login/login",$("#loginForm").serializeArray(),function(data){
			location.href = basePath + "/center/index";
		})
	});
	$("#btnClear").click(function(){
		$("#loginForm")[0].reset();
	});
	$("#btnSet").click(function(){
		doGet("http://localhost:8080/emap/sys/appstoreservice/sjzds/yyfx.do","",function(data){
			//location.href = basePath + "/login/welcome";
		})
	});
	
	$("#btnGet").click(function(){
		doGet("http://localhost:8080/emap/sys/appstoreservice/sjzds/test.do","",function(data){
			//location.href = basePath + "/login/welcome";
		})
	});
});