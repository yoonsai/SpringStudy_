package com.sist.main;
/*
 *   @Autowired : 반드시 스프링에서 메모리 할당을 해야 자동 주입이 가능
 *   
 *   class A
 *   {
 *      @Autowired
 *      B b; ==> null
 *   }
 *   @Component
 *   class B
 *   {
 *      @Autowired
 *      A a; ==> 주소
 *   }
 * 
 */
import java.util.*;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;

public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
		FoodDAO fDao=(FoodDAO)app.getBean("fDao");
		Scanner scan=new Scanner(System.in);
		System.out.print("1.업체명, 2.주소, 3.음식종류 선택:");
		int col=scan.nextInt();
		String fd="";
		String[] temp= {"","name","address","type"};
		fd=temp[col];
		
		System.out.print("검색어 입력:");
		String ss=scan.next();
		Map map=new HashMap();
		map.put("ss",ss);
		map.put("col_name", fd);
		List<FoodVO> list=fDao.foodFindData(map);
		
		for(FoodVO vo:list)
		{
			System.out.println(vo.getFno()+" "+vo.getName()+" ");
		}
		System.out.println("===============================================");
		GoodsDAO gDao=(GoodsDAO)app.getBean("gDao");
		System.out.print("1.상품명, 2:배송 선택:");
		int tab=scan.nextInt();
		String[] tables= {"","goods_name","goods_delivery"};
		String table=tables[tab];
		System.out.println("검색어 입력:");
		String word=scan.next();
		map.put("table", table);
		map.put("word", word);
		List<GoodsVO> glist=gDao.goodsFindData(map);
		for(GoodsVO vo:glist)
		{
			System.out.println(vo.getNo()+" "+vo.getGoods_name()+" "+vo.getGoods_price());
		}
	} 

}
