package com.sist.aop;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.dao.*;
/*
 * 
 *  1. 모니터링 / 로깅 / 오류 검사 (처리) / 성능 파악
 *     => 트랜잭션, 보안, 암호화 복호화, 데이터 읽기 => 분석
 *  = 공통된 기능을 재사용하는 기법
 *  = 공통적인 내용을 모아서 관리
 *  = 라이브러리(트랜잭션, 보안)
 *  
 *  Spring Framework
 *    => DI
 *    => AOP
 *    => MVC
 *  ------------------
 *  
 *  1. 어떤 클래스의 메소드에서 적용
 *     PointCut
 *       => execution("특정위치 지정")
 *       => within("패키지명")
 *  2. 메소드 위치 => JoinPoint
 *     = Before 
 *     = After : finally
 *     = AfterReturning : 정상수행 => return값을 받을 수 있다
 *     = AfterThrowing : 에러처리 
 *     = Around
 *  3. 인터셉트 : 자동 로그인, ID저장...
 *    public String display()
 *    {
 *      before()
 *      try{
 *        ========= setAutoCommit(false)
 *          소스
 *        ========= commit()
 *      }catch(Exception e)
 *      {
 *      
 *      }
 *      finally{
 *          @After
 *      }
 *      
 *    } 
 *    
 */

@Aspect
@Component
public class BoardAOP {
	@Autowired
	private BoardDAO dao;
	
	@After("execution(* com.sist.web.*Controller.*(..))")
	public void after()
	{
		List<BoardVO> list=dao.boardTop5();
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		//request를 받을 수 없을땐 얻어와야함
		//실제 사용중인 request를 가지고 올때 사용 => Cookie
		request.setAttribute("tList", list);
	}
}
