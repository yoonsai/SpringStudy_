package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.FoodDAO;
import com.sist.dao.FreeBoardDAO;
import com.sist.vo.FreeBoardVO;

@Service
public class FreeBoardServiceImpl implements FreeBoardService{
	@Autowired
	private FreeBoardDAO fdao;
	@Override
	public List<FreeBoardVO> freeBoardListData(int start, int end) {
		// TODO Auto-generated method stub
		return fdao.freeBoardListData(start, end);
	}

	@Override
	public int freeboardTotalpage() {
		// TODO Auto-generated method stub
		return fdao.freeboardTotalpage();
	}

	@Override
	public void freeboardInsert(FreeBoardVO vo) {
		// TODO Auto-generated method stub
		fdao.freeboardInsert(vo);
	}

	@Override
	public FreeBoardVO freeboardDetailData(int no) {
		// TODO Auto-generated method stub
		return fdao.freeboardDetailData(no);
	}

	@Override
	public String freeboardDelete(int no, String pwd) {
		// TODO Auto-generated method stub
		return fdao.freeboardDelete(no, pwd);
	}

	@Override
	public FreeBoardVO freeboardUpdateData(int no) {
		// TODO Auto-generated method stub
		return fdao.freeboardUpdateData(no);
	}

	@Override
	public String freeboardUpdate(FreeBoardVO vo) {
		// TODO Auto-generated method stub
		return fdao.freeboardUpdate(vo);
	}
	
	
}
