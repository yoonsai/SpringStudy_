package com.sist.dao;

import java.util.Date;
import lombok.Data;

@Data
public class EmpVO {
	private int empno,sal,deptno;
    private String ename,job,dbday;
    private Date hiredate;
    private DeptVO dvo=new DeptVO();
    private SalGradeVO svo=new SalGradeVO();
}
