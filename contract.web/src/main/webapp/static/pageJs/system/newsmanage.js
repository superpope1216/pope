/**
 * 
 */
 
 $(document).ready(function(){
	 $("#btnNew").click(function(){
			window.location.href=basePath+"/newsEdit/index?wid=";
	});
	 queryList(0);
	 function queryList(pageId){
			if(pageId==undefined || pageId<0){
				pageId=0;
			}
			doGet(basePath+"/news/list","startPage="+pageId,function(data){
				if(data.data.data){
					var _data=data.data.data;
					var _tr="";;
					for(var i=0;i<_data.length;i++){
						_tr+='<tr>';
						
						_tr+='<td class="text-left">'+toStr(_data[i].name)+'</td>';
						_tr+='<td class="text-center">'+toStr(_data[i].beginTime)+'</td>';
						_tr+='<td class="text-center">'+toStr(_data[i].endTime)+'</td>';
						var onLineName="";
						if(toStr(_data[i].online)=="1"){
							onLineName="上线";
						}else if(toStr(_data[i].online)=="0"){
							onLineName="下线";
						}
						_tr+='<td class="text-left">'+onLineName+'</td>';
						_tr+='<td class="text-left">'+toStr(_data[i].createTime)+'</td>';
						_tr+='<td class="text-center">';
						_tr+='<div class="btn-group">';
						if(toStr(_data[i].online)=="1"){
							_tr+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-data="'+toStr(_data[i].online)+'" data-option="btnDetail" data-key="'+_data[i].wid+'">下线</button>';	
						}
						else{
							_tr+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-data="'+toStr(_data[i].online)+'" data-option="btnDetail" data-key="'+_data[i].wid+'">上线</button>';
						}
					    	
						_tr+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnModify" data-key="'+_data[i].wid+'">录</button>';
						_tr+='<button type="button" style="margin-left:4px;" class="btn btn-xs btn-danger" data-option="btnDelete" data-key="'+_data[i].wid+'"><i class="icon icon-times"></i></button>';
							
						}
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
						window.location.href=basePath+"/newsEdit/index?wid="+key;
					});
					$("#mainTable").delegate("[data-option='btnDetail']","click",function(){
						var key=$(this).attr("data-key");
						var _data=$(this).attr("data-data");
						if(_data=="1"){
							confirm("您确认下线该新闻吗？",function(e){
								doPost(basePath+"/news/upordown","wid="+key+"&flag=0",function(data){
									window.location.reload();
								});
							});
						}else{
							confirm("您确认上线该新闻吗？",function(e){
								doPost(basePath+"/news/upordown","wid="+key+"&flag=1",function(data){
									window.location.reload();
								});
							});
						}
					});
					$("#mainTable").delegate("[data-option='btnDelete']","click",function(){
						var key=$(this).attr("data-key");
						confirm("您确认删除该新闻吗？",function(e){
							doPost(basePath+"/news/delete","wid="+key,function(data){
								window.location.reload();
							});
						});
						return false;
					});
			});
	 }
					
 });