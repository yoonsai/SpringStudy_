package com.sist.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO implements OracleDB{

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("MemberDAO:display() Call....");
	}
	
}
