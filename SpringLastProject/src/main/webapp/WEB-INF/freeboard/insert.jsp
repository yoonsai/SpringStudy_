<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
</style>
</head>
<body>
  <div class="wrapper row3 row1" id="fboardApp">
   <div id="slider" class="clear"> 
     <h2 class="sectiontitle">글쓰기</h2>
     <table class="table">
        <tr>
          <th width="10%">이름</th>
          <td width="90%"><input type="text" ref="name" size=15 v-model="name" class="input-sm"></td>
        </tr>
        <tr>
          <th width="10%">제목</th>
          <td width="90%"><input type="text" ref="name" size=50 v-model="subject" class="input-sm"></td>
        </tr>
        <tr>
          <th width="10%">내용</th>
          <td width="90%"><textarea cols="52" rows="10" ref="content" v-model="content"></textarea></td>
        </tr>
        <tr>
          <th width="10%">비밀번호</th>
          <td width="90%"><input type="password" ref="pwd" size=15 v-model="pwd" class="input-sm"></td>
        </tr>
        <tr>
          <td colspan="2" class="text-center inline">
          <input type="button" value="글쓰기" class="btn-sm btn-danger" @click="dataPost()">
          <input type="button" value="취소" class="btn btn-sm btn-success" onclick="javascript:history.back()">
          </td>
        </tr>
     </table>
   </div>
  </div>
  <script>
  let fApp=Vue.createApp({
	  data(){
		  return{
			  name:'',
			  subject:'',
			  content:'',
			  pwd:''
		  }
	  },
	  mounted(){
		  
	  },
	  methods:{
		  dataPost(){
			  if(this.name==="")
			  {
				  this.$refs.name.focus()
				  return
			  }
			  if(this.subject==="")
			  {
				  this.$refs.subject.focus()
				  return
			  }
			  if(this.content==="")
			  {
				  this.$refs.content.focus()
				  return
			  }
			  if(this.pwd==="")
			  {
				  this.$refs.pwd.focus()
				  return
			  }
			  
			  axios.post('../freeboard/insert_vue.do',null,{
				  params:{
					  name:this.name,
					  subject:this.subject,
					  content:this.content,
					  pwd:this.pwd
				  }
			  }).then(response=>{
				  if(response.data==="yes")
				  {
					  location.href="../freeboard/list.do"
				  
				  }
				  else{
					  alert(response.data)
				  }
			  })
		  }
	  }
  }).mount('#fboardApp')
  </script>
</body>
</html>