package com.sist.main;

import java.lang.reflect.Member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.dao.MemberDAO;
import com.sist.dao.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberDAO dao;
    
	@GetMapping("member/login.do")
	public String member_login()
	{
		return "member/login";
	}
	@PostMapping("member/login_ok.do")
	public String member_login(String id,String pwd,Model model,HttpSession session)
	{
		MemberVO svo=new MemberVO();
		svo.setId(id);
		svo.setPwd(pwd);
		MemberVO vo=dao.memberLogin(svo);
		if(vo.getMsg().equals("OK"))
		{
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			System.out.println(session.getAttribute("id"));
			System.out.println(session.getAttribute("name"));
		}
		model.addAttribute("msg", vo.getMsg());
		return "member/login_ok";
	}
	@PostMapping("member/logout.do")
	public String member_logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:../main/main.do";
	}
}