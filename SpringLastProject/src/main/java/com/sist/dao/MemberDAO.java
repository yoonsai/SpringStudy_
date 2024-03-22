package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.sist.mapper.MemberMapper;
import com.sist.vo.MemberVO;

@Repository
public class MemberDAO {
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private MemberMapper mapper;
	
	public int memberIdCount(String userid){
		return mapper.memberIdCount(userid);
	}
	public void MemberInsert(MemberVO vo) {
		mapper.MemberInsert(vo);
	}
	public void MemberAuthorityInsert(String userId) {
		mapper.MemberAuthorityInsert(userId);
	}
	public MemberVO memberLogin(String userId,String userPwd)
	{
		MemberVO dbvo=new MemberVO();
		int count=mapper.memberIdCount(userId);
		if(count==0)
		{
			dbvo.setMsg("NOID");
		}
		else {
			dbvo=mapper.memberLogin(userId);
			if(encoder.matches(userPwd, dbvo.getUserPwd()))
			{
				dbvo.setMsg("OK");
			}
			else{
				dbvo.setMsg("NOPWD");
			}
		}
		return dbvo;
	}
}
