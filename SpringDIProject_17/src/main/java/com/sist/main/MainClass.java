package com.sist.main;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.config.EmpConfig;
import com.sist.dao.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext(EmpConfig.class);
		EmpDAO eDao=(EmpDAO)app.getBean("eDao");
		List<EmpVO> list=eDao.empAllData();
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getDbday()+" "+vo.getDvo().getDeptno()+" "+vo.getDvo().getLoc());
		}
	}

}
