package com.sist.web;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.vo.*;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.FoodServiceImpl;

@RestController
public class FoodRestController {
	@Autowired
	private FoodServiceImpl service;
	
	@GetMapping(value="food/list_vue.do",produces="text/plain;charset=UTF-8")
	public String food_list(int page) throws Exception
	{
		int rowsize=12;
		int start=(rowsize*page)-(rowsize-1);
		int end=rowsize*page;
		List<FoodVO> list=service.foodListData(start, end);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
	}
	@GetMapping(value="food/page_vue.do",produces="text/plain;charset=UTF-8")
	public String food_page(int page) throws Exception
	{
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		int totalpage=service.foodTotalPage();
		if(endPage>totalpage)
		{
			endPage=totalpage;
		}
		Map map=new HashMap();
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("totalpage", totalpage);
		map.put("curpage", page);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		return json;
	}
}
