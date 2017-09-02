<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/jsp/public/top.jsp"%>
</head>
<body>
	<div class="main">
		<%@ include file="/jsp/public/header.jsp"%>
		<%@ include file="/jsp/public/left.jsp"%>
		<div class="main-content">
			<div class="position">
				<ol class="breadcrumb">
					<li><a href="#"><i class="icon icon-home"></i> 位置</a></li>
					<li><a href="#">任务管理</a></li>
					<li class="active">任务详情</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<div class="pull-left"></div>
						<div class="pull-right">
							<button class="btn btn-default btnQuery"
								style="float: right; margin-left: 5px;" id="btnBack">返回</button>
							<button class="btn btn-primary btnQuery"
								style="float: right; margin-left: 5px; display: none;"
								id="btnSave">提交</button>

							<select id="selRwzt" class="form-control"
								style="float: right; width: 150px; display: none;">
								<option value=''>批量选择任务状态</option>
							</select>
						</div>
						<br> <br>
						<table class="table table-bordered datatable table-hover"
							id="mainTable">
							<thead>
								<tr>
									<%
										String flag = request.getAttribute("flag").toString();
										if ("examine".equals(flag)) {
									%>
									<th class="text-center" style="width: 80px;"><input
										type="checkbox" name="selAll" /></th>
									<%
										}
									%>
									<th class="text-center">样品编号</th>
									<th class="text-center">样品批次号</th>
									<th class="text-center">样品原有编号</th>
									<th class="text-center">样品性质</th>
									<th class="text-center">样品二维码</th>
									<th class="text-center">分析项目</th>
									<th class="text-center">任务状态</th>
									<%
										if ("examine".equals(flag)) {
									%>
									<th class="text-center">操作</th>
									<%
										}
									%>
								</tr>
							</thead>
							<tbody id="tblUserInfo">
							</tbody>
						</table>
						<div class="pull-right">
							<div id='pageInfo' class="pagination"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		var pwid = "${wid}";
		var flag = "${flag}";//编辑还是查看
	</script>
	<script id="tblDetailInfoTpl" type="text/x-jquery-tmpl">
				
			</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/task/taskInfoDetail.js"></script>
</body>
</html>