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
								<button class="btn btn-primary btnQuery" id="btnNew">新
									建</button>
							</div>
							<br>
							<table class="table table-bordered table-hover" id="mainRole">
								<thead>
									<tr>
										<th class="text-center">名称</th>
										<th class="text-center" width="80px">操作</th>
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
							<ul id="permissionTree"  class="ztree" style="border:0;margin-top:0px;background:#FFF;padding-top:0px;"></ul>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<script id="tblRoleInfoTpl" type="text/x-jquery-tmpl">
				<tr>
						
					<td class="text-left"><input type="hidden" name="wid" value="{{= wid}}">{{= name}}</td>
					<td class="text-center">
					<a href="###" class="text-danger"><i class="icon-edit"></i></a>
					<a href="###" class="text-danger"><i class="icon-trash"></i></a></td>
				</tr>
	 </script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/pageJs/system/permission.js"></script>
</body>
</html>