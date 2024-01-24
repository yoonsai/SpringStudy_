package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.sist.spring.Student;

public class MainClass2 {
	public static void main(String[] args) {
		GenericXmlApplicationContext app=new GenericXmlApplicationContext("app2.xml");
		Student stu=(Student)app.getBean("stu");
		System.out.println("학번:"+stu.getHakbun());
		System.out.println("이름:"+stu.getName());
		System.out.println("국어:"+stu.getKor());
		System.out.println("영어:"+stu.getEng());
		System.out.println("수학:"+stu.getMath());
		app.close(); // GenericXmlApplicationContext에서만 가능
		
	}
}
