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
					<li><a href="#">耗材管理</a></li>
					<li class="active">公共仓库</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<form action="#" method="post">
							<div class="search">
								<input type="text" class="text" name="queryCondition"
									placeholder="请输入品名进行查询" class="queryCondition" id="queryCondition"> &nbsp;
								<button class="btn btn-primary btnQuery" type="button"
									id="btnQuery">查询</button>
							</div>
						</form>
					</div>
				</div>
				<div class="panel">
					<div class="panel-body">
						<div class="pull-left" >
							<button class="btn btn-primary btnQuery" style="display:none;margin-bottom:10px;" id="btnAdd">新 建</button>
						</div>
						<div class="pull-right">
							<!-- <button class="btn btn-primary" style="width: 100px; margin-left: 10px;">导入</button> -->
							<button class="btn btn-primary btnQuery" style="display:none;margin-bottom:10px;" id="btnExport">导出</button>
						</div>
						<table class="table table-bordered" id="mainTable">
							<thead>
								<tr>
									<th style="width: 80px;" class="text-center"><input
										type="checkbox" name="selAll"></th>
									<th class="text-center">消耗品名</th>
									<th class="text-center">类别</th>
									<th class="text-center">有效期</th>
									<th class="text-center">数量</th>
									<th class="text-center">供应商</th>
									<th class="text-center">操作</th>
								</tr>
							</thead>
							<tbody id="tblSupplyInfo">
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


	<div class="modal fade" id="modelEdithSupplyInfo">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">编辑</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="supplyForm">
						<div class="form-group">
							<input type="hidden" name="wid" value=""> <label
								for="name" class="col-sm-2 required">分类</label>
							<div class="col-md-4 col-sm-4">
								<select class="form-control" name="hcfl" required
									placeholder="请选择分类"></select>
							</div>
							<label for="gh" class="col-sm-2 required">品名</label>
							<div class="col-md-4 col-sm-4">
								<div class="input-group">
									<input type="text" class="form-control" name="pm">
									<div class="input-group-btn">
										<button type="button" class="btn btn-default dropdown-toggle"
											data-toggle="dropdown">
											<span class="caret"></span>
										</button>
										<ul class="dropdown-menu dropdown-menu-right" role="menu">
										</ul>
									</div>
									<!-- /btn-group -->
								</div>
							</div>
						</div>
						<div class="form-group">
							
							<label for="email" class="col-sm-2 required">消耗品录入时间</label>
							<div class="col-md-4 col-sm-4">
								<input type="text" class="form-control" name="xhplrsj"
									placeholder="请输入录入时间" onClick="WdatePicker()" required>
							</div>
							<label for="contractvalidity" class="col-sm-2 required">供应商</label>
							<div class="col-md-4 col-sm-4">
								<input type="text" class="form-control" name="gys"
									placeholder="请输入供应商" required>
							</div>
						</div>

						<div class="form-group">
							<label for="team" class="col-sm-2 required">库存</label>
							<div class="col-md-4 col-sm-4">
								<input type="text" class="form-control" name="kc"
									placeholder="请输入库存" required>
							</div>
							<label for="birthday" class="col-sm-2 required">数量单位</label>
							<div class="col-md-4 col-sm-4">
								<select class="form-control" name="sldw" required
									placeholder="请选择数量单位"></select>
							</div>

						</div>
						<div class="form-group">
							<label for="degree" class="col-sm-2 required">单价</label>
							<div class="col-md-4 col-sm-4">
								<input type="text" class="form-control" name="dj"
									placeholder="请输入单价" required>
							</div>
							<label for="jobcategory" class="col-sm-2 required">货币单位</label>
							<div class="col-md-4 col-sm-4">
								<select class="form-control" name="hbdw" required
									placeholder="请选择货币单位"></select>
							</div>


						</div>
						<div class="form-group">
							<label for="department" class="col-sm-2 required">有效期（天）</label>
							<div class="col-md-4 col-sm-4">
								<input type="text" class="form-control" name="yxq"
									placeholder="请输入有效期" required>
							</div>
						</div>

						<div class="form-group">
							<label for="contractvalidity" class="col-sm-2">备注</label>
							<div class="col-md-10 col-sm-10">
								<input type="text" class="form-control" name="bz"
									placeholder="请输入备注" >
							</div>
						</div>

					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary"
						id="btnSaveSupplyInfo">保存</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="modelViewSupplyInfo">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">详情</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="supplyViewForm">
						<div class="form-group">
							<input type="hidden" name="wid" value=""> <label
								for="name" class="col-sm-2 required">分类</label>
							<div class="col-md-4 col-sm-4">
								<p class="form-control-static" name="hcfl"></p>
							</div>
							<label for="gh" class="col-sm-2 required">品名</label>
							<div class="col-md-4 col-sm-4">
								<p class="form-control-static" name="pm"></p>
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-sm-2 required">消耗品录入时间</label>
							<div class="col-md-4 col-sm-4">
								<p class="form-control-static" name="xhplrsj"></p>
							</div>
							<label for="contractvalidity" class="col-sm-2 required">供应商</label>
							<div class="col-md-4 col-sm-4">
								<p class="form-control-static" name="gys"></p>
							</div>
						</div>

						<div class="form-group">
							<label for="team" class="col-sm-2 required">库存</label>
							<div class="col-md-4 col-sm-4">
								<p class="form-control-static" name="kc"></p>
							</div>
							<label for="birthday" class="col-sm-2 required">数量单位</label>
							<div class="col-md-4 col-sm-4">
								<p class="form-control-static" name="sldw"></p>
							</div>

						</div>
						<div class="form-group">
							<label for="degree" class="col-sm-2 required">单价</label>
							<div class="col-md-4 col-sm-4">
								<p class="form-control-static" name="dj"></p>
							</div>
							<label for="jobcategory" class="col-sm-2 required">货币单位</label>
							<div class="col-md-4 col-sm-4">
								<p class="form-control-static" name="hbdw"></p>
							</div>


						</div>
						<div class="form-group">
							<label for="department" class="col-sm-2 required">有效期</label>
							<div class="col-md-4 col-sm-4">
								<p class="form-control-static" name="yxq"></p>
							</div>
							<label for="job" class="col-sm-2 required">预警数量</label>
							<div class="col-md-4 col-sm-4">
								<p class="form-control-static" name="yjsl"></p>
							</div>
						</div>

						<div class="form-group">
							<label for="contractvalidity" class="col-sm-2">备注</label>
							<div class="col-md-10 col-sm-10">
								<p class="form-control-static" name="bz"></p>
							</div>
						</div>

					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" >
    	var buttonsPermission="${buttons}";
    </script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/supply/supplyInfo.js"></script>
</body>
</html>