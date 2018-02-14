/**
 * 
 */
$(document).ready(function(){
	
	queryList();
	
	queryListJxz();
	
	queryListYwc();
	
	queryListBtg();
	
	function queryListJxz(startPage){
		$("#tblJxzLevelInfo").html("");
		if(startPage==undefined){
			startPage=0;
		}
		doGet(basePath+"/userleavesexamine/listOther","taskStatu=101&startPage="+startPage,function(data){
			if(data.data.data){
				$('#tblLevelInfoTpl2').tmpl(data.data.data).appendTo('#tblJxzLevelInfo');
				//$("#jxzTable").datatable({sortable: true});
			}else{
				//$("#jxzTable").datatable({sortable: true});
			}
			pageHelper("#queryListJxz",data.data.page-1,data.data.total,function(pageId){
				queryListJxz(pageId);
			});
		});
		
		
	}
	
	function queryListYwc(startPage){
		$("#tblYwcLevelInfo").html("");
		if(startPage==undefined){
			startPage=0;
		}
		doGet(basePath+"/userleavesexamine/listOther","taskStatu=102&startPage="+startPage,function(data){
			if(data.data.data){
				$('#tblLevelInfoTpl2').tmpl(data.data.data).appendTo('#tblYwcLevelInfo');
				//$("#ywcTable").datatable({sortable: true});
			}else{
				//$("#ywcTable").datatable({sortable: true});
			}
			pageHelper("#ywcPageInfo",data.data.page-1,data.data.total,function(pageId){
				queryListYwc(pageId);
			});
		});
	
	}
	
	function queryListBtg(startPage){
		$("#tblBtgLevelInfo").html("");
		if(startPage==undefined){
			startPage=0;
		}
		doGet(basePath+"/userleavesexamine/listOther","taskStatu=-99&startPage="+startPage,function(data){
			if(data.data.data){
				$('#tblLevelInfoTpl2').tmpl(data.data.data).appendTo('#tblBtgLevelInfo');
				//$("#btgTable").datatable({sortable: true});
			}else{
				//$("#btgTable").datatable({sortable: true});
			}
			pageHelper("#btgPageInfo",data.data.page-1,data.data.total,function(pageId){
				queryListBtg(pageId);
			});
		});
		
	}
	
	function queryList(startPage){
		$("#tblLevelInfo").html("");
		if(startPage==undefined){
			startPage=0;
		}
		doGet(basePath+"/userleavesexamine/list","startPage="+startPage,function(data){
			if(data.data.data){
				$('#tblLevelInfoTpl').tmpl(data.data.data).appendTo('#tblLevelInfo');
				//$("#mainTable").datatable({sortable: true});
			}else{
				//$("#mainTable").datatable({sortable: true});
			}
			$("#mainTable").delegate("[data-option='examineLeave']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认审核通过吗？",function(){
					doPost(basePath+"/userleavesexamine/examinePass","wid="+key,function(data){
						alert("审核通过成功！");
						window.location.reload();
					});
				});
			});
			$("#mainTable").delegate("[data-option='examineNotPassLeave']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认审核不通过吗？",function(){
					doPost(basePath+"/userleavesexamine/examineNotPass","wid="+key,function(data){
						window.location.reload();
					})
				});
				
			});
			pageHelper("#pageInfo",data.data.page-1,data.data.total,function(pageId){
				queryList(pageId);
			});
			
			
		})
	}
	
	$("#btnSaveLeaveInfo").click(function(){
		if(_validater.form()){
			var url=basePath+"/userleaves";
			if($("#levelForm [name='wid']").val()==""){
				url+="/insert";
			}else{
				url+="/update";
			}
			doPost(url,$("#levelForm").serializeArray(),function(data){
				window.location.reload();
			});
		}
	});
})