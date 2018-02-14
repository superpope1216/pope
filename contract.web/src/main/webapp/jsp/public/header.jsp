<%@page import="com.pope.contract.dto.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header class="header" style="background: #0288d1;">
	<div class="header-left">
		<!-- <div class="sidebar-toggle">
			<i class="icon icon-bars" style="color: white;"></i>
		</div> -->
		<div class="logo" style="color: white; height: 30px;">
			<img src="${pageContext.request.contextPath}/static/img/logo.png" style="height:30px;">
		</div>
	</div>
	<div style="float: left; color: white;">
		<div class="logo" style="color: white;margin-top:15px;">
			<span class="text-primary" style="color: white;">实验室管理系统</span>
		</div>

	</div>
	<div class="pull-right" style="margin-top: 15px;">
		<div class="dropdown">
			<%
				LoginInfo loginInfo2 = (LoginInfo) session.getAttribute(ConstantUtil.USER_SESSION_NAME);
				Role currentRole2 = (Role) session.getAttribute(ConstantUtil.USER_CURRENT_ROLE);
				List<Role> roles2 = loginInfo2.getRoles();
			%>
			<button class="btn" type="button" data-toggle="dropdown"
				style="background-color: #0288d1; color: #fff; text-shadow: none; border: 1px solid #fff; border-radius: 2px;"><%=currentRole2.getName()%><span
					class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<%
					if (roles2 != null) {
						for (Role role : roles2) {
				%>

				<li><a
					href='${pageContext.request.contextPath}/login/changeRole?wid=<%=role.getWid() %>'>
						<%=role.getName()%></a></li>
				<%
					}
					}
				%>
				<li><a href='${pageContext.request.contextPath}/login/logout'>退出系统</a></li>
			</ul>
		</div>
	</div>

</header>