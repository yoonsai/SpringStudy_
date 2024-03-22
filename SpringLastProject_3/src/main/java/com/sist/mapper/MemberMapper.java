package com.sist.mapper;
/*
USERID     NOT NULL VARCHAR2(20)  
USERNAME   NOT NULL VARCHAR2(51)  
USERPWD    NOT NULL VARCHAR2(20)  
ENABLED             NUMBER(1)     
SEX                 VARCHAR2(6)   
BIRTHDAY   NOT NULL VARCHAR2(20)  
EMAIL               VARCHAR2(100) 
POST       NOT NULL VARCHAR2(10)  
ADDR1      NOT NULL VARCHAR2(500) 
ADDR2               VARCHAR2(500) 
PHONE               VARCHAR2(20)  
CONTENT             CLOB          
REGDATE             DATE          
MODIFYDATE          DATE          
LASTLOGIN           DATE 
 */

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.MemberVO;

public interface MemberMapper {
	//1. 회원가입
	@Select("SELECT COUNT(*) FROM projectMember WHERE userid=#{userid}")
	public int memberIdCount(String userid);
	// => ID 중복체크
	@Insert("INSERT INTO projectMember(userid,username,userpwd,sex,birthday,email,post,addr1,addr2,phone,content) "
			+ "VALUES(#{userId},#{userName},#{userPwd},#{sex},#{birthday},#{email},#{post},#{addr1},#{addr2},#{phone},#{content})")
	public void MemberInsert(MemberVO vo);
	
	@Insert("INSERT INTO projectAuthority VALUES(#{userId},'ROLE_USER')")
	public void MemberAuthorityInsert(String userId);
	//2. 로그인
	//2-1. id존재여부 확인 => memberIdCount재사용
	//2-2. 비밀번호 검색
	@Select("SELECT pm.userId, pm.userName, pm.userPwd, pm.enabled, pa.authority "
			+ "FROM projectMember pm, projectAuthority pa "
			+ "WHERE pm.userId=pa.userId AND pm.userId=#{userId}")
	public MemberVO memberLogin(String userId);
	
	@Select("SELECT userId,userName,sex,email,addr,addr2,phone FROM projectMember "
			+ "WHERE userId=#{userId}")
	public MemberVO memberSessionInfoData(String userId);
}

