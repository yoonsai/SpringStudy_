package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.*;
import java.util.*;

//@ResponseBody
@RestController
//내가원하는데이터를 보낼때(자바스크립트 등 일반문자열을 보낼때)
//일반 파일명을 지정할때는 Controller
public class boardRestController {
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("board/update_ok.do")
	public String board_update_ok(BoardVO vo)
	{
		String result="";
		Boolean bCheck=dao.boardUpdate(vo);
		if(bCheck==true)
		{
			result="<script>location.href=\"detail.do?no="+vo.getNo()+"\"</script>";
		}
		else {
			
			result="<script>alert(\"비밀번호가 틀렸습니다\");history.back();</script>";

		}
		return result;
	}
	@RequestMapping("board/delete_ok.do")
	public String board_delete_ok(int no,String pwd)
	{
		String result="";
		boolean bCheck=dao.boardDelete(no, pwd);
		if(bCheck==true)
		{
			result="yes";
		}
		else
			result="no";
		return result;
	}
	
}
