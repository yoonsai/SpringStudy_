<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3"></script>
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#msg').keyup(function(){
		$('#print').text($('#msg').val())
	})
});

</script> -->
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
<!-- 
   mount 가상 메모리에 저장
   mounted 올라간 상태
   가상 돔에 저장
   diff 변경된 부분만 변경 -> vuejs에 저장되어있음


   Vue : 1. 가상 돔을 사용 => 속도를 빠르게 처리
            mount => 가상 메모리에 저장
             => string  / stringbuffer
         2. 생명주기 => callback
         3. 디렉티브 => 제어문
         4. 서버연동 => axios
         5. 출력 형식 => {{}} / :src=
         6. 양방향 => v-model
         7. router => 화면 변경
         ==================================
         8. vue-bootstrap
         
         1. 생명주기 => vue3(react), vuex(mvc)
         beforeCreate()
         created()
         ------------------------ Vue객체 생성
         beforeMount()
         mounted()
         ------------------------ 가상 메모리에 HTML을 올린 경우
            => $(function(){}), window.onload
            => 서버에서 데이터를 읽는다 : 멤버변수에 저장
            => Jquery연동
         beforeUpdate()
         updated()
         ----------------- 데이터 갱신
            => component : Main / Sub => sub에 값을 전송 => $emit
         beforeDestory()
         destoryed()
         ----------------- 메모리 해제
         
         
 -->
<body>
   <div class="container">  
     <div class="row">
       <input type="text" size="30" class="input-sm" v-model="msg">
       <!-- v-model="msg" => 입력한 값을 msg에 저장해라 -->
     </div>
     <div class="row">
       <div>{{msg}}</div>
     </div>
   </div>
   
   <script>
     // Vue Js
     let app=Vue.createApp({
    	 data(){
    		 //멤버변수 설정
    		 return {
    			 msg:''
    		 }		 
    	 },
    	 // callback함수
    	 // vue에 의해 자동으로 호출됨
    	 beforeCreate(){
    		 console.log("Vue객체 생성 전:beforeCreate() Call")
    	 },
    	 created(){
    		 console.log('Vue객체 생성 완료:created() Call') 
    	 },
    	 beforeMount(){
    		console.log('Html과 데이터를 가장메모리에 올리기 전:beforeMount() Call') 
    	 },
    	 mounted(){
    		console.log('가상 메모리에 HTML이 올라간 상태: window.onload, $(function(){})), mounted() Call') 
    	 },
    	 beforeUpdate(){
    		 console.log('변경전 : beforeUpdate() Call')
    	 },
    	 updated(){
    		console.log("변경 완료:updated() Call") 
    	 },
    	 beforeDestory(){
    		 console.log('Vue객체 메모리 해제 전:beforeDestory() Call')
    	 },
    	 destoryed(){
    		 console.log("Vue객체 메모리 해제:destoryed() Call")
    	 },
    	 //사용자 정의 메소드
    	 methods:{
    		 
    	 }
     }).mount('.container')
   </script>
</body>
</html>