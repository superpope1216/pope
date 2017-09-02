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
			}
		}
	});
	queryForm();
	queryBatchInfo();
	queryContractFxxm();
	function queryForm(){
		if(wid && wid!=""){
			doGet(basePath+"/contractEditInfo/queryContractInfo","wid="+wid,function(data){
				setForm(data.data);
			});
		}else{
			doGet(basePath+"/contractEditInfo/queryForm","pcid="+firstPcid+"&pcids="+pcids,function(data){
				setForm(data.data);
			});
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
					str+='<td class="text-center"><input type="radio" data-option="radBatch" name="radBatch" value="'+_d[i].wid+'"></td>';
					str+='<td class="text-center">'+toStr(_d[i].ypph)+'</td>';
					str+='<td class="text-center">'+toStr(_d[i].syr)+'</td>';
					str+='<td class="text-center">'+toStr(_d[i].sydw_display)+'</td>';
					str+="</tr>";
				}
				$("#tblBatchInfo").html(str);
			}
			$("#mainBatchTable").delegate("[data-option='radBatch']","click",function(){
				var _key=$(this).val();
				doGet(basePath+"/contractEditInfo/queryFxxmByBatchId","pcid="+_key+"&htid="+wid,function(data){
					var str2="";
					if(data && data){
						for(var j=0;j<data.data.length;j++){
						str2+="<tr>";
						str2+='<td class="text-center"><input type="checkbox" data-option="checkFxxd"  value="'+data.data[j].lbdm+'"></td>';
						str2+='<td class="text-center">'+data.data[j].lbmc+'</td>';
						str2+="</tr>";
						}
					}
					$("#tblFxxmDetailInfo").html(str2);
				});
			});
		});
	}
	function queryFxxm(){
		doGet(basePath+"/contractEditInfo/queryFxxm","pcids="+pcids,function(data){
			
		});
	}
	function setForm(data){
		$("#userForm [name='wid']").val(data.wid);
		$("#userForm [name='dqbh']").val(data.dqbh);
		$("#userForm [name='htmc']").html(toStr(data.htmc));
		$("#userForm [name='htlx']").html(toStr(data.htlx_display));
		$("#userForm [name='htbh']").html(toStr(data.htbh));
		$("#userForm [name='htjf']").html(toStr(data.htjf_display));
		$("#userForm [name='xmfzr']").html(toStr(data.xmfzr));
		$("#userForm [name='htje']").html(toStr(data.htje));
		$("#userForm [name='htje']").html(toStr(data.htje));
		$("#userForm [name='htzk']").html(toStr(data.htzt_display));
		
		$("#userForm [name='htsj']").html(toStr(data.htsj));
		$("#userForm [name='htzxsj']").html(toStr(data.htzxsj));
		$("#userForm [name='dfzh']").html(toStr(data.dfzh));
		$("#userForm [name='bz']").html(toStr(data.bz));
	}
	
	
	$("#btnSave").click(function(){
		if (_validater.form()) {
			var url = basePath + "/contractEditInfo/saveContractInfo?pcids="+pcids;
			var datas = $("#userForm").serializeArray();
			doPost(url, datas, function(data) {
				if (data && data.data) {
					alert(data.msg);
					window.location.href=basePath+"/contractEditInfo/index?wid="+data.data;
				}
			});
		}
	});
	$("#btnAddFxxm").click(function(){
		if($("#userForm [name='wid']").val()==""){
			alert("请先保存合同基本信息后再进行操作！");
			return false;
		}
		
		var chkPc=$("#tblBatchInfo [name='radBatch']:checked");//选中的批次
		var chkFxxm=$("#tblFxxmDetailInfo [data-option='checkFxxd']:checked");//选中的分析项目
		
		if(chkFxxm.length<=0){
			alert("请至少选择一个分析项目！");
			return ;
		}
		var _selectPcId=chkPc[0].value;
		var _selectFxxmBh="";
		for(var i=0;i<chkFxxm.length;i++){
			_selectFxxmBh+=","+chkFxxm[i].value;
		}
		if(_selectFxxmBh){
			_selectFxxmBh=_selectFxxmBh.substr(1);
		}
		
		var url = basePath + "/contractEditInfo/addFxxm";
		var datas ="htid="+wid+"&pcid="+_selectPcId+"&fxxms="+_selectFxxmBh;
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