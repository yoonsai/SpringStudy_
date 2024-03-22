<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
  margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 800px;
}
</style>
</head>
<body>
  <div class="container">
   <div class="row">
    <h3 class="text-center">상세보기</h3>
    <table class="table">
      <tr>
       <th width=10% class="text-center">번호</th>
       <td width=10% class="text-center">${vo.no }</td>
      </tr>
      <tr>
       <th width=15% class="text-center">이름</th>
       <td width=15% class="text-center">${vo.name }</td>
      </tr>
      <tr>
       <th width=45% class="text-center">제목</th>
       <td width=45%>${vo.subject }</td>
      </tr>
        <tr>
         <th width=20% class="text-center">작성일</th>
         <td width=20% class="text-center">${vo.dbday }</td>
         
        </tr>
        <tr>
         <th width=10% class="text-center">조회수</th>
         <td width=10% class="text-center">${vo.hit }</td>
        </tr>
        <tr>
          <td colspan="2">
             <a href="update.do?no=${vo.no}" class="btn btn-info btn-sm">수정</a>
             <a href="#" class="btn btn-info btn-sm">삭제</a>
             <a href="#" class="btn btn-info btn-sm">목록</a>
          </td>
        </tr>
        
    </table>
   </div>
  </div>
</body>
</html>


