<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>

    <div class="container">
        <span> list2 </span>
        <c:forEach var="i" begin="0" end="${ datas.size()-1 }">
            <span ><font color="red"> ${lg.getResult(i) }</font></span>

        </c:forEach>


    </div>


    <!-- list 
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
                            onclick='modelValues("${data.term}","${data.definition}")'>
                            <font size="4">DELETE</font>
                        </span>
                        <span class="badge badgeSpan"
                            onclick="location.href='${pageContext.request.contextPath}/<c:out value="${pathForList}"></c:out>/${data.id}'">
                            <font size="4">EDIT</font>
                        </span>
                        <h4 class="list-group-item-heading h4">
                            <c:out value="id: ${data.term}"></c:out>
                        </h4>
                        <p class="list-group-item-text h4">
                            <c:out value="fhId: ${data.definition}"></c:out>
                        </p> 
                    </a></li>
            </c:forEach>
        </ul>
    </div>-->
</body>
</html>