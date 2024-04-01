package com.sist.web;

import javax.inject.Qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/*
 * @Controller / @RestController => 면접 (80%)
   =============================================
	Spring
	  => Spring / Spring MVC / Spring-Boot의 차이점 
	  => Spring Framework => 생명주기
	  => Bean
	  => Interceptor / Filter의 차이점
	  => IoC / DI
	  => Container의 종류 / Container란
	  => VO / DTO / Entity ===> 100%
	  => MVC 구조에 대한 설명
	      servlet / jsp
 * 
 *    => Spring MVC에서 Http요청이 들어왔을 경우 흐름에 대해 설명
 *      => 면접 => 돌려서 나온다
 *    => 기타
 *      => Spring-Security의 구조 (필수)
 *      => AOP 이용하는 방법
 *      
 *   Java
 *    => Java / Python => 차이점
 *    => Java에서 접근지정어
 *    => JVM의 구조
 *    => GC
 *    => ************** Call By Reference / Call By Value      
 *    => ************** 리플렉션
 *    => for / foreach의 차이점
 *    => Wrapper의 사용처  => 만들어진 배경
 *    => 제네릭스
 *    => 직렬화 / 역직렬화 => IO
 *    => equals / ==
 *    => 추상 클래스 / 인터페이스의 차이점
 *    => 오버로딩 / 오버라이딩
 *    => 싱글턴 / 팩토리패턴
 *    => String / StringBuffer / StringBuilder
 *    => List / Set / Map
 *    
 *    
 *   Oracle
 *    => JOIN / Subquery
 *    => 프로시저 / 트리거 
 *    => 데이터형 (BLOB/BFile)
 *    => View의 종류 
 *    => DML / DDL / TCL
 *    
 *   Front 
 *    => HTML
 *    => JSP : 생명주기 / Session/Cookie, JSTL/EL, DBCP, MVC
 *    => Servlet => JSP/Servlet비교
 *    => JavaScript => ES6 => let/var/const, => , ..., 호이스팅 / *** 클로저
 *       
 *       JSON / JSONP => Cross Origin
 *    => VueJS : 장단점 (특징) 
 *    => ReactJS/Redux (특징)
 *    => Ajax : XML, JSON, 문자열
 *    ====================================== 40%, 프로젝트 60%
 *       솔루션 업체 : 쓰레드,네트워크,자료구조 => 코딩테스트
 *       
 *    @Controller / @RestController => 문자열,JSON
 *                   React / Vue
 *                   => 독립적 / 브라우저
 *    파일 관리 => 다른 프로그램 연동
 *                | 자바스크립트 / 코틀린 (모바일)
 *                | Spring-Boot
 *                     | 자바/코틀린 => 라이센스
 *    사용할 클래스 제작
 *    =============
 *      클래스와 클래스의 연관 관계 => DI
 *      프레임워크 : 틀  => 메인보드 (CPU,메모리 ====> 클래스)
 *        | 라이브러리의 집합 => 레고 / 완제품
 *                         ==== 전자정부 프레임워크 / Any프레임워크(삼성)                                
 *         
 *      
 *      
 *      => 요청클래스 메모리 할당 => Container에 저장
 *                                 | BeanFactory
 */
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.service.FoodService;
@Controller
// Target(value={TYPE})
public class MainController {
	private FoodService fService; //통합 => BI
	// 권장 사항 => 자동 주입
	//  Target(value={CONSTRUCTOR, METHOD, PARAMETER, FIELD, ANNOTATION_TYPE})
	// 스프링에 등록된 클래스 객체의 주소값을 찾아서 대입
	// interface => 중복이 있는 경우에는 @Autowired는 사용이 불가능
	@Autowired
	//@Qualifier(name="b") // 생성자는 사용할 수 없음
	// => 여러개가 중복된 경우에 특정 객체를 주입받는 경우에 사용
	
	/*
	 *  Spring / Spring-Boot의 차이점
	 *  => 핵심모듈을 모아서 만든 프레임워크
	 *     ------ 동작을 위한 라이브러리 집합
	 *     ------ 단점 : 설정파일이 어렵다
	 *            pom.xml / web.xml / application-*.xml
	 *            -------
	 *             호환성
	 *  => 설정 파일을 자동으로 생성 => spring 프레임워크를 쉽게 사용이 가능하게 만든 것
	 *     xml => properties => yml(파이썬) => 들여쓰기
	 *     server: 
	 *            port=80 => Spring Cloud          
	 * 
	 */
	public MainController(FoodService fService)
	{
		this.fService=fService;
	}
	@GetMapping("main/main.do")
	public String main_main() {
		return "";
	}
	@RequestMapping("main/main.do")
	public String main_main2()
	{
		return "";
	}
}
