package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.MyDAO2;

public class MainClass2 {
	public static void main(String[] args) {
		MyDAO2 dao=new MyDAO2();
		dao.select();
		dao.insert();
		dao.delete();
		dao.update();
		System.out.println("============AOP적용후============");
		ApplicationContext app=new ClassPathXmlApplicationContext("app2.xml");
		MyDAO2 dao2=(MyDAO2)app.getBean("dao");
		dao2.select();
		dao2.insert();
		dao2.delete();
		dao2.update();
	}
}
