package com.sist.web.controller;

import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.web.dao.FoodDAO;
import com.sist.web.entity.Food;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	
	@GetMapping("/food/list")
	public String food_list(String title,String page,Model model)
	{
		if(page==null)
			page="1";
		if(title==null)
			title="";
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-rowSize;
		List<Food> list=dao.foodListData(start,title);
		int count=dao.foodRowCount(title);
		int totalpage=(int)Math.ceil(count/12.0);
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("count", count);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("title", title);
		model.addAttribute("main_html", "food/list");
		return "main";
	}
	@GetMapping("/food/before_detail")
	public String food_before(int no,RedirectAttributes ra,HttpServletResponse response,Model model)
	{
		Cookie cookie=new Cookie("food"+no, String.valueOf(no));
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		ra.addAttribute("no", no);
		return "redirect:../food/detail";
	}
	
	@GetMapping("/food/detail")
	public String food_detail(int no,Model model)
	{
		Food vo=dao.findByNo(no);
		vo.setHit(vo.getHit()+1);
		dao.save(vo);
		String[] deimages = vo.getDeimage().split("\\^");
		String[] conts = vo.getCont().split("\\.");
		model.addAttribute("vo", vo);
		model.addAttribute("deimages", deimages);
		model.addAttribute("conts", conts);
		model.addAttribute("main_html", "food/detail");
		return "main";
	}
}
