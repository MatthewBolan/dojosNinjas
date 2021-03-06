<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    
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



	<h3>Name your Dojo <c:out value="${ user.userName }"></c:out>!</h3>
	
	<form:form action="/createDojo" method="post" modelAttribute="dojo">
	
	<form:hidden path="user" value="${user.id}"/>
	
    <p>
        <form:label path="name">Dojo Name</form:label>
        
        <form:input path="name"/>
        
    </p>
    
    <p>
    <form:errors path="name" class="text-danger"/>
    </p> 
      
    <input type="submit" value="Submit"/>
    
	</form:form>
  
	<a href="/homepage">Home</a>

</body>
</html>