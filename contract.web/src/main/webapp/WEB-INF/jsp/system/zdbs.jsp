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
					<li><a href="#">系统管理</a></li>
					<li class="active">字典表管理</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="col-md-12 col-sm-12">
					<div class="panel">
						<div class="panel-body">
							<div class="pull-left">
								<button class="btn btn-primary btnQuery" id="btnNew">新
									建</button>
							</div>
							<br> <br>
							<table class="mainTable table-hover" id="mainTable">
								<thead>
									<tr>
										<td class="text-center">编码</td>
										<td class="text-center">名称</td>
										<td class="text-center">排序</td>
										<td data-width="130px" class="text-center">操作</td>
									</tr>
								</thead>
								<tbody id="tblZdbsInfo">
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
	</div>

	<div class="modal fade" id="modelEditZdbsInfo">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">字典表信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="zdbsForm">
						<table style="width: 100%" class="mainTable">
							<tr>
								<td class="tbl-one-text"><input type="hidden"
									name="wid" value="">编码<span class="myrequrire">*</span></td>
								<td class="tbl-one-edit-value"><input type="text" class="form-control" name="code"
									placeholder="请输入字典表编码" required></td>
							</tr>
							<tr>
								<td class="tbl-one-text">名称<span class="myrequrire">*</span></td>
								<td class="tbl-one-edit-value"><input type="text" class="form-control" name="name"
									placeholder="请输入字典表名称" required></td>
							</tr>
							<tr>
								<td class="tbl-one-text">排序<span class="myrequrire">*</span></td>
								<td class="tbl-one-edit-value"><input type="text" class="form-control" name="orderby"
									placeholder="请输入排序信息" required></td>
							</tr>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="btnSaveZdbsInfo">保存</button>
				</div>
			</div>
		</div>
	</div>
	<script id="tblZdbsInfoTpl" type="text/x-jquery-tmpl">
				
	 </script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/system/zdbs.js"></script>
</body>
</html>