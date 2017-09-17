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
					<li class="active">新闻编辑</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="col-md-12 col-sm-12">
					<div class="panel">
						<div class="panel-body">
							<form class="form-horizontal" id="zdbsForm">
								<div class="form-group">
									<input type="hidden" name="wid" value=""><label
										for="code" class="col-sm-2 required">新闻名称</label>
									<div class="col-md-8 col-sm-8">
										<input type="text" class="form-control" name="name"
											placeholder="请输入新闻名称" required>
									</div>

								</div>
								
								<div class="form-group">
									<input type="hidden" name="content"/>
									<label for="orderby" class="col-sm-2 required">新闻内容</label>
									<div class="col-md-8 col-sm-8">
										<div style="width: 100%;">
											<SCRIPT id="txtcontent" align="center" name="txtcontent"
												type=text/plain ></SCRIPT>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="code" class="col-sm-2 required">开始时间</label>
									<div class="col-md-3 col-sm-3">
										<input type="text" class="form-control" name="beginTime"
											placeholder="请输入开始时间" onClick="WdatePicker()" required>
									</div>
									<label for="code" class="col-sm-2 required">结束时间</label>
									<div class="col-md-3 col-sm-3">
										<input type="text" class="form-control" name="endTime"
											placeholder="请输入结束时间" onClick="WdatePicker()" required>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-10 col-sm-10" style="text-align:center;margin:0 auto;">
									
										<button class="btn btn-primary btnQuery" type="button"
											id="btnSave">保存</button>
											<button class="btn btn-default btnQuery" type="button"
											id="btnBack">返回</button>
									</div>
								</div>

							</form>

						</div>

					</div>
				</div>
			</div>
			<script type="text/javascript">
				var wid="${wid}";
			</script>
			<script type="text/javascript"
				src="${pageContext.request.contextPath}/static/pageJs/system/newsedit.js"></script>
</body>
</html>