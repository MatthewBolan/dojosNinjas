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

<h1 class="text-center">Registration / Login</h1>

<div class="d-flex justify-content-evenly">

<form:form action="/register" method="post" modelAttribute="newUser" class="bg-dark text-primary my-3 w-25 p-3">

        <div class="form-group">
        
            <label>User Name:</label>
            
            <form:input path="userName" class="form-control" />
            
            <form:errors path="userName" class="text-danger" />
            
        </div>
        
        
        <div class="form-group">
        
            <label>Email:</label>
            
            <form:input path="email" class="form-control" />
            
            <form:errors path="email" class="text-danger" />
            
        </div>
        
        
        <div class="form-group">
        
            <label>Password:</label>
            
            <form:password path="password" class="form-control" />
            
            <form:errors path="password" class="text-danger" />
            
        </div>
        
        
        <div class="form-group">
        
            <label>Confirm Password:</label>
            
            <form:password path="confirm" class="form-control" />
            
            <form:errors path="confirm" class="text-danger" />
            
        </div>
        
        
        <input type="submit" value="Register" class="btn btn-primary my-3" />
        
    </form:form>
    
    <form:form action="/login" method="post" modelAttribute="newLogin" class="bg-dark text-primary my-3 w-25 p-3 h-25">
    
    
        <div class="form-group">
        
            <label>Email:</label>
            
            <form:input path="email" class="form-control" />
            
            <form:errors path="email" class="text-danger" />
            
        </div>
        
        
        <div class="form-group">
        
            <label>Password:</label>
            
            <form:password path="password" class="form-control" />
            
            <form:errors path="password" class="text-danger" />
            
        </div>
        
        
        <input type="submit" value="Login" class="btn btn-success my-3" />
        
    </form:form>
    
    </div>

</body>
</html>