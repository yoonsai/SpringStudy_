<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width: 960px;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div class="container" id="foodListApp">
    <div class="row">
      <div class="col-md-3" v-for="vo in food_list">
	    <div class="thumbnail">
	      <a>
	        <img :src="'https://www.menupan.com'+vo.poster" style="width:100%;height=100%">
	        <div class="caption">
	          <p style="font-size: 8px">{{vo.name}}</p>
	        </div>
	      </a>
	    </div>
	  </div>
    </div>
    <div style="height: 20px"></div>
    <div class="row" style="text-align: center">
	   <ul class="pagination">
		  <li v-if="startPage>1"><a @click="prev()">&laquo;</a></li>
		  <li v-for="i in range(startPage,endPage)" :class="curpage===i?'active':''"><a @click="pageChange(i)">{{i}}</a></li>
		  <li v-if="endPage<totalpage"><a @click="next()">&raquo;</a></li>
	   </ul>
	 </div>
  </div>
  <script>
  let foodapp=Vue.createApp({
	  data(){
		  return {
			  food_list:[],
			  curpage:1,
			  totalpage:0,
			  startPage:0,
			  endPage:0
		  }
	  },
	  mounted(){
		  this.dataRecv();
		  // 콜백 => 시작과 동시에 호출 => window.onload => Vue에 의한 자동호출
	  },updated(){
		  // 자동 호출되는 함수 => data()에 등록된 값이 변경되는 경우에 호출
	  },
	  //사용자 정의 함수 : 이벤트 (버튼 클릭, 이미지 클릭)
	  methods:{
		  dataRecv(){
			  axios.get("../food/list_vue.do",{
				  params:{
					  page:this.curpage // list_vue.do?page=1 => data:{no:1}
				  }
			  }).then(response=>{
				  console.log(response.data)
				  this.food_list=response.data
			  })
			  
			  axios.get("../food/page_vue.do",{
				  params:{
					  page:this.curpage // list_vue.do?page=1 => data:{no:1}
				  }
			  }).then(response=>{
				  console.log(response.data)
				  this.curpage=response.data.curpage
				  this.totalpage=response.data.totalpage
				  this.startPage=response.data.startPage
				  this.endPage=response.data.endPage
			  })
		  },
		  range(start,end){
			  let arr=[]
			  let len=end-start
			  for(let i=0;i<=len;i++)
			  {
				  arr[i]=start
				  start++;
			  }
			  return arr
		  },
		  prev(){
				 this.curpage=this.startPage-1;
				 this.dataRecv();
		  },
		  next(){
				 this.curpage=this.endPage+1;
				 this.dataRecv();
		  },
		  pageChange(i){
				 this.curpage=i;
				 this.dataRecv();
	      } 
	  },
	  components:{
		  
	  }
  }).mount("#foodListApp")
  </script>
</body>
</html>