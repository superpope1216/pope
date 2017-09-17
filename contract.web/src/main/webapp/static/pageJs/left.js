$(document).ready(function(){
	if($select){
		$("#treeMenu [datawid='"+$select+"']").parent().addClass("active");
	}
	if($open){
		$("#treeMenu [datawid='"+$open+"']").parent().addClass("open");
	}
	
	doGet(basePath+"/center/messageCount","",function(data){
		$("#aMessage").html(data.data);
	});
	$("#treeMenu a").click(function(){
		$("#treeMenu li").removeClass("active");
		$(this).parent().addClass("active");
		$("#treeMenu .open").removeClass("open");
		if($(this).attr("dataflag")=="2"){
			$(this).parent().parent().parent().addClass("open");
		}
		var _open=$("#treeMenu .open").find("a").attr("datawid");
		if(!_open){
			_open="";
		}
		var _select_wid=$("#treeMenu .active").find("a").attr("datawid");
		var _select_url=$("#treeMenu .active").find("a").attr("dataurl");
		if(!_select_url){
			_select_url="";
		}
		if(_select_url){
			_select_url=_select_url+"?open="+_open+"&select="+_select_wid;
			window.location.href=basePath+_select_url;
		}
	});
});
