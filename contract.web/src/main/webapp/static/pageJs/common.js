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

function setButtonsDisplay(buttonsPermission){
	if(buttonsPermission){
		var _b=buttonsPermission.split(",");
		for(var i=0;i<_b.length;i++){
			if(_b[i]){
				$("#"+_b[i]).show();
			}
			
		}
	}
}

function toStr(value){
	if(value){
		return value;
	}
	return "";
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
 
 function doSyncGet(url,params,callback){
	 $.ajax({
	 		  type: "GET",
	 		  url: url,
	 		  async:false,
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
            	 items_per_page : 10,
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
 	}, "请填写正确的密码格式(8到16位字符之间，必须包含大写或者小写字符)"); 
 
 
 
 function doGetSelect(url,params,obj,data2,callBack){
	 $(obj).empty();
	 doGet(url,params,function(data){
		 var str="<option value=''>--请选择--</option>";
		 if(data.data && data.data.length>0){
			 for(var i=0;i<data.data.length;i++){
				 var checked="";
				if(data2 && data2==data.data[i].lbdm){
					checked=" selected='selected' ";
				}
				 str+="<option "+checked+" value='"+data.data[i].lbdm+"'>"+data.data[i].lbmc+"</option>"
			 }
		 }
		 $(obj).append(str);
		 if(callBack){
				 callBack();
		}
	 });
 }
 function doGetSelect2(tblName,obj,data2,callBack){
	 doGet(basePath+"/zdbdetail/list","tableName="+tblName,function(data){
		 $(obj).empty();
		 var str="<option value=''>--请选择--</option>";
		 if(data.data && data.data.length>0){
			 for(var i=0;i<data.data.length;i++){
				 var checked="";
				if(data2 && data2==data.data[i].lbdm){
					checked=" selected='selected' ";
				}
				 str+="<option "+checked+" value='"+data.data[i].lbdm+"'>"+data.data[i].lbmc+"</option>"
			 }
		 }
		 $(obj).append(str);
		 if(callBack){
				 callBack();
		}
	 });
 }

 function doGetMulSelect(url,params,obj,data2,callBack){
	 $.ajax({
	 		  type: "GET",
	 		  url: url,
	 		  data: params,
	 		  dataType: 'json',  
	 		  success:function(data){
	 			 $(obj).empty();
	 			 var str="";
	 			 if(data && data.success){
	 				 
	 				 if(data.data && data.data.length>0){
	 					 for(var i=0;i<data.data.length;i++){
	 						 var checked="";
	 						if(data2 && data2==data.data[i].LBDM){
	 							checked=" selected='selected' ";
	 						}
	 						 str+="<option "+checked+" value='"+data.data[i].LBDM+"'>"+data.data[i].LBMC+"</option>"
	 					 }
	 				 }
	 				
	 			 }
	 			 $(obj).append(str);
	 			 if(callBack){
	 				 callBack();
	 			 }
	 		  }
	 		});	
	 }