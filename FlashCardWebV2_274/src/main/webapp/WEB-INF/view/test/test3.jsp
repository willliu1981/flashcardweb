<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/public/bootstrapCommon.jsp" />

<style type="text/css">
div.panel, p.flip {
	margin: 0px;
	padding: 5px;
	text-align: center;
	background: #e5eecc;
	border: solid 1px #c3c3c3;
}

div.panel {
	height: 120px;
	display: none;
	position: absolute;
}

.siblings * {
	display: block;
	border: 2px solid lightgrey;
	color: black;
	padding: 5px;
	margin: 15px;
}
</style>

<script type="text/javascript">
  function callback1() {
	$("p").toggle(1000);
  }

  $(document).ready(function() {

	//* 	
	$(".flip").click(function() {
	  $(".panel").slideDown(1000);
	  $(".panel").animate({
		left : '300px',
		height : '+=300px',
		width : '+=300px'

	  });
	}); //*/

	$(".flipup").click(function() {
	  $(".panel").animate({
		left : '300px',
		height : 'toggle',
		width : 'toggle'

	  });
	}); //*/

	/* 	$("button").click(function() {
	 $(this).css("background", "red");
	 $("p").toggle(1000, callback1());
	 }); */

	/* 	$("#dataTable tbody tr").on("click", function() {
	 console.log($(this).text());
	 }); */
  });

  /*   function notify() {
   alert("clicked");
   }

   $("button").on("click", notify); */

  /*初始化修改部門列表*/
  /* 
  function updateDpet() {
  // 初始化部門修改信息下拉列表

  $('#updateDeptMd').on('show.bs.modal', function(e) {
    var id = $(e.relatedTarget).data('orderid'); //根據上面a標籤中傳遞的data-orderid取值,這裏也可以通過data-id取值
    var term = $(e.relatedTarget).data('orderTerm');
    var definition = $(e.relatedTarget).data('orderDefinition');
    var data = $('#updateDeptMd').data('cc');// 也可以直接取data對象再取值
    console.log("id=" + id);
    console.log("term=" + term);
    console.log("data=" + data);

    $('#updateDeptId').val(id);
    $('#updateDeptName').val(term);

    // 到後臺獲取部門信息
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




    <div class="panel">
        <p>xxxxxxxxxxx</p>
        <ul>
            <li><span>click me2</span></li>
            <li><span>click me3</span></li>
            <li><span>click me4</span></li>
        </ul>
    </div>

    <table class="dataTable">
        <tbody>
            <tr>
                <td>
                    <p class="flip">click me</p>
                    <p class="flipup">flip up</p>
                    <button>xxx</button>
                </td>
            </tr>
        </tbody>



    </table>





    fc=${fc.term}

    <a href="#updateDeptMd" data-toggle="modal" class="btn btn-success btn-xs" data-orderId="${fc.id}"
        data-orderTerm="${fc.term}" data-orderDefinition="${fc.definition}" onclick="updateDpet()">修改</a>

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




</body>
</html>