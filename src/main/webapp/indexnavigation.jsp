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
        	<c:forEach items="${ lists }" var="l">
        	<li><a href="${pageContext.request.contextPath}/${l.lUri}" class="${l.lStyle }">${l.jName }</a></li>
           </c:forEach>
           <!--  <li><a href="booksmanager.jsp" class="widgets">书本管理</a></li>
            <li><a href="sectionmanager.jsp" class="buttons">章节管理</a></li>
            <li><a href="knowladgepointmanager.jsp" class="support">知识点管理</a></li>
            <li><a href="questiontype.jsp" class="typo">题目类型管理</a></li>
			<li><a href="#formsub" class="editor">题目管理</a>
            	<span class="arrow"></span>
            	<ul id="formsub">
               		<li><a href="singlechoicemanager.jsp">单项选择</a></li>
                    <li><a href="multiplechoicemanager.jsp">多项选择</a></li>
                    <li><a href="completionmanager.jsp">填空题</a></li>
                    <li><a href="trueorfalsequestionmanager.jsp">判断题</a></li>
                    <li><a href="essayquestionmanager.jsp">问答题</a></li>
                    <li><a href="analysisthetopicquestionmanager.jsp">辨析题</a></li>
                </ul>
            </li> -->
        </ul>
        <a class="togglemenu"></a>
        <br /><br />
    </div><!--leftmenu-->
     