package com.sist.main;

import org.springframework.stereotype.Component;

/*
 *  어노테이션 
 *    = 메모리 할당(선택적)
 *      => 스프링에서 기능별로 구분해서 사용
 *      @Component : 일반 클래스 => ~Manager, MainClass
 *      @Repository : 저장소 => ~DAO
 *      @Service : DAO여러개를 연결해서 사용, BI
 *                 => 기능을 통합해서 사용
 *                 => 실무에서는 가장 많이 사용되는 어노테이션
 *                 => ~Service
 *      @Controller : Model (스트럿츠 : ~Action)
 *                 => BoardContorller
 *      @RestController : Model => 자바스크립트와 연결
 *        => VueJS
 *      @ControllerAdive : 모든 Model클래스의 예외처리
 *      
 *      @Configuration:application.xml =>  자바로 설젇
 *    = DI
 *      @AutoWired => 스프링에 의해서 자동으로 객체주소를 주임
 *      
 *    
 * 
 * 
 */
@Component
class A{
   public void display()
   {
	   System.out.println("A:display() call...");
   }
}

class B{
	public void display()
	   {
		System.out.println("B:display() call...");
	   }
}

@Component
class C{
	public void display()
	   {
		System.out.println("C:display() call...");
	   }
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//@Component가 없으면 메모리 할당을 안함
		String[] cls= {"com.sist.main.A","com.sist.main.B","com.sist.main.C"};
		try {
		   for(String s:cls)
		   {
			   Class clsName=Class.forName(s);
			   if(clsName.isAnnotationPresent(Component.class)==false)
			   {
				   //isAnnotationPresent => 어노테이션이 존재하냐 안하냐
				   continue; // 존재하지 않으면 생략
			   }
			   Object obj=clsName.getDeclaredConstructor().newInstance();
			   System.out.println(obj);
		   }
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
