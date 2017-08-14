/**
 * 
 */
$(document).ready(function(){
	queryList();
	function queryList(){
		doGet(basePath+"/task/listTaskInfo","",function(data){
			if(data.data.data){
				$('#tblUserInfoTpl').tmpl(data.data.data).appendTo('#tblUserInfo');
				//$("#mainTable").datatable({checkable: true});
			}else{
				//$("#mainTable").datatable({checkable: true});
			}
			$("#mainTable").delegate("[data-option='copy']","click",function(){
				var key=$(this).attr("data-key");
				if(confirm("您确认复制该样品批次吗",function(data){
					doPost(basePath+"/batch/copyBatch", "wid="+key, function(data) {
						window.location=basePath+"/batch/detailIndex?wid="+data.data;
					});
				}));
			});
			$("#mainTable").delegate("[data-option='detail']","click",function(){
				var key=$(this).attr("data-key");
				window.location=basePath+"/task/taskDetailsIndex?wid="+key;
			});
			$("#mainTable").delegate("[data-option='lu']","click",function(){
				var key=$(this).attr("data-key");
				window.location=basePath+"/batch/detailIndex?wid="+key;
			});
			$("#mainTable").delegate("[data-option='gui']","click",function(){
				var key=$(this).attr("data-key");
				
			});
			$("#mainTable").delegate("[data-option='delete']","click",function(){
				var key=$(this).attr("data-key");
				confirm("您确认删除该样品批次信息吗？",function(e){
					doPost(basePath+"/batch/deleteBatch","wid="+key,function(data){
						alert("样品批次删除成功！");
						window.location.reload();
					});
				});
			});
		})
	}
});