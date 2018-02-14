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
					<li class="active">新闻管理</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="col-md-12 col-sm-12">
					<div class="panel">
						<div class="panel-body">
							<div class="pull-left">
								<button class="btn btn-primary btnQuery" id="btnNew">新
									建</button>
							</div>
							<br> <br>
							<table class="mainTable table-hover"
								id="mainTable">
								<thead>
									<tr>
										<td class="text-center">新闻名称</td>
										<td class="text-center">开始时间</td>
										<td class="text-center">结束时间</td>
										<td class="text-center">上线状态</td>
										<td class="text-center">创建时间</td>
										<td data-width="130px" class="text-center">操作</td>
									</tr>
								</thead>
								<tbody id="tblZdbsInfo">
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
	</div>

	<script id="tblZdbsInfoTpl" type="text/x-jquery-tmpl">
				<tr>	
					<td class="text-center">{{= lbmc}}</td>
					<td class="text-left">{{= fxxlb}}</td>
					<td class="text-center">{{= fxdj}}</td>
					<td class="text-center">{{= zk_display}}</td>
					<td class="text-center">{{= fxyj}}</td>
					<td class="text-center">{{= fxry_display}}</td>
					<td class="text-center">{{= shry_display}}</td>
					<td class="text-center">
					<a href="javascript:void(0);"  data-key='{{= wid}}' data-option='editZdbs' class="text-danger"><i class="icon-edit"></i></a>
					<a href="javascript:void(0);" data-key='{{= wid}}' data-option='deleteZdbs' class="text-danger"><i class="icon-trash"></i></a></td>
				</tr>
	 </script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/pageJs/system/newsmanage.js"></script>
</body>
</html>