package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@GetMapping("/member/login")
	public String login(Model model) {
		model.addAttribute("main_html", "member/login");
		return "main";
	}
	@GetMapping("/member/logout")
	public String member_logout(HttpSession session)
	{
		try {
			session.invalidate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "redirect:../";
	}
}
