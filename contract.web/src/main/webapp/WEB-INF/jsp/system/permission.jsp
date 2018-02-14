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
					<li class="active">权限管理</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="col-md-4 col-sm-6">
					<div class="panel">
						<div class="panel-heading">角色</div>
						<div class="panel-body">
							<div class="pull-left mb10">
								<button class="btn btn-primary btnQuery" id="btnNewRole">新
									建</button>
							</div>
							<br>
							<table class="mainTable table-hover" id="mainRole">
								<thead>
									<tr>
										<td class="text-center">名称</td>
										<td class="text-center">排序</td>
										<td class="text-center" width="80px">操作</td>
									</tr>
								</thead>
								<tbody id="tblRoleInfo">
								</tbody>
							</table>
						</div>

					</div>
				</div>
				<div class="col-md-8 col-sm-8">
					<div class="panel">
						<div class="panel-heading">权限信息</div>
						<div class="panel-body">
							<div class="col-md-12 pull-left mb10">
								<button class="btn btn-primary btnQuery" id="btnSavePerms">保存权限</button>
							</div>
							<div class="col-md-12">
								<ul id="permissionTree" class="ztree"
									style="border: 0; margin-top: 0px; background: #FFF; padding-top: 0px;"></ul>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<div class="modal fade" id="modelEdithRoleInfo">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">角色</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="roleForm">
						<table style="width: 100%" class="mainTable">
							<tr>
								<td class="tbl-one-text"><input type="hidden" name="wid" value=""> 角色名<span class="myrequrire">*</span></td>
								<td class="tbl-one-edit-value"><input type="text"
									class="form-control" name="name" placeholder="请输入角色名称" required></td>
							</tr>
							
							<tr>
								<td class="tbl-one-text">排序<span class="myrequrire">*</span></td>
								<td class="tbl-one-edit-value"><input type="text" class="form-control" name="orderby"
										placeholder="请输入排序" required></td>
							</tr>
							<tr>
								<td class="tbl-one-text">描述</td>
								<td class="tbl-one-edit-value"><textarea rows="3" class="form-control" name="description"
										placeholder="请输入描述"></textarea></td>
							</tr>
							</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="btnSaveRoleInfo">保存</button>
				</div>
			</div>
		</div>
	</div>

	<script id="tblRoleInfoTpl" type="text/x-jquery-tmpl">
				<tr>
						
					<td class="text-left"><input type="hidden" name="wid" value="{{= wid}}">{{= name}}</td>
					<td class="text-left">{{= orderby}}</td>
					<td class="text-center">
					<a href="javascript:void(0);"  data-key='{{= wid}}' data-option='editRole' class="text-danger"><i class="icon-edit"></i></a>
					<a href="javascript:void(0);" data-key='{{= wid}}' data-option='deleteRole' class="text-danger"><i class="icon-trash"></i></a></td>
				</tr>
	 </script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/system/permission.js"></script>
</body>
</html>