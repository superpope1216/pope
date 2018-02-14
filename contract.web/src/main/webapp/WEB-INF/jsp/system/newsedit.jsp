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
								<table style="width: 100%" class="mainTable">
									<tr>
										<td class="tbl-one-text" style="width:15%;"><input type="hidden" name="wid"
											value="">新闻名称<span class="myrequrire">*</span></td>
										<td class="tbl-one-edit-value" style="width:85%;"><input type="text"
											class="form-control" name="name" placeholder="请输入新闻名称"
											required></td>
									</tr>
									<tr>
										<td class="tbl-one-text" style="width:15%;">新闻内容<span class="myrequrire">*</span></td>
										<td class="tbl-one-edit-value"  style="width:85%;"><div style="width: 100%;">
												<SCRIPT id="txtcontent" align="center" name="txtcontent"
													type=text/plain></SCRIPT>
											</div></td>
									</tr>
									<tr>
										<td class="tbl-one-text" style="width:15%;">开始时间<span class="myrequrire">*</span></td>
										<td class="tbl-one-edit-value"  style="width:85%;"><input type="hidden" name="content" /><input type="text" class="form-control" name="beginTime"
											placeholder="请输入开始时间" onClick="WdatePicker()" required></td>
									</tr>
									<tr>
										<td class="tbl-one-text" style="width:15%;">结束时间<span class="myrequrire">*</span></td>
										<td class="tbl-one-edit-value"  style="width:85%;"><input type="text" class="form-control" name="endTime"
											placeholder="请输入结束时间" onClick="WdatePicker()" required></td>
									</tr>
								</table>
								<div class="form-group">
									<div class="col-md-10 col-sm-10"
										style="text-align: center; margin: 0 auto;">

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
				var wid = "${wid}";
			</script>
			<script type="text/javascript"
				src="${pageContext.request.contextPath}/static/pageJs/system/newsedit.js"></script>
</body>
</html>