const foodCard={
		   props:['food_list'],
		   template:`<div class="col-md-3" v-for="vo in food_list">
			    <div class="thumbnail">
			      <a>
			        <img :src="'https://www.menupan.com'+vo.poster" style="width:100%;height=100%">
			        <div class="caption">
			          <p style="font-size: 8px">{{vo.name}}</p>
			        </div>
			      </a>
			    </div>
			  </div>`
}
