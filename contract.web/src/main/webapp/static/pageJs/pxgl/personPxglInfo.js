/**
 * 
 */
$(document).ready(function(){
	
	queryList();
	function queryList(pageId){
		$('#tblUserInfo').empty();
		if(pageId==undefined){
			pageId=0;
		}
		var params="startPage="+pageId;
		doGet(basePath+"/personPxgl/list",params,function(data){
			if(data.data.data){
				var _data=data.data.data;
				var tbl="";
				for(var i=0;i<_data.length;i++){
					tbl+='<tr>';
					tbl+='<td class="text-center">'+toStr(_data[i].pxlx_display)+'</td>';
					tbl+='<td class="text-center">'+toStr(_data[i].pxmc)+'</td>';
					tbl+='<td class="text-left">'+toStr(_data[i].userName)+'</td>';
					tbl+='<td class="text-left">'+toStr(_data[i].begtime)+'</td>';
					tbl+='<td class="text-left">'+toStr(_data[i].endtime)+'</td>';
					tbl+='<td class="text-left">'+toStr(_data[i].pxfy)+'</td>';
					tbl+='<td class="text-left">'+toStr(_data[i].rwzt_display)+'</td>';
					tbl+='</tr>';
				}
				$("#tblUserInfo").html(tbl);
			}
			pageHelper("#pageInfo",data.data.page-1,data.data.total,function(pageId){
				queryList(pageId);
			});
		})
	}
	
	
})