/**
 * 
 */
function alert(msg,callback){
	if(callback){
		bootbox.alert(msg,callback);
	}else{
		bootbox.alert(msg);
	}
}


function confirm(msg,callBackFunc,yes,no){
	 bootbox.confirm({
		    message: msg,
		    buttons: {
		        confirm: {
		            label: yes?yes:"确认",
		            className: 'btn-success'
		        },
		        cancel: {
		            label: no?no:'取消',
		            className: 'btn-danger'
		        }
		    },
		    callback: function (result) {
		    	if(result){
			    	if(callBackFunc){
			    		callBackFunc();
			    	}
		    	}
		    }
		});
}

 function doGet(url,params,callback){
	 $.ajax({
	 		  type: "GET",
	 		  url: url,
	 		  data: params,
	 		  dataType: 'json',  
	 		  success:function(data){
	 			 ajaxBack(data,callback);
	 		  }
	 		});	
	 }
 
 function ajaxBack(data,callBack){
	 if (data.code == 10000) {
        	if(callBack){
        		callBack(data);
        	}
     } else{
    	 alert(data.msg);
     }
 }

 function doPost(url,params,callback){
	 var aContentType="";
	 $.ajax({
	 		  type: "POST",
	 		  url: url,
	 		  data: params,
	 		  dataType: 'json',  
	 		  success:function(data){
	 			 ajaxBack(data,callback);
	 		  }
	 		});	
	 }
 
 function pageHelper(pageUI,currentPage,totalNum,callPage){
	 $(pageUI).pagination(
			 totalNum?totalNum:0,
             {
            	 items_per_page : 20,
            	 current_page:currentPage?currentPage:0,
                 num_edge_entries : 2,
                 num_display_entries : 4,
                 callback: callPage
             }); 
 }
 

 /**
  *大于0
  */
 $.validator.addMethod("greaterThanZero",function(value,element,params){
 	if(value<=0){
 		return false;
 	}
 	return true;
 },"请输入大于0的数值");

 $.validator.addMethod("isMobile", function(value, element) { 
 	  var length = value.length; 
 	  if(!(/^1[34578]\d{9}$/.test(value))){   
 	        return false; 
 	    } 
 	  return true;
 	}, "请正确填写您的手机号码"); 
 $.validator.addMethod("password", function(value, element) { 
 	  var length = value.length; 
 	  if(!(/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$/.test(value))){ 
 	        return false; 
 	    } 
 	  return true;
 	}, "请填写正确的密码格式"); 