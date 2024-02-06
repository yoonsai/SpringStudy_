package com.sist.web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

@RestController
// 자바 스크립트와 연동 => 데이터를 받아서 처리 후에 결과값을 전송 => Rest => GET/POST/PUT/DELETE
// @ResponseBody
public class BoardRestController {
	@Autowired
	private BoardDAO dao;
	
	@GetMapping(value="board/list_vue.do",produces="text/plain;charset=UTF-8")
	public String board_list(int page) throws Exception
	{
		int rowSize=10;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		List<BoardVO> list=dao.boardListData(start, end);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		return json;
	}
	@GetMapping(value="board/page_vue.do",produces="text/plain;charset=UTF-8")
	public String board_page(int page) throws Exception
	{
		Map map=new HashMap();
		int totalpage=dao.boardTotalPage();
		map.put("totalpage", totalpage);
		map.put("curpage", page);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map); // 한번에 보낼 수가 없어서 메소드 두개 생성
		return json;
	}
	@PostMapping(value="board/insert_ok.do",produces="text/plain;charset=UTF-8")
	public void board_insert_ok(BoardVO vo)
	{
		dao.boardInsert(vo);
		//String url="<script>location.href=\"list.do\"</script>";
		//return url; //파일명을 직접 적을 수 없음 (restcontroller는 x)
		//return "ok";
	}
	@GetMapping(value="board/detail_vue.do",produces="text/plain;charset=UTF-8")
	public String board_detail(int no) throws Exception {
		BoardVO vo=dao.boardDetailData(no);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		System.out.println(json);
		return json;
	}
	
	@GetMapping(value="board/update_vue.do",produces="text/plain;charset=UTF-8")
	public String board_update_vue(int no) throws Exception {
		BoardVO vo=dao.boardUpdateData(no);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		System.out.println(json);
		return json;
	}
	@PostMapping(value="board/update_ok.do",produces="text/plain;charset=UTF-8")
	public String board_update_ok(BoardVO vo) {
		String result=dao.boardUpdate(vo);
		return result;
	}
	@GetMapping(value="board/delete_ok.do",produces="text/plain;charset=UTF-8")
	public String board_delete_ok(String pwd,int no) {
		String result=dao.boardDelete(pwd, no);
		return result;
	}
	
}
