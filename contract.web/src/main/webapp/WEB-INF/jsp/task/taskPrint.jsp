<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/jsp/public/top.jsp"%>
<title>分包申请表</title>
<style>
.table {
	border-collapse: collapse;
}

.table td {
	border: 1px solid #666;
	height: 40px;
	padding-left: 2px;
}
</style>
</head>
<body>
	<center>
		<div style="width: 700px">
			
			<table style="width: 100%">
				<tr>
					<td align="left" style="border-bottom: 1px solid #666"><img
						src="${pageContext.request.contextPath}/static/img/icon.png"></td>
				</tr>
			</table>
			<p style="font-family: 黑体; font-size: 40px; font-weight: bold;">检测任务通知单</p>
			<table style="width: 100%">
				<tr>
					<td align="right" style="border-bottom: 1px solid #666">
						<button class="btn btn-primary btnQuery" type="button"
															id="btnSave">保存</button>
															<button class="btn btn-primary btnQuery" type="button"
															id="btnDownLoad">下载</button>
					</td>
				</tr>
			</table>
			<form id="mainForm">
			<input type="hidden" id="wid" name="wid"> <input
				type="hidden" id="taskid" name="taskid">
			<table class="table" style="width: 100%">
				<tr style="height: 35px;">

					<td style="width: 100px;">样品类别</td>
					<td style="width: 250px;"><span id='spanyplb'></span></td>
					<td style="width: 100px;">样品数量</td>
					<td style="width: 250px;"><span id='spanypsl'></span></td>
				</tr>
				<tr>
					<td>委托编号</td>
					<td><input type="text" id="wtbh" required name="wtbh"
						style="width: 90%;"></td>
					<td>试验编号</td>
					<td><span id='spansybh'></span></td>
				</tr>
				<tr>
					<td style="height: 100px;">检验项目</td>
					<td colspan="3"><span id='spanjcxm'></span></td>
				</tr>
				<tr>
					<td>检测依据</td>
					<td colspan="3"><input type="text" required id="jcyj" name="jcyj"
						style="width: 90%;"></td>
				</tr>
				<tr>
					<td>送样人</td>
					<td><span id='spansyr'></span></td>
					<td>委托时间</td>
					<td><span id='spansysj'></span></td>
				</tr>
				<tr>
					<td>领样人</td>
					<td><input type="text" id="lyr" style="width: 90%;" required name="lyr"></td>
					<td>领样时间</td>
					<td><input type="text" required id="lysj" name="lysj"
						style="width: 90%;"></td>
				</tr>
				<tr>
					<td >检测人员</td>
					<td><span id='spanjcry'></span></td>
					<td>检测时间</td>
					<td><span id='spanjcsj'></span></td>
				</tr>
				<tr>
					<td >审核人员</td>
					<td><span id='spanshry'></span></td>
					<td>审核时间</td>
					<td><span id='spanshsj'></span></td>
				</tr>
				<tr>
					<td style="height: 50px;">备注</td>
					<td colspan="3"><textarea required rows="3" cols="80" id="bz"
							name="bz"></textarea></td>
				</tr>
			</table>
			</form>
			<div style="text-align: left">注：试验完成后，检验任务通知单交业务部存档</div>
		</div>

	</center>
	<script language="javascript">
		var wid="${wid}";
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/task/taskPrint.js"></script>
</body>
</html>