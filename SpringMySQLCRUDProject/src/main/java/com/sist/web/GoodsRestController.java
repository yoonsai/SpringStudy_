package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsVO;

@RestController
@CrossOrigin("http://localhost:3000")
public class GoodsRestController {
	@Autowired
	private GoodsDAO gDao;
	
	 @GetMapping(value="goods/list_react.do", produces="text/plain;charset=UTF-8")
	 public String goods_list(int page) throws Exception {
	//	 if(page==null)
	//	 {
	//	    page="1";
	//	 }
	//	 int curpage=Integer.parseInt(page);
		 int rowSize=20;
		 int start=(rowSize*page)-rowSize;
		 List<GoodsVO> list=gDao.goodsListData(start);
		 ObjectMapper mapper=new ObjectMapper();
		 String json=mapper.writeValueAsString(list);
		 return json;
	 }
	 @GetMapping(value="goods/page_react.do",produces="text/plain;charset=UTF-8")
	 public String goods_page(int page) throws Exception
	 {
		 int totalpage=gDao.goodsTotalpage();
		 Map map=new HashMap();
		 map.put("curpage", page);
		 map.put("totalpage", totalpage);
		 ObjectMapper mapper=new ObjectMapper();
		 String json=mapper.writeValueAsString(map);
		 return json;
		 
	 }
}
