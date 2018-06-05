<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Forms | Amanda Admin Template</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.default.css" type="text/css" />
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

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/custom/elements.js"></script>

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
    <jsp:include page="jurisdictionnavigation.jsp"/>
    <div class="centercontent">
    
        <div class="pageheader">
            <h1 class="pagetitle">角色</h1>
            <span class="pagedesc">The content below are loaded using inline data</span>
            
            <ul class="hornav">
            <shiro:hasPermission name="jurisdiction:role:view">
              <li class="current"><a href="#basicform">角色列表</a></li>
            </shiro:hasPermission>
            <shiro:hasPermission name="jurisdiction:role:accredit">
                <li><a href="#validation">角色权限管理</a></li>
            </shiro:hasPermission>
            <shiro:hasPermission name="jurisdiction:role:create">
                <li><a href="#create">角色添加</a></li>  
            </shiro:hasPermission>
            </ul>
        </div><!--pageheader-->
        
        <div id="contentwrapper" class="contentwrapper">
        	
        	<div id="basicform" class="subcontent">
        	 
                        <div class="widgetbox">
                            <div class="title"><h3>Statements</h3></div>
                            <div class="widgetcontent padding0 statement">
                               <table cellpadding="0" cellspacing="0" border="0" class="stdtable">
                                    <colgroup>
                                        <col class="con0" />
                                        <col class="con1" />
                                        <col class="con0" />
                                    </colgroup>
                                    <thead>
                                        <tr>
                                            <th class="head0">角色id</th>
                                            <th class="head1">角色名称</th>
                                            <th class="head1">是否可用</th>
                                            <th class="head1">操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                        	<c:forEach items="${ roleList }" var="r">
                                        	   <td>${ r.rId }</td>
                                           	  <td>${r.rName }</td>
                                           	  <td>${r.rAvailable }</td>
                                            <td>
                                            <shiro:hasPermission name="jurisdiction:role:update">
                                             	<a>修改</a>
                                            </shiro:hasPermission>
                                            <shiro:hasPermission name="jurisdiction:role:delete">
                                            	 <a>删除</a>
                                            </shiro:hasPermission>
                                           </td>
                                         
                                        </tr>
                                           
                                        	</c:forEach>
                                        
                                    </tbody>
                                </table>
                            </div><!--widgetcontent-->
                        </div><!--widgetbox-->
             
      </div><!--subcontent-->
         
         
            <div id="validation" class="subcontent" style="display: none">
                   <form class="stdform" action="" method="post">
                         <p>
                        	<label>角色选择</label>
                        	   <span class="formwrapper">
                            	<select data-placeholder="选择角色" class="chzn-select" style="width:350px;" tabindex="2">
                         			<c:forEach items="${roleSelectList }" var="rl">
                         		      	<option value="${ rl.rId }">${ rl.rName }</option>
                         			</c:forEach>
                            </select>
                            </span>
                        </p>
                        <p>
                          
                        	<label>权限选择</label>
                        	
                            <span id="dualselect" class="dualselect">
                           	<select class="uniformselect" name="select3" multiple="multiple" size="10">
                                       	<c:forEach items="${noBelongRole }" var="b">
                                	 <option value="${ b.jId }">${b.jName }</option>
                                    </c:forEach>
                                </select>
                               
                                <span  class="ds_arrow">
                                	<span class="arrow ds_prev">&laquo;</span>
                                     <span class="arrow ds_next">&raquo;</span>
                                </span>
                                <select  name="select4" multiple="multiple" size="10">
                                	<c:forEach items="${belongRole }" var="b">
                                	 <option value="${ b.jId }">${b.jName }</option>
                                    </c:forEach>
                                </select>
                            </span>
                        </p>
                          <p class="stdformbutton">
                        	<button class="submit radius2">提交</button>
                        </p>
                  </form>
         </div><!--subcontent-->
         <div id="create" class="subcontent" style="display: none">
                   <form class="stdform" action="" method="post">
             			    <p>
                        	<label>角色名称</label>
                            <span class="field"><input type="text" name="firstname" id="firstname2" class="longinput" /></span>
                        </p>
                          <p class="stdformbutton">
                        	<button class="submit radius2">提交</button>
                        </p>
                  </form>
         </div><!--subcontent-->
        </div><!--contentwrapper-->
        
	</div><!-- centercontent -->
    
    
</div><!--bodywrapper-->

</body>
</html>
