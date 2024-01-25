package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.CookieStore;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;

@Controller
public class GoodsController {
	@Autowired
	private GoodsDAO dao;
	//String[] tables= {"","goods_all","goods_best","goods_new"};
 	@GetMapping("store/goods_all.do")
	public String goods_all(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=curpage*rowSize;
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		int totalpage=dao.goodsTotalPage();
		if(endPage>totalpage)
			endPage=totalpage;
		List<GoodsVO> list=dao.goodsListData(start, end);
		
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("curpage", curpage);
		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../store/goods_all.jsp");
		return "main/main";
	}
 	
 	@GetMapping("store/goods_detail_before.do")
 	public String goods_detail_before(int no,HttpServletResponse response, RedirectAttributes ra)
 	{
 		Cookie cookie=new Cookie("goods_"+no,String.valueOf(no));
 		cookie.setPath("/"); // "/"로 시작하는 모든 경로에 대해서
 		cookie.setMaxAge(60*60*24);
 		response.addCookie(cookie);
 		
 		ra.addAttribute("no", no); // redirect할때 같이 보낼 값 설정 
 	
 		return "redirect:../store/goods_detail.do";
 	}
 	@GetMapping("store/goods_detail.do")
 	public String goods_detail(int no,Model model)
 	{
 		GoodsVO vo=dao.goodsDetailData(no);
 		model.addAttribute("vo", vo);
 		model.addAttribute("main_jsp", "../store/goods_all_detail.jsp");
 		return "main/main";
 	}
 	
}
