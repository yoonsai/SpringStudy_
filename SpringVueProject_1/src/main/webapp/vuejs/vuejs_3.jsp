<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script src="https://unpkg.com/vue@3"></script>
</head>
<body>
   <div class="container">
    <div class="row">
      <table class="table">
        <tr>
          <th class="text-center">사번</th>
          <th class="text-center">이름</th>
          <th class="text-center">성별</th>
          <th class="text-center">부서</th>
          <th class="text-center">근무지</th> 
        </tr>
        <!-- v-for과 v-if는 동시에 사용할 수 없다 -->
        <tr v-for="vo in sawon">
          <td class="text-center" v-if="vo.loc=='서울'">{{vo.sabun}}</td>
          <td class="text-center" v-if="vo.loc=='서울'">{{vo.name}}</td>
          <td class="text-center" v-if="vo.loc=='서울'">{{vo.sex}}</td>
          <td class="text-center" v-if="vo.loc=='서울'">{{vo.dept}}</td>
          <td class="text-center" v-if="vo.loc=='서울'">{{vo.loc}}</td> 
        </tr>
      </table>
    </div>
   </div>
   <script>
    let app=Vue.createApp({
    	data(){
    		return {    
    			sawon:[
    				{ sabun: '001', name: '홍길동', sex: '남', dept: '개발팀', loc: '서울' },
                    { sabun: '002', name: '이순신', sex: '남', dept: '디자인팀', loc: '부산' },
                    { sabun: '003', name: '김영희', sex: '여', dept: '마케팅팀', loc: '서울' },
                    { sabun: '005', name: '심청이', sex: '여', dept: '개발팀', loc: '서울' },
                    { sabun: '006', name: '박문수', sex: '남', dept: '디자인팀', loc: '부산' },
                    { sabun: '007', name: '박문길', sex: '남', dept: '마케팅팀', loc: '서울' }
    			]
    		}
    	}
    }).mount('.container');
   </script>
  </body>
</html>