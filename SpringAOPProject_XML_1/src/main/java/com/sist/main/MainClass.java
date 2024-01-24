package com.sist.main;
/*
 *   container
 *   ApplicationContext => Map
 *   AnnotationConfigApplicationContext
 *   WebApplication 
 *   => 객체 생성 / 주입 / 소멸 => XML, Annotaion
 *   2. DI => 객체 생성시에 주입
 * 
 * 
 */
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		
		List<EmpVO> list=dao.empListData();
//		for(EmpVO vo:list)
//		{
//			System.out.println(vo.getEmpno()+" "+vo.getJob()+" "+vo.getDbday()+" "+vo.getSal());
//		}
	}

}
