<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>

<!-- jstl 标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>index page</title>
</head>
<body>

	<h3>首页</h3>
	
	<c:if test="${user != null}">
		<p>欢迎您 , ${user.uname}</p>
	</c:if>   
	<c:if test="${user == null}">
		<p>注册 | 登录</p>
	</c:if> 
	
	
	<hr>
	
	
	<a href="<c:url value="/addMoments.jsp"/>">添加朋友圈</a><br>
	
	<a href="<c:url value="/moment?method=get"/>">显示朋友圈</a><br><br>
	
	<a href="<c:url value='/product?method=getProduct' />">显示所有产品</a>

	
</body>
</html>