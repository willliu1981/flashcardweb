<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

xxxx
    <form:form action="submitForm" method="post">
        <table>
            <tr>
                <td>First name: <form:input path="term" />
                </td>
            </tr>
        </table>
        <table>
            <tr>
                <td>Last name: <form:input path="definition" />
                </td>
            </tr>
        </table>
        <input type="submit" value="Submit" />
    </form:form>
</body>
</html>