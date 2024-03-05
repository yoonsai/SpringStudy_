package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.MemberDAO;
import com.sist.web.entity.Member;

import jakarta.servlet.http.HttpSession;

@RestController
public class MemberRestController {
	@Autowired
	private MemberDAO dao;
	
	@PostMapping("/member/login_ok")
	public String member_login(String id,String pwd,HttpSession session)
	{
		String result="";
		int count=dao.memberIdCount(id);
		if(count==0)
		{
			result="NOID";
		}
		else {
			Member vo=dao.memberInfoData(id);
			if(vo.getPwd().equals(pwd))
			{
				result="OK";
				session.setAttribute("name", vo.getName());
				session.setAttribute("id", vo.getId());
			}
			else {
				result="NOPWD";
			}
		}
		return result;
	}
}
