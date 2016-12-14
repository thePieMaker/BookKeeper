<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ReadIt App</title>
<link rel="stylesheet" href="<c:url value="/css/indexStyle.css" />">
</head>
<body>
	<div class="header"> 
		<center><h1>Welcome to ReadIt</h1><h2>The Book Wishlist App</h2></center>
	</div>
	<div><center>
	<table cellpadding="10">
		<tr>
			<th>Please log in to continue</th>
			<th>No account? Click below to sign up</th>
		</tr>
		<tr>
			<td><c:url value="/home" var="url" />
				<a href="${url}">Click to Log In</a> </td>
			<td><c:url value="/createAccount" var="url2" />
				<a href="${url2}">Create Account</a> </td>
		</tr>
		<tr>
			<td><img src="./images/book3.png"/> </td>
			<td><img src="./images/book.png"/> </td>
		</tr>
	</table>  
	</center>
	</div>
	
	<div id="createAccount"> 
		<p><c:if test="${accountCreated}"><h3>Account successfully created</h3><p>You may now log in</p></c:if></p>
	</div>
	

</body>
</html>