package com.sist.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
		SeoulDAO dao=(SeoulDAO)app.getBean("dao");
		
		List<SeoulVO> list=dao.natureListData();
		for(SeoulVO vo:list)
		{
			System.out.println(vo.getNo()+" "+vo.getTitle());
		}
		
		
		System.out.println("===================================");
		Scanner scan=new Scanner(System.in);
		System.out.print("번호 입력:");
		int no=scan.nextInt();
		SeoulVO vo=dao.natureDetailData(no);
		System.out.println("번호:"+vo.getNo());
		System.out.println("장소:"+vo.getTitle());
		System.out.println("주소:"+vo.getAddress());
		System.out.println("소개:"+vo.getMsg());
		
		System.out.println("===================================");
		System.out.print("장소명 입력:");
		String name=scan.next();
		List<SeoulVO> list1=dao.natureFindListData(name);
		for(SeoulVO vo2:list1)
		{
			System.out.println(vo2.getNo()+" "+vo2.getTitle());
		}
		System.out.println("===================================");
		List<SeoulVO> list2=dao.shopListData();
		for(SeoulVO vo1:list2)
		{
			System.out.println(vo1.getNo()+" "+vo1.getTitle());
		}
		
		System.out.println("===================================");
		System.out.print("번호 입력:");
		int no1=scan.nextInt();
		SeoulVO vo1=dao.shopDetailData(no1);
		System.out.println("번호:"+vo1.getNo());
		System.out.println("장소:"+vo1.getTitle());
		System.out.println("주소:"+vo1.getAddress());
		
		System.out.println("===================================");
		System.out.print("장소명 입력:");
		String title=scan.next();
		List<SeoulVO> list3=dao.natureFindListData(title);
		for(SeoulVO vo2:list3)
		{
			System.out.println(vo2.getNo()+" "+vo2.getTitle());
		}
	}

}
