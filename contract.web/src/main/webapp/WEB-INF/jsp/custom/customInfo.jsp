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
					<li><a href="#">客户管理</a></li>
					<li class="active">客户档案信息</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<form action="#" method="post">
							<div class="search">
								<input type="text" class="text" name="topic"
									placeholder="送样人/样品批次号/样品编号" class="queryCondition">
								&nbsp;
								<button class="btn btn-primary btnQuery" type="button"
									id="btnQuery">查询</button>
							</div>
						</form>
					</div>
				</div>
				<div class="panel">
					<div class="panel-body">
						<div class="pull-left">
							<button class="btn btn-primary btnQuery" id="btnAdd"
								style="display: none;">新建</button>
						</div>
						<br> <br>
						<table class="table table-bordered datatable table-hover"
							id="mainTable">
							<thead>
								<tr>
									<th class="text-center" style="width: 80px;"><input
										type="checkbox" name="selAll" /></th>
									<th class="text-center">客户编码</th>
									<th class="text-center">客户名称</th>
									<th class="text-center">客户类别</th>
									<th class="text-center">客户公司信息</th>
									<th class="text-center">联系方式</th>
									<th data-width="160px" class="text-center">操作</th>
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

	<div class="modal fade" id="modelEdidCustomInfo">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">编辑</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="customForm"
						style="margin-top: 10px;">
						<div class="form-group">
							<input type="hidden" name="wid" value=""> <input
								type="hidden" name="dqbh" value=""><label for="name"
								class="col-sm-2 required">客户名称</label>
							<div class="col-md-4 col-sm-4">
								<input type="text" class="form-control" name="customName"
									placeholder="请输入客户名称" required>
							</div>
							<label for="gh" class="col-sm-2 required">客户编号</label>
							<div class="col-md-4 col-sm-4">
								<input type="text" class="form-control" readonly
									name="customNumber" placeholder="请输入客户编号" required>
							</div>
						</div>
						<div class="form-group">
							<label for="phone" class="col-sm-2 required">客户类别</label>
							<div class="col-md-4 col-sm-4">
								<select name="customType" class="form-control" required>
									<option value=''>--请选择--</option>
								</select>
							</div>
							<label for="email" class="col-sm-2 required">客户联系方式</label>
							<div class="col-md-4 col-sm-4">
								<input type="text"  class="form-control"
									name="contractWay" placeholder="请输入客户联系方式" required>
							</div>
						</div>
						<div class="form-group">
							<label for="phone" class="col-sm-2 required">客户基本信息</label>
							<div class="col-md-10 col-sm-10">
								<input type="text" class="form-control" name="linkMan"
									placeholder="请输入客户基本信息" required>
							</div>
						</div>
						<div class="form-group">
							<label for="phone" class="col-sm-2 required">客户公司名称</label>
							<div class="col-md-10 col-sm-10">
								<input type="text" class="form-control" name="companyName"
									placeholder="请输入客户公司名称" required>
							</div>
						</div>
						<div class="form-group">
							<label for="phone" class="col-sm-2 required">客户公司地址</label>
							<div class="col-md-10 col-sm-10">
								<input type="text" class="form-control" name="companyAddress"
									placeholder="请输入客户公司地址" required>
							</div>
						</div>
						<div class="form-group">
							<label for="phone" class="col-sm-2 required">客户账户信息</label>
							<div class="col-md-10 col-sm-10">
								<input type="text" class="form-control" name="companyAccount"
									placeholder="请输入客户账户信息" required>
							</div>
						</div>
						<div class="form-group">
							<label for="phone" class="col-sm-2 required">客户预存账号</label>
							<div class="col-md-10 col-sm-10">
								<input type="text" class="form-control" name="companyPreAccount"
									placeholder="请输入客户预存账号" required>
							</div>
						</div>
					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="btnSaveCustomInfo">保存</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var buttonsPermission = "${buttons}";
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/custom/customInfo.js"></script>
</body>
</html>