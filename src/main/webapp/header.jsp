<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
  <div class="topheader">
        <div class="left">
            <h1 class="logo">BookScanExercises.<span>Admin</span></h1>
            <span class="slogan">图书扫码练题系统</span>
            
            <div class="search">
            	<form action="" method="post">
                	<input type="text" name="keyword" id="keyword" value="请输入" />
                    <button class="submitbutton"></button>
                </form>
            </div><!--search-->
            
            <br clear="all" />
            
        </div><!--left-->
        
        <div class="right">
        	<!--<div class="notification">
                <a class="count" href="ajax/notifications.html"><span>9</span></a>
        	</div>-->
            <div class="userinfo">
            	<img src="${pageContext.request.contextPath}/static/images/thumbs/avatar.png" alt="" />
                <span> <shiro:principal/> </span>
            </div><!--userinfo-->
            
            <div class="userinfodrop">
            	<div class="avatar">
                	<a href=""><img src="${pageContext.request.contextPath}/static/images/thumbs/avatarbig.png" alt="" /></a>
                    <div class="changetheme">
                    	切换主题: <br />
                    	<a class="default"></a>
                        <a class="blueline"></a>
                        <a class="greenline"></a>
                        <a class="contrast"></a>
                        <a class="custombg"></a>
                    </div>
                </div><!--avatar-->
                <div class="userdata">
                	<h4>Juan</h4>
                    <span class="email">youremail@yourdomain.com</span>
                    <ul>
                    	<li><a href="editprofile.html">编辑资料</a></li>
                        <li><a href="accountsettings.html">账号设置</a></li>
                        <li><a href="help.html">帮助</a></li>
                        <li><a href="${pageContext.request.contextPath}/logout">退出</a></li>
                    </ul>
                </div><!--userdata-->
            </div><!--userinfodrop-->
        </div><!--right-->
    </div><!--topheader-->
    
    
    <div class="header">
    	<ul class="headermenu">
      	 <c:forEach items="${menus}" var="m" >
   	   <li class="current"> <a href="${pageContext.request.contextPath}/${m.lUri}"><span class="icon ${ m.lStyle }"></span>${m.jName}</a></li>

    </c:forEach>
       <!--  	 <li><a href="adminmanager.jsp"><span class="icon icon-pencil"></span>权限管理</a></li>
            <li><a href="testpapers.jsp"><span class="icon icon-message"></span>试卷管理</a></li>
            <li><a href="reports.html"><span class="icon icon-chart"></span>统计报表</a></li>
       -->  </ul>	
      
    </div><!--header-->
