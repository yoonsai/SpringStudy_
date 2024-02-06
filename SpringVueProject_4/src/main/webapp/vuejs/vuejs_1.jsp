<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
      Vue : Evan You (구글 => AnglarJS:복잡)
            IBM => OS2, MS 도스창
            | 단순한 프레임워크 (VueJS => 1.단순하다, 가벼운 프레임 워크
                                    2.데이터를 효율적으로 다룰 수 있음
                                    3. 속도가 빠르다
                                    4. 코드의 재사용이 가능
                                    5. 컴포넌트 기반
                                    => 전자상거래, 대시보드, 블로그, 뉴스 사이트
            사용 : MVVM
                  M (Model) : 데이터 저장 => data()
                  V (View) : 화면 출력 {{}}, v-for, v-model, v-if, v-show, v-if v-else
                  VM (ViewModel) : 상태(데이터관리,연산처리)
                                   생명주기
                                   1. mounted : onload
                                   2. updated : 수정
                                   3. 사용자 정의
                                      methods:{
                                        => 이벤트 처리
                                      }
                                   4. components:{
                                        기능 => 이미지카드, 애니메이션 => 재사용이 가능 
                                      }
                                   5. filter : 10,000
                                      computed : 계산된 경우
            -------------------------------------------------------------------------
            1. Vue객체 생성 => 여러개 생성이 가능
               ------
               | 범위 지정 ==> mount('태그명, 클래스명, id명')
               
               let app=Vue.createApp({
                   ----------------------
                   Model => 데이터 관리
                   data(){
                     return {
                        fno:0,
                        list:[], Array
                        obj:{}, object => 자바스크립트 객체
                        isShow:true => Boolean
                        =============================== 멤버변수 => 이걸 쓰려면 this. 이렇게 써야함 
                     } => 선언/초기화만 가능 => 서버(spring/nodeJS)읽기가 불가능 
                   }
                   -----------------------------
                   ViewModel => 데이터 처리
                  1) 변수의 초기화
                     => 서버나 파일
                     => 이미 만들어진 메소드 (CallBack) => Vue동작 시 자동으로 호출
                     => compoenentDI
                     mounted(){
                        서버나 파일 읽기 => data에 저장된 변수에 초기화
                        ===
                        axios.get("서버URL",{
                                     서버로 요청하는 데이터 설정
                                     params:{
                                         fno:1,
                                         id:'admin'
                                     }
                                 }).then(res(결과값을 받는다)=>{
                                     멤버변수에 대입
                                 })
                        axios.post("서버URL",{
                                     서버로 요청하는 데이터 설정
                                     params:{
                                         fno:1,
                                         id:'admin'
                                     }
                                 }).then(res(결과값을 받는다)=>{
                                     멤버변수에 대입
                                 })
                     }
                     ------------------
                     사용자 정의 메소드 
                     이벤트 (버튼 클릭, 마우스 오버, key...)
                     methods:{
                         btnClick(){
                           
                         },
                         mouseClick(){
                         
                         }
                         재사용을 목적
                         components:{
                            template:'<div></div>'
                         }
                     }
               })
               =======================
               화면 출력
               
               출력 형식
               <div>{{data()에 설정}}</div> => text() $().text("")
               <div :data-no="fd"> => :속성명="변수명"
               디렉티브
                 => v-for="vo in 배열명" => v-for="(vo,index) in 배열명" ==> 인덱스번호도 가져올 수 있음
                 => v-if="true/false"
                 => v-show="true/false" => display:none, display:''
                 => v-if ~ v-else
                 => v-if ~ v-elseif ~ v-else
                 => 입력값 => 멤버변수에 전송 => v-model="멤버변수 설정"
               => 이벤트
                  v-on:click ==> @click="사용자 정의 메소드"
                  v-on:change ==> @change
                  v-on:keyup ==> @keyup.enter, space...
                  v-on:keydown ==> @keydown
               => 프로그램
                  => 반복수행을 할때 : 메소드를 제작
                  => 시작과 동시에 데이터 읽기
                     ================== mounted()
                  => 이전 this.curpage-1
                  => 다음 this.curpage+1
                  => 블록별 번호 this.curpage=값
               class A
               {
                  state={
                    
                  }
                  componentDiMount(){mounted()}
                  btnclick(){
                  }
               }
               => react:단독처리
               => JSP / Spring => PR
                  

--%>
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
.images:hover{
   cursor:pointer;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
</head>
<body>
  <div class="container">
    <div class="row">
      <h3 class="text-center">{{message}}</h3>
      <input type="button" value="클릭" @click="change()"><br>
      <input type="text" size="20" v-model="message">
    </div>
  </div>
  <script> 
   let app=Vue.createApp({
	   data(){
		   return {
			   message:'Hello Vue'
		   }
	   },
	   // 데이터 처리 / 초기화 => viewModel => MVVM
	   methods:{
		   change(){
			   this.message="변경됨"
		   }
	   }
   }).mount('.container')
  </script>
</body>
</html>