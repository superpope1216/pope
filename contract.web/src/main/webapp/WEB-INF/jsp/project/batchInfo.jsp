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
					<li class="active">用户管理</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<form action="#" method="post">
							<div class="search">


								<input type="text" class="text" name="topic"
									placeholder="送样人/样品批次号/样品编号" class="queryCondition"> &nbsp;
								<button class="btn btn-primary btnQuery" type="button" id="btnQuery">查询</button>
							</div>
						</form>
					</div>
				</div>
				<div class="panel">
					<div class="panel-body">
						<div class="pull-left">
							<button class="btn btn-primary btnQuery" id="btnQcht">起草合同</button>
							<button class="btn btn-primary btnQuery" id="btnFqrw">发起任务</button>
						</div>
						<div class="pull-right">
							<button class="btn btn-primary btnQuery" id="btnNew">新 建</button>
							<button class="btn btn-primary" style="width: 100px; margin-left: 10px;">导入</button>
							<button class="btn btn-primary btnQuery">导出</button>
						</div>
						
						<br> <br>
						<table class="table table-bordered"
							id="mainTable">
							<thead>
								<tr>
									<th style="width:80px;" class="text-center">
										<input type="checkbox" name="selAll">
									</th>
									<th class="text-center">样品批次</th>
									<th class="text-center">类别</th>
									<th class="text-center">送样人</th>
									<th class="text-center">数量</th>
									<th class="text-center">单位</th>
									<th class="text-center">存放地</th>
									<th class="text-center">对方单位</th>
									<th class="text-center">批次状态</th>
									<th class="text-center">送样时间</th>
									<th style="width:160px;" class="text-center">操作</th>
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
		<div class="modal-dialog modal-lg">
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
								for="name" class="col-sm-2 required">人员名称</label>
							<div class="col-md-4 col-sm-4">
								<input type="text" class="form-control" name="name"
									placeholder="请输入人员名称" required>
							</div>
							<label for="gh" class="col-sm-2 required">员工号</label>
							<div class="col-md-4 col-sm-4">
								<input type="text" class="form-control" name="gh"
									placeholder="请输入员工号" required>
							</div>
						</div>
						<div class="form-group">
							<label for="phone" class="col-sm-2 required">手机号</label>
							<div class="col-md-4 col-sm-4">
								<input type="text" class="form-control" name="phone"
									placeholder="请输入手机号" required>
							</div>
							<label for="email" class="col-sm-2 required">邮箱地址</label>
							<div class="col-md-4 col-sm-4">
								<input type="text" class="form-control" name="email"
									placeholder="请输入邮箱地址" required>
							</div>
						</div>
						<div class="form-group">
							<label for="department" class="col-sm-2 required">部门信息</label>
							<div class="col-md-4 col-sm-4">
								<div class="input-group">
									<input type="hidden" name="department" id="department" value="" />
									<input type="text" class="form-control" readonly
										id="txtDepartment" name="txtDepartment" placeholder="请选择部门信息"
										required> <span class="input-group-addon"
										id="btnSelectBm"><i class="icon caret"></i></span>

								</div>
							</div>
							<label for="team" class="col-sm-2 required">科室小组</label>
							<div class="col-md-4 col-sm-4">
								<select id="team" class="form-control" name="team"  required placeholder="请选择科室小组"></select> 
							</div>
						</div>
						<div class="form-group">
							<label for="birthday" class="col-sm-2 required">出生年月</label>
							<div class="col-md-4 col-sm-4">
								<input type="text" class="form-control" name="birthday"
									placeholder="请输入出生年月" onClick="WdatePicker()" required>
							</div>
							<label for="degree" class="col-sm-2 required">学位</label>
							<div class="col-md-4 col-sm-4">
								<input type="text" class="form-control" name="degree"
									placeholder="请输入学位" required>
							</div>
						</div>
						<div class="form-group">

							<label for="jobcategory" class="col-sm-2 required">职位类别</label>
							<div class="col-md-4 col-sm-4">
								<select class="form-control" name="jobcategory"
									placeholder="请输入职位类别" required>
							</div>
							<label for="job" class="col-sm-2 required">职位</label>
							<div class="col-md-4 col-sm-4">
								<input type="text" class="form-control" name="job"
									placeholder="请输入职位" required>
							</div>

						</div>
						<div class="form-group">
							<label for="contractvalidity" class="col-sm-2 required">合同有效期</label>
							<div class="col-md-4 col-sm-4">
								<input type="text" class="form-control" name="contractvalidity"
									placeholder="请输入合同有效期" required>
							</div>
							<label for="contractvalidity" class="col-sm-2 required">合同签订时间</label>
							<div class="col-md-4 col-sm-4">
								<input type="text" class="form-control" name="contracttime"
									onClick="WdatePicker()" placeholder="请输入合同签订时间" required>
							</div>

						</div>
						<div class="form-group">
							<label for="1" class="col-sm-2 required">权限信息</label>
							<div class="col-md-4 col-sm-4">
									<select id="userInfoRole" name="userInfoRole" class="form-control"
												multiple="multiple" required>
												<option value=''>--请选择--</option>
									</select>
							</div>
						</div>

					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="btnSaveUserInfo">保存</button>
				</div>
			</div>
		</div>
	</div>

	<div id="menuContent" class="menuContent"
		style="display: none; z-index:999999999;background: #f1f1f1; position: absolute;">
		<ul id="treeDemo" class="ztree" style="margin-top: 0; width: 100%;"></ul>
	</div>

	<script id="tblUserInfoTpl" type="text/x-jquery-tmpl">
				<tr>
					<td class="text-center"><input type="checkbox" name="chkSingle" value="{{= wid}}"></td>
				    <td class="text-center">{{= pcmc}}</td>
					<td class="text-center">{{= pclb_display}}</td>
					<td class="text-center">{{= syr}}</td>
					<td class="text-left">{{= sl}}</td>
					<td class="text-left">{{= sldw_display}}</td>
					<td class="text-left">{{= cfd}}</td>
					<td class="text-left">{{= gys}}</td>
					<td class="text-left">{{= pczt_display}}</td>
					<td class="text-left">{{= pczt_sysj}}</td>
					<td class="text-center">
						<div class="btn-group">
          					<button type="button" class="btn btn-xs btn-primary" data-option="copy" data-key="{{= wid}}">复</button>
						    <button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="detail" data-key="{{= wid}}">详</button>
							<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="lu" data-key="{{= wid}}">录</button>
							<button type="button" style="margin-left:4px;" class="btn btn-xs btn-primary" data-option="gui" data-key="{{= wid}}">归</button>
          					<button type="button" style="margin-left:4px;" class="btn btn-xs btn-danger" data-option="delete" data-key="{{= wid}}"><i class="icon icon-times"></i></button>
        				</div>
					</td>
				</tr>
			</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/project/batchInfo.js"></script>
</body>
</html>