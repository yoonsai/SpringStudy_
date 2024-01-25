package com.sist.inter;
// <bean>

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class FoodInterceptor extends HandlerInterceptorAdapter{

   @Override
   // main.do 찾기 전(모델 수행 전: 자동로그인, id찾기)
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
         throws Exception {
      System.out.println("====== prehandle() call...=======");
      return super.preHandle(request, response, handler);
   }

   @Override
   // viewResolver로 넘어가기 전에 사용
   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
         ModelAndView modelAndView) throws Exception {
      System.out.println("====== postHandle() call...=======");
      super.postHandle(request, response, handler, modelAndView);
   }

   @Override
   // JSP로 넘어가기 전에 사용
   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
         throws Exception {
      System.out.println("====== afterCompletion() call...=======");
      super.afterCompletion(request, response, handler, ex);
   }
   
   
}