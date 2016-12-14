<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a Book</title>
<link rel="stylesheet" href="<c:url value="/css/style.css" />">
</head>
<body>
	<div class="header"> 
		<center><h1>Welcome to ReadIt</h1><h2>The Book Wishlist App</h2></center>
	</div>
	<h2>Add a Book</h2>
	<c:url var="url" value="/savebook" />
	<form:form commandName="livre" method="POST" action="${url}">
		Name: <form:input path="name" /><br>
		Author: <form:input path="author" /><br>
		Genre: <form:select path="genre" items="${livre.genres}" /><br>
		Rating: <form:select path="rating" items="${livre.ratings}" /><br>
		Completed? <form:select path="completed" items="${livre.isCompleted}" /><br>
		<br>
		<input type="submit" value="Save Book" />
	</form:form>
	
	<p>
		<c:url value="/home" var="url" />
		<a href="${url}">Back to Home</a>
	
		<c:url value="/view" var="url2" />
		<a href="${url2}">View your books</a>
	</p>
	
</body>
</html>