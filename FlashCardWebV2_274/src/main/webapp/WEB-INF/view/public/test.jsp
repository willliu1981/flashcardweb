<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

    <%
    String getVar1 = request.getParameter("active");

    out.println("var=" + getVar1);
    %>
    <br />
    v=${param.active}

</body>
</html>