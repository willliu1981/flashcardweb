<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page import="idv.fc.model.Flashcard,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

    <%
    Flashcard f1 = new Flashcard();
    f1.setTerm("a1");
    Flashcard f2 = new Flashcard();
    f2.setTerm("a2");

    List<Flashcard> dds = new ArrayList<>();
    dds.add(f1);
    dds.add(f2);

    request.setAttribute("dds", dds);
    %>


    <h1>data=${datas[0].term }</h1>

    <c:forEach var="it" items="${datas} ">
        ${it.term}

    </c:forEach>

    <c:forEach var="it" items="${ dds }">
        <tr>
            <td>: ${it.term }</td>
            <td>: ${it.definition }</td>
        </tr>
    </c:forEach>


</body>
</html>