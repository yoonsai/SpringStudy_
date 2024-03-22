package com.sist.dao;
import com.sist.mapper.MemberMapper;
import com.sist.vo.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;
	public MemberVO isLogin(String id,String pwd) {
		MemberVO vo=new MemberVO();
		int count=mapper.idCount(id);
		if(count>0)
		{
			MemberVO dbvo=mapper.isLogin(id);
			if(pwd.equals(dbvo.getPwd()))
			{
				vo.setId(id);
				vo.setName(dbvo.getName());
				vo.setMsg("OK");
			}
			else {
				vo.setMsg("NOPWD");
			}
		}else {
			vo.setMsg("NOID");
		}
		return vo;
		
		
	}
	
}
