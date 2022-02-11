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
	<a
		href="hello?username=<%=u.getUsername()%>&password=<%=u.getPassword()%>">test
		spring mvc</a>

	<form action="hello" method="post">
	<input type="text" name="username" value="<%=u.getUsername()%>" />
	<input type="text" name="password" value="<%=u.getPassword()%>" />
		<input type="submit" value="test"></input>
	</form>
</body>
</html>