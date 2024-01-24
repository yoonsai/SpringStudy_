package com.sist.main;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sist.dao.*;
/*
 *   DI : 클래스와 클래스 사이의 관계를 설정하는것 (의존관계설정)
 * 
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		List<EmpVO> list=dao.empListData();
		int i=0;
		for(EmpVO vo:list)
		{
			i=++i;
			System.out.println(i+" "+vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob()+" "+vo.getSal()+" "+vo.getHiredate());
		}
		System.out.println("=======================");
		
		Scanner scan=new Scanner(System.in);
		System.out.print("사번입력:");
		int empno=scan.nextInt();
		EmpVO vo1=dao.empDetailData(empno);
		System.out.println(vo1.getEname()+" "+vo1.getJob()+" "+vo1.getSal()+" "+vo1.getHiredate());
		
		/*
		 * System.out.println("=======================");
		 * 
		 * DeptDAO dao2=(DeptDAO)app.getBean("dao2"); List<DeptVO>
		 * list2=dao2.deptListData(); for(DeptVO vo2:list2) {
		 * System.out.println(vo2.getDeptno()+" "+vo2.getDname()+" "+vo2.getLoc()); }
		 */
		
	}

}
