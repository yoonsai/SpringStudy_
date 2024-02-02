package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	@GetMapping("member/logout.do")
	public  String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:../food/list.do";
	}
	
}
