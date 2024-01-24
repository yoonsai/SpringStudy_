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
   width: 960px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let bClick=true
$(function(){
	$('#del').click(function(){
		if(bClick==true)
		{
		    bClick=false;
		    $('#delTr').show();
		    $('#del').text("취소");
		}
		else{
			bClick=true;
			$('#delTr').hide();
			$('#del').text("수정");
		}
	})
	$('#delBtn').on('click',function(){
		let no=$(this).attr('data-no');
		let pwd=$('#pwd').val();
		alert(no+" "+pwd)
		if(pwd.trim()==="")
		{
			$('#pwd').focus();
			return;
		}
		$.ajax({
			type:'post',
			url:'delete_ok.do',
			data:{'no':no,'pwd':pwd},
			success:function(result){
				if(result=='yes')
				{
					location.href="list.do"
				}
				else{
					alert("비밀번호가 틀립니다");
					$('#pwd').val("");
					$('#pwd').focus();
				}
			}
		})
	})
})

</script>
</head>
<body>
  <div class="container">
  <div class="row">
  <h3 class="text-center">상세보기</h3>
    <table class="table">
     <tr> 
      <th width="20%" class="text-center">번호</th>
      <td width="30%" class="text-center">${vo.no }</td>
      <th width="20%" class="text-center">작성일</th>
      <td width="30%" class="text-center">${vo.dbday }</td>
     </tr>
    <tr> 
      <th width="20%" class="text-center">이름</th>
      <td width="30%" class="text-center">${vo.name }</td>
      <th width="20%" class="text-center">조회수</th>
      <td width="30%" class="text-center">${vo.hit }</td>
     </tr>
     <tr> 
      <th width="20%" class="text-center">제목</th>
      <td colspan="3">${vo.subject }</td>
     </tr>
     
     <c:if test="${vo.filecount>0 }">
       <tr>
         <th width="20%" class="text-center">첨부파일</th>
         <td colspan="3">
           <ul>
            <c:forEach var="filename" items="${fList}" varStatus="s">
                <li><a href="download.do?fn=${filename}">${filename }</a>(${sList[s.index]}Bytes)</li>
             </c:forEach>
            </ul>
         </td>
       </tr>
     </c:if>
     
     <tr> 
      <td colspan="4" class="text-left" valign="top" height="200">
       <pre style="white-space: pre-wrap;border:none;">${vo.content }</pre>
      </td>
     </tr>
     <tr> 
      <td colspan="4" class="text-right">
       <a href="update.do?no=${vo.no }" class="btn btn-xs btn-danger">수정</a>
       <span class="btn btn-xs btn-danger" id="del">삭제</span>
       <a href="list.do" class="btn btn-xs btn-danger">목록</a>
      </td>
     </tr>
     <tr style="display:none" id="delTr">
       <td colspan="4" class="text-right">
        비밀번호:<input type="password" name="pwd" size="10" class="input-sm" id="pwd">
               <input type="submit" value="삭제" class="btn-sm btn-warning" data-no="${vo.no }" id="delBtn">
     </tr>
    </table>
    </div>
  </div>
</body>
</html>