<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="true"%>
<%@ page import="idv.kwl.test.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>hello java xxx2</h1>
	<%
	User u = new User();
	u.setUsername("abc");
	u.setPassword("123");

	request.setAttribute("username1", u.getUsername());
	%>
	<a href="hello?user=<%=u%>">test spring mvc</a>
</body>
</html>