<%@page import="com.pope.contract.code.MenuLevel"%>
<%@page import="com.pope.contract.entity.system.Permission"%>
<%@page import="com.pope.contract.util.CommonUtil"%>
<%@page import="com.pope.contract.entity.system.Role"%>
<%@page import="java.util.List"%>
<%@page import="com.pope.contract.util.ConstantUtil"%>
<%@page import="com.pope.contract.dto.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/pageJs/left.js"></script>
<aside class="sidebar">

	<div class="col-sm-12 sidebar-image">
		<div class="col-sm-5">
			<img src="http://zui.sexy/docs/img/img2.jpg" class="img-circle"
				alt="圆形图片">
		</div>
		<div class="col-sm-7 clolor-white">我的测试</div>
	</div>
	<div class="sidebar-menu">
		<%
			LoginInfo loginInfo = (LoginInfo) session.getAttribute(ConstantUtil.USER_SESSION_NAME);
			Role currentRole = (Role) session.getAttribute(ConstantUtil.USER_CURRENT_ROLE);
			Role role = currentRole;
			List<Permission> permissions = role.getPermissions();
			boolean findSecond = false, findThree = false;

			if (CommonUtil.isNotEmptyList(permissions)) {
				StringBuilder secondMenu = new StringBuilder();
				StringBuilder threeMenu = new StringBuilder();
				String secondUrl = "", secondName = "";
				for (Permission per : permissions) {
					if (CommonUtil.isNotEmptyList(per.getList())) {
		%>
		<div class='item vertical open active'>
			<a href='#'> <i class='icon icon-cogs'></i> <span><%=per.getName()%></span>
				<span class='arrow'></span></a>
			<%
				for (Permission per2 : per.getList()) {
			%>
			<div class='vertical-menu'>
				<a href='${pageContext.request.contextPath}<%=per2.getUrl() %>'><%=per2.getName()%></a>
			</div>
			<%
				}
						} else {
			%>
			<div class='item vertical  '>
				<a href='${pageContext.request.contextPath}<%=per.getUrl() %>'>
					<i class='icon icon-cogs'></i> <span><%=per.getName()%></span>
				</a>
			</div>
			<%
				}
					}
				}
			%>
		</div>
</aside>