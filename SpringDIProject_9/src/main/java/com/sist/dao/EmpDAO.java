package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
// ("dao")가 없어도 됨 => 대신 클래스명으로 대체
// 없을때=> EmpDAO dao=(EmpDAO)app.getBean("empDAO"); 
// @Repository("dao")
// => EmpDAO dao=(EmpDAO)app.getBean("dao"); 
public class EmpDAO {
	@Autowired
	private EmpMapper mapper;

//	public void setMapper(EmpMapper mapper) {
//		this.mapper = mapper;
//	}
	public List<EmpVO> empDeptJoinData()
	{
		return mapper.empDeptJoinData();
	}
}
