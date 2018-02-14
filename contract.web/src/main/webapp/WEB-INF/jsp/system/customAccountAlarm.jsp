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
					<li class="active">告警配置</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="col-md-4 col-sm-6">
					<div class="panel">
						<div class="panel-heading">角色</div>
						<div class="panel-body">
							<br>
							<table class="mainTable table-hover" id="mainRole">
								<thead>
									<tr>
										<td class="text-center">名称</td>
										<td class="text-center">排序</td>
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
						<div class="panel-heading">告警配置</div>
						<div class="panel-body">
							<div class="col-md-12 pull-left mb10">
								<button class="btn btn-primary btnQuery" id="btnSavePerms">保存</button>
							</div>
							<div class="col-md-12">

								<form class="form-horizontal" id="alarmForm">
									<table id="mainTable" class="mainTable">
										<tr>
											<td class="tbl-one-text"><input type="hidden" name="wid"
												value=""> <input type="hidden" name="permissionId"
												value=""> 客户账户余额告警</td>
											<td class="tbl-one-edit-value"><input type="checkbox"
												name="customAccount"></td>
										</tr>
									</table>
								</form>
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
					<td class="text-left">{{= orderby}}</td>
				</tr>
	 </script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/system/customAccountAlarm.js"></script>
</body>
</html>