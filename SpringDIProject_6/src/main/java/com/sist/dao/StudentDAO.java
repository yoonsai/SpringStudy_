package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public class StudentDAO {
	private StudentMapper mapper;

	public void setMapper(StudentMapper mapper) {
		this.mapper = mapper;
	}
	
	public List<StudentVO> studentListData()
	{
		return mapper.studentListData();
	}
	
	public StudentVO studentDetailData(int hakbun)
	{
		return mapper.studentDetailData(hakbun);
	}

	public void studentInsertData(StudentVO vo)
	{
		mapper.studentInsertData(vo);
	}
	public void studentDelete(int hakbun)
	{
		mapper.studentDelete(hakbun);
	}
	
	public void studentUpdate(StudentVO vo)
	{
		mapper.studentUpdate(vo);
	}
    
}
