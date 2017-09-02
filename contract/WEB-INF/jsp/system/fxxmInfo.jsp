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
					<li class="active">分析项目管理</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="col-md-12 col-sm-12">
					<div class="panel">
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
										<th class="text-center">分析项目名称</th>
										<th class="text-center">分析项目类别</th>
										<th class="text-center">分析单价</th>
										<th class="text-center">折扣</th>
										<th class="text-center">分析依据</th>
										<th class="text-center">分析人员</th>
										<th class="text-center">审核人员</th>
										<th data-width="130px" class="text-center">操作</th>
									</tr>
								</thead>
								<tbody id="tblZdbsInfo">
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
							<input type="hidden" name="wid" value=""> <label
								for="code" class="col-sm-2 required">分析项目名称</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" class="form-control" name="lbmc"
									placeholder="请输入分析项目名称" required>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="col-sm-2 required">请输入分析类别</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" class="form-control" name="fxxlb"
									placeholder="请输入分析类别" required>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="col-sm-2 required">分析单价</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" class="form-control" name="fxdj"
									placeholder="请输入分析单价" required>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="col-sm-2 required">折扣</label>
							<div class="col-md-8 col-sm-8">
								<select name="zk" class="form-control" required>
									<option value=''>--请选择--</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="col-sm-2 required">分析依据</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" class="form-control" name="fxyj"
									placeholder="请输入分析依据" required>
							</div>
						</div>
						<div class="form-group">
							<label for="orderby" class="col-sm-2 required">分析人员</label>
							<div class="col-md-8 col-sm-8">
								<select name="fxry" class="form-control" required>
									<option value=''>--请选择--</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="orderby" class="col-sm-2 required">审核人员</label>
							<div class="col-md-8 col-sm-8">
								<select name="shry" class="form-control" required>
									<option value=''>--请选择--</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="orderby" class="col-sm-2 required">排序</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" class="form-control" name="orderby"
									placeholder="请输入排序信息" required>
							</div>
						</div>
						<div class="form-group">
							<label for="orderby" class="col-sm-2 ">备注</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" class="form-control" name="bz"
									placeholder="请输入备注信息">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="btnSaveZdbsInfo">保存</button>
				</div>
			</div>
		</div>
	</div>
	<script id="tblZdbsInfoTpl" type="text/x-jquery-tmpl">
				<tr>	
					<td class="text-center">{{= lbmc}}</td>
					<td class="text-left">{{= fxxlb}}</td>
					<td class="text-center">{{= fxdj}}</td>
					<td class="text-center">{{= zk_display}}</td>
					<td class="text-center">{{= fxyj}}</td>
					<td class="text-center">{{= fxry_display}}</td>
					<td class="text-center">{{= shry_display}}</td>
					<td class="text-center">
					<a href="javascript:void(0);"  data-key='{{= wid}}' data-option='editZdbs' class="text-danger"><i class="icon-edit"></i></a>
					<a href="javascript:void(0);" data-key='{{= wid}}' data-option='deleteZdbs' class="text-danger"><i class="icon-trash"></i></a></td>
				</tr>
	 </script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/system/fxxmInfo.js"></script>
</body>
</html>