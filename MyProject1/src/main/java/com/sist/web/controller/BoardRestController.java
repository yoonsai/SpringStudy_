package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.BoardDAO;
import com.sist.web.entity.Board;

@RestController
public class BoardRestController {
	@Autowired
	private BoardDAO dao;
	
	@GetMapping("/board/delete")
	public String board_delete(int no,String pwd)
	{
		String result="";
		Board vo=dao.findByNo(no);
		if(vo.getPwd().equals(pwd))
		{
		    result="yes";
			dao.delete(vo);
		}
		else {
		    result="no";	
		}
		return result;
		
	}
	@PostMapping("/board/update_vue")
	public String board_update(Board vo)
	{
		String result="";
		Board db_vo=dao.findByNo(vo.getNo());
		if(vo.getPwd().equals(db_vo.getPwd()))
		{
		    result="yes";
		    vo.setHit(db_vo.getHit());
			dao.save(vo);
		}
		else {
		    result="no";
		}
		return result;

	}
//	@GetMapping("/board/update")
//	public String boardUpdateOk(Board vo)
//	{
//		String result="";
//		try {
//			
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//			
//		}
//		vo.setHit(0);
//	}
}
