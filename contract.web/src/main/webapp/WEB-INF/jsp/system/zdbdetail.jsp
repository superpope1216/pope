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
					<li class="active">字典表详情</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="col-md-4 col-sm-4">
					<div class="panel">
						<div class="panel-heading">字典表信息</div>
						<div class="panel-body">
							<div class="col-md-12">
								<ul id="zdbTree" class="ztree"
									style="border: 0; margin-top: 0px; background: #FFF; padding-top: 0px;"></ul>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-8 col-sm-8" >
					<div class="panel">
						<div class="panel-heading">字典表详情</div>
						<div class="panel-body"> 
							<div class="pull-left">
								<button class="btn btn-primary btnQuery" id="btnNew">新
									建</button>
							</div>
							<br> <br>
							<table class="table table-bordered datatable table-hover"
								id="mainTable">
								<thead>
									<tr>
										<th class="text-center">类别代码</th>
										<th class="text-center">类别名称</th>
										<th class="text-center">排序</th>
										<th data-width="130px" class="text-center">操作</th>
									</tr>
								</thead>
								<tbody id="tblSjzdInfo">
								</tbody>
							</table>
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
						<div class="form-group">
							<input type="hidden" name="wid" value=""> 
							<input type="hidden" name="tableName" value="">
							<label
								for="lbdm" class="col-sm-2 required">类别编码</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" class="form-control" name="lbdm"
									placeholder="请输入字典表编码" required>
							</div>
						</div>
						<div class="form-group">
							<label for="lbmc" class="col-sm-2 required">类别名称</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" class="form-control" name="lbmc"
									placeholder="请输入字典表名称" required>
							</div>
						</div>
						<div class="form-group">
							<label for="orderby" class="col-sm-2 required">排序</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" class="form-control" name="orderby"
									placeholder="请输入排序信息" required>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="button" class="btn btn-primary"
								id="btnSaveZdbsInfo">保存</button>
						</div>
			</div>
		</div>
	</div>
	<script id="tblSjzdInfoTpl" type="text/x-jquery-tmpl">
				<tr>
					<td class="text-center">{{= lbdm}}</td>
					<td class="text-left">{{= lbmc}}</td>
					<td class="text-center">{{= orderby}}</td>
					<td class="text-center">
					<a href="javascript:void(0);"  data-key='{{= wid}}'  data-option='editSjzd' class="text-danger"><i class="icon-edit"></i></a>
					<a href="javascript:void(0);" data-key='{{= wid}}' data-option='deleteSjzd' class="text-danger"><i class="icon-trash"></i></a></td>
				</tr>
	 </script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/pageJs/system/zdbdetail.js"></script>
</body>
</html>