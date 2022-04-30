<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/public/bootstrapCommon.jsp" />
</head>
<body>
    <!-- header include nav -->
    <jsp:include page="/WEB-INF/view/public/header.jsp" flush="true">
        <jsp:param name="active" value="flashcard-add" />
    </jsp:include>

    <!-- 巨屏 -->
    <div class="jumbotron">
        <div class="container">
            <h1>FlashCard</h1>
            <p>Flashcard 編輯</p>
        </div>
    </div>

    <div class="container">
        <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/flashcard">
            <fieldset>
                <legend>新增 Flashcard</legend>
                <div class="form-group">
                    <label for="inputEmail" class="col-lg-2 control-label">Term</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" name="term" placeholder="Ex: apple">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-lg-2 control-label">Definition</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" name="definition" placeholder="Ex: 蘋果">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <button type="reset" class="btn btn-default">Cancel</button>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>


    <!-- 模態框 -->
    <div class="modal fade" tabindex="-1" role="dialog" id="myModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">FlashCard</h4>
                </div>
                <div class="modal-body">
                    <p>編輯中&hellip;</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->
</body>
</html>