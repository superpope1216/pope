/**
 * 
 */
 
 $(document).ready(function(){
	 $("#btnNew").click(function(){
			window.location.href=basePath+"/messagesEdit/index?wid=";
	});
	 queryList(0);
	 function queryList(pageId){
			if(pageId==undefined || pageId<0){
				pageId=0;
			}
			doGet(basePath+"/messages/list","startPage="+pageId,function(data){
				if(data.data.data){
					var _data=data.data.data;
					var _tr="";;
					for(var i=0;i<_data.length;i++){
						_tr+='<tr>';
						
						_tr+='<td class="text-left">'+toStr(_data[i].name)+'</td>';
						_tr+='<td class="text-left">'+toStr(_data[i].createTime)+'</td>';
						_tr+='<td class="text-center">';
						_tr+='<div class="btn-group">';
						_tr+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnModify" data-key="'+_data[i].wid+'">录</button>';
						_tr+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-danger" data-option="btnDelete" data-key="'+_data[i].wid+'"><i class="icon icon-times"></i></button>';
						_tr+='</div>';
						_tr+='</td>';
						_tr+='</tr>';
					}
					$('#tblZdbsInfo').html(_tr);
					pageHelper("#pageInfo",data.data.page-1,data.data.total,function(pageId){
						queryList(pageId);
					});
					$("#mainTable").delegate("[data-option='btnModify']","click",function(){
						var key=$(this).attr("data-key");
						window.location.href=basePath+"/messagesEdit/index?wid="+key;
					});
					
					$("#mainTable").delegate("[data-option='btnDelete']","click",function(){
						var key=$(this).attr("data-key");
						confirm("您确认删除该新闻吗？",function(e){
							doPost(basePath+"/messages/delete","wid="+key,function(data){
								window.location.reload();
							});
						});
						return false;
					});
				}
			});
	 }
					
 });