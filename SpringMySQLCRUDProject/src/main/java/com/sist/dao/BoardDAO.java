package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class BoardDAO {
    @Autowired
    private BoardMapper mapper;
    
    public List<BoardVO> boardListData(int start)
    {
    	return mapper.boardListData(start);
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
    	return mapper.boardDetailData(no);
    }
    public BoardVO boardUpdateData(int no)
    {
    	return mapper.boardDetailData(no);
    }
}
