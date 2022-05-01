<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/public/bootstrapCommon.jsp" />

<style type="text/css">
</style>

<script type="text/javascript">
  $(document).ready(function() {
	$(".tt").click(function() {
	  var d = $("#id1").data("d2");
	  var d2 = $("#a1").data("d1");
	  var d3 = $("#a1").data("orderTerm");
	  console.log("xxxx1 " + d);
	  console.log("xxxx2 " + d2);
	  console.log("xxxx3 " + d3);
	});
  });

  /*初始化修改部門列表*/
  //* 
  function updateDpet() {
	// 初始化部門修改信息下拉列表

	$('#updateDeptMd').on('show.bs.modal', function(e) {
	  var id = $(e.relatedTarget).data('orderid'); //根據上面a標籤中傳遞的data-orderid取值,這裏也可以通過data-id取值
	  var term = $(e.relatedTarget).data('orderterm');
	  var definition = $(e.relatedTarget).data('orderDefinition');
	  var data = $('#a1').data('orderterm');// 也可以直接取data對象再取值
	  var data2 = $('#a1').data('orderterm');// 也可以直接取data對象再取值
	  console.log("id=" + id);
	  console.log("term=" + term);
	  console.log("data=" + data);
	  console.log("data2=" + data2);

	  $('#updateDeptId').val(id);
	  $('#updateDeptName').val(term);

	  // 到後臺獲取部門信息
	  /*
	  $.ajax({
	  url : '${pageContext.request.contextPath}/ajax/flashcard/' + id,
	  type : 'GET',
	  data : {
	    id : id
	  },
	  dataType : 'json',
	  success : function(data) {
	    console.log('xxx=' + data);
	    //查詢empId 
	    $('#updateDeptId').val(data.id);
	    $("#updateDeptName").val(data.term);
	  },
	  error : function() {
	    console.log('xxx=error');
	  }
	  });
	  //*/
	});
  }
  //*/
</script>
</head>
<body>
    <jsp:include page="/WEB-INF/view/public/header.jsp" flush="true">
        <jsp:param name="active" value="" />
    </jsp:include>


    <div class="container" id="x1">
        <h1>歡迎使用 FlashCard</h1>
    </div>

    <br />
    <br />
    <br />

    <div class="container">
        <span class="s1" id="id1" data-d1="${fc.term}" data-d2="${fc.definition}">xxx1</span>
        <br>
        <span class="tt">xxx2</span>
    </div>
    <br />
    <br />
    <br />

    fc=${fc.term}

    <div class="container">
        <a id="a1" href="#updateDeptMd" data-toggle="modal" class="btn btn-success btn-xs" data-orderId="${fc.id}"
            data-orderTerm="${fc.term}" data-orderDefinition="${fc.definition}" data-d1="${fc.term}"
            onclick="updateDpet()">修改</a>
    </div>

    <!--修改部門的模態框-->
    <div class="modal" id="updateDeptMd" data-cc="xx">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title">修改部門信息</h3>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="updateDeptFom">
                        <div class="form-group">
                            <label for="updateId" class="control-label col-md-2">Id</label>
                            <div class="col-md-10">
                                <input class="form-control" type="text" id="updateDeptId" name="id" readonly />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="updateName" class="control-label col-md-2">部門名稱</label>
                            <div class="col-md-10">
                                <input class="form-control" type="text" id="updateDeptName" name="name" />
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" id="updateDeptBtn">修改</button>
                </div>
            </div>
        </div>
    </div>


    <br />
    <br />
    <br />

</body>
</html>