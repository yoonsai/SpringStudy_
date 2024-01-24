package com.sist.spring;
/*
 * 
 * 스프링은 오픈 소스 라이브러리 => 확장성 (변경해서 사용이 가능)
 *              =================================
 *                프레임워크 (스프링 = 전자정부 프레임워크 ANY 프레임워크)
 *                
 * 지원하는 라이브러리
 * =============
 *  Core : 1. bean : 객체생성 => 객체 소멸
 *         <bean> : 클래스 한개
 *         <context:component-scan> : 패키지 단위로 (*)
 *          => 선택적 => 어노테이션
 *         2. 순수하게 자바만 이용 => @Bean
 *         =========================================
 *  Data Access : JDBC / ORM(MyBatis,JPA) / JMS / OXM
 *                ======================= Transaction
 *  Web : Web / MVC
 *  AOP : 공통 모듈 => Commons~
 *        Transaction / Security
 *        
 *  스프링 => 클래스 관리자 (프로그램에 맞게 만든 클래스를 관리)
 *          사용자 정의 클래스 / 라이브러리 클래스
 *          ====================================
 *          컨테이너
 *  컨테이너 => 객체를 저장하는 공간
 *        => 객체의 생명주기를 담당 (생성 / 소멸)
 *  스프링에서 지원하는 컨테이너
 *  ===================
 *     BeanFactory
 *         |
 *   ApplicationContext
 *         |
 * ------------------------------------------------------------------------------------
 * |                                        |                                         | WebApplicationContext
 * GenericXmlApplicationContext            AnnotaionConfigApplicationContext
 *    => close():Application                   => XML없이 사용
 *       클래스가 많은 경우 / 연결관계가 많은 경우
 * => 스프링은 자바 전용이 아니다     
 * =========> 실무
 *            사용자 정의 클래스 => 어노테이션
 *            라이브러리 클래스 => 공통 (XML)
 * ===========================================
 *   스프링 프레임워크의 특징
 *   1. 경량 컨테이너
 *      : Spring에서 객체 생성 => 소멸을 담당
 *        = DL => 클래스 찾기 => getBean()
 *        = DI => 객체 생성시에 멤버변수의 초기값이 필요한 경우
 *                => 자동 로그인, 데이터베이스 처리
 *                => setterDI (set메소드에 값 채우기) / 생성자DI (매개변수에 값 채우기)
 *   2. POJO 방식을 사용한다 => 스프링 2.5
 *      (Plain Old Java Object)
 *      특정 프레임워크 기술에 의존하지 않는다
 *      Plain : 상속되지 않는 클래스 => 결합성 낮은 프로그램
 *      => OLD => 일반 자바
 *   3. 유지보수 : 클래스가 독립적으로 저장
 *   4. 확장성
 *   5. 필요한 모든 라이브러리를 지원한다
 *  ============================================================================
 *  1. DI (***)
 *  2. DL
 *  3. AOP (***) :  (Aspect Oriented Programming) = 관점 지향 프로그래밍, 관점 지향은 쉽게 말해 어떤 로직을 기준으로 핵심적인 관점, 부가적인 관점으로 나누어서 보고 그 관점을 기준으로 각각 모듈화하겠다는 것이다. 여기서 모듈화란 어떤 공통된 로직이나 기능을 하나의 단위로 묶는 것을 말한다.
 *  ===================== 기본
 *  4. DataBase (ORM)
 *  5. Transaction (***)
 *  6. Web (MVC) (***) 핵심
 *  7. Security 
 *  ============================================================================
 *     DI => 스프링을 통해서 멤버변수의 초기화
 *           객체생성
 *     => 라이브러리는 자바 소스를 추가할 수 없다
 *        => 라이브러리에서 읽어가는 파일을 생성
 *                     ==========
 *                      1. XML 
 *                         => 태그명 / 속성명이 다르면 인식을 못한다
 *                      2. Annotaion에 있는 클래스 
 *                         => 스프링에서 지원하는 어노테이션만 이용한다 
 * 
 */
// 스프링에서 관리하는 클래스 (VO제외)
public class Sawon {
	// 1. setter DI
	private int sabun;
	private String name;
	private String sex;
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
