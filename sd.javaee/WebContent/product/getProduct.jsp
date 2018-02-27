<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!-- jstl 标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
		
		<h3>show Products</h3>
		
		<hr>
		
		<table border="1"  align="center" width="50%">
			<tr>
				<td>No</td>
				<td>Name</td>
				<td>detail</td>
				<td>price</td>
				<td>img</td>
			</tr>
			
			<c:forEach var="p"  items="${products}">
			
				<tr>
					<td>${p.pid}</td>
					<td>${p.name}</td>
					<td>${p.detail}</td>
					<td>${p.price}</td>
					<td>
						<img  height="24px" width="24px" src="<c:url value="/resource/img/buy.png"/> ">
					</td>
				</tr>
				
			</c:forEach>
			
		
		</table>
		
</body>
</html>