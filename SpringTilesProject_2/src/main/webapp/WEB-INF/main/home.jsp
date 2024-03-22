<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
a:hover{
   cursor: pointer;
}
</style>
</head>
<body>
 <div class="container" id="listApp">
	 <div class="row">
	  <div class="col-md-3" v-for="vo in food_list">
	    <div class="thumbnail">
	      <a :href="'../food/detail.do?fno='+vo.fno">
	        <img :src="'https://www.menupan.com'+vo.poster" style="width:100%;height=100%">
	        <div class="caption">
	          <p>{{vo.name}}</p>
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
  let app=Vue.createApp({
	  data(){
		  return {
			  food_list:{},
			  curpage:1,
			  totalpage:0,
			  startPage:0,
			  endPage:0
		  }
	  },
	  mounted() {
		this.datare();
		this.pagere();
	  },
	  methods:{
		  datare(){
			  axios.get('food/list_vue.do',{
				  params:{
					  page:this.curpage
					  
				  }
			  }).then(response=>{
				  console.log(response.data)
				  this.food_list=response.data
			  })
		  },
		  pagere(){
			  axios.get('food/page_vue.do',{
				  params:{
					  page:this.curpage
					  
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
			  let range=[]
			  let len=end-start;
			  for(let i=0;i<=len;i++)
			  {
				  range[i]=start;
				  start++;
			  }
			  return range;
		  },
		  prev(){
			  this.curpage=this.startPage-1;
			  this.datare();
			  this.pagere();
		  },
		  next(){
			  this.curpage=this.endPage+1;
			  this.datare();
			  this.pagere();
		  },
		  pageChange(page){
			  this.curpage=page;
			  this.datare();
			  this.pagere();
		  }
	  }
	  
  }).mount('#listApp')
 </script>
</body>
</html>