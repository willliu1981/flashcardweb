<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ls" uri="https://fc.idv/jsp/tlds/listTags"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
  function modelValues(id,... datas) {
	var items=$(".modal-body").find(".modal-body-item");

	/* show datas */
	for(var i=0; i<datas.length;i++){
	  items[i].innerHTML=datas[i];
	}
	
	/* delete */
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
            <li class="list-group-item">${facade.listTitle}
                <h3>${title}</h3>
            </li>

            <ls:eachItem listFacade="${facade}" var="item">
                <li class="list-group-item"><a href="#" class="list-group-item">${item}</a></li>
            </ls:eachItem>
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
                <div class="modal-body">${facade.modalBody}</div>
                <div class="modal-footer">
                    <form id="modal_form" action="${pageContext.request.contextPath}/${pathForList}/" method="post">
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