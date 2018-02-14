/**
 * 
 */

$(document).ready(function(){
	 $.validator.addMethod("password", function(value, element) { 
	 	  var length = value.length; 
	 	 if(length<=0){
	 		 return false;
	 	 }
	 	  return true;
	 	}, "密码不能为空");
	var _validater=$("#loginForm").validate({
		errorPlacement: function(error, element) {
			// Append error within linked label
			$(error).insertAfter($(element));
			//.append(error);
			//$("#mainForm").find( "label[for='" + element.attr( "id" ) + "']" ).append( error );
		},
		rules:{
			password:{
				required:true
			}
			
		}
	});
	$("#btnLogin").click(function(){
		if(_validater.form()){
			doPost(basePath+"/login/login",$("#loginForm").serializeArray(),function(data){
				location.href = basePath + "/center/index";
			});
		}
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