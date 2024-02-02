package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.MemberMapper;
import com.sist.vo.MemberVO;

@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;
	
	public MemberVO isLogin(String id,String pwd) {
		
		int count=mapper.idCount(id);
		MemberVO vo=new MemberVO();
		if(count>0)
		{
			MemberVO dbvo=mapper.isLogin(id);
			String db_pwd=dbvo.getPwd();
			if(db_pwd.equals(pwd))
			{
				vo.setMsg("OK");
				vo.setName(dbvo.getName());
				vo.setId(dbvo.getId());
			}
			else {
				vo.setMsg("NOPWD");
			}
		}
		else {
			vo.setMsg("NOID");
		}
		return vo;
	}
}
