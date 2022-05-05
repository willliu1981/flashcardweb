<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tx" uri="https://fc.idv/jsp/tlds/myTestTags"%>
<%@ taglib prefix="fc" uri="https://fc.idv/jsp/tlds/myFCTags"%>
<%@ page import="idv.fc.taglib.listgroup.ModelType"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style type="text/css">
</style>

</head>
<body>

    <div>
        <tx:Calc num1="2" num2="3" />
    </div>
    <div>
        <tx:CalcArea operation="squ" num1="2" num2="4" />
    </div>
    <div>fc=${fc}</div>
    <div>
        tag fc=
        <%----%> <fc:Test model="${fc}" /> 
    </div>

</body>
</html>