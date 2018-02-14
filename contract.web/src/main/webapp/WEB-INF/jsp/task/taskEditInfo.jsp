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
						<table style="width: 100%; margin-top: 5px;">
							<tr>
								<td class="td-left-bold">
									<h3>
										<span class="span-left-border">任务详情</span>
									</h3>
								</td>
								<td align="right">
									<button class="btn btn-primary btnQuery" type="button"
										id="btnSave">保存</button>
								</td>
							</tr>
						</table>
						<form class="form-horizontal" id="taskForm"
							style="margin-top: 10px;">
							<table class="mainTable">
								<tr>
									<input type="hidden" name="wid" value=""/>
									<td class="tbl-one-text" style="width:20%;"><input type="hidden" name="pcwid"
										value=""> 样品批号<span class="myrequrire">*</span></td>
									<td class="tbl-one-edit-value" style="width:80%;"><input type="text"
										class="form-control" name="ypph" readonly required></td>
								</tr>
								<tr>
									<td class="tbl-one-text" style="width:20%;">分析项目<span class="myrequrire">*</span>
									</td>
									<td class="tbl-one-edit-value" style="width:80%;"><select name="fxxm"
										class="form-control" required>
											<option value=''>--请选择--</option>
									</select></td>
								</tr>
								<tr>
									<td class="tbl-one-text" style="width:20%;">计划开始时间<span class="myrequrire">*</span>
									</td>
									<td class="tbl-one-edit-value" style="width:80%;"><input type="text"
										class="form-control" name="jhkssj" placeholder=""
										id="jhkssj" onClick="WdatePicker({maxDate:'#F{$dp.$D(\'jhjssj\')}'})" required></td>
								</tr>
								<tr>
									<td class="tbl-one-text" style="width:20%;">计划完成时间<span class="myrequrire">*</span>
									</td>
									<td class="tbl-one-edit-value" style="width:80%;"><input type="text"
										class="form-control" id="jhjssj" name="jhjssj" placeholder=""
										onClick="WdatePicker({minDate:'#F{$dp.$D(\'jhkssj\')}'})" required></td>
								</tr>
								<tr>
									<td class="tbl-one-text" style="width:20%;">分析人员<span class="myrequrire">*</span>
									</td>
									<td class="tbl-one-edit-value" style="width:80%;"><select name="rwfpr"
										class="form-control" required>
											<option value=''>--请选择--</option>
									</select></td>
								</tr>
								<tr>
									<td class="tbl-one-text" style="width:20%;">审核人员<span class="myrequrire">*</span>
									</td>
									<td class="tbl-one-edit-value" style="width:80%;"><select name="rwshr"
										class="form-control" required>
											<option value=''>--请选择--</option>
									</select></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var pcid = "${pcid}";
		var taskId="${taskId}";
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/task/taskEditInfo.js"></script>
</body>
</html>