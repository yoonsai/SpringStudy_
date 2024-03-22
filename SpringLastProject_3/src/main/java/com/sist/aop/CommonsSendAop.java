package com.sist.aop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.manager.NewsManager;
import com.sist.manager.WordManager;
import com.sist.service.FoodService;
import com.sist.vo.FoodVO;
import com.sist.vo.NewsVO;
import com.sist.vo.NoticeVO;
import com.sist.vo.WordVO;

@Aspect
@Component
public class CommonsSendAop {
	@Autowired
	private FoodService service;
	
	@Autowired
	private NewsManager mgr;
	
	@Autowired
	private WordManager wmgr;
	
	@After("execution(* com.sist.web.*Controller.*(..))")
	public void footerSend()
	{
		List<FoodVO> fList=service.foodTop7();
		List<NoticeVO> nList=service.noticeTop7();
		List<NewsVO> newsList=mgr.newsFind("맛집");
		
		
		 HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder
                 .getRequestAttributes()).getRequest();

        request.setAttribute("nList", nList);
        request.setAttribute("fList", fList);
        request.setAttribute("newsList", newsList); 

	}
	
}
