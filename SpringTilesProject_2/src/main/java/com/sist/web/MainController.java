package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("main/main.do")
	public String main_main() {
		return "main";
	}
	@GetMapping("food/detail.do")
	public String food_detail(int fno,Model model,HttpSession session) {
		String id=(String)session.getAttribute("id");
		model.addAttribute("fno",fno);
		model.addAttribute("id", id);
		return "food/detail";
	}
	
}
