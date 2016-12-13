<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookKeeper</title>
</head>
<body>
	<center><h1>Welcome to BookKeeper</h1><h2>The Book Wishlist App</h2></center>
	
	<p>Please log in to continue</p>
	
	
	<p>No account? Click below to sign up</p>
	<c:url value="/createAccount" var="url2" />
	<a href="${url2}">Create Account</a>
	
	<p>
	<c:url value="/secure" var="url" />
	<a href="${url}">Secure Page</a>
	
	
	<c:url value="/addBook" var="url3" />
	<a href="${url3}">Add Book</a>
	
	<c:url value="/searchBook" var="url4" />
	<a href="${url4}">Search for Book</a>
	</p>
	<c:if test="${accountCreated}"><h3>Account successfully created</h3></c:if>
</body>
</html>