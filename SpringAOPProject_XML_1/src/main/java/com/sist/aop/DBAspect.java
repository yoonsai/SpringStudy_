package com.sist.aop;

import com.sist.dao.*;
import java.util.*;
// DI => Injection => setter,생성자
// DI => 클래스와 클래스의 연결관계설정

/*
 * Advice
 * ======
 *   PointCut => 어떤 메소드에 적용
 *   JoinPoint => 위치
 *     = Before => 메소드 시작전
 *     = After => finally
 *     = AfterThrowing => catch(에러 발생)
 *     = AfterReturning => return(정상 수행)
 *     = Around : 전후
 *     
 *     ======= Around
 *       소스
 *     ======= Around
 *   =======================================
 *   통합해서 새로운 기능을 만든다 (위빙 => Weaving) => Proxy패턴 
 *   
 *   PointCut : 어떤 메소드 적용 여부
 *     execution(" * 패키지명.클래스명.*()"
 *                == 리턴형         ==모든 메소드 매개변수가 없는
 *                                매개변수 상관없이 (..)
 *                                (String),(String,int)
 *                                
 *     모든 패키지에 있는 모든 클래스에 적용
 *     => 로그
 *     within("패키지명.*")
 *     
 *     => 모든 모델 클래스 => * 패키지명.*Controller.*(..)
 * 
 */

import org.aspectj.lang.ProceedingJoinPoint;

public class DBAspect {
	private EmpDAO dao;
	public void setDao(EmpDAO dao) {
		this.dao=dao;
	}
	// try진입전
	public void before() {
		dao.getConnection();
	}
	//finally
	public void after()
	{
		dao.disConnection();
	}
	//데이터 출력 => After-Returning
	public void afterReturning(Object obj)
	{
		System.out.println("====== 결과값 자동처리 ======");
		List<EmpVO> list=(List<EmpVO>)obj;
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEmpno()+" "+vo.getJob()+" "+vo.getDbday()+" "+vo.getSal());
		}
	}
	//에러 => After-Throwing
	public void afterThrowing(Throwable ex)
	{
		System.out.println("=======에러발생=======");
		ex.printStackTrace();
		// Web => @ContorllerAdvice : 공통 예외처리
	}
	//시간 => Around => 트랜잭션 / 보안 프로그램 / 로그
	public Object around(ProceedingJoinPoint jp) throws Throwable
	{
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
