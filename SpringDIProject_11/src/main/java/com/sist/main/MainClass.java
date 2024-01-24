package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.sist.dao.*;


@Component
/*
 *  @Component                                클래스
 *   => 사용 위치 ==> 클래스에만 적용 @Target(value={TYPE}) 
 *  
 *  @Autowired                       생성자       메소드     파라미터(매개변수)     필드(멤버변수)     어노테이션
 *   => 사용 위치 ==>  Target(value={CONSTRUCTOR, METHOD,    PARAMETER,        FIELD,     ANNOTATION_TYPE})
 *   
 *   class A
 *   {
 *      @
 *      B b (필드)
 *      @
 *      public A(){}
 *      @
 *      public void display(){}
 *      public A(@B b){}
 *              ====== 파라미터
 *   }
 * 
 */
public class MainClass {
	// @Autowired + @Qualifier = @Resource(1.8) => 현재는 버전이 높아지면서 없어짐
	@Autowired // @Autowired로 인터페이스로 접근했을때 같은 내용이 있으면 어떤건지 찾을 수 없음
	@Qualifier("memberDAO") // @Qualifier 어떤 클래스를 찾을지 지정해줌
	private OracleDB ob; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mainClass");
		mc.ob.display();
		
	}

}
