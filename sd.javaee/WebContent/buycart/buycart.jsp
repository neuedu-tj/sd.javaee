<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!-- jstl 标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>


<style>
	
	* {
		text-decoration : none
	
	}

</style>

</head>
<body>
	
	<h3>BuyCart</h3>
	<hr>
	
	<p>总价 : ${buycart.totalPrice}</p>
	
	<table border="1" > 
		<tr>
			<td>Name</td>
			<td>Amount</td>
			<td>ItemPrice</td>
			<td>update/remove</td>
		</tr>

		
		<c:forEach var="item" items="${buycart.items }">
			<tr>
				<td>${item.product.name }</td>
				<td width="150px">
					<a href="<c:url value="buycart?method=addProduct&pid=${item.product.pid }&amount=-1"/>" >-</a>
					<input value="${item.amount }"   size=10 />
					<a href="<c:url value="buycart?method=addProduct&pid=${item.product.pid }&amount=1"/>">+</a>
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