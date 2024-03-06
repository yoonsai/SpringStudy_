package com.sist.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.web.dao.ReplyDAO;
import com.sist.web.entity.Reply;

import jakarta.servlet.http.HttpSession;

@RestController
public class ReplyRestController {
	@Autowired
	private ReplyDAO dao;
	@PostMapping("/reply/insert")
	public String replyInsert(Reply vo,HttpSession session)
	{
		String result="";
		try {
			String id=(String)session.getAttribute("id");
			String name=(String)session.getAttribute("name");
			vo.setId(id);
			vo.setName(name);
			dao.save(vo);//insert
			result="yes";
		}
		catch(Exception e) {
			e.printStackTrace();
			result="no";
		}
		return result;
		

	}
	@GetMapping("/reply/list")
	public List<Reply> replyList(int fno)
	{
		 return dao.replyListData(fno);
		/*
		 * ObjectMapper mapper=new ObjectMapper(); String
		 * json=mapper.writeValueAsString(list);
		 */
	}
}
