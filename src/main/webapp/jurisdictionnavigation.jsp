<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
   <jsp:include page="header.jsp"></jsp:include>
   
    <div class="vernav2 iconmenu">
    	<ul>
        	<c:forEach items="${adminlists }" var="l">
         	<li><a href="${pageContext.request.contextPath}/${l.lUri}" class="${l.lStyle }">${l.jName }</a></li>
         </c:forEach>

         <a class="togglemenu"></a>
        <br /><br />
    </div><!--leftmenu-->
     