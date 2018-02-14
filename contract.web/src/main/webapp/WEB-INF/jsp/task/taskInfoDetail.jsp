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
					<li><a href="${pageContext.request.contextPath}/task/index?open=150&select=160">任务管理</a></li>
					<li class="active">任务详情</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<table style="width: 100%; margin-top: 1px;">
							<tr>
								<td class="td-left-bold">
									<h3>
										<span class="span-left-border">任务信息</span>
									</h3>
								</td>
								<td align="right">
									<button class="btn btn-default btnQuery"
								style="float: right; margin-left: 5px;" id="btnBack">返回</button>
								</td>
							</tr>
						</table>
						<form class="form-horizontal" id="queryTaskForm">
						<table class="mainTable">
								<tr>
									<td class="tbl-two-text">
										任务名称			
									</td>
									<td class="tbl-two-edit-value">
										<p class="form-control-static" name="rwmc"></p>
									</td>
									<td class="tbl-two-text">
										任务编号			
									</td>
									<td class="tbl-two-edit-value">
										<p class="form-control-static" name="rwbh"></p>
									</td>
								</tr>
								<tr>
									<td class="tbl-two-text">
										样品批次			
									</td>
									<td class="tbl-two-edit-value">
										<p class="form-control-static" name="ypph"></p>
									</td>
									<td class="tbl-two-text">
										任务状态			
									</td>
									<td class="tbl-two-edit-value">
										<p class="form-control-static" name="rwzt_display"></p>
									</td>
								</tr>
								<tr>
									<td class="tbl-two-text">
										计划开始时间			
									</td>
									<td class="tbl-two-edit-value">
										<p class="form-control-static" name="jhkssj"></p>
									</td>
									<td class="tbl-two-text">
										计划结束时间			
									</td>
									<td class="tbl-two-edit-value">
										<p class="form-control-static" name="jhjssj"></p>
									</td>
								</tr>
								<tr>
									<td class="tbl-two-text">
										实际开始时间			
									</td>
									<td class="tbl-two-edit-value">
										<p class="form-control-static" name="sjkssj"></p>
									</td>
									<td class="tbl-two-text">
										实际结束时间			
									</td>
									<td class="tbl-two-edit-value">
										<p class="form-control-static" name="sjjssj"></p>
									</td>
								</tr>
								<tr>
									<td class="tbl-two-text">
										任务分析人		
									</td>
									<td class="tbl-two-edit-value">
										<p class="form-control-static" name="rwfpr_display"></p>
									</td>
									<td class="tbl-two-text">
										分析完成时间			
									</td>
									<td class="tbl-two-edit-value">
										<p class="form-control-static" name="jcwcsj"></p>
									</td>
								</tr>
								<tr>
									<td class="tbl-two-text">
										任务审核人		
									</td>
									<td class="tbl-two-edit-value">
										<p class="form-control-static" name="rwshr_display"></p>
									</td>
									<td class="tbl-two-text">
										审核完成时间			
									</td>
									<td class="tbl-two-edit-value">
										<p class="form-control-static" name="shwcsj"></p>
									</td>
								</tr>
								<tr>
									<td class="tbl-two-text">
										分析项	
									</td>
									<td class="tbl-two-edit-value">
										<p class="form-control-static" name="fxxm_display"></p>
									</td>
									<td class="tbl-two-text">
										备注	
									</td>
									<td class="tbl-two-edit-value">
										<p class="form-control-static" name="bz"></p>
									</td>
								</tr>
								<tr>
									<td class="tbl-two-text">
										附件
									</td>
									<td class="tbl-two-edit-value" colspan="3">
										<a href="javascript:void(0)" id="btnPrint">任务检测申请单</a>
									</td>
								</tr>
								
								
						</table>
						</form>
					</div>
					
				</div>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<table style="width: 100%; margin-top: 1px;">
							<tr>
								<td class="td-left-bold">
									<h3>
										<span class="span-left-border">子任务信息</span>
									</h3>
								</td>
								<td align="right">
									
							<button class="btn btn-primary btnQuery"
								style="float: right; margin-left: 5px; display: none;"
								id="btnSave">提交</button>

							<select id="selRwzt" class="form-control"
								style="float: right; width: 150px; display: none;">
								<option value=''>批量选择任务状态</option>
							</select>
								</td>
							</tr>
						</table>
						<table class="mainTable table-hover" id="mainTable">
							<thead>
								<tr>
									<%
										String flag = request.getAttribute("flag").toString();
										if ("examine".equals(flag)) {
									%>
									<td class="text-center" style="width: 80px;"><input
										type="checkbox" name="selAll" /></td>
									<%
										}
									%>
									<td class="text-center">样品编号</td>
									<!-- <td class="text-center">样品批次号</td> -->
									<td class="text-center">样品原有编号</td>
									<td class="text-center">样品性质</td>
									<td class="text-center">样品二维码</td>
									<td class="text-center">分析项目</td>
									<td class="text-center">任务状态</td>
									<%
										if ("examine".equals(flag)) {
									%>
									<td class="text-center">操作</td>
									<%
										}
									%>
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
		var pwid = "${wid}";
		var flag = "${flag}";//编辑还是查看
	</script>
	<script id="tblDetailInfoTpl" type="text/x-jquery-tmpl">
				
			</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/task/taskInfoDetail.js"></script>
</body>
</html>