<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
   <jsp:include page="header.jsp"></jsp:include>
   
    <div class="vernav2 iconmenu">
    	<ul>
           <li><a href="thefinalpapermanager.jsp" class="editor">期末试卷</a></li>
           <li><a href="themedtermpapermanager.jsp" class="gallery">期中试卷</a></li>
           <li><a href="unittestingmanager.jsp"  class="support">单元测试</a></li>
           <li><a href="knowledgepointestmanager.jsp" class="elements"> 知识点测试</a></li>
           <li><a href="customtestpapermanager.jsp" class="typo">自定义试卷</a></li>
        </ul>
        <a class="togglemenu"></a>
        <br /><br />
    </div><!--leftmenu-->