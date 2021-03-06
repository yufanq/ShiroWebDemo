<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Forms | Amanda Admin Template</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/style.default.css"
	type="text/css" />
	
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/page/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/page/questiontypemanager.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/jquery-1.7.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/jquery.cookie.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/colorpicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/jquery.uniform.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/charCount.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/ui.spinner.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/chosen.jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/custom/general.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/custom/forms.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/staticjs/custom/elements.js"></script>
<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="css/style.ie9.css"/>
<![endif]-->
<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="css/style.ie8.css"/>
<![endif]-->
<!--[if lt IE 9]>
	<script src="${pageContext.request.contextPath}/static/http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
<![endif]-->
</head>

<body class="withvernav">

	<div class="bodywrapper">
		<jsp:include page="indexnavigation.jsp" />
		<div class="centercontent">

			<div class="pageheader">
				<h1 class="pagetitle">题目类型</h1>
				<span class="pagedesc">The content below are loaded using
					inline data</span>

				<ul class="hornav">
					<li class="current"><a href="#basicform">类型列表</a></li>
					<li><a href="#validation">类型添加</a></li>
				</ul>
			</div>
			<!--pageheader-->

			<div id="contentwrapper" class="contentwrapper">

				<div id="basicform" class="subcontent">

					<div class="widgetbox">
						<div class="title">
							<h3>Statements</h3>
						</div>
						<div class="widgetcontent padding0 statement">
							<table cellpadding="0" cellspacing="0" border="0"
								class="stdtable">
								<colgroup>
									<col class="con0" />
									<col class="con1" />
									<col class="con0" />
								</colgroup>
								<thead>
									<tr>
										<th class="head0">类型id</th>
										<th class="head1">类型名称</th>
										<th class="head1">类型分值</th>
										<th class="head1">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${ questypeBean.list }" var="qt">
										<tr>
											<td>${ qt.tId }</td>
											<td>${ qt.tName }</td>
											<td>${ qt.tValue }</td>
											<td>
												<shiro:hasPermission name="index:questiontype:update">
													<a href="javascript:void(0)" onclick="modQuestionType(this)">修改</a>
												</shiro:hasPermission> 
												<shiro:hasPermission name="index:questiontype:delete">
													<a href="${pageContext.request.contextPath}/questiontype/${qt.tId}/deleteQuestionType" ">删除</a>
												</shiro:hasPermission></td>
										</tr>
									</c:forEach>
									
								</tbody>
							</table>
						</div>
						<!--widgetcontent-->
						${ msg }
					</div>
					<!--widgetbox-->
					<br />

				   <ul class="pagination pagination2">
                    	当前第<strong> ${requestScope.page.pageIndex}</strong> 页，共 <strong>${requestScope.page.pageCount}</strong> 页
                    	<li class="first"><a href="${pageContext.request.contextPath}/questiontype?pageIndex=1" class="disable">&laquo;</a></li>
                        <li class="previous"><a href="${pageContext.request.contextPath}/questiontype?pageIndex=${requestScope.page.pageIndex - 1 }" class="disable">&lsaquo;</a></li>
                    	<li><a href="${pageContext.request.contextPath}/questiontype?pageIndex=${requestScope.page.pageIndex}" class="current"> ${requestScope.page.pageIndex}</a></li>
                        <li><a href="${pageContext.request.contextPath}/questiontype?pageIndex=${requestScope.page.pageIndex + 1}"> ${requestScope.page.pageIndex + 1}</a></li>
                        <li><a href="${pageContext.request.contextPath}/questiontype?pageIndex=${requestScope.page.pageIndex + 2}"> ${requestScope.page.pageIndex + 2}</a></li>
                        <li><a href="${pageContext.request.contextPath}/questiontype?pageIndex=${requestScope.page.pageIndex + 3}"> ${requestScope.page.pageIndex + 3}</a></li>
                        <li><a href="${pageContext.request.contextPath}/questiontype?pageIndex=${requestScope.page.pageIndex + 4}"> ${requestScope.page.pageIndex + 4}</a></li>
                        <li class="next"><a href="${pageContext.request.contextPath}/questiontype?pageIndex=${requestScope.page.pageIndex + 1}">&rsaquo;</a></li>
                        <li class="last"><a href="${pageContext.request.contextPath}/questiontype?pageIndex=${requestScope.page.pageCount}">&raquo;</a></li>
                    </ul>
					<br />
				</div>
				<!--subcontent-->


				<div id="validation" class="subcontent" style="display: none">
					<form class="stdform" action="${pageContext.request.contextPath}/questiontype/createQuestionType" method="post">
						<p>
							<label>类型名称</label> <span class="field"><input type="text"
								name="tName" id="firstname" class="longinput" /></span>
						</p>
						<p>
							<label>类型分值</label> <span class="field"><input type="text"
								name="tValue" id="firstname" class="longinput" /></span>
						</p>
						

						<p class="stdformbutton">
							<button class="submit radius2">提交</button>
						</p>
					</form>
				</div>
				<!--subcontent-->

			</div>
			<!--contentwrapper-->

		</div>
		<!-- centercontent -->


	</div>
	<!--bodywrapper-->

</body>
</html>
