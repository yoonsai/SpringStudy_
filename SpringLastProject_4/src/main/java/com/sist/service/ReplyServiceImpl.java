package com.sist.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.*;
import com.sist.dao.*;

@Service
public class ReplyServiceImpl implements ReplyService{
    @Autowired
    private ReplyDAO rDao;

	@Override
	public List<ReplyVO> replyListData(int rno) {
		// TODO Auto-generated method stub
		return rDao.replyListData(rno);
	}
	
	@Override
	public void replyInsert(ReplyVO vo) {
		// TODO Auto-generated method stub
		rDao.replyInsert(vo);
	}
	
	@Override
	public void replyUpdate(ReplyVO vo) {
		// TODO Auto-generated method stub
		rDao.replyUpdate(vo);
	}
	
	@Override
	public void replyDelete(int no) {
		// TODO Auto-generated method stub
		rDao.replyDelete(no);
	}

	@Override
	public MemberVO memberInfoData(String userId) {
		// TODO Auto-generated method stub
		return rDao.memberInfoData(userId);
	}
	  
  
}
