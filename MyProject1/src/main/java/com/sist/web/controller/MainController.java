package com.sist.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.dao.ActivityDAO;
import com.sist.web.dao.FoodDAO;
import com.sist.web.entity.Activity;
import com.sist.web.entity.Food;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {
	@Autowired
	private FoodDAO dao;
	@Autowired
	private ActivityDAO adao;
	@GetMapping("/")
	public String main_page(Model model,HttpServletRequest request)
	{
		Cookie[] cookies=request.getCookies();
		List<Food> fList=new ArrayList<Food>();
		List<Activity> AList=new ArrayList<Activity>();
		int k=0;
		if(cookies!=null)
		{
			for(int i=cookies.length-1;i>=0;i--)
			{
				if(cookies[i].getName().startsWith("food"))
				{
					if(k>8)
						break;
					String no=cookies[i].getValue();
					Food r=dao.findByNo(Integer.parseInt(no));
					fList.add(r);
					k++;
				}
				if(cookies[i].getName().startsWith("activity"))
				{
					if(k>8)
						break;
					String no=cookies[i].getValue();
					Activity r=adao.findByNo(Integer.parseInt(no));
					AList.add(r);
					k++;
				}
			}
		}
		List<Food> list=dao.foodMainListData();
		List<Activity> alist=adao.activityMainListData();
		model.addAttribute("fList", fList);
		model.addAttribute("list", list);
		model.addAttribute("alist", alist);
		model.addAttribute("AList", AList);
		model.addAttribute("main_html", "main/home");
		return "main";
	}
}
