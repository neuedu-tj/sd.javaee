<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
    
    <!-- jstl 标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<h4>Add Product</h4>
	
	<hr>
	
	<form action='<c:url value="/product?method=addProduct"  />'  method="post"  enctype="multipart/form-data">
	
		Name : <input name="name"/> <br>
		Detail : <input name="detail" /> <br>
		Price : <input name="price" /> <br>
		img : <input type="file"  name="img" multiple="multiple"  /> <br>
	
		<input type="submit" value="提交" />
	
	</form>
	

</body>
</html>