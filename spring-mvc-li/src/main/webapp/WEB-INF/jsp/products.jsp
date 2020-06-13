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

	<sf:form action="searchForProducts" method="POST"
		modelAttribute="product">
		<sf:input path="name" type="search" name="search"
			placeholder="Search..." />
		<br>

		<button type="Submit" name="Search">
			<i class="fa fa-search"></i>
		</button>
	</sf:form>


</body>
</html>