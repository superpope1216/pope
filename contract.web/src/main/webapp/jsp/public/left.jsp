<%@page import="com.pope.contract.code.MenuLevel"%>
<%@page import="com.pope.contract.entity.system.Permission"%>
<%@page import="com.pope.contract.util.CommonUtil"%>
<%@page import="com.pope.contract.entity.system.Role"%>
<%@page import="java.util.List"%>
<%@page import="com.pope.contract.util.ConstantUtil"%>
<%@page import="com.pope.contract.dto.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/pageJs/left.js"></script>
<aside class="sidebar">
	<div class="sidebar-menu">
		<div class="text-center"><img src="http://zui.sexy/docs/img/img2.jpg" width="100px" height="80px" class="img-circle" alt="圆形图片"></div>
		<div class="text-center mt10 clolor-white" >我的测试</div>
		<%
			LoginInfo loginInfo = (LoginInfo) session.getAttribute(ConstantUtil.USER_SESSION_NAME);
			List<Role> roles = loginInfo.getRoles();
			if (CommonUtil.isNotEmptyList(roles)) {
				Role role = roles.get(0);
				List<Permission> permissions = role.getPermissions();
				boolean findSecond=false,findThree=false;
				if (CommonUtil.isNotEmptyList(permissions)) {
					int i=0;
					int j=0;
					for (Permission per : permissions) {
						if(per.getLevel()==MenuLevel.SECOND.getCode()){
							System.out.println("======="+per.getName());
							findSecond=true;
							findThree=false;
							j=0;
							if(i!=0){
								%>
								</div>
							<%
							}
							i++;
						}
						else if(per.getLevel()==MenuLevel.THREE.getCode()){
							System.out.println("=======2"+per.getName());
							findThree=true;
							findSecond=false;
						}else{
							findThree=false;
							findSecond=false;
						}
						if(findSecond){
							%>
							<div class='item vertical open active'>
							<a href='#'>
							<i class='icon icon-cogs'></i> <span><%=per.getName() %></span>
							<span class='arrow'></span></a>
						<%
						}
						if(findThree){
							String url=per.getUrl();
							String href="";
							if(url.indexOf(",")>=0){
								String[] urls=url.split(",");
								for(String s:urls){
									if(s.indexOf("index")>=0){
										href=s;
										break;
									}
								}
							}
							if(j==0){
								%>
								<div class='vertical-menu'>
							<%
							}else{
								if(findSecond){
								%>
								</div>
							<%}
							}
							%>
								<a href='${pageContext.request.contextPath}<%=href %>'><%=per.getName()%></a>
							<%
							j++;
						} 
						
					}
					 %>
					</div>
					<%

				}
			}
		%> 
	</div>
</aside>