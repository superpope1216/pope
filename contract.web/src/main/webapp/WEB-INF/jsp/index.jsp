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
					<li class="active">首页</li>
			</ol>
		</div>
		<div class="wrapper">
			<div class="panel">
				<div class="panel-body">
						<form action="#" method="post">
						<div class="search">
   							搜索名称：
   								<input type="text" class="text" name="topic" placeholder="搜索名称" class="queryCondition">
   							
   							&nbsp;<button class="btn btn-primary"  class="btnQuery">查询</button>  
   						</div>
					</form>
				</div>
			</div>

			<div class="panel">
				<div class="panel-body">
					<div class="pull-left"><button class="btn btn-primary" style="width:100px;">新  建</button></div>
					<div class="pull-right"><button class="btn btn-primary" style="width:100px;margin-left:10px;">导入</button>&nbsp;&nbsp;</div>
					&nbsp;&nbsp;<div class="pull-right" >&nbsp;&nbsp;<button class="btn btn-primary" style="width:100px;">导出</button></div>
					<br>					<br>
					<table class="table table-bordered table-hover">
				        <thead>
				          	<tr>
				          		<th width="40" class="text-center"><input type="checkbox" name="checkbox"></th>
					            <th width="50" class="text-center">ID</th>
					            <th>栏目名称</th>
					            <th width="200" class="text-center">上级栏目</th>
					            <th width="100" class="text-center">是否启用</th>
					            <th width="150" class="text-center">更新日期</th>
					            <th width="140" class="text-center">操作</th>
				          	</tr>
				        </thead>
				        <tbody>
				          	<tr>
					          	<td class="text-center"><input type="checkbox" name="checkbox"></td>
					            <td class="text-center">1</td>
					            <td>这是栏目名称</td>
					            <td class="text-center">--</td>
					            <td class="text-center">
									<div class="btn-group">
          								<button type="button" class="btn btn-xs btn-primary">启用</button>
          								<button type="button" class="btn btn-xs">禁用</button>
        							</div>
					            </td>
					            <td class="text-center">2016-06-05 16:20</td>
					            <td class="text-center">
									<button type="button" class="btn btn-sm btn-success"><i class="icon-edit"></i> 编辑</button>
									<button type="button" class="btn btn-sm btn-danger"><i class="icon-trash"></i> 删除</button>
					            </td>
				          	</tr>
				          	<tr>
					          	<td class="text-center"><input type="checkbox" name="checkbox"></td>
					            <td class="text-center">1</td>
					            <td>这是栏目名称</td>
					            <td class="text-center">--</td>
					            <td class="text-center">
									<div class="btn-group">
          								<button type="button" class="btn btn-xs btn-primary">启用</button>
          								<button type="button" class="btn btn-xs">禁用</button>
        							</div>
					            </td>
					            <td class="text-center">2016-06-05 16:20</td>
					            <td class="text-center">
									<button type="button" class="btn btn-sm btn-success"><i class="icon-edit"></i> 编辑</button>
									<button type="button" class="btn btn-sm btn-danger"><i class="icon-trash"></i> 删除</button>
					            </td>
				          	</tr>
				          	<tr>
					          	<td class="text-center"><input type="checkbox" name="checkbox"></td>
					            <td class="text-center">1</td>
					            <td>这是栏目名称</td>
					            <td class="text-center">--</td>
					            <td class="text-center">
									<div class="btn-group">
          								<button type="button" class="btn btn-xs btn-primary">启用</button>
          								<button type="button" class="btn btn-xs">禁用</button>
        							</div>
					            </td>
					            <td class="text-center">2016-06-05 16:20</td>
					            <td class="text-center">
									<button type="button" class="btn btn-sm btn-success"><i class="icon-edit"></i> 编辑</button>
									<button type="button" class="btn btn-sm btn-danger"><i class="icon-trash"></i> 删除</button>
					            </td>
				          	</tr>
				          	<tr>
					          	<td class="text-center"><input type="checkbox" name="checkbox"></td>
					            <td class="text-center">1</td>
					            <td>这是栏目名称</td>
					            <td class="text-center">--</td>
					            <td class="text-center">
									<div class="btn-group">
          								<button type="button" class="btn btn-xs btn-primary">启用</button>
          								<button type="button" class="btn btn-xs">禁用</button>
        							</div>
					            </td>
					            <td class="text-center">2016-06-05 16:20</td>
					            <td class="text-center">
									<button type="button" class="btn btn-sm btn-success"><i class="icon-edit"></i> 编辑</button>
									<button type="button" class="btn btn-sm btn-danger"><i class="icon-trash"></i> 删除</button>
					            </td>
				          	</tr>
				          	<tr>
					          	<td class="text-center"><input type="checkbox" name="checkbox"></td>
					            <td class="text-center">1</td>
					            <td>这是栏目名称</td>
					            <td class="text-center">--</td>
					            <td class="text-center">
									<div class="btn-group">
          								<button type="button" class="btn btn-xs btn-primary">启用</button>
          								<button type="button" class="btn btn-xs">禁用</button>
        							</div>
					            </td>
					            <td class="text-center">2016-06-05 16:20</td>
					            <td class="text-center">
									<button type="button" class="btn btn-sm btn-success"><i class="icon-edit"></i> 编辑</button>
									<button type="button" class="btn btn-sm btn-danger"><i class="icon-trash"></i> 删除</button>
					            </td>
				          	</tr>
				          	<tr>
					          	<td class="text-center"><input type="checkbox" name="checkbox"></td>
					            <td class="text-center">1</td>
					            <td>这是栏目名称</td>
					            <td class="text-center">--</td>
					            <td class="text-center">
									<div class="btn-group">
          								<button type="button" class="btn btn-xs btn-primary">启用</button>
          								<button type="button" class="btn btn-xs">禁用</button>
        							</div>
					            </td>
					            <td class="text-center">2016-06-05 16:20</td>
					            <td class="text-center">
									<button type="button" class="btn btn-sm btn-success"><i class="icon-edit"></i> 编辑</button>
									<button type="button" class="btn btn-sm btn-danger"><i class="icon-trash"></i> 删除</button>
					            </td>
				          	</tr>
				          	<tr>
					          	<td class="text-center"><input type="checkbox" name="checkbox"></td>
					            <td class="text-center">1</td>
					            <td>这是栏目名称</td>
					            <td class="text-center">--</td>
					            <td class="text-center">
									<div class="btn-group">
          								<button type="button" class="btn btn-xs btn-primary">启用</button>
          								<button type="button" class="btn btn-xs">禁用</button>
        							</div>
					            </td>
					            <td class="text-center">2016-06-05 16:20</td>
					            <td class="text-center">
									<button type="button" class="btn btn-sm btn-success"><i class="icon-edit"></i> 编辑</button>
									<button type="button" class="btn btn-sm btn-danger"><i class="icon-trash"></i> 删除</button>
					            </td>
				          	</tr>
				          	<tr>
					          	<td class="text-center"><input type="checkbox" name="checkbox"></td>
					            <td class="text-center">1</td>
					            <td>这是栏目名称</td>
					            <td class="text-center">--</td>
					            <td class="text-center">
									<div class="btn-group">
          								<button type="button" class="btn btn-xs btn-primary">启用</button>
          								<button type="button" class="btn btn-xs">禁用</button>
        							</div>
					            </td>
					            <td class="text-center">2016-06-05 16:20</td>
					            <td class="text-center">
									<button type="button" class="btn btn-sm btn-success"><i class="icon-edit"></i> 编辑</button>
									<button type="button" class="btn btn-sm btn-danger"><i class="icon-trash"></i> 删除</button>
					            </td>
				          	</tr>
				          	<tr>
					          	<td class="text-center"><input type="checkbox" name="checkbox"></td>
					            <td class="text-center">1</td>
					            <td>这是栏目名称</td>
					            <td class="text-center">--</td>
					            <td class="text-center">
									<div class="btn-group">
          								<button type="button" class="btn btn-xs btn-primary">启用</button>
          								<button type="button" class="btn btn-xs">禁用</button>
        							</div>
					            </td>
					            <td class="text-center">2016-06-05 16:20</td>
					            <td class="text-center">
									<button type="button" class="btn btn-sm btn-success"><i class="icon-edit"></i> 编辑</button>
									<button type="button" class="btn btn-sm btn-danger"><i class="icon-trash"></i> 删除</button>
					            </td>
				          	</tr>
				          	<tr>
					          	<td class="text-center"><input type="checkbox" name="checkbox"></td>
					            <td class="text-center">1</td>
					            <td>这是栏目名称</td>
					            <td class="text-center">--</td>
					            <td class="text-center">
									<div class="btn-group">
          								<button type="button" class="btn btn-xs btn-primary">启用</button>
          								<button type="button" class="btn btn-xs">禁用</button>
        							</div>
					            </td>
					            <td class="text-center">2016-06-05 16:20</td>
					            <td class="text-center">
									<button type="button" class="btn btn-sm btn-success"><i class="icon-edit"></i> 编辑</button>
									<button type="button" class="btn btn-sm btn-danger"><i class="icon-trash"></i> 删除</button>
					            </td>
				          	</tr>
				          	<tr>
					          	<td class="text-center"><input type="checkbox" name="checkbox"></td>
					            <td class="text-center">1</td>
					            <td>这是栏目名称</td>
					            <td class="text-center">--</td>
					            <td class="text-center">
									<div class="btn-group">
          								<button type="button" class="btn btn-xs btn-primary">启用</button>
          								<button type="button" class="btn btn-xs">禁用</button>
        							</div>
					            </td>
					            <td class="text-center">2016-06-05 16:20</td>
					            <td class="text-center">
									<button type="button" class="btn btn-sm btn-success"><i class="icon-edit"></i> 编辑</button>
									<button type="button" class="btn btn-sm btn-danger"><i class="icon-trash"></i> 删除</button>
					            </td>
				          	</tr>
				          	<tr>
					          	<td class="text-center"><input type="checkbox" name="checkbox"></td>
					            <td class="text-center">1</td>
					            <td>这是栏目名称</td>
					            <td class="text-center">--</td>
					            <td class="text-center">
									<div class="btn-group">
          								<button type="button" class="btn btn-xs btn-primary">启用</button>
          								<button type="button" class="btn btn-xs">禁用</button>
        							</div>
					            </td>
					            <td class="text-center">2016-06-05 16:20</td>
					            <td class="text-center">
									<button type="button" class="btn btn-sm btn-success"><i class="icon-edit"></i> 编辑</button>
									<button type="button" class="btn btn-sm btn-danger"><i class="icon-trash"></i> 删除</button>
					            </td>
				          	</tr>
				          	<tr>
					          	<td class="text-center"><input type="checkbox" name="checkbox"></td>
					            <td class="text-center">1</td>
					            <td>这是栏目名称</td>
					            <td class="text-center">--</td>
					            <td class="text-center">
									<div class="btn-group">
          								<button type="button" class="btn btn-xs btn-primary">启用</button>
          								<button type="button" class="btn btn-xs">禁用</button>
        							</div>
					            </td>
					            <td class="text-center">2016-06-05 16:20</td>
					            <td class="text-center">
									<button type="button" class="btn btn-sm btn-success"><i class="icon-edit"></i> 编辑</button>
									<button type="button" class="btn btn-sm btn-danger"><i class="icon-trash"></i> 删除</button>
					            </td>
				          	</tr>
				        </tbody>
				        <tfoot>
							<tr>
				          		<th width="40" class="text-center"><input type="checkbox" name="checkbox"></th>
					            <th colspan="8">
									<button type="button" class="btn btn-danger"><i class="icon-trash"></i> 删除</button>
					            </th>
					            
				          	</tr>
				        </tfoot>
				    </table>
				    <div class="pull-right">
										<div id='pageInfo' class="pagination"></div>
									</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/pageJs/index.js"></script>
</body>
</html>