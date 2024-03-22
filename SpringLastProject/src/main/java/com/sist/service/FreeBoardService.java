package com.sist.service;

import java.util.List;

import com.sist.vo.FreeBoardVO;

public interface FreeBoardService {
    public List<FreeBoardVO> freeBoardListData(int start,int end);
	
	
	public int freeboardTotalpage();
	
	// 추가
	public void freeboardInsert(FreeBoardVO vo);
	
	public FreeBoardVO freeboardDetailData(int no);
	
	public String freeboardDelete(int no,String pwd);
	
	public FreeBoardVO freeboardUpdateData(int no);
	
	public String freeboardUpdate(FreeBoardVO vo);
}
