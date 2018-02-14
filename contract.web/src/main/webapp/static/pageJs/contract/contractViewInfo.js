/**
 * 
 */
$(document).ready(function(){
	var _validater = $("#userForm").validate({
		errorPlacement : function(error, element) {
			// Append error within linked label
			$(error).insertAfter($(element));
			// .append(error);
			// $("#mainForm").find( "label[for='" + element.attr( "id" )
			// + "']"
			// ).append( error );
		},
		rules : {
			phone : {
				required : true,
				isMobile : true
			},
			email : {
				required : true,
				email : true
			},
			sl:{
				digits:true
			},
			dj:{
				number:true,
				min:0
			},
			htzk:{
				required:true,
				number:true,
				min:0,
				max:1
			}
			
		}
	});
	setEditButtonShow();
	queryForm();
	queryBatchInfo();
	queryContractFxxm();
	function queryForm(){
		if(wid && wid!=""){
			doGet(basePath+"/contractEditInfo/queryContractInfo","wid="+wid,function(data){
				setForm(data.data);
				setViewForm(data.data);
			});
		}else{
			doGet(basePath+"/contractEditInfo/queryForm","pcid="+firstPcid+"&pcids="+pcids,function(data){
				setForm(data.data);
				setViewForm(data.data);
				
			});
		}
		
	}
	function setEditButtonShow(){
		if(currentRwzt!="1" && currentRwzt!="-99"){
			$("#btnAddFxxm").hide();
			$("#btnEditContract").hide();
			
			$("#mainBatchTable tr").find("td:eq(0)").hide();
		}else{
			$("#btnAddFxxm").show();
			$("#btnEditContract").show();
			
			$("#mainBatchTable tr").find("td:eq(0)").show();
		}
		
	}
	function queryContractFxxm(){
		if(wid){
			doGet(basePath+"/contractEditInfo/listContractFxxmMoney","htid="+wid,function(data){
				if(data.data){
					var tbl="";
					for(var i=0;i<data.data.length;i++){
						var _d=data.data[i];
						tbl+="<tr>";
						tbl+='<td class="text-center">'+toStr(_d.fxxm_display)+'</td>';
						tbl+='<td class="text-center">'+toStr(_d.dj)+'</td>';
						tbl+='<td class="text-center">'+toStr(_d.sl)+'</td>';
						tbl+='<td class="text-center">'+toStr(_d.zkjg)+'</td>';
						tbl+='<td class="text-center">'+toStr(_d.zj)+'</td>';
						tbl+="</tr>";
					}
					$("#tblContractFxxmInfo").html(tbl);
				}
			});
		}
	}
	
	function queryBatchInfo(){
		var url="";
		var param="";
		if(wid && wid!=""){
			url=basePath+"/contractEditInfo/queryBatchInfo";
			param="wid="+wid;
		}else{
			url=basePath+"/contractEditInfo/queryBatchInfo";
			param="pcids="+pcids;
		}
		doGet(url,param,function(data){
			var _d=data.data;
			if(_d){
				var str="";
				for(var i=0;i<_d.length;i++){
					str+="<tr>";
					if(currentRwzt=="1" || currentRwzt=="-99"){
						str+='<td class="text-center"><input type="checkbox" data-option="checkFxxd" name="checkFxxd" value="'+_d[i].wid+','+_d[i].fxxmbh+'"></td>';
					}
					str+='<td class="text-center">'+toStr(_d[i].ypph)+'</td>';
					str+='<td class="text-center">'+toStr(_d[i].ypsl)+'</td>';
					str+='<td class="text-center">'+toStr(_d[i].fxxm_display)+'</td>';
					str+="</tr>";
				}
				$("#tblBatchInfo").html(str);
			}
//			
//			$("#mainBatchTable").delegate("[data-option='radBatch']","click",function(){
//				var _key=$(this).val();
//				doGet(basePath+"/contractEditInfo/queryFxxmByBatchId","pcid="+_key+"&htid="+wid,function(data){
//					var str2="";
//					if(data && data){
//						for(var j=0;j<data.data.length;j++){
//						str2+="<tr>";
//						str2+='<td class="text-center"><input type="checkbox" data-option="checkFxxd"  value="'+data.data[j].lbdm+'"></td>';
//						str2+='<td class="text-center">'+data.data[j].lbmc+'</td>';
//						str2+="</tr>";
//						}
//					}
//					$("#tblFxxmDetailInfo").html(str2);
//				});
//			});
		});
	}
	function queryFxxm(){
		doGet(basePath+"/contractEditInfo/queryFxxm","pcids="+pcids,function(data){
			
		});
	}
	
	$("#btnEditContract").click(function(){
		$("#btnSave").show();
		$("#btnTish").show();
		$("#btnEditContract").hide();
		$("#userViewForm").hide();
		$("#userForm").show();
	});
	function setViewForm(data){
		$("#userViewForm [name='wid']").val(data.wid);
		$("#userViewForm [name='dqbh']").val(data.dqbh);
		$("#userViewForm [name='htmc']").html(toStr(data.htmc));
		$("#userViewForm [name='htlx']").html(toStr(data.htlx_display));
		$("#userViewForm [name='htbh']").html(toStr(data.htbh));
		$("#userViewForm [name='htjf']").html(toStr(data.htjf_display));
		$("#userViewForm [name='xmfzr']").html(toStr(data.xmfzr));
		$("#userViewForm [name='htje']").html(toStr(data.htje));
		$("#userViewForm [name='htje']").html(toStr(data.htje));
		$("#userViewForm [name='htzk']").html(toStr(data.htzk_display));
		
		$("#userViewForm [name='htsj']").html(toStr(data.htsj));
		$("#userViewForm [name='htzxsj']").html(toStr(data.htzxsj));
		$("#userViewForm [name='dfzh']").html(toStr(data.dfzh));
		$("#userViewForm [name='bz']").html(toStr(data.bz));
	
}
	function setForm(data){
		$("#userForm [name='wid']").val(data.wid);
		$("#userForm [name='dqbh']").val(data.dqbh);
		$("#userForm [name='htmc']").val(toStr(data.htmc));
		
		doGetSelect2("T_CONTRACT_SJZD_HTLX","#userForm [name='htlx']",data.htlx);
		$("#userForm [name='htbh']").val(toStr(data.htbh));
		$("#userForm [name='htjf']").val(toStr(data.htjf));
		$("#userForm [name='p_htjf']").html(toStr(data.htjf_display));
		$("#userForm [name='xmfzr']").val(toStr(data.xmfzr));
		$("#userForm [name='p_xmfzr']").html(toStr(data.xmfzr));
		$("#userForm [name='htje']").val(toStr(data.htje));
		$("#userForm [name='p_htje']").html(toStr(data.htje));
		//$("#userForm [name='htzk']").val(toStr(data.htzk));
		doGetSelect2("T_CONTRACT_SJZD_HTZK","#userForm [name='htzk']",data.htzk);
		$("#userForm [name='htsj']").val(toStr(data.htsj));
		$("#userForm [name='p_htsj']").html(toStr(data.htsj));
		$("#userForm [name='htzxsj']").val(toStr(data.htzxsj));
		$("#userForm [name='dfzh']").val(toStr(data.dfzh));
		$("#userForm [name='p_dfzh']").html(toStr(data.dfzh));
		$("#userForm [name='bz']").val(toStr(data.bz));
	}
	
	
	$("#btnSave").click(function(){
		if (_validater.form()) {
			var url = basePath + "/contractEditInfo/saveContractInfo?pcids="+pcids;
			var datas = $("#userForm").serializeArray();
			doPost(url, datas, function(data) {
				if (data && data.data) {
					alert(data.msg);
					window.location.href=basePath+"/contractEditInfo/viewIndex?wid="+wid;
				}
			});
		}
	});
	$("#btnTish").click(function(){
		if (_validater.form()) {
			confirm("您确认该合同提交审核吗？",function(){
			var url = basePath + "/contractEditInfo/submitContractInfo?pcids="+pcids;
			var datas = $("#userForm").serializeArray();
			doPost(url, datas, function(data) {
				if (data && data.data) {
					alert(data.msg);
					window.location.href=basePath+"/contractEditInfo/viewIndex?wid="+wid;
				}
			});
			});
		}
	});
	$("#btnAddFxxm").click(function(){
		if($("#userForm [name='wid']").val()==""){
			alert("请先保存合同基本信息后再进行操作！");
			return false;
		}
		
		var chkFxxm=$("#tblBatchInfo [name='checkFxxd']:checked");//选中的批次
		//var chkFxxm=$("#tblFxxmDetailInfo [data-option='checkFxxd']:checked");//选中的分析项目
		
		if(chkFxxm.length<=0){
			alert("请至少选择一个分析项目！");
			return ;
		}
		//var _selectPcId=chkPc[0].value;
		var _selectFxxmBh="";
		for(var i=0;i<chkFxxm.length;i++){
			_selectFxxmBh+=";"+chkFxxm[i].value;
		}
		if(_selectFxxmBh){
			_selectFxxmBh=_selectFxxmBh.substr(1);
		}
		
		var url = basePath + "/contractEditInfo/addFxxm";
		var datas ="htid="+wid+"&fxxms="+_selectFxxmBh;
		doPost(url, datas, function(data) {
				window.location.reload();
		});
	});
	
	
	$("#mainTable [name='selAll']").click(function(){
		if($(this)[0].checked){
			$("#mainTable [name='chkSingle']").prop("checked",true);
		}else{
			$("#mainTable [name='chkSingle']").prop("checked",false);
		}
	});
});