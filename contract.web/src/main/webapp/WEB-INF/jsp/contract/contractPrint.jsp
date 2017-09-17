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
			<p style="font-family: 黑体; font-size: 40px; font-weight: bold;">分包申请表</p>
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
				type="hidden" id="htid" name="htid">
			<table class="table" style="width: 100%">
				<tr style="height: 35px;">

					<td style="width: 100px;">样品类别</td>
					<td style="width: 250px;"><input type='hidden' id='yplb'
						name='yplb'><span id='spanyplb'></span></td>
					<td style="width: 100px;">样品数量</td>
					<td style="width: 250px;"><input type='hidden' id='ypsl'
						name='ypsl'><span id='spanypsl'></span></td>
				</tr>
				<tr>
					<td>委托编号</td>
					<td><input type="text" id="wtbh" required name="wtbh"
						style="width: 90%;"></td>
					<td>分包编号</td>
					<td><input type='hidden' id='fbbh' name='fbbh'><span
						id='spanfbbh'></span></td>
				</tr>
				<tr>
					<td style="height: 100px;">分包项目</td>
					<td colspan="3"><input type='hidden' id='fbxm' name='fbxm'><span
						id='spanfbxm'></span></td>
				</tr>
				<tr>
					<td>分包实验室</td>
					<td colspan="3"><input type="text" required id="fbsys" name="fbsys"
						style="width: 90%;"></td>
				</tr>
				<tr>
					<td>送样人</td>
					<td><input type='hidden' id='syr' name='syr'><span
						id='spansyr'></span></td>
					<td>委托时间</td>
					<td><input type='hidden' id='wtsj' name='wtsj'><span
						id='spanwtsj'></span></td>
				</tr>
				<tr>
					<td>领样人</td>
					<td><input type="text" id="lyr" style="width: 90%;" required name="lyr"></td>
					<td>分包时间</td>
					<td><input type='hidden' id='fbsj' name='fbsj'><span
						id='spanfbsj'></span></td>
				</tr>
				<tr>
					<td >申请人</td>
					<td><input type="text" id="sqr" style="width: 90%;" name="sqr" required></td>
					<td>实验室主管</td>
					<td><input type="text" id="syszg" style="width: 90%;" name="syszg" required></td>
				</tr>
				<tr>
					<td style="height: 50px;">分布可行性分析</td>
					<td colspan="3"><textarea required rows="3" cols="80" id="fbkxxfx"
							name="fbkxxfx"></textarea></td>
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
		src="${pageContext.request.contextPath}/static/pageJs/contract/contractPrint.js"></script>
</body>
</html>