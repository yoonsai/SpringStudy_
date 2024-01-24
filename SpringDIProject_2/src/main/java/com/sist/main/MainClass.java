package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.spring.*;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app1.xml");
		Sawon sa=(Sawon)app.getBean("sa");
		System.out.println(sa.getSabun()+" "+sa.getName()+" "+sa.getSex());
		System.out.println("==========================");
		Member mem=(Member)app.getBean("mem");
		mem.print();
		System.out.println("==========================");
		Member mem1=(Member)app.getBean("mem1");
		mem1.print();
		System.out.println("==========================");
		Member mem2=(Member)app.getBean("mem2");
		mem2.print();
		
		
	}
}
