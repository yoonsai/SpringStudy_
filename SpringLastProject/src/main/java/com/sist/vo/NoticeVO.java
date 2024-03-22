package com.sist.vo;

import java.util.Date;

import lombok.Data;

@Data
public class NoticeVO {
	private int no,hit;
	private String name,subject,content,dbday;
	private Date regdate;
	/*
	 * no NUMBER,
   name VARCHAR2(51) DEFAULT '관리자',
   subject VARCHAR2(1000) CONSTRAINT pn_sub_nn NOT NULL,
   content CLOB CONSTRAINT pn_cont_nn NOT NULL,
   regdate DATE DEFAULT SYSDATE,
   hit NUMBER DEFAULT 0,
   CONSTRAINT pn_no_pk PRIMARY KEY(no)
	 */
}
