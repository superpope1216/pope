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
					<li class="active">字典表管理</li>
				</ol>
			</div>
			<div class="wrapper">

				<ul class="nav nav-tabs">
					<li class="active"><a data-tab href="#leaveFlowSet">请假流程</a></li>
					<li><a data-tab href="#tabContent2">标签2</a></li>
					<li><a data-tab href="#tabContent3">标签3</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="leaveFlowSet">
						<div class="panel">
							<div class="panel-body">
								<div class="pull-left">
									<button class="btn btn-primary btnQuery" id="btnNewLeave">新
										建</button>
								</div>
								<br> <br>
								<table class="table table-bordered datatable table-hover"
									id="userLeaveTable">
									<thead>
										<tr>
											<th class="text-center">步骤</th>
											<th class="text-center">审核角色</th>
											<th class="text-center">审核类型</th>
											<th data-width="130px" class="text-center">操作</th>
										</tr>
									</thead>
									<tbody id="tblUserLeaveTable">
									</tbody>
								</table>
								<div class="pull-right">
									<div id='userLeavePageInfo' class="pagination"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="tab-pane" id="tabContent2">
						<p>标签2的内容。</p>
					</div>
					<div class="tab-pane" id="tabContent3">
						<p>这是标签3的内容。</p>
					</div>
				</div>
			</div>

		</div>
	</div>
	</div>

	<div class="modal fade" id="modelEditLeaveInfo">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">关闭</span>
					</button>
					<h4 class="modal-title">请假流程设置</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="leaveExamineForm">
						<div class="form-group">
							<input type="hidden" name="wid" value="">
							<input type="hidden" name="type" value="1">
							 <label 	for="code" class="col-sm-2 required">步骤</label>
							<div class="col-md-8 col-sm-8">
								<input type="text" class="form-control" name="px"
									placeholder="请输入步骤" required>
							</div>
						</div>
						
						<div class="form-group">
							<label for="shtype" class="col-sm-2 required">类型</label>
							<div class="col-md-8 col-sm-8">
								<select name="shType" class="form-control">
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="col-sm-2 required">审核人员</label>
							<div class="col-md-8 col-sm-8">
								<select name="name" class="form-control">
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="btnSaveLeaveInfo">保存</button>
				</div>
			</div>
		</div>
	</div>
	<script id="tblUserLeaveInfoTpl" type="text/x-jquery-tmpl">
				<tr>	
					<td class="text-center"><input type="hidden" name="wid" value="{{= wid}}">{{= px}}</td>
					<td class="text-left">
						{{if sjzdName}}
							{{= sjzdName.name}}
						{{/if}}
						
					</td>
					<td class="text-center">
						{{if sjzdShType}}
							{{= sjzdShType.lbmc}}
						{{/if}}
					</td>
					<td class="text-center">
					<a href="javascript:void(0);"  data-key='{{= wid}}' data-option='editZdbs' class="text-danger"><i class="icon-edit"></i></a>
					<a href="javascript:void(0);" data-key='{{= wid}}' data-option='deleteZdbs' class="text-danger"><i class="icon-trash"></i></a></td>
				</tr>
	 </script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/system/flowset.js"></script>
</body>
</html>