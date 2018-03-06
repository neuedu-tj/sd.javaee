<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!-- jstl 标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>BuyCart</h3>
	<hr>
	
	<table>
		<tr>
			<td>Name</td>
			<td>Amount</td>
			<td>ItemPrice</td>
			<td>update/remove</td>
		</tr>
		
		<c:forEach var="item" items="${buycart.items }">
			<tr>
				<td>${item.product.name }</td>
				<td>
					<input value="${item.amount }"/>
				</td>
				<td>${item.amount * item.product.price }</td>
				<td>
					<a href='#'>remove</a>
				</td>
		</tr>
		</c:forEach>
	
	
	</table>
		
</body>
</html>