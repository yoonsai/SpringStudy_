package com.sist.spring3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 *   1. 스프링은 프로젝트에 필요한 클래스를 모아서 관리해주는 역할 수행
 *                        ================ 컨테이너
 *      => 경량 컨테이너 
 *      => 단순한 연결 관계를 가지고 있다
 *      => 라이브러리로 제공
 *         => 오픈소스 
 *         => Core
 *         => 컨테이너 클래스
 *            BeanFactory => core
 *                 |
 *            ApplicationContext => core / AOP
 *                 |
 *            WebApplicationContext => core / AOP
 *            
 *      컨테이너
 *      컴포넌트 : 개발자가 만든 클래스 한개 (기능을 수행하는 클래스)
 *              => 컴포넌트 여러개를 묶어서 관리 => 컨테이너
 *      컨테이너의 역할
 *      ==========
 *      1. 객체 생성  ==> NEW를 사용해야되는 클래스 
 *                      => ~VO는 데이터형  
 *      2. 객체 변수의 초기화 ==> DI
 *      3. 객체 소멸
 *      ================= 객체의 생명주기
 *      4. 객체를 찾아주는 역할 수행 (DL)
 *      DL / DI => core
 *       
 *      Spring : 클래스 관리자 / 멤버변수 초기화 / 메소드 호출 / 생성자 매개변수
 *                           ===================================
 *                             | DI(Dependency injection,'의존성주입') => XML =>  외부에서 객체 간의 관계(의존성)를 결정해 주는데 즉, 객체를 직접 생성하는 것이 아니라 외부에서 생성 후 주입시켜 주는 방식
 *      
 *      1. 클래스 관리
 *         => 클래스 등록 => 찾기
 *      ===================== DL
 *      2. 객체 생성시에 필요한 변수가 주입
 *      ========================== DI
 *      
 *      
 *      
 *      DL
 *      의존관계 검색(Dependency Lookup)은 의존관계가 있는 객체를 외부에서 주입 받는 것이 아닌, 의존관계가 필요한 객체에서 직접 검색하는 방식
 *      
 * 
 * 
 */
public class MainClass {
	public static void main(String[] args) {
		// 스프링에서 사용하는 default폴더 = classpath => 자동으로 인식하는 폴더 src/main/java
		// 1. XML파싱
		// 2. 컨테이너 => XML전송
		ApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
		//                         --------------------------------- xml을 파싱하는것 => xml파일을 넣어주기만 하면됨
		// 등록된 클래스를 모아서 관리하는 역할의 클래스 => 컨테이너
		// 객체 메모리 할당 => 등록
		/*
		 *  class ApplicationContext
		 *  {
		 *      Map map=new HashMap();
		 *      map.put("id명", Class,forName("Class명")
		 *      
		 *      public Object getBean(String key)
		 *      {
		 *          return map(key)
		 *      }
		 *  }
		 * 
		 */
		// 객체 찾기 => DL
		Board board=(Board)app.getBean("board");
		//                      -------- id명칭
	    board.board_list();
	    System.out.println(board);
	    Board board1=(Board)app.getBean("board");
	    board1.board_list();
	    System.out.println(board1);
	    Board board2=(Board)app.getBean("board");
	    board2.board_list();
	    System.out.println(board2);
	    
	    Notice notice=(Notice)app.getBean("notice");
	    notice.notice_list();
	    System.out.println(notice);
	    Notice notice1=(Notice)app.getBean("notice");
	    notice1.notice_list();
	    System.out.println(notice1);
	    Notice notice2=(Notice)app.getBean("notice");
	    notice2.notice_list();
	    System.out.println(notice2);
	}
}
