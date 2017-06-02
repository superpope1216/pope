<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/jsp/public/top.jsp"%>

<style type="text/css">
div#rMenu {
	position: absolute;
	visibility: hidden;
	top: 0;
	background-color: #555;
	text-align: left;
	padding: 2px;
}

div#rMenu ul li {
	margin: 1px 0;
	padding: 0 5px;
	cursor: pointer;
	list-style: none outside none;
	background-color: #DFDFDF;
}
</style>
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
					<li class="active">部门管理</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="col-md-4 col-sm-4">
					<div class="panel">
						<div class="panel-heading">部门信息</div>
						<div class="panel-body">
							<div class="col-md-12">
								<ul id="departTree" class="ztree"
									style="border: 0; margin-top: 0px; background: #FFF; padding-top: 0px;"></ul>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-8 col-sm-8" id="divDepart">
					<div class="panel">
						<div class="panel-heading">部门详情</div>
						<div class="panel-body"> 
							<div class="col-md-12">
								<form class="form-horizontal" id="departForm">
									<input type="hidden" name="wid" value="">
									<input type="hidden" name="type" value="">
									<input type="hidden" name="pid" value="">
									<div class="form-group">
										<label for="bm" class="col-sm-2 required">部门编码</label>
										<div class="col-md-10 col-sm-10">
											<input type="text" class="form-control" name="bm"
												placeholder="请输入部门编码">
										</div>
									</div>
									<div class="form-group">
										<label for="name" class="col-sm-2 required">部门名称</label>
										<div class="col-md-10 col-sm-10">
											<input type="text" class="form-control" name="name"
												placeholder="请输入部门名称">
										</div>
									</div>
								</form>
							</div>
							<div class="col-md-12 text-center">
								<button class="btn btn-primary btnQuery" id="btnSaveDepart">保存</button>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-8 col-sm-8" id="divTeam" style="display:none;">
					<div class="panel">
						<div class="panel-heading">小组详情</div>
						<div class="panel-body">
							
							<div class="col-md-12">
								<form class="form-horizontal" id="teamForm">
									<div class="form-group" >
									<input type="hidden" name="wid" value="">
									<input type="hidden" name="type" value="">
									<input type="hidden" name="pid" value="">
										<label for="bm" class="col-sm-2 required">小组编码</label>
										<div class="col-md-10 col-sm-10">
											<input type="text" class="form-control" name="bm"
												placeholder="请输入小组编码">
										</div>
									</div>
									<div class="form-group">
										<label for="name" class="col-sm-2 required">小组名称</label>
										<div class="col-md-10 col-sm-10">
											<input type="text" class="form-control" name="name"
												placeholder="请输入小组名称">
										</div>
									</div>
								</form>
							</div>
							<div class="col-md-12 text-center">
								<button class="btn btn-primary btnQuery" id="btnSaveTeam">保存</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div id="rMenu">
		<ul>
			<li id="m_addDepart" >增加部门</li>
			<li id="m_delDepart" >删除部门</li>
			<li id="m_addTeam"  >增加小组</li>
			<li id="m_delTeam"  >删除小组</li>
		</ul>
	</div>
	<script id="tblRoleInfoTpl" type="text/x-jquery-tmpl">
				<tr>
						
					<td class="text-left"><input type="hidden" name="wid" value="{{= wid}}">{{= name}}</td>
					<td class="text-center">
					<a href="javascript:void(0);"  data-key='{{= wid}}' data-option='editRole' class="text-danger"><i class="icon-edit"></i></a>
					<a href="javascript:void(0);" data-key='{{= wid}}' data-option='deleteRole' class="text-danger"><i class="icon-trash"></i></a></td>
				</tr>
	 </script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/system/department.js"></script>
</body>
</html>