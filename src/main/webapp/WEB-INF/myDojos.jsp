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

<h1>Greetings ${user.userName}</h1>

<h2>You are the MASTER of these dojo's</h2>

<c:forEach var="i" items="${user.dojos}">

<p> <c:out value="${i.name }"></c:out>  <p>

</c:forEach>

<a href="/homepage">Home</a>

</body>
</html>