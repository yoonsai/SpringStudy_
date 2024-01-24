package com.sist.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.SeoulDAO;
import com.sist.dao.SeoulVO;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
		SeoulDAO dao=(SeoulDAO)app.getBean("dao");
		
		List<SeoulVO> list=dao.shopListData();
		for(SeoulVO vo:list)
		{
			System.out.println(vo.getNo()+" "+vo.getTitle());
		}
		
		Scanner scan=new Scanner(System.in);
		System.out.print("번호 입력:");
		int no=scan.nextInt();
		SeoulVO vo=dao.shopDetailData(no);
		
		System.out.println("번호:"+vo.getNo());
		System.out.println("장소:"+vo.getTitle());
		System.out.println("주소:"+vo.getAddress());
		
		System.out.print("장소명 입력:");
		String title=scan.next();
		
		List<SeoulVO> slist=dao.shopFindData(title);
		for(SeoulVO vo1:slist)
		{
			System.out.println(vo1.getNo()+" "+vo1.getTitle());
		}
	}
}
