<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ls" uri="https://idv.kw/tags/list"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
  function modalValues(id,... datas) {
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
            <li class="list-group-item"><ls:listHeader></ls:listHeader></li>
            <ls:eachItem var="item">
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
                    <ls:modalHeader></ls:modalHeader>
                </div>
                <div class="modal-body">
                    <ls:modalBody></ls:modalBody>
                </div>
                <div class="modal-footer">
                    <ls:modalFooter>
                        <input type="hidden" name="_method" value="delete" />
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                            <font color="black">{btnCloseName}</font>
                        </button>
                        <button id="model_delete" type="submit" class="btn btn-primary" style="background: red;">{btnDeleteName}</button>
                    </ls:modalFooter>
                </div>
            </div>
        </div>
    </div>
</body>
</html>