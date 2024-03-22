<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row1{
  margin:0px auto;
  width: 400px;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
 <div class="wrapper row3" id="loginApp">
    <main class="container clear"> 
      <h2 class="sectiontitle">회원가입</h2>
      <div class="row row1">
         <table class="table">
           <tr>
             <td width="20%" class="text-right">ID</td>
             <td width="80%">
               <input type="text" name="id" class="input-sm" v-model="id" ref="id">
             </td>
           </tr>
           <tr>
             <td width="20%" class="text-right">Password</td>
             <td width="80%">
               <input type="password" name="pwd" class="input-sm" v-model="pwd" ref="pwd">
             </td>
           </tr>
           <tr>
             <td colspan="2" class="inline">
               <input type="checkbox" name="check" v-bind:checked="ck">ID저장
             </td>
           </tr>
           <tr>
             <td colspan="2" class="inline">
               <input type="button" value="로그인" class="btn-danger btn-sm" @click="login()">
               <input type="button" value="취소" class="btn-danger btn-sm" onclick="javascript:history.back()">
             </td>
           </tr>
         </table>
      </div>
    </main>
 </div>
 <script>
  let loginApp=Vue.createApp({
	  data(){
		  return{
			  id:'${userId}',
			  pwd:'',
			  ck:true
		  }
	  },
	  mounted(){
		  
	  },
	  methods:{
		  login(){
			  if(this.id==='')
			  {
				  alert("아이디를 입력하세요!")
				  this.$refs.id.focus()
				  return
			  }
			  if(this.pwd==='')
			  {
				  alert("비밀번호를 입력하세요!")
				  this.$refs.pwd.focus()
				  return
			  }
			  
			  axios.get('../member/login_ok_vue.do',{
				  params:{
					  userId:this.id,
					  userPwd:this.pwd,
					  ck:this.ck
				  }
			  }).then(response=>{
				  if(response.data==='NOID')
				  {
					  this.id=''
					  this.pwd=''
					  alert("존재하지 않는 아이디입니다.")
					  this.ck=false
				  }
				  else if(response.data==='NOPWD'){
					  this.pwd=''
					  this.ck=false
					  alert("비밀번호가 일치하지 않습니다.")
				  }
				  else{
					  location.href="../main/main.do"
				  }
			  })
		  }
	  }
  }).mount("#loginApp")
 </script>
</body>
</html>