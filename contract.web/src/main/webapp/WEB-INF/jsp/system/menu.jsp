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
					<li class="active">菜单管理</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="col-md-4 col-sm-4">
					<div class="panel">
						<div class="panel-heading">菜单信息</div>
						<div class="panel-body">
							<div class="col-md-12">
								<ul id="permissionTree" class="ztree"
									style="border: 0; margin-top: 0px; background: #FFF; padding-top: 0px;"></ul>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-8 col-sm-8" id="divDepart">
					<div class="panel">
						<div class="panel-heading">菜单信息</div>
						<div class="panel-body">
							<div class="col-md-12">
								<form class="form-horizontal" id="menuForm">
									<table style="width: 100%" class="mainTable">
										<tr>
											<td class="tbl-one-text"><input type="hidden" name="wid"
												value="">菜单名称<span class="myrequrire">*</span></td>
											<td class="tbl-one-edit-value"><input type="text"
												class="form-control" name="name" placeholder="请输入菜单名称"></td>
										</tr>
									</table>
								</form>
							</div>
							<div class="col-md-12 text-center">
								<button class="btn btn-primary btnQuery" id="btnSaveMenu">保存</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/system/menu.js"></script>
</body>
</html>