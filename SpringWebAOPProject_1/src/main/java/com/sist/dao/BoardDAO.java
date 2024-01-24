package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sist.mapper.BoardMapper;

@Repository
public class BoardDAO {
	
	@Autowired
	private BoardMapper mapper;
	
	public List<BoardVO> boardListData(Map map)
	{
		return mapper.boardListData(map);
	}
	public void boardInsertData(BoardVO vo)
	{
		mapper.boardInsertData(vo);
	}
	public int boardTotalPage()
	{
		return mapper.boardTotalPage();
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
	public boolean boardUpdate(BoardVO vo)
	{
		boolean bCheck=false;
		String pwd=mapper.boardGetPassword(vo.getNo());
		if(pwd.equals(vo.getPwd()))
		{
			bCheck=true;
			mapper.boardUpdateData(vo);
		}
		return bCheck;	
	}
	public List<BoardVO> boardTop5()
	{
		return mapper.boardTop5();
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void boardReplyInsert(int pno,BoardVO vo)
	{
		BoardVO pvo=mapper.boardParentInfoData(pno);
		mapper.boardGroupStepIncrement(pvo);
		vo.setGroup_id(pvo.getGroup_id());
		vo.setGroup_step(pvo.getGroup_step()+1);
		vo.setGroup_tab(pvo.getGroup_tab()+1);
		vo.setRoot(pno);
		mapper.boardReplyInsert(vo);
		mapper.boardDepthIncrement(pno);
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean boardDelete(int no,String pwd)
	{
		//@Around
		boolean bCheck=false;
		String db_pwd=mapper.boardGetPassword(no);
		BoardVO vo=mapper.boardDeleteInfoData(no);
		if(pwd.equals(db_pwd))
		{
			bCheck=true;
			if(vo.getDepth()==0)
			{
				mapper.boardReplyDelete(no);
			}
			else {
				vo.setSubject("관리자가 삭제한 게시물입니다");
				vo.setContent("관리자가 삭제한 게시물입니다");
				vo.setNo(no);
				mapper.boardReplyDeleteUpdate(vo);
			}
			mapper.boardDepthDecrement(no);
			
		}
		return bCheck;
	}
}
