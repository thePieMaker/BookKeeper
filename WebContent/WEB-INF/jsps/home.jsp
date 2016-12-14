<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="<c:url value="/css/style.css" />">
</head>
<body>
	<div class="header"> 
		<center><h1>Welcome to ReadIt</h1><h2>The Book Wishlist App</h2></center>
	</div>
<h2>Welcome, you may select an option below</h2>
	<div>
		<c:url value="/addBook" var="url3" />
		<a href="${url3}">Add Book</a>
	</div>
	
	<div>
		<c:url value="/searchBook" var="url4" />
		<a href="${url4}">Search for Book</a>
	</div>
	<div>
		<c:url value="/view" var="url2" />
		<a href="${url2}">View your books</a>
	</div>
	
	<div>
		<p><a href="<c:url value="/logout" />">Logout</a></p>
	</div>
</body>
</html>