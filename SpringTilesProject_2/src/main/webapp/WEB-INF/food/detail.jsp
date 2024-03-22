<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style type="text/css">
a:hover{
   cursor: pointer;
}
</style>
</head>
<body>
  <div class="container" id="detailApp">
    <div class="row">
     <table class="table">
       <tr>
       <td width=30% class="text-center" rowspan="8">
        <img style="width:100%" id="poster" :src="'https://www.menupan.com'+food_detail.poster">
       </td>
       <td colspan="2">
        <h3 id="name"><span id="name">{{food_detail.name }}</span>&nbsp;<span style="color:orange">{{food_detail.score }}</span></h3>
       </td>
     </tr>
     <tr>
       <th width=10% class="text-left">업종</th>
       <td width=60% id="type">{{food_detail.type }}</td>
     </tr>
     <tr>
       <th width=10% class="text-left">전화</th>
       <td width=60% id="phone">{{food_detail.phone }}</td>
     </tr>
     <tr>
       <th width=10% class="text-left">주소</th>
       <td width=60% id="address">{{food_detail.address }}</td>
     </tr>
     <tr>
       <th width=10% class="text-left">테마</th>
       <td width=60%" id="theme">
        <ul>
          <li v-for="t in theme">{{t }}</li>
        </ul>
       </td>
     </tr>
     <tr>
       <th width=10% class="text-left">영업시간</th>
       <td width=60% id="time">{{food_detail.time }}</td>
     </tr>
     <tr>
       <th width=10% class="text-left">가격대</th>
       <td width=60% id="price">{{food_detail.price }}</td>
     </tr>
     <tr>
       <th width=10% class="text-left">좌석</th>
       <td width=60% id="seat">{{food_detail.seat }}</td>
     </tr>
     <tr>
       <td colspan="3" class="text-right">
         <input type="button" value="목록" class="btn btn-xs btn-primary" onclick="javascript:history.back()">
       </td>
     </tr>
     </table>
   </div>
  </div>
  <%-- component --%>
  <div class="container" id="replyApp">
   <div class="row">
     <table class="table">
       <tr>
        <td>
          <table class="table" v-for="rvo in reply_list">
           <tr>
            <td class="text-left">◑{{rvo.name}}({{rvo.dbday}})</td>
            <td class="text-right">
              <span v-if="rvo.id===sessionId">
                <input type="button" :value="bCheck && rno===rvo.rno? '취소' : '수정'" class="btn-xs btn-success" @click="isshow(rvo.rno)" ref="change">         
                <input type="button" value="삭제" class="btn-xs btn-info" @click="replyDelete(rvo.rno)">
              </span>
            </td>
           </tr>
           <tr>
             <td colspan="2">
              <pre style="white-space: pre-wrap;background-color: white;border:none">{{rvo.msg}}</pre>
             </td>
           </tr>
           <tr>
             <td colspan="2" v-if="isShow===true && rno===rvo.rno">
             <textarea rows="5" cols="90" style="float: left" class="nMsg">{{rvo.msg}}</textarea>
             <input type=button value="댓글수정" style="float: left;height: 96px" class="btn-danger" @click="replyUpdate(rvo.rno)">
             </td>
           </tr>
          </table>
        </td>
       </tr>
     </table>
     <table class="table" v-show="sessionId!=''">
       <tr>
         <td class="text-left">
          <textarea rows="5" cols="90" style="float: left" v-model="msg" ref="msg"></textarea>
          <input type=button value="댓글쓰기" style="float: left;height: 96px" class="btn-danger" @click="replyInsert()">
         </td>
       </tr>
     </table>
   </div>
  </div>
  <script>
 let detailApp=Vue.createApp({
	 data(){
		 return {
			 food_detail:{},
			 fno:${fno},
			 theme:[]
		 }
	 },
	 mounted(){
		 axios.get('http://localhost:8080/web/food/detail_vue.do',{
			 params:{
				 fno:this.fno
			 }
		 }).then(response=>{
			 console.log(response.data)
			 this.food_detail=response.data
			 this.theme=response.data.theme.split(",")
			 
		 })
	 }
 }).mount("#detailApp")
 
 let replyApp=Vue.createApp({
	  data(){
		return {
			fno:${fno},
			sessionId:'${id}',
			reply_list:[],
			msg:'',
			rno:0,
			isShow:false,
			bCheck:false
		}  
	  },
	  mounted(){
		  // 시작과 동시에 댓글 읽기 
		  axios.get('../reply/list_vue.do',{
				  params:{
					  fno:this.fno
				  }
			  }).then(response=>{
				  console.log(response.data)
				  this.reply_list=response.data
			  })
	  },
	  methods:{
		  // 수정 
		  replyUpdate(rno){
			  let nMsg=$('.nMsg').val();
			  axios.get('../reply/update_vue.do',{
				  params:{
					  rno:rno,
					  fno:this.fno,
					  msg:nMsg
				  }
			  }).then(response=>{
				  this.reply_list=response.data
				  this.isShow=false
				  this.bCheck=true
			  })
		  },
		  // 삭제
		  replyDelete(Rno){
			  axios.get('../reply/delete_vue.do',{
				  params:{
					  rno:Rno,
					  fno:this.fno
				  }
			  }).then(response=>{
				  this.reply_list=response.data
			  })
		  },
		  // 추가
		  replyInsert(){
			  if(this.msg==="")
			  {
				  this.$refs.msg.focus()
				  return
			  }
			  axios.get('../reply/insert_vue.do',{
				  params:{
					  msg:this.msg,
					  fno:this.fno
				  }
			  }).then(response=>{
				  this.reply_list=response.data
				  this.msg=""
			  })
		  },
		  isshow(rno){
			  this.rno=rno
			  if(this.bCheck===false)
			  {
				  this.isShow=true
				  this.bCheck=true  
			  }
			  else{
				  this.isShow=false
				  this.bCheck=false
			  }
		  }
		  
	  }
  }).mount('#replyApp')
</script>
</body>
</html>