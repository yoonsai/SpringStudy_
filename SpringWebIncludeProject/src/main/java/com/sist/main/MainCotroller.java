package com.sist.main;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.sist.dao.*;

@Controller
public class MainCotroller {
	@Autowired
	private FoodDAO dao;
	
	@GetMapping("main/main.do")
	public String main_main(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		int totalpage=dao.foodTotalPage();
		if(endPage>totalpage)
			endPage=totalpage;
		List<FoodVO> list=dao.foodListData(start,end);
		model.addAttribute("main_jsp","home.jsp");
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalpage", totalpage);
		
		return "main/main";
	}
}
