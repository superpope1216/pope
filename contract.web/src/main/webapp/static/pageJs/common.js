/**
 * 
 */


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