package com.sist.vo;

import java.util.Date;

import lombok.Data;

/*
 * 
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
@Data
public class MemberVO {
	private int enabled;
	private String userId,userPwd,userName,sex,birthday,email,post,addr1,addr2,phone,content,reg_dbday,mod_dbday,last_dbday,phone1,phone2,msg;
	private Date regdate,modifydate,lastlogin;
	private String authority;

}
