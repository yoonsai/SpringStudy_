package com.sist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.FreeBoardDAO;
import com.sist.manager.WordManager;
import com.sist.service.FreeBoardService;
import com.sist.service.FreeBoardServiceImpl;
import com.sist.vo.FreeBoardVO;
import com.sist.vo.WordVO;

@Controller
@RequestMapping("freeboard/")
public class BoardController {
	@Autowired
	private WordManager mgr;
	@Autowired
	private FreeBoardService service;
	
	@GetMapping("list.do")
	public String board_list()
	{
		return "freeboard/list";
	}
	@GetMapping("insert.do")
	public String board_insert()
	{
		return "freeboard/insert";
	}
	@GetMapping("detail.do")
	public String board_insert(int no,Model model)
	{
		FreeBoardVO vo=service.freeboardUpdateData(no);
		List<WordVO> list=mgr.wordListData(vo.getContent());
		model.addAttribute("list",list);
		model.addAttribute("no", no);
		return "freeboard/detail";
	}
	@GetMapping("update.do")
	public String board_update(int no,Model model)
	{
		model.addAttribute("no", no);
		
		return "freeboard/update";
	}
}
