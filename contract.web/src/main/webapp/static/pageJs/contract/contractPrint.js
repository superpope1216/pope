/**
 * 
 */
$(document).ready(function() {
	var _validater = $("#mainForm").validate({
		errorPlacement : function(error, element) {
			// Append error within linked label
			$(error).insertAfter($(element));
			// .append(error);
			// $("#mainForm").find( "label[for='" + element.attr( "id" )
			// + "']"
			// ).append( error );
		}
	});

	$("#btnSave").click(function() {
		if (_validater.form()) {
			doPost(basePath+"/contractPrint/save",$("#mainForm").serializeArray(),function(){
				window.location.reload();
			});
		}
	});

	$("#btnDownLoad").click(function() {
		if (_validater.form()) {
			doPost(basePath+"/contractPrint/save",$("#mainForm").serializeArray(),function(){
				//window.open(basePath+"/contractPrint/download");
				location.href=basePath+"/contractPrint/download?wid="+wid;
			});
		}
	});
	
	function save(){
		
	}
	doGet(basePath + "/contractPrint/select", "htid=" + wid, function(data) {
		if (data.data) {
			var _data = data.data;
			$("#wid").val(_data.wid);
			$("#htid").val(_data.htid);
			$("#yplb").val(_data.yplb);
			$("#spanyplb").html(_data.yplb);
			$("#ypsl").val(_data.ypsl);
			$("#spanypsl").html(_data.ypsl);
			$("#wtbh").val(_data.wtbh);
			$("#fbbh").val(_data.fbbh);
			$("#spanfbbh").html(_data.fbbh);
			$("#fbxm").val(_data.fbxm);
			$("#spanfbxm").html(_data.fbxm);
			$("#fbsys").val(_data.fbsys);
			$("#syr").val(_data.syr);
			$("#spansyr").html(_data.syr);
			$("#spanwtsj").html(_data.wtsj);
			$("#wtsj").val(_data.wtsj);
			$("#lyr").val(_data.lyr);
			$("#fbsj").val(_data.fbsj);
			$("#spanfbsj").html(_data.fbsj);

			$("#sqr").val(_data.sqr);
			$("#syszg").val(_data.syszg);
			$("#fbkxxfx").val(_data.fbkxxfx);
		}

	});

});