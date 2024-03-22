package com.sist.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.ReplyService;
import com.sist.vo.ReplyVO;

@RestController
public class ReplyRestController {
	@Autowired
	private ReplyService rservice;
	
	public String commonsReplyData(int rno) throws Exception
	{
		ObjectMapper mapper=new ObjectMapper();
		List<ReplyVO> list=rservice.replyListData(rno);
		String json=mapper.writeValueAsString(list);
		return json;
	}
	
	@PostMapping(value="recipe/reply_insert_vue.do",produces="text/plain;charset=UTF-8")
	public String reply_insert(ReplyVO vo,HttpSession session) throws Exception
	{
		String userId=(String)session.getAttribute("userId");
		String userName=(String)session.getAttribute("userName");
		vo.setUserId(userId);
		vo.setUserName(userName);
		rservice.replyInsert(vo);
		return commonsReplyData(vo.getRno());
	}
	@GetMapping(value="recipe/reply_delete_vue.do",produces="text/plain;charset=UTF-8")
	public String reply_delete(int no, int rno) throws Exception
	{
		rservice.replyDelete(no);
		return commonsReplyData(rno);
	}
	@PostMapping(value="recipe/reply_update_vue.do",produces="text/plain;charset=UTF-8")
	public String reply_update(ReplyVO vo) throws Exception
	{
		rservice.replyUpdate(vo);
		return commonsReplyData(vo.getRno());
	}
}
