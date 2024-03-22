<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
</style>
</head>
<body>
  <div class="wrapper row3 row1" id="fboardApp">
   <div id="slider" class="clear"> 
     <h2 class="sectiontitle">수정하기</h2>
     <table class="table">
        <tr>
          <th width="10%">이름</th>
          <td width="90%"><input type="text" ref="name" size=15 class="input-sm" v-model="name"></td>
        </tr>
        <tr>
          <th width="10%">제목</th>
          <td width="90%"><input type="text" ref="name" size=50 class="input-sm" v-model="subject"></td>
        </tr>
        <tr>
          <th width="10%">내용</th>
          <td width="90%"><textarea cols="52" rows="10" ref="content" v-model="content"></textarea></td>
        </tr>
        <tr>
          <th width="10%">비밀번호</th>
          <td width="90%"><input type="password" ref="pwd" size=15 class="input-sm" v-model="pwd"></td>
        </tr>
        <tr>
          <td colspan="2" class="text-center inline">
          <input type="button" value="수정하기" class="btn-sm btn-danger" @click="update()">
          <input type="button" value="취소" class="btn btn-sm btn-success" onclick="javascript:history.back()">
          </td>
        </tr>
     </table>
   </div>
  </div>
  <script>
  let fboardApp=Vue.createApp({
	  data(){
		  return{
			  no:${no},
			  name:'',
			  subject:'',
			  content:'',
			  pwd:''
		  }
	  },
	  mounted(){
		  axios.get('../freeboard/update_vue.do',{
			  params:{
				  no:this.no
			  }
		  }).then(response=>{
			  console.log(response.data)
			  this.name=response.data.name
			  this.subject=response.data.subject
			  this.content=response.data.content
		  })
	  },
	  methods:{
		  update(){
			  if(this.name==="")
		      {
				  this.$refs.name.focus()
				  return;
		      }
			  if(this.subject==="")
		      {
				  this.$refs.subject.focus()
				  return;
		      }
			  if(this.content==="")
		      {
				  this.$refs.content.focus()
				  return;
		      }
			  if(this.pwd==="")
		      {
				  this.$refs.pwd.focus()
				  return;
		      }
			  
			  axios.post('../freeboard/update_ok.do',null,{
				  params:{
					  no:this.no,
					  name:this.name,
					  subject:this.subject,
					  content:this.content,
					  pwd:this.pwd
				  }
			  }).then(response=>{
				  if(response.data==="yes")
				  {
					  location.href="../freeboard/detail.do?no="+this.no
				  }
				  else{
					  alert("비밀번호가 틀립니다!")
					  this.pwd=''
					  this.$refs.pwd.focus()
				  }
			  })
		  }
	  }
  }).mount('#fboardApp')
  </script>
</body>
</html>