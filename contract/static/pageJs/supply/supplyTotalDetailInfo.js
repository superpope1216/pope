/**
 * 
 */
$(document).ready(function(){
	
	queryListLyd(0);
	queryListSgd(0);
	queryListShd(0);
	function queryListLyd(pageId){
		if(pageId==undefined){
			pageId=0;
		}
		$("#tblJxzTaskInfo").empty();
		doGet(basePath+"/supplyTotalDetailInfo/listLyd","startPage="+pageId+"&hcid="+hcid,function(data){
			if(data.data.data){
				$('#tblLydInfoTpl').tmpl(data.data.data).appendTo('#tblLydInfo');
				// $("#mainTable").datatable({checkable: true});
			}
			pageHelper("#lydPageInfo",data.data.page-1,data.data.total,function(pageId){
				queryListLyd(pageId);
			});
		});
	}
	
	function queryListSgd(pageId){
		if(pageId==undefined){
			pageId=0;
		}
		$("#tblSgdInfo").empty();
		doGet(basePath+"/supplyTotalDetailInfo/listSgd","startPage="+pageId+"&hcid="+hcid,function(data){
			if(data.data.data){
				$('#tblInfoTpl').tmpl(data.data.data).appendTo('#tblSgdInfo');
				// $("#mainTable").datatable({checkable: true});
			}
			pageHelper("#sgdPageInfo",data.data.page-1,data.data.total,function(pageId){
				queryListSgd(pageId);
			});
		});
	}
	
	function queryListShd(pageId){
		if(pageId==undefined){
			pageId=0;
		}
		$("#tblShdInfo").empty();
		doGet(basePath+"/supplyTotalDetailInfo/listShd","startPage="+pageId+"&hcid="+hcid,function(data){
			if(data.data.data){
				$('#tblInfoTpl').tmpl(data.data.data).appendTo('#tblShdInfo');
				// $("#mainTable").datatable({checkable: true});
			}
			pageHelper("#shdPageInfo",data.data.page-1,data.data.total,function(pageId){
				queryListShd(pageId);
			});
		});
	}
})