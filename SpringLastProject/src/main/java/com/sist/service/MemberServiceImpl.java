package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO mDao;

	@Override
	public int memberIdCount(String userid) {
		// TODO Auto-generated method stub
		return mDao.memberIdCount(userid);
	}

	@Override
	public void MemberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		mDao.MemberInsert(vo);
	}

	@Override
	public void MemberAuthorityInsert(String userId) {
		// TODO Auto-generated method stub
		mDao.MemberAuthorityInsert(userId);
	}

	@Override
	public MemberVO memberLogin(String userId, String userPwd) {
		// TODO Auto-generated method stub
		return mDao.memberLogin(userId, userPwd);
	}
	
}
