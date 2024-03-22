package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FreeBoardMapper;
import com.sist.vo.FreeBoardVO;

@Repository
public class FreeBoardDAO {
	@Autowired
	private FreeBoardMapper mapper;
	
    public List<FreeBoardVO> freeBoardListData(int start,int end)
    {
    	return mapper.freeBoardListData(start, end);
    }
	
	
	public int freeboardTotalpage() {
		return mapper.freeboardTotalpage();
	}
	
	// 추가
	public void freeboardInsert(FreeBoardVO vo) {
		mapper.freeboardInsert(vo);
	}
	
	public FreeBoardVO freeboardDetailData(int no) {
		mapper.hitIncrement(no);
		return mapper.freeboardDetailData(no);
	}

	public String freeboardDelete(int no,String pwd)
	{
		String result="no";
		String db_pwd=mapper.freeboardGetPassword(no);
		if(db_pwd.equals(db_pwd))
		{
			result="yes";
			mapper.freeboardDelete(no);
		}
		return result;
	}
	public FreeBoardVO freeboardUpdateData(int no) {

		return mapper.freeboardDetailData(no);
	}
	
	public String freeboardUpdate(FreeBoardVO vo)
	{
		String result="no";
		String db_pwd=mapper.freeboardGetPassword(vo.getNo());
		if(vo.getPwd().equals(db_pwd))
		{
			result="yes";
			mapper.freeboardUpdate(vo);
		}
		return result;
	}
}
