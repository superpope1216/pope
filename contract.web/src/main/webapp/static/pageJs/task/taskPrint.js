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
			doPost(basePath+"/taskPrint/save",$("#mainForm").serializeArray(),function(){
				window.location.reload();
			});
		}
	});

	$("#btnDownLoad").click(function() {
		if (_validater.form()) {
			doPost(basePath+"/taskPrint/save",$("#mainForm").serializeArray(),function(){
				//window.open(basePath+"/contractPrint/download");
				location.href=basePath+"/taskPrint/download?taskId="+wid;
			});
		}
	});
	
	function save(){
		
	}
	doGet(basePath + "/taskPrint/select", "taskId=" + wid, function(data) {
		if (data.data) {
			var _data = data.data;
			$("#wid").val(toStr(_data.wid));
			$("#taskid").val(toStr(_data.taskid));
			$("#spanyplb").html(toStr(_data.yplp));
			$("#spanypsl").html(toStr(_data.ypsl));
			$("#wtbh").val(toStr(_data.wtbh));
			$("#spansybh").html(toStr(_data.sybh));
			$("#spanjcxm").html(toStr(_data.jcxm));
			$("#jcyj").val(toStr(_data.jcyj));
			$("#spansyr").html(toStr(_data.syr));
			$("#spansysj").html(toStr(_data.sysj));
			$("#lyr").val(toStr(_data.lyr));
			$("#lysj").val(toStr(_data.lysj));
			$("#spanjcry").html(toStr(_data.jcr));
			$("#spanjcsj").html(toStr(_data.jcsj));
			$("#spanshry").html(toStr(_data.shry));
			$("#spanshsj").html(toStr(_data.shsj));
			$("#bz").val(toStr(_data.bz));

		}

	});

});