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
					<li class="active">合同管理</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<form action="#" method="post">
							<div class="search">
								<form class="form-horizontal" id="userForm">
									<div class="form-group">
										<label for="phone" class="col-sm-1 ">送样人</label>
										<div class="col-md-3 col-sm-3">

											<input type="text" class="form-control " name="topic"
												placeholder="" class="queryCondition">
										</div>
									</div>
									<div class="form-group">
										<label for="phone" class="col-sm-1 ">合同编号</label>
										<div class="col-md-3 col-sm-3">
											<input type="text" class="form-control " name="topic"
												placeholder="" class="queryCondition">
										</div>
									</div>
									<div class="form-group">
										<label for="phone" class="col-sm-1 ">样品批次号</label>
										<div class="col-md-3 col-sm-3">
											<input type="text" class="form-control " name="topic"
												placeholder="" class="queryCondition">
										</div>
									</div>
									<div class="form-group">
										<label for="phone" class="col-sm-1 ">分析项</label>
										<div class="col-md-3 col-sm-3">
											<input type="text" class="form-control " name="topic"
												placeholder="" class="queryCondition">
										</div>
									</div>
									<button class="btn btn-primary btnQuery" type="button"
										id="btnQuery">查询</button>
								</form>
							</div>
						</form>
					</div>
				</div>
				<div class="panel">
					<div class="panel-body">
						<table class="table table-bordered datatable table-hover"
							id="mainTable">
							<thead>
								<tr>
									<th class="text-center" style="width: 80px;"><input
										type="checkbox" name="selAll" /></th>
									<th class="text-center">时间</th>
									<th class="text-center">合同名称</th>
									<th class="text-center">合同编号</th>
									<th class="text-center">合同类型</th>
									<th class="text-center">对方名称</th>
									<th class="text-center">对方账号</th>
									<th class="text-center">金额</th>
									<th data-width="80px" class="text-center">操作</th>
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
	<script type="text/javascript">
		var buttonsPermission = "${buttons}";
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/contract/contractInfo.js"></script>
</body>
</html>