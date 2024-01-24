package com.sist.aop;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpVO;

@Aspect
@Component
public class DBAspect {
	//1. before
    //2. after
	//3. around
	@Autowired
	private EmpDAO dao;
	
	// try진입전
	@Before("execution(* com.sist.dao.EmpDAO.emp*(..))")
	public void before() {
		dao.getConnection();
		System.out.println("오라클 연결 자동 호출:CallBack");
	}
	//finally
	@After("execution(* com.sist.dao.EmpDAO.emp*(..))")
	public void after()
	{
		dao.disConnection();
		System.out.println("오라클 해제 자동 호출:CallBack");
	}
	
	//시간 => Around => 트랜잭션 / 보안 프로그램 / 로그
	@Around("execution(* com.sist.dao.EmpDAO.emp*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable
	{
		System.out.println("사용자 로그 자동 호출:CallBack");
		Object obj=null;
		long start=System.currentTimeMillis();
		System.out.println("호출된 메소드:"+jp.getSignature().getName());
		//사용자가 호출한 메소드
		//메소드호출
		obj=jp.proceed(); //dao.empListData() => invoke()
		long end=System.currentTimeMillis();
		System.out.println("수행시간:"+(end-start));
		return obj;
	}
}
