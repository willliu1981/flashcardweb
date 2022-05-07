<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>

    <%--     <div class="container">
        <span> list2 </span>
        <c:forEach var="i" begin="0" end="${ datas.size()-1 }">
            <span ><font color="red"> ${lg.getResult(i) }</font></span>

        </c:forEach>


    </div> --%>


    <!-- list -->
    <div class="container">
        <ul class="list-group myBadgeCursor">
            <li class="list-group-item">
                <%--   <span class="badge"
                    onclick="location.href='${pageContext.request.contextPath}/<c:out value="${pathForList}"></c:out>'">
                    <font size="5">ADD</font>
                </span> --%> ${lg.titleResult }
                <h3>HolderData</h3>
            </li>
            <c:forEach var="i" begin="0" end="${ datas.size()-1 }">
                <li class="list-group-item"><a href="#" class="list-group-item">
                        <%--                  <span class="badge" style="background: red;" data-target="#listDeleteModal" data-toggle="modal"
                            onclick='modelValues("${data.term}","${data.definition}")'>
                            <font size="4">DELETE</font>
                        </span>
                        <span class="badge badgeSpan"
                            onclick="location.href='${pageContext.request.contextPath}/<c:out value="${pathForList}"></c:out>/${data.id}'">
                            <font size="4">EDIT</font>
                        </span> --%>

                        ${lg.getDataResult(i) }

                    </a></li>
            </c:forEach>
        </ul>
    </div>

    <!-- 模態框 用於 list delete-->
    <div class="modal fade" tabindex="-1" role="dialog" id="listDeleteModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">Flashcard</h4>
                </div>
                <div class="modal-body">
                    <label id="modal_fcTerm" style="font-size: 20px;">term</label>
                    <br />
                    <label id="modal_fcDefinition" style="font-size: 20px;">definition</label>
                </div>
                <div class="modal-footer">
                    <form id="modal_form" action="${pageContext.request.contextPath}/flashcard/" method="post">
                        <input type="hidden" name="_method" value="delete" />
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                            <font color="black">Close</font>
                        </button>
                        <button id="model_delete" type="submit" class="btn btn-primary" style="background: red;">Delete
                            Data</button>
                    </form>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->
</body>
</html>