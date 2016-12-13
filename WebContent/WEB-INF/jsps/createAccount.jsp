<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Account</title>
<link rel="stylesheet" href="<c:url value="/css/style.css" />">
<script src="<c:url value="/scripts/script.js" />"></script>

</head>
<body>
<div id="error"></div>
	<c:url value="/register" var="url"/>
	<form name="form" method="post" action="${url}" onsubmit="return verify()">	
		UserName: <input name="username" type="text" /><br />
		Password: <input name="password" type="password" /><br />
		Re-enter Password: <input name="verifyPassword" type="password" /><br />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="submit" value="Create Account!" onclick="verify()" />
	</form>

</body>
</html>