package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.FreeBoardServiceImpl;
import com.sist.vo.FreeBoardVO;

@RestController
@RequestMapping("freeboard/")
public class BoardRestController {
	@Autowired
	private FreeBoardServiceImpl service;
	
	@GetMapping(value="list_vue.do",produces="text/plain;charset=UTF-8")
	public String freeboard_list(int page) throws Exception
	{
		int rowSize=10;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		List<FreeBoardVO> list=service.freeBoardListData(start, end);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
	}
	
	@GetMapping(value="page_vue.do",produces="text/plain;charset=UTF-8")
	public String freeboard_page(int page) throws Exception
	{
		int totalpage=service.freeboardTotalpage();
		Map map=new HashMap();
		map.put("totalpage", totalpage);
		map.put("curpage",page);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		return json;
	}
	@PostMapping(value="insert_vue.do",produces="text/plain;charset=UTF-8")
	public String freeboard_insert(FreeBoardVO vo) throws Exception
	{
		String result="";
		try {
			service.freeboardInsert(vo);
			result="yes";
		}catch(Exception e) {
			result=e.getMessage();
		}
		return result;
	}
	@GetMapping(value="detail_vue.do",produces="text/plain;charset=UTF-8")
	public String freeboard_detail(int no) throws Exception
	{
		
		FreeBoardVO vo=service.freeboardDetailData(no);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		return json;
	}
	
	@GetMapping(value="delete_vue.do",produces="text/plain;charset=UTF-8")
	public String freeboard_delete(int no,String pwd)
	{
		String result=service.freeboardDelete(no, pwd);
		return result;
	}
	@GetMapping(value="update_vue.do",produces="text/plain;charset=UTF-8")
	public String freeboard_update(int no) throws Exception
	{
		FreeBoardVO vo=service.freeboardUpdateData(no);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		return json;
	}
	@PostMapping(value="update_ok.do",produces="text/plain;charset=UTF-8")
	public String freeboard_update_ok(FreeBoardVO vo)
	{
		String result=service.freeboardUpdate(vo);
		return result;
	}
}
