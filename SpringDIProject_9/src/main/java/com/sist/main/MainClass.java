package com.sist.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpVO;

/*
 *  1. XML 버전 ====> XML파일 공유
 *  2. Annotation =====> 개별적으로 사용이 가능
 *     => 분업화 (가장 많이 사용)
 *     Annotation
 *     => 사용자 정의 클래스 
 *     => 라이브러리 클래스 (어노테이션이 없다) => 상속
 *  3. 사용자 정의 클래스는 어노테이션을 이용
 *     라이브러리 클래스는 XML => 공통 사용
 *  ========================================
 *     4버전 형식 => 5버전 설정파일 (자바) => 6버전 분산처리
 *                                        | MSA (Spring Cloud)
 *               ================================
 *                    | 보안 (모든 파일 자바)
 *  스프링 
 *    => 틀 (프로그램 형식을 정리 -> 모든 개발자가 동일한 포멧)
 *       => 형식 통일 (형식을 제공) => 프레임워크
 *    => 형식 동일
 *       1. DI => 객체 생성
 *                ------ 객체 생성시에 필요한 데이터를 주입
 *                       멤버변수 초기화
 *                       = setXxx()
 *                       = 생성자
 *                ------ 개발자가 사용
 *                객체 소멸
 *                ======== 컨테이너 (제공)
 *       2. 중복 코딩
 *            => OOP에서 단점 (자동 호출이 안된다)
 *               => 중복 코딩 (메소드, 메소드 여러개 -> 클래스)
 *            => 자동 호출이 가능
 *            => AOP => 단어
 *               Before / After / After-Returning / After-Throwing
 *               위빙 , JoinPointer. PointCut
 *               
 *               public String display()
 *               {
 *                   try{
 *                      Before
 *                   }catch(Exception e)
 *                   {
 *                      @ After-Throwing ==> ccc()
 *                   }
 *                   finally
 *                   {
 *                      @ After ==> bbb()
 *                   }
 *                   @After-Returning
 *                   return "";
 *               }
 *   ======================================================
 *   1. Application
 *   2. Web Application (MVC)       
 *   
 * 
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//모델 역할
		ApplicationContext app=new ClassPathXmlApplicationContext("app2.xml");
		EmpDAO dao=(EmpDAO)app.getBean("empDAO"); //DL.DI
		List<EmpVO> list=dao.empDeptJoinData();
		for(EmpVO vo:list) {
			System.out.println("이름:"+vo.getEname());
			System.out.println("직급:"+vo.getJob());
			System.out.println("부서명:"+vo.getDvo().getDname());
			System.out.println("지역:"+vo.getDvo().getLoc());
			System.out.println("입사일:"+vo.getDbday());
			System.out.println("================================");
		}
	}

}
