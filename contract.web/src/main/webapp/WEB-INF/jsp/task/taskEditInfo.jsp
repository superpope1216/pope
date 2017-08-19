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
					<li><a href="#">任务管理</a></li>
					<li class="active">任务操作</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<form class="form-horizontal" id="taskForm"
							style="margin-top: 10px;">
							<div class="form-group">
								<label for="name" class="col-sm-2 required">样品批号</label>
								<div class="col-md-4 col-sm-4">
									<input type="text" class="form-control" name="ypph" readonly required>
								</div>
							</div>
							<div class="form-group">
								<label for="department" class="col-sm-2 required">分析项目</label>
								<div class="col-md-4 col-sm-4">
									<select name="fxxm" class="form-control" required>
										<option value=''>--请选择--</option>
									</select>
								</div>
							</div>
							<!-- 
							<div class="form-group">
								<label for="department" class="col-sm-2 required">任务分配人</label>
								<div class="col-md-4 col-sm-4">
									<select name="rwfpr" class="form-control" required>
										<option value=''>--请选择--</option>
									</select>
								</div>
							</div>
							 -->
							<div class="form-group">
								<label for="department" class="col-sm-2 required">计划开始时间</label>
								<div class="col-md-4 col-sm-4">
									<input type="text" class="form-control" name="jhkssj"
										placeholder="" onClick="WdatePicker()" required>
								</div>
							</div>
							<div class="form-group">
								<label for="department" class="col-sm-2 required">计划完成时间</label>
								<div class="col-md-4 col-sm-4">
									<input type="text" class="form-control" name="jhjssj"
										placeholder="" onClick="WdatePicker()" required>
								</div>
							</div>
						</form>
						<div>
							<button class="btn btn-primary btnQuery" type="button"
								id="btnSave">保存</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var pcid="${pcid}";
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/task/taskEditInfo.js"></script>
</body>
</html>