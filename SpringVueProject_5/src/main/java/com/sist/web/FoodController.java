package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sist.dao.*;
import java.util.*;

@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	
	@GetMapping("food/list.do")
	public String food_list(){
		return "food/list";
		
	}
	@GetMapping(value="food/list_vue.do",produces="text/plain;charset=UTF-8")
    @ResponseBody
    // @Restcontroller
    public String food_list_vue(int page)
    {
		// [{fno:1,poster:'',name:''}{}]
		// VueJS => 연결전에 초기값을 설정할 수 있음 => page가 null이어서 항상 String으로 받았었는데 그럴 필요없음
	    int rowSize=20;
	    int start=(rowSize*page)-(rowSize-1);
	    int end=rowSize*page;
	    Map map=new HashMap();
	    map.put("start",start);
	    map.put("end", end);
	    int totalpage=dao.foodTotalPage();
	    final int BLOCK=10;
	    int startPage=((page-1)/BLOCK*BLOCK)+1;
	    int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	    if(endPage>totalpage)
	    	endPage=totalpage;
	    int i=0;
	    List<FoodVO> list=dao.foodListData(map);
	    JSONArray arr=new JSONArray(); // [] => array // {} => JsonObject
	    for(FoodVO vo:list)
	    {
	    	JSONObject obj=new JSONObject();
	    	obj.put("fno", vo.getFno());
	    	obj.put("name", vo.getName());
	    	obj.put("poster", vo.getPoster()); // {fno:1,poster:'',name:''}
	    	if(i==0)
	    	{
	    		obj.put("curpage", page);
	    		obj.put("totalpage", totalpage);
	    		obj.put("startPage", startPage);
	    		obj.put("endPage", endPage);
	    		
	    	}
	    	arr.add(obj); // [{fno:1,poster:'',name:'',curpage:'',totalpage:''},{fno:2,poster:'',name:''}...]
	    	i++;
	    }
	    return arr.toJSONString();
    }
	
	@GetMapping("food/page_vue.do")
	@ResponseBody
	public String food_page_vue(int page)
	{
		// startPage endPage curpage totalpage
		return "";
	}
}
