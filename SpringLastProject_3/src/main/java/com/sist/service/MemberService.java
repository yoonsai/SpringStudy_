package com.sist.service;

import com.sist.vo.MemberVO;

public interface MemberService {
	public int memberIdCount(String userid);
	public void MemberInsert(MemberVO vo);
	public void MemberAuthorityInsert(String userId);
	public MemberVO memberLogin(String userId,String userPwd);
	public MemberVO memberSessionInfoData(String userId);
}
