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
  width: 700px;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div class="container">
    <h3 class="text-center">글쓰기</h3>
    <div class="row">
     <%--
           form => 기본 기능 (서버로 데이터 전송)
                => 화면 reset
                => 기능을 동작하지 못하게 만든다 @submit.prevent
      --%>
     <form @submit.prevent="submitForm">
      <table class="table">
       <tr>
        <th width=15% class="text-center">이름</th>
        <td width=85%>
         <input type=text size=15 class="input-sm" v-model="name" ref="name">
        </td>
       </tr>
       <tr>
        <th width=15% class="text-center">제목</th>
        <td width=85%>
         <input type=text size=50 class="input-sm" v-model="subject" ref="subject">
        </td>
       </tr>
       <tr>
        <th width=15% class="text-center">내용</th>
        <td width=85%>
         <textarea rows="10" cols="52" v-model="content" ref="content"></textarea>
        </td>
       </tr>
       <tr>
         <th width=15% class="text-center">첨부파일</th>
         <td width=85%>
           <input type="file" ref="upfiles" class="input-sm" multiple="multiple" accept="upload/*" v-model="upfiles">
         </td>
       </tr>
       <!-- multiple="multiple" 파일 여러개 첨부가능 files 배열에 저장 /  accept="upload/*"  모든 파일 유형 선택 가능
            사용자가 여러 파일을 선택하면 각 파일은 파일 입력 요소의 files 속성에 배열로 저장됩니다.
        -->
       <tr>
        <th width=15% class="text-center">비밀번호</th>
        <td width=85%>
         <input type=password size=15 class="input-sm" v-model="pwd" ref="pwd">
        </td>
       </tr>
       <tr>
         <td colspan="2" class="text-center">
           <input type="submit" value="글쓰기" class="btn-success btn-sm">
           <input type="button" value="취소" onclick="javascript:history.back()"
            class="btn-info btn-sm"
           >
         </td>
       </tr>
      </table>
     </form>
    </div>
  </div>
  <script>
  let app = Vue.createApp({
    // 멤버 변수 설정
    data() {
      return {
        name:'',
        subject:'',
        content:'',
        pwd:'',
        upfiles:''
      }
    },
    // 멤버 함수 설정
    methods: {
      // submit 버튼 호출시에 => 데이터 전송이 없이 submitForm()를 호출
      //@submit.prevent
      // submit / a => defaultPrevent => 이벤트 동작을 중지
      submitForm() {
        // NOT NULL => 유효성 검사
        if (this.name === "") {
          this.$refs.name.focus(); // ref는 태그를 제어
          return;
        }
        if (this.subject === "") {
          this.$refs.subject.focus(); // ref는 태그를 제어
          return;
        }
        if (this.content === "") {
          this.$refs.content.focus(); // ref는 태그를 제어
          return;
        }
        if (this.pwd === "") {
          this.$refs.pwd.focus(); // ref는 태그를 제어
          return;
        }

        // form에 있는 모든 데이터를 불러올 때 사용
        let formData = new FormData();
        // 데이터 추가
        formData.append("name", this.name);
        formData.append("subject", this.subject);
        formData.append("content", this.content);
        formData.append("pwd", this.pwd);

        let leng = this.$refs.upfiles.files.length; //files 파일의 길이 가져올 때 사용하는것
        //alert("leng=" + leng);
        if(leng>0)
        {
        	for(let i=0;i<leng;i++)
        	{
        		formData.append("files["+i+"]",this.$refs.upfiles.files[i])
        	}
        }
        
        // 서버로 전송
        axios.post('../databoard/insert_vue.do',formData,{
        	header:{
        		//post기반의 파일 업로드 프로토콜
        		'Content-Type':'multipart/form-data'
        	}
        })
        .then(response=>{
      	  if(response.data==='yes')
      	  {
      		  location.href="../databoard/list.do"
      	  }
      	  else{
      		  alert(response.data) //자바에서 에러났을때
      	  }
        }).catch(error=>{
      	 console.log(error.response) // vue에서 에러났을때는 개발자도구
        })

      } //submitForm()끝
      
      
    },
    // CallBack => Vue에 의해 호출되는 함수
    mounted() {
      // 시작과 동시에 처리
    },
    updated() {
      // 데이터를 갱신 => component를 만든 경우
    }
  });
  app.mount('.container'); // 올바른 마운트 설정
  
</script>

</body>
</html>