<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search For a Book</title>
<link rel="stylesheet" href="<c:url value="/css/style.css" />">
</head>
<body>
	<div class="header"> 
		<center><h1>Welcome to ReadIt</h1><h2>The Book Wishlist App</h2></center>
	</div>
	<h2>Search Books</h2>
	
	<c:url var="url" value="/searchBook" />
	<form:form commandName="livre" method="post" action="${url}">
		Genre: <form:select path="genre" items="${livre.genres}" />  <input type="submit" value="Search" />
	</form:form>

	<br>
	<div class="results"><h3>Results:</h3>
		<c:forEach items="${booklist}" var="livre">
			<h3>${livre.name}, ${livre.author}, ${livre.genre} </h3>
		</c:forEach> 
	</div>
	<p>
		<c:url value="/addBook" var="url1" />
		<a href="${url1}">Add a Book</a>
	</p>
	
	<p>
		<c:url value="/home" var="url" />
		<a href="${url}">Back to Home</a>
	</p>


</body>
</html>