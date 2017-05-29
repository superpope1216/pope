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
					<li class="active">权限管理</li>
				</ol>
			</div>
			<div class="wrapper">
				<div class="col-md-3 col-sm-5">
					<div class="panel">
						<div class="panel-heading">角色</div>
						<div class="panel-body">
							<table class="table table-bordered table-hover">
								<thead>
									<tr>
										<th width="50" class="text-center">名称</th>
										<th width="100">描述</th>
									</tr>
								</thead>
								<tbody id="tblUserInfo">
								</tbody>
							</table>
						</div>

					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>