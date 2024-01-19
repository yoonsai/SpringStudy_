package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.sawon.Sawon;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
		Sawon sa1=(Sawon)app.getBean("sa1");
		System.out.println(sa1.getName());
		
		Sawon sa2=(Sawon)app.getBean("sa2");
		System.out.println(sa1.getName());
	}
}
