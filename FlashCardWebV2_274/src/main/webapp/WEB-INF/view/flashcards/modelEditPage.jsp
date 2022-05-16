<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="er" uri="https://idv.kw/tags/editor"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/public/bootstrapCommon.jsp" />
</head>
<body>
    <er:setEditor type="${erType}" var="editor" />

    <!-- include header nav -->
    <jsp:include page="/WEB-INF/view/public/header.jsp" flush="true">
        <jsp:param name="active" value="" />
    </jsp:include>

    <!-- 引入巨屏 -->
    <jsp:include page="/WEB-INF/view/public/jumbotron.jsp">
        <jsp:param name="title" value="${editor.attributes.jumboTitle}" />
    </jsp:include>

    <div class="container">
        <er:form facade="${editor}">
            <frm:form action="${pageContext.request.contextPath}/flashcard" modelAttribute="data"
                cssClass="form-horizontal">
                <fieldset>
                    <legend> {formTitle} </legend>
                    {formBody}
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <button type="reset" class="btn btn-default" style="color: black;">Cancel</button>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </div>
                </fieldset>
            </frm:form>
        </er:form>
    </div>

</body>
</html>