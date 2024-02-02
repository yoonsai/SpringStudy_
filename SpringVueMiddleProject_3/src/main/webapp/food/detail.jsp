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
   width: 960px;
   
} 
.row1{
   width: 600px;
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<!-- <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=666e34535b94b665d2f33b3ee94a689a"></script> -->
</head>
<body>
  <jsp:include page="${login_jsp}"></jsp:include>
  <div class="container" id="app1">
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
       <td width=60% id="theme">
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
     <div style="height: 20px"></div>
     <div class="row">
      <div id="map" style="width:100%;height:350px;"></div>
     </div>
   </div>
  </div>
  
  <div class="container" id="app2">
    <div class="row1">
    
    </div>
  </div>
  <script>
   let app=Vue.createApp({
	   data(){
		   return {
			   fno:${fno},
		       food_detail:{},
		       address:'',
   			   name:'',
   			   theme:[],
   			   sessionId:''
		   }
	   },
	   mounted(){
		   axios.get("../food/detail_vue.do",{
			   params:{
				   fno:this.fno
			   }
		   }).then(response=>{
			   console.log(response.data)
			   this.food_detail=response.data
			   this.address=response.data.address
   			   this.name=response.data.name
   			   this.theme=response.data.theme.split(",")
   			
   			   if(window.kakao && window.kakao.maps)
   			   {
   				   this.initMap()
   			   }
   			   else
   			   {
   				   this.addScript()
   			   }
		   })
	   },
	   methods:{
		   addScript(){
   			const script=document.createElement("script") //<script>
   			/* globel kakao */
   			script.onload=()=>kakao.maps.load(this.initMap)
   			script.src="http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=666e34535b94b665d2f33b3ee94a689a&libraries=services"
   			document.head.appendChild(script)
   		},
   		initMap(){
   			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
   		    mapOption = {
   		        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
   		        level: 3 // 지도의 확대 레벨
   		    };  

   		// 지도를 생성합니다    
   		var map = new kakao.maps.Map(mapContainer, mapOption); 

   		// 주소-좌표 변환 객체를 생성합니다
   		var geocoder = new kakao.maps.services.Geocoder();

   		// 주소로 좌표를 검색합니다
   		geocoder.addressSearch(this.address, function(result, status) {

   		    // 정상적으로 검색이 완료됐으면 
   		     if (status === kakao.maps.services.Status.OK) {

   		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

   		        // 결과값으로 받은 위치를 마커로 표시합니다
   		        var marker = new kakao.maps.Marker({
   		            map: map,
   		            position: coords
   		        });

   		        // 인포윈도우로 장소에 대한 설명을 표시합니다
   		        var infowindow = new kakao.maps.InfoWindow({
   		            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+$('#name').text()+'</div>'
   		        });
   		        infowindow.open(map, marker);

   		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
   		        map.setCenter(coords);
   		    } 
   		 });    
   		}
	   }
	   
   }).mount('#app1')
   
   let app2=Vue.createApp({
	   data() {
		   return {
			   
		   }
	   }
   }).mount("#app2")
  </script>
</body>
</html>