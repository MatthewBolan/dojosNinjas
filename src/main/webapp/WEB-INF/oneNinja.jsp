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

	<h1>Look at this Ninj</h1>

	
	<h3>I am <c:out value="${ninj.firstName}"></c:out><c:out value="${ninj.lastName}"></c:out> </h3>
	
	<h4>Member of: <c:out value="${ninj.dojo.name}"></c:out> </h4>
	
	<h4>I am <c:out value="${ninj.age}"></c:out> years old. </h4>
	
	
	
<a href="/">Home</a>

</body>
</html>