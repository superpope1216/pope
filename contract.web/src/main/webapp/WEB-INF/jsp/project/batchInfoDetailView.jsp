<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/jsp/public/top.jsp"%>
<style type="text/css">
#userForm .form-group {
	margin-bottom: 0px;
}
</style>
</head>
<body>
	<div class="main">
		<%@ include file="/jsp/public/header.jsp"%>
		<%@ include file="/jsp/public/left.jsp"%>
		<div class="main-content">
			<div class="position">
				<ol class="breadcrumb">
					<li><a href="#"><i class="icon icon-home"></i> 位置</a></li>
					<li><a href="${pageContext.request.contextPath}/batch/index?open=&select=130">批次管理</a></li>
					<li class="active">样品批次详情</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<table style="width: 100%; margin-top: 5px;">
							<tr>
								<td class="td-left-bold">
									<h3>
										<span class="span-left-border">批次详情</span>
									</h3>
								</td>
								<td align="right">
									<button class="btn pull-right btn-primary btnQuery"
										type="button" id="btnTask">发起任务</button>
							</tr>
						</table>
						
						<form class="form-horizontal" id="userForm"
							style="margin-top: 10px;">
							<table style="width:100%" class="mainTable">
								<tr>
									<td class="tbl-text">
										类别
									</td>
									<td class="tbl-value">
										<p class="form-control-static" name="pclb_display"></p>
									</td>
									<td class="tbl-text">
										二级分类
									</td>
									<td class="tbl-value">
										<p class="form-control-static" name="ejfl"></p>
									</td>
									<td class="tbl-text">
										批次名称
									</td>
									<td class="tbl-value">
										<p class="form-control-static" name="pcmc"></p>
									</td>
									<td class="tbl-text">
										样品批号
									</td>
									<td class="tbl-value">
										<p class="form-control-static" name="ypph"></p>
									</td>
								</tr>
								<tr>
									<td class="tbl-text">
										数量
									</td>
									<td class="tbl-value">
										<p class="form-control-static" name="sl"></p>
									</td>
									<td class="tbl-text">
										品牌
									</td>
									<td class="tbl-value">
										<p class="form-control-static" name="pp_display"></p>
									</td>
									<td class="tbl-text">
										数量单位
									</td>
									<td class="tbl-value">
										<p class="form-control-static" name="sldw_display"></p>
									</td>
									<td class="tbl-text">
										存放地
									</td>
									<td class="tbl-value">
										<p class="form-control-static" name="cfd"></p>
									</td>
								</tr>
								<tr>
									<!-- <td class="tbl-text">
										单价
									</td>
									<td class="tbl-value">
										<p class="form-control-static" name="dj"></p>
									</td>
									<td class="tbl-text">
										货币单位
									</td>
									 
									<td class="tbl-value"><p class="form-control-static" name="hbdw_display"></p>
									</td>-->
									<td class="tbl-text">
										控制时间点
									</td>
									<td class="tbl-value"><p class="form-control-static" name="kzsjd"></p>
									</td>
									<td class="tbl-text">
										送样时间
									</td>
									<td class="tbl-value"><p class="form-control-static" name="sysj"></p>
									</td>
									<td class="tbl-text">
										送样人
									</td>
									<td class="tbl-value">
										<p class="form-control-static" name="syr"></p>
									<td class="tbl-text">
										送样单位
									</td>
									<td class="tbl-value"><p class="form-control-static" name="sydw_display"></p>
									</td>
								</tr>
								<tr>
									
									<td class="tbl-text">
										送样项目负责人
									</td>
									<td class="tbl-value"><p class="form-control-static" name="syxmfzr"></p>
									</td>
									<td class="tbl-text">
										审核时间
									</td>
									<td class="tbl-value"><p class="form-control-static" name="shsj"></p>
									</td>
										<td class="tbl-text">
										样品状态监控
									</td>
									<td class="tbl-value" colSpan="1">
										<p class="form-control-static" name="pczt_display"></p>
									</td>
									<td class="tbl-text">
										合同号
									</td>
									<td class="tbl-value" colSpan="1"><p class="form-control-static" name="hth"></p>
									</td>
								</tr>
								<tr>
									<td class="tbl-text">
										分析项目
									</td>
									<td class="tbl-value" colSpan="3">
										<p class="form-control-static" name="fxxm_display"></p>
									</td>
									<td class="tbl-text">
										备注
									</td>
									<td class="tbl-value" colSpan="3"><p class="form-control-static" name="bz"></p>
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

						<table style="width: 100%; margin-top: 5px;">
							<tr>
								<td class="td-left-bold">
									<h3>
										<span class="span-left-border">批次内样品详情</span>
									</h3>
								</td>
							</tr>
						</table>
						<table class="mainTable table-hover"
							id="mainTable">
							<thead>
								<tr>
									<td class="text-center">样品编号</td>
									<!-- <td class="text-center">样品批次号</td> -->
									<td class="text-center">样品原有编号</td>
									<td class="text-center">样品性质</td>
									<td class="text-center">样品二维码</td>
									<td class="text-center">分析项目</td>
								</tr>
							</thead>
							<tbody id="tblDetailInfo">
							</tbody>
						</table>
						<div class="pull-right">
							<div id='pageInfo' class="pagination"></div>
						</div>
					</div>
				</div>
			</div>

			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">

						<table style="width: 100%; margin-top: 5px;">
							<tr>
								<td class="td-left-bold">
									<h3>
										<span class="span-left-border">批次内关联任务</span>
									</h3>
								</td>
							</tr>
						</table>
						<div class="pull-right" style="margin-bottom: 10px;">
							<button class="btn btn-primary btnQuery" id="btnSubmit">提交审核</button>
							<button class="btn btn-primary btnQuery" style="width: 120px;"
								id="btnPrint">任务检测申请单</button>
						</div>
						<br>
						<table class="mainTable table-hover"
							id="mainTaskTable" style="margin-top: 10px;">
							<thead>
								<tr>
									<td class="text-center" style="width: 80px;"><input
										type="checkbox" name="selAll" /></td>
									<td class="text-center">任务名称</td>
									<td class="text-center">责任人</td>
									<td class="text-center">计划开始时间</td>
									<td class="text-center">计划结束时间</td>
									<td class="text-center">实际开始时间</td>
									<td class="text-center">实际结束时间</td>
									<td class="text-center">分析项目</td>
									<td class="text-center">任务审核人</td>
									<td class="text-center">任务状态</td>
									<td data-width="160px" class="text-center">操作</td>
								</tr>
							</thead>
							<tbody id="tblTaskDetailInfo">
							</tbody>
						</table>
						<div class="pull-right">
							<div id='taskPageInfo' class="pagination"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<script id="tblDetailInfoTpl" type="text/x-jquery-tmpl">
				<tr>
					<td class="text-center">{{= ypbh}}</td>
					
					<td class="text-left">{{= ypyybh}}</td>
					<td class="text-left">{{= ypxz}}</td>
					<td class="text-left">{{= ypewm}}</td>
					<td class="text-left">{{= fxxm_display}}</td>
				</tr>
			</script>
	<script type="text/javascript">
		var wid = "${wid}";
		var modifyType = "${type}";
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/project/batchInfoDetailView.js"></script>
</body>
</html>