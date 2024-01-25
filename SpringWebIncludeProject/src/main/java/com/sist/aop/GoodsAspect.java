package com.sist.aop;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import java.util.*;
import com.sist.dao.*;

@Aspect
@Component
public class GoodsAspect {
	
	@Autowired
	private GoodsDAO dao;
	
	@After("execution(* com.sist.main.GoodsController.goods_all(..))")
	public void goods_cookie()
	{
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		Cookie[] cookies=request.getCookies();
		List<GoodsVO> gList=new ArrayList<GoodsVO>();
		if(cookies!=null)
		{
			System.out.println(cookies.length);
			for(int i=cookies.length-1;i>=0;i--)
			{
				if(cookies[i].getName().startsWith("goods_"))
				{
					String no=cookies[i].getValue();
				 	GoodsVO vo=dao.goodsCookie(Integer.parseInt(no));
					gList.add(vo);
				}
			}
		}
		request.setAttribute("count", gList.size());
		request.setAttribute("gList", gList);
		
	}
}
