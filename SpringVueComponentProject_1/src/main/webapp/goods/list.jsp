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
  <div class="container">
    <div class="row">
      <goodslist></goodslist>
    </div>
    
    <div style="height: 20px"></div>
    <div class="row">
      <pagelist></pagelist>
    </div>
  </div>
  <script>
  const goodslist={
	  template:`<div class="col-md-3" v-for="vo in $parent.goods_list">
		    <div class="thumbnail">
		      <a>
		        <img :src="vo.goods_poster" style="width:100%;height=100%">
		        <div class="caption">
		          <p>{{vo.goods_price}}</p>
		        </div>
		      </a>
		    </div>
		  </div>`
  }
  const pagelist={
		  template:`<ul class="pagination">
			  <li v-if="$parent.startPage>1"><a @click="$parent.prev()">&laquo;</a></li>
			  <li v-for="i in $parent.range($parent.startPage,$parent.endPage)" :class="$parent.curpage===i?'active':''"><a @click="$parent.pageChange(i)">{{i}}</a></li>
			  <li v-if="$parent.endPage<$parent.totalpage"><a @click="$parent.next()">&raquo;</a></li>
		   </ul>`
  }
   let goodsApp=Vue.createApp({
	   data(){
		   return {
			   goods_list:[],
			   curpage:1,
			   totalpage:0,
			   endPage:0,
			   startPage:0,
			   goods_page:{}
			   
		   }
	   },
	   mounted(){
		 this.dataRecv();  
	   },
	   components:{
		   "goodslist":goodslist,
		   "pagelist":pagelist
	   },
	   methods:{
		   dataRecv(){
			   axios.get('../goods/list_vue.do',{
				   params:{
					   page:this.curpage
				   }
			   }).then(response=>{
				   console.log(response.data)
				   this.goods_list=response.data
			   })
			   
			   axios.get('../goods/page_vue.do',{
				   params:{
					   page:this.curpage
				   }
			   }).then(response=>{
				   console.log(response.data)
				   this.goods_page=response.data
				   this.curpage=response.data.curpage
				   this.totalpage=response.data.totalpage
				   this.startPage=response.data.startPage
				   this.endPage=response.data.endPage
			   })
		   },
		   prev(){
			   this.curpage=this.startPage-1;
			   this.dataRecv();
		   },
		   next(){
			   this.curpage=this.endPage+1;
			   this.dataRecv();
		   },
		   pageChange(page){
			   this.curpage=page;
			   this.dataRecv();
		   },
		   range(start,end){
			   let arr=[]
			   let len=end-start
			   for(let i=0;i<=len;i++)
			   {
				   arr[i]=start
				   start++
			   }
			   return arr
		   }
		   
	   }
   }).mount('.container')
  </script>
</body>
</html>