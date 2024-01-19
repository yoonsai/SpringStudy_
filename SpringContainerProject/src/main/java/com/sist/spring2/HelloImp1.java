package com.sist.spring2;

public class HelloImp1 implements Hello{
	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println(name+"님 환영합니다");
		//  sayHello1로 메소드명을 바꿔도 해당 클래스만 오류남
	}
}
