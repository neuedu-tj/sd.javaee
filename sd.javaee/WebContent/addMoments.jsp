<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>

<!-- jstl 标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>add moments page</title>
</head>
<body>

	<c:if test="${user != null}">
		<p>欢迎您 , ${user.uname}</p>
	</c:if>   
	<c:if test="${user == null}">
		<p>注册 | 登录</p>
	</c:if> 
	
	
	<hr>
	
	<h4 align="center">添加朋友圈</h4>
	
	<form action="<c:url value="/moments" />" method="post" enctype="multipart/form-data">
		
			<input type="text" name="mcontent"><br>
			<input type="file" name="imgs" /><br>
		
			<input type="submit" value="发送" />
	</form>

</body>
</html>