<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Books</title>
<link rel="stylesheet" href="<c:url value="/css/viewStyle.css" />">
</head>
<body>
	<div class="header"> 
		<center><h1>Welcome to ReadIt</h1><h2>The Book Wishlist App</h2></center>
	</div>
	<table id="viewTable">
		<tr>
			<th>Name</th>
			<th>Author</th>
			<th>Genre</th>
			<th>Rating</th>
			<th>Completed?</th>
			<th>Edit Record</th>
			<th>Delete Record</th>
			
		</tr>     
		
	    <c:forEach items="${livres}" var="livre">
		<tr>
			<th>${livre.name}</th>
			<th>${livre.author} </th>
			<th>${livre.genre}</th>
			<th>${livre.rating}</th>
			<th>${livre.completed}</th>
			<th><a href="<c:url value="/editLivre/${livre.id}" />">Edit</a></th>
			<th><a href="<c:url value="/deleteLivre/${livre.id}" />">Delete</a></th>
		</tr>
		</c:forEach>
	
	</table>
	
	<p>
		<c:url value="/home" var="url" />
		<a href="${url}">Back to Home</a>
	
	</p>
</body>
</html>