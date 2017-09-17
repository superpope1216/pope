/**
 * 
 */

$(document).ready(function(){
	var _height=$(document).height()-100;
	$("#divNews").height(_height);
	$("#divXx").height(_height);
	queryNewsList(0);
	queryMessagesList(0);
	function queryNewsList(pageId){
			if(pageId==undefined || pageId<0){
				pageId=0;
			}
			doGet(basePath+"/center/newsList","startPage="+pageId,function(data){
				if(data.data.data){
					var _data=data.data.data;
					var _tr="";;
					for(var i=0;i<_data.length;i++){
						_tr+='<div class="item">';
						_tr+='<div class="item-heading">';
						_tr+='	<div class="pull-right">';
						_tr+='<span class="text-muted">'+toStr(_data[i].createTime)+'</span> &nbsp;';
						_tr+='	</div>';
						_tr+='	<h4>';
						_tr+='		<a href="'+basePath+'/newsDetail/index?wid='+_data[i].wid+'">'+toStr(_data[i].name)+'</a>';
						_tr+='	</h4>';
						_tr+='</div>';
						_tr+='</div>';
					}
					$('#divNews').html(_tr);
					pageHelper("#pageInfoNews",data.data.page-1,data.data.total,function(pageId){
						queryNewsList(pageId);
					});
				}
				
	});
	}
	
	function queryMessagesList(pageId){
		if(pageId==undefined || pageId<0){
			pageId=0;
		}
		doGet(basePath+"/center/messagesList","startPage="+pageId,function(data){
			if(data.data.data){
				var _data=data.data.data;
				var _tr="";;
				for(var i=0;i<_data.length;i++){
					_tr+='<div class="item">';
					_tr+='<div class="item-heading">';
					_tr+='	<div class="pull-right">';
					_tr+='<span class="text-muted">'+toStr(_data[i].createTime)+'</span> &nbsp;';
					_tr+='	</div>';
					_tr+='	<h4>';
					_tr+='		<a href="'+basePath+'/messagesDetail/index?wid='+_data[i].wid+'">'+toStr(_data[i].name)+'</a>';
					_tr+='	</h4>';
					_tr+='</div>';
					_tr+='</div>';
				}
				$('#divMessages').html(_tr);
				pageHelper("#pageInfoMessages",data.data.page-1,data.data.total,function(pageId){
					queryNewsList(pageId);
				});
			}
			
});
}
});