<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page isErrorPage="true" %> 
    
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

<h1>Edit Your Ninja</h1>
	
	

	<form:form action="/editNinja/${ninj.id}" method="post" modelAttribute="ninj">
	
	<input type="hidden" name="_method" value="put">
	
    <p>
    
        <form:label path="firstName"> Ninj First Name</form:label>
        
        <form:errors path="firstName"/>
        
        <form:input path="firstName"/>
        
    </p>
    
    
    <p>
    
        <form:label path="lastName"> Ninj Last Name</form:label>
        
        <form:errors path="lastName"/>
        
        <form:input path="lastName"/>
        
    </p>
    
    
    <p>
    
        <form:label path="age">Age</form:label>
        
        <form:errors path="age"/>
        
        <form:input type="number" path="age"/>
        
    </p>
    
    
     <form:select path="dojo">
    
    	<c:forEach var="i" items="${dojos}">
    	
    		<form:option value="${i.id}">${i.name}</form:option>
    		
   		</c:forEach>
   		
    </form:select>
    
    
        
    <input type="submit" value="Submit"/>
    
</form:form> 



<a href="/homepage">Home</a>



</body>
</html>