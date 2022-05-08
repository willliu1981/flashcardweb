<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
  //$("#listDeleteModal").model("hide");
  function modelValues(id) {
	modelValues(id, "");
  }

  function modelValues(id, var1) {
	modelValues(id, var1, "");
  }

  function modelValues(id, var1, var2) {
	modelValues(id, var1, var2, "");
  }

  function modelValues(id, var1, var2, var3) {
	$("#modal_var1").text(var1);
	$("#modal_var2").text(var2);
	$("#modal_var3").text(var3);
	$("#modal_form").attr("action", function(i, orig) {
	  return orig + id;
	});
  }
</script>
</head>

<body>
    <!-- list -->
    <div class="container">
        <ul class="list-group myBadgeCursor">
            <li class="list-group-item">${listGroup.getTitleResult()}
                <h3>${title}</h3>
            </li>
            <c:forEach var="i" begin="0" end="${listGroup.itemSize-1}">
                <li class="list-group-item"><a href="#" class="list-group-item"> ${listGroup.getBodyResult(i) }
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
                    <h4 class="modal-title">${title}</h4>
                </div>
                <div class="modal-body">
                    <label id="modal_var1" style="font-size: 20px;">term</label>
                    <br />
                    <label id="modal_var2" style="font-size: 20px;">definition</label>
                    <br />
                    <label id="modal_var3" style="font-size: 20px;">var3</label>
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