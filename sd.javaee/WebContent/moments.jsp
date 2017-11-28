<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>

<!-- jstl 标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>moment page</title>
</head>
<body>

	<c:forEach var="m" items="${moments }">
		
		<div>
			<div style="border:1px sold red">${m.mcontent}</div>
			<div >
				<c:forTokens var="img" delims =";" items="${m.imgs }">
					<img src="${img}"   height="60px" width="60px" />
				</c:forTokens>
			</div>
		</div>
		<hr>
	</c:forEach>

</body>
</html>