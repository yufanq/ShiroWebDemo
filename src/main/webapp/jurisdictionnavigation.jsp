<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
   <jsp:include page="header.jsp"></jsp:include>
   
    <div class="vernav2 iconmenu">
    	<ul>
        	<li><a href="adminmanager.jsp" class="gallery">管理员管理</a></li>
            <li><a href="rolemanager.jsp" class="widgets">角色管理</a></li>
            <li><a href="jurisdictionmanager.jsp" class="support">权限管理</a></li>
        <a class="togglemenu"></a>
        <br /><br />
    </div><!--leftmenu-->
     