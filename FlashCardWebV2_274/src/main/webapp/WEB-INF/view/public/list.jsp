<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>
    <!-- list -->
    <div class="container">
        <ul class="list-group myBadgeCursor">
            <li class="list-group-item"><span class="badge"
                    onclick="location.href='${pageContext.request.contextPath}/<c:out value="${pathForList}"></c:out>'">
                    <font size="5">ADD</font>
                </span>
                <h3>HolderData</h3></li>
            <c:forEach var="data" items="${datas}">
                <li class="list-group-item"><a href="#" class="list-group-item">
                        <span class="badge" style="background: red;" data-target="#listDeleteModal" data-toggle="modal"
                            onclick='modelValues("${data.id}","${data.fhId}")'>
                            <font size="4">DELETE</font>
                        </span>
                        <span class="badge badgeSpan"
                            onclick="location.href='${pageContext.request.contextPath}/<c:out value="${pathForList}"></c:out>/${data.id}'">
                            <font size="4">EDIT</font>
                        </span>
                        <h4 class="h4" class="list-group-item-heading">
                            <c:out value="id: ${data.id}"></c:out>
                        </h4>
                        <p class="h4" class="list-group-item-text">
                            <c:out value="fhId: ${data.fhId}"></c:out>
                        </p>
                    </a></li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>