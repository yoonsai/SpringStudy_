package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.vo.*;
import com.sist.mapper.BoardMapper;

@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	
    public List<BoardVO> boardListData(int start,int end)
    {
    	return mapper.boardListData(start, end);
    }
	
	public int boardTotalPage()
	{
		return mapper.boardTotalPage();
	}
	
	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo);
	}
	public BoardVO boardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.BoardDetailData(no);
	}
	public BoardVO boardUpdateData(int no)
	{
		return mapper.BoardDetailData(no);
	}
	public String boardUpdate(BoardVO vo) {
		String result="no";
		String db_pwd=mapper.boardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd()))
		{
			result="yes";
			mapper.boardUpdate(vo);
		}
		return result;
	}
	public String boardDelete(String pwd,int no) {
		String result="no";
		String db_pwd=mapper.boardGetPassword(no);
		if(db_pwd.equals(pwd))
		{
			result="yes";
			mapper.boardDelete(no);
		}
		return result;
	}
}
