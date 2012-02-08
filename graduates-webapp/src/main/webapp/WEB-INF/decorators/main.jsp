<%@page import="org.springframework.context.annotation.Import"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 
<%@ page import="com.dayatang.projmgmt.domain.OrganizationCategory"%>
<%
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><decorator:title default="Struts Starter"/></title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<base href="<%=basePath%>"/>
	<script type="text/javascript" src="js/jq.js"></script>
	<script type="text/javascript" src="js/bootstrap-dropdown.js"></script>
	<link href="styles/main.css" rel="stylesheet" type="text/css" />
	   <style type="text/css">
      body {padding-top: 60px; }
    </style>
	<decorator:head/>
</head>
<body>

<div class="container">
<div class="well">
<decorator:body/>
</div>
</div>

<div class="container">
    <p class="pull-left">&copy; Copyright <a href="http://www.dayatang.com"><s:text name="copyright" /></a>.</p>
    <p class="pull-right"><a href="http://www.dayatang.com">power by <s:text name="power-by" /></a></p>
</div>
  
</body>

</html>
