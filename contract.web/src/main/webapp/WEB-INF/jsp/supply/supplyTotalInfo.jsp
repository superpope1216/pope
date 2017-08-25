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
					<li class="active">耗材领用管理</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<form action="#" method="post">
							<div class="search">
								<input type="text" class="text" name="topic"
									placeholder="品名" class="queryCondition"> &nbsp;
								<button class="btn btn-primary btnQuery" type="button"
									id="btnQuery">查询</button>
							</div>
						</form>
					</div>
				</div>
				<div class="panel">
					<div class="panel-body">
						<table class="table table-bordered" id="mainTable">
							<thead>
								<tr>
									<th class="text-center">消耗品名</th>
									<th class="text-center">类别</th>
									<th class="text-center">数量</th>
									<th class="text-center">数量单位</th>
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

	<div class="modal fade" id="modelSlbSupplyInfo">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">领用</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="slbForm">
						<div class="form-group">
							<input type="hidden" name="wid" value=""> <input
								type="hidden" name="hcid" value=""> <label for="name"
								class="col-sm-2 ">分类</label>
							<div class="col-md-8 col-sm-8">
								<p class="form-control-static" name="hcfl"></p>
							</div>

						</div>
						<div class="form-group">
							<label for="gh" class="col-sm-2 ">品名</label>
							<div class="col-md-8 col-sm-8">
								<p class="form-control-static" name="pm"></p>
							</div>
						</div>
						<div class="form-group">
							<label for="gh" class="col-sm-2 ">可领用数量</label>
							<div class="col-md-8 col-sm-8">
								<p class="form-control-static" name="kc"></p>
							</div>
						</div>
						<div class="form-group">
							<label for="gh" class="col-sm-2 required">领用数量</label>
							<div class="col-md-8 col-sm-8">

								<input type="text" class="form-control" name="lysl"
									placeholder="请输入领用数量" required>
							</div>
						</div>
						<div class="form-group">
							<label for="gh" class="col-sm-2 required">归还数量</label>
							<div class="col-md-8 col-sm-8">

								<input type="text" class="form-control" name="ghsl"
									placeholder="请输入归还数量" required>
							</div>
						</div>
						<div class="form-group">
							<label for="gh" class="col-sm-2">备注</label>
							<div class="col-md-8 col-sm-8">

								<input type="text" class="form-control" name="bz"
									placeholder="请输入备注" required>
							</div>
						</div>
					</form>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary"
							id="btnSaveSlbSupplyInfo">申请</button>
					</div>
				</div>
			</div>
		</div>
	</div>



	<div class="modal fade" id="modelGmbSupplyInfo">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">购买</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="gbForm">
						<div class="form-group">
							<input type="hidden" name="wid" value=""> <input
								type="hidden" name="hcid" value=""> <label for="name"
								class="col-sm-2 ">分类</label>
							<div class="col-md-8 col-sm-8">
								<p class="form-control-static" name="hcfl"></p>
							</div>

						</div>
						<div class="form-group">
							<label for="gh" class="col-sm-2">品名</label>
							<div class="col-md-8 col-sm-8">
								<p class="form-control-static" name="pm"></p>
							</div>
						</div>
						<div class="form-group">
							<label for="gh" class="col-sm-2 required">申购数量</label>
							<div class="col-md-8 col-sm-8">

								<input type="text" class="form-control" name="lysl"
									placeholder="请输入申购数量" required>
							</div>
						</div>
						<div class="form-group">
							<label for="gh" class="col-sm-2">备注</label>
							<div class="col-md-8 col-sm-8">

								<input type="text" class="form-control" name="bz"
									placeholder="请输入备注" required>
							</div>
						</div>
					</form>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary"
							id="btnSaveGmbSupplyInfo">申请</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="modelShbSupplyInfo">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">损坏</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="shbForm">
						<div class="form-group">
							<input type="hidden" name="wid" value=""><input
								type="hidden" name="hcid" value=""> <label for="name"
								class="col-sm-2 ">分类</label>
							<div class="col-md-8 col-sm-8">
								<p class="form-control-static" name="hcfl"></p>
							</div>

						</div>
						<div class="form-group">
							<label for="gh" class="col-sm-2">品名</label>
							<div class="col-md-8 col-sm-8">
								<p class="form-control-static" name="pm"></p>
							</div>
						</div>
						<div class="form-group">
							<label for="gh" class="col-sm-2 required">申购数量</label>
							<div class="col-md-8 col-sm-8">

								<input type="text" class="form-control" name="lysl"
									placeholder="请输入申购数量" required>
							</div>
						</div>
						<div class="form-group">
							<label for="gh" class="col-sm-2">备注</label>
							<div class="col-md-8 col-sm-8">

								<input type="text" class="form-control" name="bz"
									placeholder="请输入备注" required>
							</div>
						</div>
					</form>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary"
							id="btnSaveShbSupplyInfo">申请</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	

	<script id="tblSupplyInfoTpl" type="text/x-jquery-tmpl">
				<tr>
				    <td class="text-center">{{= pm}}</td>
					<td class="text-center">{{= hcfl_display}}</td> 
					<td class="text-left">{{= kc}}</td>
					<td class="text-left">{{= sldw_display}}</td>
					<td class="text-center">
						<div class="btn-group">
							<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="btnView" data-key="{{= wid}}">详</button>
          					
        				</div>
					</td>
				</tr>
			</script>
	<script type="text/javascript" >
    	var buttonsPermission="${buttons}";
    </script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/supply/supplyTotalInfo.js"></script>
</body>
</html>