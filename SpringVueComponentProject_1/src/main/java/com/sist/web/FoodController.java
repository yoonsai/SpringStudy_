package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// JSP와 연결 => 화면 변경 => forward(request) "경로명/파일명" / redirect(request를 초기화) "Redirect:...do" => 글쓰기 => 목록
@Controller
public class FoodController {
	@GetMapping("main/main.do")
	public String main_main()
	{
		return "food/list";
	}
}
