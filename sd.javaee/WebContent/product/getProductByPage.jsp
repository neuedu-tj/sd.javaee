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
		
		<h3>show ProductsByPages</h3>
		
		<hr>
		
		<p>共 ${pageBean.totalRows } 条记录</p>
		
		<c:forEach var="page" begin="1" end="${pageBean.totalPage }">
			<a href="<c:url value='/product?method=getProductByPage&curr=${page }' />">${page } | &nbsp;&nbsp;&nbsp;</a>
		</c:forEach>
		
		
		<table border="1"  align="center" width="80%">
			<tr>
				<td>No</td>
				<td>Name</td>
				<td>detail</td>
				<td>price</td>
				<td>img</td>
				<td></td>
			</tr>
			
			<c:forEach var="p"  items="${pageBean.data}">
			
				<tr>
					<td>${p.pid}</td>
					<td>${p.name}</td>
					<td>${p.detail}</td>
					<td>${p.price}</td>
					<td>
						<c:forTokens var="each_img" items="${p.img }" delims=",">
							<img src="${each_img }"  height="40px">
						</c:forTokens>
					</td>
					<td>
						<img  height="24px" width="24px" src="<c:url value="/resource/img/buy.png"/> ">
					</td>
				</tr>
				
			</c:forEach>
			
		
		</table>
		
</body>
</html>