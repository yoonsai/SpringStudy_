package com.sist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsVO;

@Controller
public class GoodsController {
	@Autowired
	private GoodsDAO gDao;
	
	@GetMapping("goods/list.do")
	public String goods_list(String page,Model model)
	{
		// Model => JSP로 값을 전송할때 사용 (전송 객체)
		if(page==null)
		{
			page="1";
		}
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(rowSize*curpage)-rowSize; // mysql은 0번부터 (LIMIT)
		List<GoodsVO> list=gDao.goodsListData(start);
		int totalpage=gDao.goodsTotalpage();
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list", list);
		return "goods/list";
	}
}
