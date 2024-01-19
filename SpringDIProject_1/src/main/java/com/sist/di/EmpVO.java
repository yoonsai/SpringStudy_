package com.sist.di;
// 사용자 정의 데이터형 => 스프링에 의존하지 않는다
/*
 *  스프링은 모든 클래스는 등록 / VO,Bean,DTO제외
 * 
 * 
 */
import java.util.*;
public class EmpVO {
	private int empno,sal;
	private String ename,job;
	private Date hiredate;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	
}
