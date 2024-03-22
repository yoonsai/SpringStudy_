package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.GoodsServiceImpl;
import com.sist.vo.GoodsVO;

@RestController
public class GoodsRestController {
	@Autowired
	private GoodsServiceImpl service;
	
	@GetMapping(value="goods/list_vue.do",produces="text/plain;charset=UTF-8")
	public String goods_list(int page) throws Exception{
		int rowsize=12;
		int start=(rowsize*page)-(rowsize-1);
		int end=rowsize*page;
		List<GoodsVO> list=service.goodsListData(start, end);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
	}
	@GetMapping(value="goods/page_vue.do",produces="text/plain;charset=UTF-8")
	public String goods_page(int page) throws Exception{
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		int totalpage=service.goodsTotalPage();
		if(endPage>totalpage)
			endPage=totalpage;
		Map map=new HashMap();
		map.put("startPage",startPage);
		map.put("endPage", endPage);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		return json;
	}
}
