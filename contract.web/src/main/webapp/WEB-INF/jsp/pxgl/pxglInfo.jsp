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
					<li><a href="#">进行培训</a></li>
					<li class="active">进修培训管理</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<form class="form-horizontal" id="queryContractForm">
							<div class="form-group">
								<label for="phone" class="col-sm-1 ">培训类型</label>
								<div class="col-md-3 col-sm-3">

									<select name="queryPxlx" class="form-control">
										<option value=''>--请选择--</option>
									</select>
								</div>
								<label for="phone" class="col-sm-1 ">培训名称</label>
								<div class="col-md-3 col-sm-3">
									<input type="text" class="form-control " name="queryPxmc"
										"
										placeholder="">
								</div>
								<label for="phone" class="col-sm-1 ">培训人</label>
								<div class="col-md-3 col-sm-3">
									<input type="text" class="form-control queryCondition"
										name="queryMan" placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="phone" class="col-sm-1 ">任务状态</label>
								<div class="col-md-3 col-sm-3">
									<select name="queryRwzt" class="form-control">
										<option value=''>--请选择--</option>
									</select>
								</div>
								<div class="col-md-3 col-sm-3">
									<button class="btn btn-primary btnQuery" type="button"
										id="btnQuery">查询</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="panel">
					<div class="panel-body">
						&nbsp;&nbsp;
						<div class="pull-right">
							&nbsp;&nbsp;
							<button class="btn btn-primary btnQuery" style="display: none;"
								id="btnAdd">新建</button>
						</div>
						<br> <br>
						<table class="table table-bordered datatable table-hover"
							id="mainTable">
							<thead>
								<tr>
									<th class="text-center">培训类型</th>
									<th class="text-center">培训名称</th>
									<th class="text-center">培训人</th>
									<th class="text-center">开始时间</th>
									<th class="text-center">结束时间</th>
									<th class="text-center">培训费用</th>
									<th class="text-center">任务状态</th>
									<th data-width="130px" class="text-center">操作</th>
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
	<div class="modal fade" id="modelEdithUserInfo">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">编辑</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="userForm">
						<div class="form-group">
							<input type="hidden" name="wid" value=""> <label
								for="name" class="col-sm-2 required">培训类型</label>
							<div class="col-md-6 col-sm-6">
								<select name="pxlx" class="form-control " required>
									<option value=''>--请选择--</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="col-sm-2 required">培训名称</label>
							<div class="col-md-6 col-sm-6">
								<input type="text" class="form-control" name="pxmc"
									placeholder="请输入培训名称" required>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="col-sm-2 required">培训人</label>
							<div class="col-md-6 col-sm-6">
								<select name="by1" class="form-control " required>
									<option value=''>--请选择--</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="col-sm-2 required">开始时间</label>
							<div class="col-md-6 col-sm-6">
								<input type="text" class="form-control" name="begtime"
									placeholder="请输入开始时间" required onClick="WdatePicker()">
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="col-sm-2 required">结束时间</label>
							<div class="col-md-6 col-sm-6">
								<input type="text" class="form-control" name="endtime"
									placeholder="请输入结束时间" required onClick="WdatePicker()">
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="col-sm-2 required">培训费用</label>
							<div class="col-md-6 col-sm-6">
								<input type="text" class="form-control" name="pxfy"
									placeholder="请输入培训费用" required>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="col-sm-2 required">备注</label>
							<div class="col-md-6 col-sm-6">
								<textarea name="bz" rows="3" cols="35"></textarea>
							</div>
						</div>
					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="btnSaveUserInfo">保存</button>
					<button type="button" class="btn btn-primary" id="btnSubmitUserInfo">提交审核</button>
				</div>
			</div>
		</div>
	</div>

	<div id="menuContent" class="menuContent"
		style="display: none; z-index: 999999999; background: #f1f1f1; position: absolute;">
		<ul id="treeDemo" class="ztree" style="margin-top: 0; width: 100%;"></ul>
	</div>
	<script type="text/javascript">
		var buttonsPermission = "${buttons}";
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/pxgl/pxglInfo.js"></script>
</body>
</html>