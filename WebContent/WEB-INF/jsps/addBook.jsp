<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a Book</title>
</head>
<body>
	<h1>Add a Book</h1>
	<c:url var="url" value="/savebook" />
	<form:form commandName="book" method="post" action="${url}">
		Name: <form:input path="name" /><br>
		Author: <form:input path="author" /><br>
		Genre: <form:select path="genre" items="${book.genres}" /><br>
		<br>
		<input type="submit" value="Save Book" />
	</form:form>
	
</body>
</html>