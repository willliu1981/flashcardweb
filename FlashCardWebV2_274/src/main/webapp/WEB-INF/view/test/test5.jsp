<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/public/bootstrapCommon.jsp" />

<style type="text/css">
</style>

<script type="text/javascript">
  
</script>
</head>
<body>
    <jsp:include page="/WEB-INF/view/public/header.jsp" flush="true">
        <jsp:param name="active" value="" />
    </jsp:include>


    <div class="container" id="x1">
        <h1>歡迎使用 FlashCard</h1>
    </div>


    <form id="model_formID" action="${pageContext.request.contextPath}/flashcard/r" method="post">
        <input type="hidden" name="_method" value="delete" />
        <button id="model_delete" type="submit" style="background: red;">Delete Data</button>
    </form>

    <form id="model_formID" action="${pageContext.request.contextPath}/flashcard" method="post">
        <input type="text" name="term" value="x1" />
        <input type="text" name="definition" value="XX1" />

        <button id="model_delete" type="submit" style="background: blue;">Add</button>
    </form>

    <form id="model_formID" action="${pageContext.request.contextPath}/flashcard" method="post">
        <input type="hidden" name="_method" value="put" />
        <input type="hidden" name="id" value="xx" />
        <input type="text" name="term" value="txx" />
        <input type="text" name="definition" value="txx1" />

        <button id="model_delete" type="submit" style="background: green;">Edit</button>
    </form>

    <form id="model_formID" action="${pageContext.request.contextPath}/debug_flashcard2/s/s" method="post">
        <input type="hidden" name="_method" value="put" />
        <input type="hidden" name="id" value="a" />
        <input type="text" name="term" value="txx2" />
        <input type="text" name="definition" value="txx2" />

        <button id="model_delete" type="submit" style="background: orange;">Debug</button>
    </form>

    <br />
    <br />
    <br />




    <br />
    <br />
    <br />

</body>
</html>