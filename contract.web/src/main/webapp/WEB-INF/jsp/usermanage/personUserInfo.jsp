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
					<li class="active">用户个人信息</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<div class="pull-right">
							<button class="btn btn-primary" style="width: 100px; " id="btnModify">编辑</button>
						</div>
						<br><br>
						<div>
							<form class="form-horizontal" id="userViewForm">
								<div class="form-group">
									<label for="name" class="col-sm-2 ">人员名称</label>
									<div class="col-md-4 col-sm-4">
										<p class="form-control-static" name="name1"></p>
									</div>
									<label for="gh" class="col-sm-2">员工号</label>
									<div class="col-md-4 col-sm-4">
										<p class="form-control-static" name="gh"></p>
									</div>
								</div>
								<div class="form-group">
									<label for="phone" class="col-sm-2">手机号</label>
									<div class="col-md-4 col-sm-4">
										<p class="form-control-static" name="phone"></p>
									</div>
									<label for="email" class="col-sm-2">邮箱地址</label>
									<div class="col-md-4 col-sm-4">
										<p class="form-control-static" name="email"></p>
									</div>
								</div>
								<div class="form-group">
									<label for="department" class="col-sm-2 ">部门信息</label>
									<div class="col-md-4 col-sm-4">
										<p class="form-control-static" name="department"></p>
									</div>
									<label for="team" class="col-sm-2 ">科室小组</label>
									<div class="col-md-4 col-sm-4">
										<p class="form-control-static" name="team"></p>
									</div>
								</div>
								<div class="form-group">
									<label for="birthday" class="col-sm-2 ">出生年月</label>
									<div class="col-md-4 col-sm-4">
										<p class="form-control-static" name="birthday"></p>
									</div>
									<label for="degree" class="col-sm-2 ">学位</label>
									<div class="col-md-4 col-sm-4">
										<p class="form-control-static" name="degree"></p>
									</div>
								</div>
								<div class="form-group">

									<label for="jobcategory" class="col-sm-2 ">职位类别</label>
									<div class="col-md-4 col-sm-4">
										<p class="form-control-static" name="jobcategory"></p>
									</div>
									<label for="job" class="col-sm-2 ">职位</label>
									<div class="col-md-4 col-sm-4">
										<p class="form-control-static" name="job"></p>
									</div>

								</div>
								<div class="form-group">
									<label for="contractvalidity" class="col-sm-2 ">合同有效期</label>
									<div class="col-md-4 col-sm-4">
										<p class="form-control-static" name="contractvalidity"></p>
									</div>
									<label for="contractvalidity" class="col-sm-2 ">合同签订时间</label>
									<div class="col-md-4 col-sm-4">
										<p class="form-control-static" name="contracttime"></p>
									</div>

								</div>
							</form>
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
								<input type="text" class="form-control" name="name1"
									placeholder="请输入人员名称" required>
							</div>
							<label for="gh" class="col-sm-2 required">员工号</label>
							<div class="col-md-4 col-sm-4">
								<input type="text" class="form-control" readonly name="gh"
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
									placeholder="请输入职位类别" required></select>
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
		style="display: none; z-index: 999999999; background: #f1f1f1; position: absolute;">
		<ul id="treeDemo" class="ztree" style="margin-top: 0; width: 100%;"></ul>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/usermanage/personUserInfo.js"></script>
</body>
</html>