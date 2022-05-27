<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="er" uri="https://idv.kw/tags/editor"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/view/public/bootstrapCommon.jsp" />

<!-- selected model global variable -->
<script type="text/javascript">
      var contextPath;
      var models;
      var pageNum=1;
      var pageInfo;
      
</script>



<!-- get datas and list -->
<script type="text/javascript">
      $(function() {
          contextPath=$(".list-group-item-title").attr("data-contextPath");
          models=$(".list-group-item-title").attr("data-queryPath");

          getDatas(pageNum);
        
      });
      
      //get datas from ajax
      function getDatas(num){
          //失效時不處理
      	  if($(this).hasClass('hrefDisabled')){
      		return;
      	  }
    	
          pageNum=num;
          
          $.ajax({
              type : "get",
              dataType:"json",
              url :  contextPath+"/simple/"+models+"/"+num, 
              success : function(resp) {
                
                datas = [];
                pageInfo = resp.pageInfo;
                for (i = 0; i < pageInfo.list.length; i++) {
                  datas.push(pageInfo.list[i]);
                }
                
                createListDomElement(datas);
    
                //處理分頁
                doPager(); 
              },
    
              error : function(thrownError) {
                alert("error:" + thrownError);
              }
            });
          
        //創建list item
          function createListDomElement(ds) {
            $(".list-group-item-title").next().addClass("list-group-item-replaced");
            $(".list-group-item-replaced").nextUntil(".list-group-item-footer").remove(); 
            
            const domElements = ds.map( place => {
              
              return `
              <li class="list-group-item"><a href="javascript:;" class="list-group-item">
                  <span class="badge" onclick="">
                      <font size="5">cited</font>
                  </span>
                  <h4 class="h4" class="list-group-item-heading"> $<c:out value="{place.value}" /> </h4>
              </a></li>
          	  ` ;
            }).join("");
            $('.list-group-item-replaced').replaceWith(domElements);
          }
        }
      
    </script>

<!-- pager -->
<script type="text/javascript">
      //(延後載入)
      function doPager() {
          $(".pager li ul .pager-first a").attr("onclick","getDatas.call($(this),"+1+")");
          doPagerAction(".pager li ul .pager-first",pageInfo.pageNum == 1);
          
          $(".pager li ul .pager-previous a").attr("onclick","getDatas.call($(this),"+(parseInt(pageInfo.pageNum)-1)+")");
          doPagerAction(".pager li ul .pager-previous",!pageInfo.hasPreviouPage);
        
            createPagerDomElement(pageInfo.navigatepageNums);
    
          $(".pager li ul .pager-next a").attr("onclick","getDatas.call($(this),"+(parseInt(pageInfo.pageNum)+1)+")");
          doPagerAction(".pager li ul .pager-next",!pageInfo.hasNextPage);
    
          $(".pager li ul .pager-last a").attr("onclick","getDatas.call($(this),"+pageInfo.navigateLastPage+")");
          doPagerAction(".pager li ul .pager-last",pageInfo.isLastPage);
      }
    
      function createPagerDomElement(navigatepageNums) {
        $(".pager-previous").next().addClass("pager-pageNum-replaced");
        $(".pager-pageNum-replaced").nextUntil(".pager-next").remove(); 
        
        const domElements = navigatepageNums.map( place => {
          var path=contextPath+"/"+models+"/"+place;
          
          if(pageNum==place){
            return `
            <li class="active"><a class="hrefDisabled" href='javascript:;' onclick=''>$<c:out value="{place}" /></a></li>
          `;
          }else{
            return `
            <li><a href='javascript:;' onclick='getDatas.call($(this),$<c:out value="{place}" />)'>$<c:out value="{place}" /></a></li>
          `;
          }
        }).join("");
        
        $('.pager-pageNum-replaced').replaceWith(domElements);
      }
      
      //使失效中
      function doPagerAction(selector,ineffective) {
        if(ineffective){
            $(selector).addClass("disabled");
            $(selector + " a").addClass("hrefDisabled");
        }else{
            $(selector).removeClass("disabled");
            $(selector + " a").removeClass("hrefDisabled");
        }
      }
      
    </script>

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
            <frm:form action="${pageContext.request.contextPath}/{path}" modelAttribute="data"
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

    <!-- 分頁 -->
    <div class="container">
        <ul class="pager">
            <li>
                <ul class="pagination">
                    <li></li>
                    <!-- 首頁 -->
                    <li class="disabled??? pager-first"><a class="hrefDisabled???" href="javascript:;">&laquo;
                        </a></li>

                    <!-- 上一頁 -->
                    <li class="disabled??? pager-previous"><a class="hrefDisabled???" href="javascript:;">Previous
                        </a></li>

                    <!-- 中間頁數 -->
                    <li class="pager-pageNum-replaced"></li>

                    <!-- 下一頁 -->
                    <li class="disabled??? pager-next"><a class="hrefDisabled???" href="javascript:;">Next </a></li>

                    <!-- 最末頁 -->
                    <li class="disabled??? pager-last"><a class="hrefDisabled???" href="javascript:;">&raquo; </a></li>
                    <li></li>
                </ul>
            </li>
        </ul>
    </div>
    <!-- /分頁 -->

    <!-- list -->
    <div class="container">
        <ul class="list-group myBadgeCursor">
            <li class="list-group-item list-group-item-title" data-contextPath="${contextPath }"
                data-queryPath="${editor.attributes.selectedModelQueryPath}"><span class="badge" onclick="">
                    <font size="5">totle</font>
                </span>
                <h3>${editor.attributes.selectedModelTitle}</h3></li>

            <li class="list-group-item-replaced"></li>
        </ul>
    </div>
    <!-- /list -->

</body>
</html>