<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fc" uri="https://fc.idv/jsp/tlds/myFCTags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/view/public/bootstrapCommon.jsp" />

<style type="text/css">
</style>

</head>
<body>

    <div>
        <fc:Test model="${fc}">tag fc </fc:Test>
    </div>

    <div>
       <%--  <jsp:include page="/WEB-INF/view/public/list2.jsp"></jsp:include> --%>
    </div>

</body>
</html>