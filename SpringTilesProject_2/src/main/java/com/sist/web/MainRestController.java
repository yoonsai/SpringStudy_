package com.sist.web;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.FoodServiceImpl;
import com.sist.vo.FoodVO;
import com.sist.vo.MemberVO;
import com.sist.vo.ReplyVO;

@RestController
public class MainRestController {
	@Autowired 
	FoodServiceImpl service;
	
	@GetMapping(value="main/food/list_vue.do",produces="text/plain;charset=UTF-8")
	public String food_list(int page) throws Exception
	{
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		List<FoodVO> list=service.foodListData(start, end);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
		
	}
	@GetMapping(value="main/food/page_vue.do",produces="text/plain;charset=UTF-8")
	public String food_page(int page) throws Exception
	{
		int totalpage=service.foodTotalPage();
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		Map map=new HashMap();
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		return json;
	}
	@GetMapping(value="food/detail_vue.do",produces="text/plain;charset=UTF-8")
	public String food_detail(int fno,HttpSession session) throws Exception
	{
		String id=(String)session.getAttribute("id");
		FoodVO vo=service.foodDetailData(fno);
		vo.setSessionId(id);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		return json;
	}
	@GetMapping(value="member/login_vue.do",produces="text/plain;charset=UTF-8")
	public String login(String id,String pwd,HttpSession session) throws Exception
	{
		MemberVO vo=service.isLogin(id, pwd);
		if(vo.getMsg().equals("OK"))
		{
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
		}
		return vo.getMsg();
	}
	@GetMapping(value="member/logout_vue.do",produces="text/plain;charset=UTF-8")
	public void logout(HttpSession session) throws Exception
	{
		session.invalidate();
	}
	
	public String commonsData(int fno) throws Exception
	{
		List<ReplyVO> list=service.replyListData(fno);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
	}
	
	@GetMapping(value="reply/list_vue.do",produces="text/plain;charset=UTF-8")
	public String reply_list(int fno) throws Exception
	{
		return commonsData(fno);
	}
	
	@GetMapping(value="reply/insert_vue.do",produces="text/plain;charset=UTF-8")
	public String insert(int fno,String msg,HttpSession session) throws Exception
	{
		String id=(String)session.getAttribute("id");
		String name=(String)session.getAttribute("name");
		ReplyVO vo=new ReplyVO();
		vo.setFno(fno);
		vo.setId(id);
		vo.setMsg(msg);
		vo.setName(name);
		service.replyInsert(vo);
		return commonsData(fno);
	}
	@GetMapping(value="reply/delete_vue.do",produces="text/plain;charset=UTF-8")
	public String delete(int fno,int rno) throws Exception
	{
		service.replyDelete(rno);
		return commonsData(fno);
	}
	
	@GetMapping(value="reply/update_vue.do",produces="text/plain;charset=UTF-8")
	public String update(int fno,int rno,String msg) throws Exception
	{
		service.replyUpdate(msg, rno);
		return commonsData(fno);
	}
}
