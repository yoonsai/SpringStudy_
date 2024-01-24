package com.sist.temp;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component("mc")
public class MainClass {
	@Autowired
	private BCryptPasswordEncoder encoder;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mc");
		String pwd="1234";
		String enPwd=mc.encoder.encode(pwd);
		System.out.println(enPwd);
		
	    Scanner scan=new Scanner(System.in);
	    System.out.print("비밀번호 입력:");
	    String myPwd=scan.next();
		
		if(mc.encoder.matches(myPwd, enPwd))
		{
			System.out.println("완료");
		}
		else {
			System.out.println("실패");
		}
	}

}
