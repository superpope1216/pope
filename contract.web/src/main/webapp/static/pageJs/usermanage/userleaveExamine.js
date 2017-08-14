/**
 * 
 */
$(document).ready(function(){
	
	queryList();
	
	queryListJxz();
	
	queryListYwc();
	
	queryListBtg();
	
	function queryListJxz(){
		doGet(basePath+"/userleavesexamine/listOther","taskStatu=03",function(data){
			if(data.data.data){
				$('#tblLevelInfoTpl2').tmpl(data.data.data).appendTo('#tblJxzLevelInfo');
				$("#jxzTable").datatable({sortable: true});
			}else{
				$("#jxzTable").datatable({sortable: true});
			}
		});
	}
	
	function queryListYwc(){
		doGet(basePath+"/userleavesexamine/listOther","taskStatu=04",function(data){
			if(data.data.data){
				$('#tblLevelInfoTpl2').tmpl(data.data.data).appendTo('#tblYwcLevelInfo');
				$("#ywcTable").datatable({sortable: true});
			}else{
				$("#ywcTable").datatable({sortable: true});
			}
		});
	}
	
	function queryListBtg(){
		doGet(basePath+"/userleavesexamine/listOther","taskStatu=-99",function(data){
			if(data.data.data){
				$('#tblLevelInfoTpl2').tmpl(data.data.data).appendTo('#tblBtgLevelInfo');
				$("#btgTable").datatable({sortable: true});
			}else{
				$("#btgTable").datatable({sortable: true});
			}
		});
	}
	
	function queryList(){
		doGet(basePath+"/userleavesexamine/list","",function(data){
			if(data.data.data){
				$('#tblLevelInfoTpl').tmpl(data.data.data).appendTo('#tblLevelInfo');
				$("#mainTable").datatable({sortable: true});
			}else{
				$("#mainTable").datatable({sortable: true});
			}
			$("#datatable-mainTable").delegate("[data-option='examineLeave']","click",function(){
				var key=$(this).attr("data-key");
				//alert(key);
				doPost(basePath+"/userleavesexamine/examinePass","wid="+key,function(data){
					alert("审核通过成功！");
					window.location.reload();
				})
			});
			$("#datatable-mainTable").delegate("[data-option='examineNotPassLeave']","click",function(){
				var key=$(this).attr("data-key");
				alert(key);
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