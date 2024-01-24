package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.spring.Board;
import com.sist.spring.Notice;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * String[] xml= {"application-board.xml","application-notice.xml"};
		 * ApplicationContext app=new ClassPathXmlApplicationContext(xml);
		 */
		
		ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
		Board b=app.getBean("board",Board.class);
		System.out.println("번호:"+b.getNo());
		System.out.println("이름:"+b.getName());
		System.out.println("제목:"+b.getSubject());
		System.out.println("========================================");
		Notice n=app.getBean("notice",Notice.class);
		System.out.println("번호:"+n.getNo());
		System.out.println("이름:"+n.getName());
		System.out.println("내용:"+n.getContent());
	}

}
