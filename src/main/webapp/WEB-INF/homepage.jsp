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


<div class="d-flex justify-content-center">

        
	<div class="container">
	
		
		
		<h3>Ninja HomePage</h3>
		
		<h4>Welcome <c:out value="${ user.userName }"></c:out></h4>
					
		
		<table class="table table-dark  table-hover table-bordered">
		
			<thead >
			
				<tr >
				
					<th class="align-middle" >First Name</th>
					
					<th class="align-middle" >Last Name</th>					
					
					<th class="align-middle" scope="col">Age</th>
					
					<th class="align-middle" scope="col">Dojo / Master</th>
					
					<th class="align-middle" scope="col">Actions</th>
					
				</tr>
				
			</thead>
				
				<tbody>
				
					<c:forEach var="i" items="${ninjas}" >
					
						<tr class=" table-secondary ">
						
							<td> <a href="/oneNinja/${i.id}"><c:out value="${i.firstName}"></c:out></a> </td>
							
							<td>  <c:out value="${i.lastName}"></c:out> </td>
		
							<td> <c:out value="${i.age}"></c:out> </td>
														
							<td> <a href="/oneDojo/${i.dojo.id }" class="button mx-3"> <c:out value="${i.dojo.name}"></c:out> </a> 
							
								<c:out  value="${i.dojo.user.userName}"></c:out>
							
							</td>
							
							<td>
							
							
							
							
							<c:choose>
							
								<c:when test="${i.user.id == user.id}">
								<a href="/editNinja/${i.id}" class="mx-3">Edit</a> <a href="/destroy/${i.id}">Delete</a>
								</c:when>
								
								<c:otherwise>
								<p style="color:red;"> Your Not The Master! </p>
								</c:otherwise> 
								
							</c:choose>
							
							
							
							
							
							   </td>
							
						</tr>
						
					</c:forEach>
					
				</tbody>
				
				
		</table>
		
		<a  href="/newNinjas" class="button mx-3">New Ninja</a>
		
		<a href="/newDojo">Create a Dojo</a>
		
		<a href="/myDojos" class="button mx-3">Your Dojo's</a>
		
		<a href="/logout" class="button mx-3" >LogOut</a>
		
	</div>
	
</div>



</body>
</html>