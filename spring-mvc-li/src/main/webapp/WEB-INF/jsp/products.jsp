<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<h1>Products</h1>

	<form action="searchByName" method="get">
		<input path="name" name="name"
			placeholder="Search..." />
			
		<input type="submit" value="Search">
	</form>

	<c:if test="${ !empty(products) }">
		<c:forEach var="product" items="${products}" >
			<p>
				<b> ${product.name} </b>
			</p>
		</c:forEach>
	</c:if>



</body>
</html>