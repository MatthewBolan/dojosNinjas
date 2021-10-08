<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet"
	href="/webjars/bootstrap/5.0.1/css/bootstrap.min.css" />

	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/5.0.1/js/bootstrap.min.js"></script>
	
	
	
	
	
	<title>Insert title here</title>
	
</head>

<body>


	<h1>Welcome to <c:out value="${dojo.name}"></c:out> </h1>
	
	<h3>Meet our ninja(s): </h3>
	
	<c:forEach var="i" items="${dojo.ninjas}">
	
		<h6> <c:out value="${i.firstName}"></c:out><c:out value="${i.lastName}"></c:out> </h6>
		
	</c:forEach>

<a href="/">Home</a>

</body>
</html>