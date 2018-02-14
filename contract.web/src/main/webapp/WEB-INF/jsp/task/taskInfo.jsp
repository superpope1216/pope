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
					<li class="active">项目任务</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
								<form class="form-horizontal" id="queryTaskForm">
									<table class="mainQueryTable">
								<tr>
									<td class="tbl-text">任务名称</td>
									<td class="tbl-four-edit-value"><input type="text"
										class="form-control " name="rwmc" placeholder="请输入任务名称"></td>
									<td class="tbl-text">责任人</td>
									<td class="tbl-four-edit-value"><input type="text"
										class="form-control " name="rwfpr_display"
										placeholder="请输入责任人"></td>
									<td class="tbl-text">任务状态</td>
									<td class="tbl-four-edit-value"><select
										class="form-control" name="rwzt" placeholder="请选择任务状态"></select>
									</td>
									<td class="tbl-four-edit-value" colspan="2"><button
											class="btn btn-primary btnQuery " type="button" id="btnQuery">查询</button></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
				<div class="panel">
					<div class="panel-body">
						<div class="pull-right">
							<button class="btn btn-primary btnQuery" id="btnSubmit"
								style="display: none;">提交审核</button>
								<!-- <button class="btn btn-primary btnQuery" style="width:120px;" id="btnPrint">任务检测申请单</button> -->
						</div>
						<br> <br>
						<table class="mainTable table-hover"
							id="mainTable">
							<thead>
								<tr>
									<td class="text-center" style="width: 80px;"><input
										type="checkbox" name="selAll" /></td>
									<td class="text-center">任务名称</td>
									<td class="text-center">责任人</td>
									<td class="text-center">计划开始时间</td>
									<td class="text-center">计划结束时间</td>
									<td class="text-center">实际开始时间</td>
									<td class="text-center">实际结束时间</td>
									<td class="text-center">分析项目</td>
									<td class="text-center">任务审核人</td>
									<td class="text-center">任务状态</td>
									<td data-width="160px" class="text-center">操作</td>
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

	<script id="tblUserInfoTpl" type="text/x-jquery-tmpl">
				
			</script>
	<script type="text/javascript">
		var buttonsPermission = "${buttons}";
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/task/taskInfo.js"></script>
</body>
</html>