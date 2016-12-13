<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search For a Book</title>
</head>
<body>
<h1>Search Books</h1>

<c:url var="url" value="/searchBook" />
<form:form commandName="book" method="post" action="${url}">
	Genre: <form:select path="genre" items="${book.genres}" /><br>
	<br>
	<input type="submit" value="Search" />
</form:form>


<c:forEach items="${booklist}" var="book">
	<h1>${book.name}, ${book.author}, ${book.genre} </h1>
</c:forEach> 

<p>
	<a href="<c:url value="/" />">Add Book</a>
</p>

</body>
</html>