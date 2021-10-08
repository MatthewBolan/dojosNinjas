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


<div style="position: fixed; z-index: -99; width: 100%; height: 100%">

        
	<div class="container">
	
		
		
		<h3>Dashboard</h3>
		
		<a  href="/newNinjas" class="button">New Ninja</a>
		
		<a href="/newDojo">Create a Dojo</a>
		
		
		<table class="table table-dark table-striped table-hover table-bordered">
		
			<thead >
			
				<tr >
				
					<th class="align-middle" >First Name</th>
					
					<th class="align-middle" >Last Name</th>					
					
					<th class="align-middle" scope="col">Age</th>
					
					<th class="align-middle" scope="col">Dojo</th>
					
					<th class="align-middle" scope="col">Actions</th>
					
				</tr>
				
			</thead>
				
				<tbody>
				
					<c:forEach  var="i" items="${ninjas}" >
					
						<tr class=" table-secondary ">
						
							<td> <a href="/oneNinja/${i.id}"><c:out value="${i.firstName}"></c:out></a> </td>
							
							<td>  <c:out value="${i.lastName}"></c:out> </td>
		
							<td> <c:out value="${i.age}"></c:out> </td>
														
							<td> <a href="/oneDojo/${i.dojo.id }"> <c:out value="${i.dojo.name}"></c:out> </a> </td>
							
							<td> <a href="/editNinja/${i.id}">Edit</a> <a href="destroy/${i.id}">Delete</a>  </td>
							
						</tr>
						
					</c:forEach>
					
				</tbody>
				
				
		</table>
		
	</div>
	
</div>

</body>
</html>