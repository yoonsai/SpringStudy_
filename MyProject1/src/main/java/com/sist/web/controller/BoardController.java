package com.sist.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.dao.BoardDAO;
import com.sist.web.entity.Board;
import com.sist.web.entity.BoardVO;

import jakarta.transaction.Transactional;

@Controller
public class BoardController {
	@Autowired
	private BoardDAO dao;
	@GetMapping("/board/list")
	public String board_list(Model model,String page)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=12;
		int start=(rowSize*curpage)-rowSize;
		List<Board> list=dao.boardListData(start);
		for(Board vo:list)
		{
			String date=vo.getRegdate().substring(0,vo.getRegdate().indexOf(" "));
			vo.setRegdate(date);
		}
		int count=(int)dao.count();
		int totalpage=(int)Math.ceil(count/7.0);
		final int BLOCK=5;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("count", count);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("main_html", "board/list");
		return "main";
	}
	@GetMapping("/board/insert")
	public String board_insert(Model model)
	{
		model.addAttribute("main_html", "board/board_insert");
		return "main";
	}
	@GetMapping("/board/detail")
	@Transactional
	public String board_detail(Model model,int no)
	{
		Board vo=dao.findByNo(no);
		int hit=vo.getHit();
		vo.setHit(hit+1);
		dao.save(vo);
		String date=vo.getRegdate().substring(0,vo.getRegdate().indexOf(" "));
		vo.setRegdate(date);
		model.addAttribute("no", no);
		model.addAttribute("vo", vo);
		model.addAttribute("main_html", "board/board_detail");
		return "main";
	}
	@GetMapping("/board/insert_ok")
	public String board_insert_ok(Board vo)
	{
		dao.save(vo);
		return "redirect:../board/list";
		
	}
	@GetMapping("/board/update")
	public String board_update(int no,Model model)
	{
		Board vo=dao.findByNo(no);
		model.addAttribute("vo", vo);
		model.addAttribute("main_html", "board/board_update");
		return "main";
		
	}
	
}
