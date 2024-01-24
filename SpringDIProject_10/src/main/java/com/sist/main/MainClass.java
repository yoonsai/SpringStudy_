package com.sist.main;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.CategoryDAO;
import com.sist.dao.CategoryVO;
import com.sist.dao.FoodDAO;
import com.sist.dao.FoodVO;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
		CategoryDAO cDao=(CategoryDAO)app.getBean("cDao");
		List<CategoryVO> cList=cDao.foodCategoryData();
		for(CategoryVO cvo:cList)
		{
			System.out.println(cvo.getCno()+" "+cvo.getTitle()+" "+cvo.getSubject());
		}
		System.out.println("===========================");
		Scanner scan=new Scanner(System.in);
		System.out.print("카테고리선택(1~30):");
		int cno=scan.nextInt();
		FoodDAO fDao=(FoodDAO)app.getBean("fDao");
		CategoryVO cvo=cDao.categoryInfoData(cno);
		System.out.println("==============================");
		System.out.println(cvo.getTitle());
		System.out.println(cvo.getSubject());
		System.out.println("==============================");
		List<FoodVO> fList=fDao.foodCategoryListData(cno);
		for(FoodVO fvo:fList)
		{
			System.out.println(fvo.getFno()+" "+fvo.getName()+" "+fvo.getAddress()+" "+fvo.getPhone());
		}
		System.out.println("===========================");
		System.out.print("맛집 선택:");
		int fno=scan.nextInt();
		FoodVO fdvo=fDao.foodDetailListData(fno);
		System.out.println("업체명:"+fdvo.getName());
		System.out.println("주소:"+fdvo.getAddress());
		System.out.println("전화:"+fdvo.getPhone());
		System.out.println("음식종류:"+fdvo.getType());
		System.out.println("가격대:"+fdvo.getPrice());
		System.out.println("영업시간:"+fdvo.getTime());
		System.out.println("주차:"+fdvo.getParking());
		System.out.println("메뉴:"+fdvo.getMenu());
	}

}
