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
					<li><a href="#">合同管理</a></li>
					<li class="active">合同审核</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="panel">
					<div class="panel-body">
						<ul class="nav nav-tabs">
							<li class="active"><a data-tab href="#dshContent">待审核</a></li>
							<li><a data-tab href="#jxzContent">进行中</a></li>
							<li><a data-tab href="#ywcContent">已完成</a></li>
							<li><a data-tab href="#shbtgContent">审核不通过</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="dshContent">
								<br>
								<table class="mainTable table-hover"
									id="mainTable">
									<thead>
										<tr>
											<td class="text-center">时间</td>
											<td class="text-center">合同名称</td>
											<td class="text-center">合同编号</td>
											<td class="text-center">合同类型</td>
											<td class="text-center">对方名称</td>
											<td class="text-center">对方账号</td>
											<td class="text-center">金额</td>
											<td data-width="80px" class="text-center">操作</td>
										</tr>
									</thead>
									<tbody id="tblTaskInfo">
									</tbody>
								</table>
								<div class="pull-right">
									<div id='pageInfo' class="pagination"></div>
								</div>
							</div>
							<div class="tab-pane" id="jxzContent">
								<br>
								<table class="mainTable table-hover"
									id="jxzTable">
									<thead>
										<tr>
											<td class="text-center">时间</td>
											<td class="text-center">合同名称</td>
											<td class="text-center">合同编号</td>
											<td class="text-center">合同类型</td>
											<td class="text-center">对方名称</td>
											<td class="text-center">对方账号</td>
											<td class="text-center">金额</td>
											<td data-width="80px" class="text-center">操作</td>
										</tr>
									</thead>
									<tbody id="tblJxzTaskInfo">
									</tbody>
								</table>
								<div class="pull-right">
									<div id='jxzPageInfo' class="pagination"></div>
								</div>
							</div>
							<div class="tab-pane" id="ywcContent">
								<br>
								<table class="mainTable table-hover"
									id="ywcTable">
									<thead>
										<tr>
											<td class="text-center">时间</td>
											<td class="text-center">合同名称</td>
											<td class="text-center">合同编号</td>
											<td class="text-center">合同类型</td>
											<td class="text-center">对方名称</td>
											<td class="text-center">对方账号</td>
											<td class="text-center">金额</td>
											<td data-width="80px" class="text-center">操作</td>
										</tr>
									</thead>
									<tbody id="tblYwcTaskInfo">
									</tbody>
								</table>
								<div class="pull-right">
									<div id='ywcPageInfo' class="pagination"></div>
								</div>
							</div>
							<div class="tab-pane" id="shbtgContent">
								<br>
								<table class="mainTable table-hover"
									id="btgTable">
									<thead>
										<tr>
											<td class="text-center">时间</td>
											<td class="text-center">合同名称</td>
											<td class="text-center">合同编号</td>
											<td class="text-center">合同类型</td>
											<td class="text-center">对方名称</td>
											<td class="text-center">对方账号</td>
											<td class="text-center">金额</td>
											<td data-width="80px" class="text-center">操作</td>
										</tr>
									</thead>
									<tbody id="tblBtgTaskInfo">
									</tbody>
								</table>
								<div class="pull-right">
									<div id='btgPageInfo' class="pagination"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/contract/contractInfoExamine.js"></script>
</body>
</html>