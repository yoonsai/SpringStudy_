<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <div class="container">
    <div class="row">
      <c:forEach var="vo" items="${list }">
        <a href="../main/detail.do?fno=${vo.fno}">
         <div class="col-md-3">
           <div class="panel panel-primary">
            <div class="panel-heading">${vo.name }</div>
           <div class="panel-body"><img src="https://www.menupan.com${vo.poster }" style="width: 240px;height: 200px"></div>
         </div>
         </div>
         </a>
      </c:forEach>
    </div>
    
    <div style="height: 20px"></div>
    
    <div class="row">
     <div class="text-center">
      <ul class="pagination">
        <c:if test="${startPage>1}">
       <li><a href="../main/main.do?page${startPage-1 }">&lt;</a></li>
       </c:if>
       <c:forEach var="i" begin="${startPage }" end="${endPage }">
       <li ${curpage==i?"class=active":"" }>
       <a href="../main/main.do?page=${i }">${i}</a>
       </li>
       </c:forEach>
       <c:if test="${endPage<totalpage}">
       <li><a href="${endPage+1}">&gt;</a></li>
       </c:if>
      </ul>
    </div>
    </div>
    <div style="height: 20px"></div>
      <div class="row">
        <h3>최근 방문 맛집</h3>
      </div>
  </div>
</body>
</html>