<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- jstl 标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="index" begin="1" end="5">

		<p>${index }</p>
	</c:forEach>

	<hr>
	
	<c:if test="${1<2 }">
		1&lt;2
	</c:if>
	<br>
	<c:if test="${3>2 }">
		3&gt;2
	</c:if>

</body>
</html>
